package ru.slartus.forpda

import android.app.Application
import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class ForpdaApp : Application() {
    override fun onCreate() {
        super.onCreate()
        initNapier()
    }

    companion object {
        val applicationScope = MainScope()
        lateinit var instance: ForpdaApp; private set
    }
}

private fun initNapier() {
    ForpdaApp.applicationScope.launch {
        Napier.base(DebugAntilog())
    }
}