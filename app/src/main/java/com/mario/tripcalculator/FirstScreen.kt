package com.mario.tripcalculator

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.mario.tripcalculator.AppRoutes.DISTANCE

@Composable
fun FirstScreen(navController: NavController, modifier: Modifier = Modifier) {
    val screenWidth = LocalConfiguration.current.screenWidthDp
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.road),
            contentDescription = stringResource(
                id = R.string.road
            ),
            modifier = modifier.size(300.dp)
        )
        Button(
            onClick = {
                navController.navigate(DISTANCE)
            },
            modifier = modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(text = stringResource(id = R.string.start))
        }
        Image(
            painter = painterResource(id = R.drawable.car),
            contentDescription = stringResource(
                id = R.string.car
            ),
            modifier = modifier
                .offset(screenWidth.dp / 2)
                .size(300.dp)
        )
    }
}


@Preview(showBackground = true)
@Composable
fun FirstScreenPreview(modifier: Modifier = Modifier) {
    FirstScreen(rememberNavController())
}