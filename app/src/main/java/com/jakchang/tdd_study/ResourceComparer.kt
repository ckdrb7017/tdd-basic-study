package com.jakchang.tdd_study

import android.content.Context

class ResourceComparer {
    fun isEqual(context: Context, resId: Int, inputStirng: String): Boolean {
        return context.getString(resId) == inputStirng
    }

}