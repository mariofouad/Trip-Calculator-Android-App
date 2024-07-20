package com.mario.tripcalculator

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.maad.tripcalculator.TripPriceScreen
import com.mario.tripcalculator.AppRoutes.DISTANCE
import com.mario.tripcalculator.AppRoutes.START
import com.mario.tripcalculator.AppRoutes.TIME
import com.mario.tripcalculator.AppRoutes.TRAFFIC_OPTIONS
import com.mario.tripcalculator.AppRoutes.TRIP_PRICE

object AppRoutes {
    const val START = "start"
    const val DISTANCE = "distance"
    const val TIME = "time"
    const val TRAFFIC_OPTIONS = "traffic_options"
    const val TRIP_PRICE = "trip_price"
}

@Composable
fun AppNavHost() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = START) {
        composable(route = START) {
            FirstScreen(navController)
        }
        composable(route = DISTANCE) {
            DistanceScreen(navController)
        }
        composable(
            route = "$TIME/{km}",
            arguments = listOf(navArgument("km") {
                type = NavType.FloatType
            })
        ) {
            val km = it.arguments?.getFloat("km")!!
            TimeScreen(navController, km)
        }
        composable(
            route = "$TRAFFIC_OPTIONS/{km}/{tripTime}",
            arguments = listOf(navArgument("km") {
                type = NavType.FloatType
            }, navArgument("tripTime") {
                type = NavType.IntType
            })
        )
        {
            val km = it.arguments?.getFloat("km")!!
            val tripTime = it.arguments?.getInt("tripTime")!!
            TrafficOptions(navController, km, tripTime)
        }
        composable(
            route = "$TRIP_PRICE/{km}/{trip_time}/{traffic}",
            arguments = listOf(
                navArgument("km") { type = NavType.FloatType },
                navArgument("trip_time") { type = NavType.IntType },
                navArgument("traffic") { type = NavType.FloatType }
            )
        ) {
            val km = it.arguments?.getFloat("km")!!
            val time = it.arguments?.getInt("trip_time")!!
            val traffic = it.arguments?.getFloat("traffic")!!
            TripPriceScreen(navController, km = km, time = time, traffic = traffic)
        }
    }
}