package smir.shitab.shitabssuperapp.pages.pokedexpage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.api.Optional
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

        val okHttpClient: OkHttpClient = OkHttpClient.Builder().build()

        apolloClient = GraphQLClient.apolloClient(this, "https://graphql-pokeapi.vercel.app/api/graphql")

        showLoader()

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
            )).execute()
        Log.d("PokeList", "Success: ${response.data}")
        hideLoader()
    }

    override val layoutResourceId: Int
        get() = R.layout.activity_poke_dex_home

}