package ru.slartus.forpda.news_list.compose

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState
import ru.slartus.forpda.news_list.NewsListComponent

@Composable
fun NewsList(component: NewsListComponent) {
    val model by component.model.subscribeAsState()

    LazyColumn {
        items(model.items) { item ->
            Text(
                text = item.title
            )
        }
    }
}