package smir.shitab.shitabssuperapp.network

import android.content.Context
import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.cache.normalized.api.MemoryCacheFactory
import com.apollographql.apollo3.cache.normalized.api.NormalizedCacheFactory
import com.apollographql.apollo3.cache.normalized.normalizedCache
import com.apollographql.apollo3.cache.normalized.sql.SqlNormalizedCacheFactory
import com.apollographql.apollo3.network.okHttpClient
import okhttp3.Interceptor
import okhttp3.OkHttpClient

object GraphQLClient {
    private var instance: ApolloClient? = null

    // in memory cache
    val cacheFactory = MemoryCacheFactory(maxSizeBytes = 10 * 1024 * 1024)  // in-memory cache
    // sql cache
    lateinit var sqlNormalizedCacheFactory: SqlNormalizedCacheFactory
    // chained in memory and sql cache
    lateinit var memoryFirstThenSqlCacheFactory: NormalizedCacheFactory

    fun apolloClient(context: Context, baseUrl: String): ApolloClient {

        sqlNormalizedCacheFactory = SqlNormalizedCacheFactory(context, "sqlNormalizedCache.db")

        memoryFirstThenSqlCacheFactory = MemoryCacheFactory(maxSizeBytes = 10 * 1024 * 1024)
            .chain(SqlNormalizedCacheFactory(context, "memoryFirstTheSqlCache.db"))

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
//            .normalizedCache(cacheFactory)
//            .normalizedCache(sqlNormalizedCacheFactory)
            .normalizedCache(memoryFirstThenSqlCacheFactory)
            .build()

        return instance!!
    }
}