package com.mario.tripcalculator

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.mario.tripcalculator.AppRoutes.TIME

@Composable
fun DistanceScreen(navController: NavController, modifier: Modifier = Modifier) {
    DataEntry(
        text = R.string.enter_the_total_distance,
        fieldLabel = R.string.distance_in_kilometers,
        modifier = modifier,
    ){distanceField ->
        val distance = distanceField.toDouble()
        navController.navigate("$TIME/$distance")
    }
}

@Preview(showBackground = true)
@Composable
fun DistanceScreenPreview(modifier: Modifier = Modifier) {
    DistanceScreen(rememberNavController())
}