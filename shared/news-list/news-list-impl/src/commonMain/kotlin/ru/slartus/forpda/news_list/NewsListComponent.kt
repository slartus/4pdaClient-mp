package ru.slartus.forpda.news_list

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import ru.slartus.forpda.news_list.api.NewsItem

interface NewsListComponent {
    val model: Value<Model>

    data class Model(
        val items: List<NewsItem>,
    )
}

class NewsListComponentImpl(
    componentContext: ComponentContext
) : NewsListComponent, ComponentContext by componentContext {
    override val model: Value<NewsListComponent.Model> =
        MutableValue(NewsListComponent.Model(items = List(100) { NewsItem("Item $it") }))
}