package smir.shitab.shitabssuperapp.network

import android.content.Context
import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.network.okHttpClient
import okhttp3.Interceptor
import okhttp3.OkHttpClient

object GraphQLClient {
    private var instance: ApolloClient? = null

    fun apolloClient(context: Context, baseUrl: String): ApolloClient {
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(Interceptor { chain ->
                val request = chain.request().newBuilder()
                    .addHeader("Content-Type", "application/json")
//                    .addHeader("", "")
                    .build()
                chain.proceed(request)
            })
            .build()

        instance = ApolloClient.Builder()
            .serverUrl(baseUrl)
//            .webSocketServerUrl("wss://...")
            .okHttpClient(okHttpClient)
            .build()

        return instance!!
    }
}