package com.proway.myapplication.model

import androidx.annotation.DrawableRes
import com.proway.myapplication.R
import java.io.Serializable

enum class Logos(val url: String, @DrawableRes val placeholder: Int) : Serializable {
    SERASA(
        "https://play-lh.googleusercontent.com/DOzUNCCAqXQy6Q5JepLCvP3chDZ7r96PmMHZHNbSODNB7zPOAaotG6m-7Qu4znDA4w",
        R.drawable.ic_launcher_background
    )
}