package com.jakchang.tdd_study

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import org.junit.Test
import com.google.common.truth.Truth.assertThat
import org.junit.After
import org.junit.Before

class ResourceComparerTest {

    private lateinit var resourceComparer: ResourceComparer

    @Before
    fun setUp(){
        resourceComparer = ResourceComparer()
    }

    @After
    fun tearDown(){
    }

    @Test
    fun stringResourceSameAsGiven_returnsTrue(){
        val context = ApplicationProvider.getApplicationContext<Context>()
        val result = resourceComparer.isEqual(context, R.string.app_name, "TDD-Study")
        assertThat(result).isTrue()
    }


    @Test
    fun stringResourceSameAsDifferent_returnsFalse(){
        val context = ApplicationProvider.getApplicationContext<Context>()
        val result = resourceComparer.isEqual(context, R.string.app_name, "TDD-Study1111")
        assertThat(result).isFalse()
    }
}