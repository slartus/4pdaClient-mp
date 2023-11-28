package ru.slartus.forpda.components

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize
import ru.slartus.forpda.news_list.NewsListComponent
import ru.slartus.forpda.news_list.NewsListComponentImpl

interface RootComponent {
    val stack: Value<ChildStack<*, Child>>

    sealed class Child {
        class NewsListChild(val component: NewsListComponent) : Child()
    }
}

class RootComponentImpl(
    componentContext: ComponentContext,
) : RootComponent, ComponentContext by componentContext {

    private val navigation = StackNavigation<Config>()

    override val stack: Value<ChildStack<*, RootComponent.Child>> =
        childStack(
            source = navigation,
            initialConfiguration = Config.NewsList, // The initial child component is List
            handleBackButton = true, // Automatically pop from the stack on back button presses
            childFactory = ::child,
        )

    private fun child(config: Config, componentContext: ComponentContext): RootComponent.Child =
        when (config) {
            is Config.NewsList -> RootComponent.Child.NewsListChild(listComponent(componentContext))
        }

    private fun listComponent(componentContext: ComponentContext): NewsListComponent =
        NewsListComponentImpl(
            componentContext = componentContext
        )

    @Parcelize
    private sealed interface Config : Parcelable {
        data object NewsList : Config
    }
}