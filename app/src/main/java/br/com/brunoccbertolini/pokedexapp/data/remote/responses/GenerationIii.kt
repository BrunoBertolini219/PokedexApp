package br.com.brunoccbertolini.pokedexapp.data.remote.responses

import com.google.gson.annotations.SerializedName

data class GenerationIii(
    val emerald: Emerald,
    val fireredleafgreen: FireredLeafgreen,
    @SerializedName("ruby-sapphire")
    val rubysapphire: RubySapphire
)