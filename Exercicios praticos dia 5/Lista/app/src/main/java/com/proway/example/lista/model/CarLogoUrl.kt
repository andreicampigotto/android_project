package com.proway.example.lista.model

import androidx.annotation.DrawableRes
import com.proway.example.lista.R
import java.io.Serializable

enum class CarLogoUrl(val url: String, @DrawableRes val placeholder: Int) : Serializable{

    FIAT(
        "https://raw.githubusercontent.com/filippofilip95/car-logos-dataset/master/logos/original/fiat.jpg",
        R.drawable.ic_launcher_foreground
    ),
    VW(
        "https://raw.githubusercontent.com/filippofilip95/car-logos-dataset/master/logos/original/volkswagen.jpg",
        R.drawable.ic_launcher_foreground
    ),
    GM(
        "https://raw.githubusercontent.com/filippofilip95/car-logos-dataset/master/logos/original/gmc.jpg",
        R.drawable.ic_launcher_foreground
    ),
    JEEP(
        "https://raw.githubusercontent.com/filippofilip95/car-logos-dataset/master/logos/original/jeep.jpg",
        R.drawable.ic_launcher_foreground
    ),
    Hyundai(
        "https://raw.githubusercontent.com/filippofilip95/car-logos-dataset/master/logos/original/hyundai.jpg",
        R.drawable.ic_launcher_foreground
        ),
    Volvo("https://raw.githubusercontent.com/filippofilip95/car-logos-dataset/master/logos/original/volvo.jpg",
        R.drawable.ic_launcher_foreground
        ),
    LinconLn("https://raw.githubusercontent.com/filippofilip95/car-logos-dataset/master/logos/original/lincoln.jpg",
        R.drawable.ic_launcher_foreground)

}