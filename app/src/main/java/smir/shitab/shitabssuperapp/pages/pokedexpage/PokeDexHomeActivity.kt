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
import smir.shitab.shitabssuperapp.network.GraphQLClient

class PokeDexHomeActivity : AppCompatActivity() {
    lateinit var apolloClient: ApolloClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_poke_dex_home)

        val okHttpClient: OkHttpClient = OkHttpClient.Builder().build()

        apolloClient = GraphQLClient.apolloClient(this, "https://graphql-pokeapi.vercel.app/api/graphql")

        GlobalScope.launch {
            delay(1000)
            getData()
        }

    }

    private suspend fun getData() {
        val response = apolloClient.query(
            GetPokemonsQuery(
                Optional.presentIfNotNull(1), // limit
                Optional.presentIfNotNull(0) // offset
            )).execute()
        Log.d("PokeList", "Success: ${response.data}")
    }

}