package smir.shitab.shitabssuperapp.pages.pokedexpage

import android.os.Bundle
import android.util.Log
import com.apollographql.apollo3.ApolloCall
import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.api.ApolloResponse
import com.apollographql.apollo3.api.Optional
import com.apollographql.apollo3.cache.normalized.FetchPolicy
import com.apollographql.apollo3.cache.normalized.fetchPolicy
import com.apollographql.apollo3.rx3.Rx3Apollo.Companion.flowable
import com.apollographql.apollo3.rx3.Rx3Apollo.Companion.single
import com.apollographql.apollo3.rx3.rxSingle
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import smir.shitab.shitabssuperapp.GetPokemonsQuery
import smir.shitab.shitabssuperapp.R
import smir.shitab.shitabssuperapp.base.activity.BaseActivity
import smir.shitab.shitabssuperapp.databinding.ActivityPokeDexHomeBinding
import smir.shitab.shitabssuperapp.network.GraphQLClient
import java.lang.Exception


class PokeDexHomeActivity : BaseActivity<ActivityPokeDexHomeBinding>() {
    lateinit var apolloClient: ApolloClient

    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_poke_dex_home)

        apolloClient = GraphQLClient.apolloClient(this, "https://graphql-pokeapi.vercel.app/api/graphql")

//        showLoader()

        GlobalScope.launch {
            delay(1000)
            getData()
        }
        /*fetchPokemon().map {
            Log.d("PokeList", "Success: ${it.data}")
        }
*/
    }

    private suspend fun getData() {
        val response = apolloClient.query(
            GetPokemonsQuery(
                Optional.presentIfNotNull(5), // limit
                Optional.presentIfNotNull(5) // offset
            ))
            // (Default) Check the cache, then only use the network if data isn't present
//            .fetchPolicy(FetchPolicy.CacheFirst)

            // Check the cache and never use the network, even if data isn't present
//            .fetchPolicy(FetchPolicy.CacheOnly)

            // Always use the network, then check the cache if network fails
//            .fetchPolicy(FetchPolicy.NetworkFirst)

            // Always use the network and never check the cache, even if network fails
            .fetchPolicy(FetchPolicy.NetworkOnly)

            .execute()
        Log.d("PokeList", "Success: ${response.data}")
//        hideLoader()
    }

    // Observable Flowable Data
    private fun getObservableFlowableData(): Flowable<ApolloResponse<GetPokemonsQuery.Data>> {
        val call: ApolloCall<GetPokemonsQuery.Data> = apolloClient.query(GetPokemonsQuery(
            Optional.presentIfNotNull(5), // limit
            Optional.presentIfNotNull(5) // offset
        ))

        Schedulers.io()
        return flowable(call)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .filter { dataResponse -> dataResponse.data != null }
    }

    // Observable Single Data
    private fun getObservableSingleData(): Maybe<ApolloResponse<GetPokemonsQuery.Data>> {
        val call: ApolloCall<GetPokemonsQuery.Data> = apolloClient.query(GetPokemonsQuery(
            Optional.presentIfNotNull(5), // limit
            Optional.presentIfNotNull(5) // offset
        ))

        Schedulers.io()
        return single(call)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .filter { dataResponse -> dataResponse.data != null }
    }

    // Observable Live Data
    private fun  getObservableLiveData(): Maybe<ApolloResponse<GetPokemonsQuery.Data>> {
        val call: ApolloCall<GetPokemonsQuery.Data> = apolloClient.query(GetPokemonsQuery(
            Optional.presentIfNotNull(5), // limit
            Optional.presentIfNotNull(5) // offset
        ))

        return single(call)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .filter {
                    dataResponse -> dataResponse.data != null
            }

    }

    private fun fetchPokemon(): Observable<ApolloResponse<GetPokemonsQuery.Data>> {
        Log.d("SHITAB_TEST", "fetchPokemon")
        val call = apolloClient.query(GetPokemonsQuery(
            Optional.presentIfNotNull(5), // limit
            Optional.presentIfNotNull(5) // offset
        ))
        Schedulers.io()
        return flowable(apolloClient.query(GetPokemonsQuery(
            Optional.presentIfNotNull(5), // limit
            Optional.presentIfNotNull(5) // offset
        ))).toObservable().map {
                data ->
            if (data.data != null) {
                Log.d("PokeList", "Success: ${data.data}")

                return@map data
            } else {
                throw Exception("Something Went Wrong!")
            }
        }




    }

    override val layoutResourceId: Int
        get() = R.layout.activity_poke_dex_home

}