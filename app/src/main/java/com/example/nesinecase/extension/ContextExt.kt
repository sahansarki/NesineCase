package com.example.nesinecase.extension

import android.content.Context
import com.example.nesinecase.util.ProgressDialogHelper

fun <T: Context> T.dismissProgress(){
    ProgressDialogHelper.dismiss()
}

fun <T: Context> T.showProgress(){
    ProgressDialogHelper.showProgress(this)
}