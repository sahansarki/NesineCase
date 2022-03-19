package com.example.nesinecase.extension

import com.example.nesinecase.util.Constants

fun urlMaker(itemPosition: Int): String{
    return Constants.PHOTO_URL + itemPosition + "&grayscale"
}