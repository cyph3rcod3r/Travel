/*
 * Copyright 2022 Cyph3rCod3r
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.cyberwalker.travel

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.*
import com.cyberwalker.travel.detail.DetailScreen
import com.cyberwalker.travel.detail.DetailScreenActions
import com.cyberwalker.travel.home.HomeScreen
import com.cyberwalker.travel.home.HomeScreenActions
import com.cyberwalker.travel.splash.SplashScreen
import com.cyberwalker.travel.splash.SplashScreenActions
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

sealed class Screen(val name: String, val route: String) {
    object Splash : Screen("splash", "splash")
    object Home : Screen("home", "home")
    object Detail : Screen("detail", "detail")
}

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.animatedComposable(
    route: String,
    arguments: List<NamedNavArgument> = emptyList(),
    deepLinks: List<NavDeepLink> = emptyList(),
    content: @Composable AnimatedVisibilityScope.(NavBackStackEntry) -> Unit
) {
    composable(route = route,
        arguments = arguments,
        deepLinks = deepLinks,
        content = content,
        enterTransition = { enterTransition() },
        exitTransition = { exitTransition() },
        popExitTransition = { popExitTransition() },
        popEnterTransition = { popEnterTransition() })
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun TravelNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberAnimatedNavController(),
    actions: NavActions = remember(navController) {
        NavActions(navController)
    }
) {
    AnimatedNavHost(
        navController = navController,
        startDestination = Screen.Splash.route,
        modifier = modifier
    ) {
        animatedComposable(Screen.Splash.route) {
            SplashScreen(onAction = actions::navigateToHome)
        }

        animatedComposable(Screen.Home.route) {
            HomeScreen(onAction = actions::navigateFromHome,navController = navController)
        }

        animatedComposable(Screen.Detail.route) {
            DetailScreen(onAction = actions::navigateFromDetails)
        }
    }
}

class NavActions(private val navController: NavController) {
    fun navigateToHome(_A: SplashScreenActions) {
        navController.navigate(Screen.Home.name) {
            popUpTo(Screen.Splash.route){
                inclusive = true
            }
        }
    }

    fun navigateFromHome(actions: HomeScreenActions) {
        when (actions) {
            HomeScreenActions.Details -> {
                navController.navigate(Screen.Detail.name)
            }
        }
    }

    fun navigateFromDetails(actions: DetailScreenActions) {
        when(actions) {
            DetailScreenActions.Back -> navController.popBackStack()
        }
    }
}