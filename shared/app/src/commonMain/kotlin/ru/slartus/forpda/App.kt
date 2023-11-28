package ru.slartus.forpda

import RootComponent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.plus
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.scale
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.stackAnimation
import ru.slartus.forpda.news_list.compose.NewsList

@Composable
fun App(rootComponent: RootComponent) {
    MaterialTheme {
        Children(
            stack = rootComponent.stack,
            modifier = Modifier.fillMaxSize(),
            animation = stackAnimation(fade() + scale()),
        ) {
            when (val child = it.instance) {
                is RootComponent.Child.NewsListChild -> NewsList(component = child.component)
            }
        }
    }
}
