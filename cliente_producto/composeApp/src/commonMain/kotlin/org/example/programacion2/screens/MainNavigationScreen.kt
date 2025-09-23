package org.example.programacion2.screens

import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.TabDisposable
import cafe.adriel.voyager.navigator.tab.TabNavigator
import org.example.programacion2.screens.tabs.ProductListTab

class MainNavigationScreen : Screen {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Content() {
        TabNavigator(
            tab = ProductListTab,
            tabDisposable = {
                TabDisposable(
                    navigator = it,
                    tabs = listOf(
                        ProductListTab,
                    )
                )
            }
        ) {
            Scaffold(
                modifier = Modifier.safeContentPadding(),
                topBar = {
                    TopAppBar(
                        title = {
                            Text(
                                text = it.current.options.title
                            )
                        }
                    )
                },
                bottomBar = {
                    NavigationBar {
                        val tabNavigator: TabNavigator = LocalTabNavigator.current

                        NavigationBarItem(
                            selected = tabNavigator.current.key == ProductListTab.key,
                            label = {
                                Text(
                                    text = ProductListTab.options.title
                                )
                            },
                            icon = {
                                Icon(
                                    painter = ProductListTab.options.icon!!,
                                    contentDescription = null
                                )
                            },
                            onClick = {
                                tabNavigator.current = ProductListTab
                            }
                        )

                    }
                },
                content = {
                    CurrentTab()
                }
            )
        }
    }
}