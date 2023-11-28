package ru.slartus.forpda.compose

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.plus
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.scale
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.stackAnimation
import com.materialkolor.dynamicColorScheme
import io.github.aakira.napier.Napier
import kotlinx.coroutines.launch
import ru.slartus.forpda.components.RootComponent
import ru.slartus.forpda.news_list.compose.NewsList

@Composable
fun App(rootComponent: RootComponent) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    AppTheme(seedColor = Color(0, 69, 90)) {
        ModalNavigationDrawer(
            drawerState = drawerState,
            drawerContent = {
                ModalDrawerSheet {
                    Text("HELLO")
                }
            },
        ) {
            Column {
                Button(
                    onClick = {
                        scope.launch {
                            Napier.d("clicked")
                            drawerState.apply {
                                if (isClosed) open() else close()
                            }
                        }
                    }
                ) {
                    Text("click me")
                }
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
    }
}

@Composable
private fun AppTheme(
    seedColor: Color,
    useDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = dynamicColorScheme(seedColor, useDarkTheme)

    MaterialTheme(
        colorScheme = colorScheme,
        content = content
    )
}