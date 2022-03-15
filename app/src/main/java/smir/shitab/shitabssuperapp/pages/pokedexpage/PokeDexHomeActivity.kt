package smir.shitab.shitabssuperapp.pages.pokedexpage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.api.Optional
import com.apollographql.apollo3.cache.normalized.FetchPolicy
import com.apollographql.apollo3.cache.normalized.fetchPolicy
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import smir.shitab.shitabssuperapp.GetPokemonsQuery
import smir.shitab.shitabssuperapp.R
import smir.shitab.shitabssuperapp.base.activity.BaseActivity
import smir.shitab.shitabssuperapp.databinding.ActivityPokeDexHomeBinding
import smir.shitab.shitabssuperapp.network.GraphQLClient
import smir.shitab.shitabssuperapp.pages.homelanding.HomeLandingActivityViewModel

class PokeDexHomeActivity : BaseActivity<ActivityPokeDexHomeBinding>() {
    lateinit var apolloClient: ApolloClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_poke_dex_home)

        apolloClient = GraphQLClient.apolloClient(this, "https://graphql-pokeapi.vercel.app/api/graphql")

//        showLoader()

        GlobalScope.launch {
            delay(1000)
            getData()
        }

    }

    private suspend fun getData() {
        val response = apolloClient.query(
            GetPokemonsQuery(
                Optional.presentIfNotNull(5), // limit
                Optional.presentIfNotNull(5) // offset
            ))
            // (Default) Check the cache, then only use the network if data isn't present
            .fetchPolicy(FetchPolicy.CacheFirst)

            // Check the cache and never use the network, even if data isn't present
//            .fetchPolicy(FetchPolicy.CacheOnly)

            // Always use the network, then check the cache if network fails
//            .fetchPolicy(FetchPolicy.NetworkFirst)

            // Always use the network and never check the cache, even if network fails
//            .fetchPolicy(FetchPolicy.NetworkOnly)

            .execute()
        Log.d("PokeList", "Success: ${response.data}")
//        hideLoader()
    }

    override val layoutResourceId: Int
        get() = R.layout.activity_poke_dex_home

}