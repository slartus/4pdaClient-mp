import androidx.compose.ui.window.ComposeUIViewController

import ru.slartus.forpda.components.RootComponent
import ru.slartus.forpda.compose.RootView

fun MainViewController(
    rootComponent: RootComponent
) = ComposeUIViewController { RootView(rootComponent) }