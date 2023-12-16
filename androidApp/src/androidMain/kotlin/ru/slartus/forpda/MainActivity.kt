package ru.slartus.forpda

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.arkivanov.decompose.defaultComponentContext
import ru.slartus.forpda.components.RootComponentImpl
import ru.slartus.forpda.compose.RootView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val root = RootComponentImpl(
            componentContext = defaultComponentContext(),
        )
        setContent {
            RootView(root)
        }
    }
}