package com.example.util


import kotlinx.coroutines.flow.*
//crossinline makes sure you are not allowed to call return in the fun arguments in network...???
// we need two generic types because we dopesnt in every situations get the same type of data but in this case wewill so its not that important
inline fun <ResultType, RequestType> networkBoundResource( //inline functions are more efficient
    crossinline query: () -> Flow<ResultType>, //take from db
    crossinline fetch: suspend () -> RequestType, //fetch data from API
    crossinline saveFetchResult: suspend (RequestType) -> Unit, // saving new data in SQLdb
    crossinline shouldFetch: (ResultType) -> Boolean = { true }//decide do we need to fetch new data from web or not
) = flow{           //this will be executed whenever we call this fun
    val data = query().first()

    val flow = if(shouldFetch(data)){ //w/e we get from any of block will be stored in flow
        emit(Resource.Loading(data))

        try {
            saveFetchResult(fetch()) //this fun can fail if dont have Internet connection or if we gett error from the server, so we need try block
            query().map { Resource.Success(data = it) } //it is w/e we get through query flow (list of characters from API)
        }catch (throwable: Throwable){
            query().map { Resource.Error(data = it, throwable = throwable) }
        }
    }else{ // if cache doesnt need to be updated
        query().map { Resource.Success(data = it) }
    }

    emitAll(flow = flow) //emiting w/e comes from map blocks
}