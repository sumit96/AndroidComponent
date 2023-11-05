package com.example.forgroundservicesdemo

import android.Manifest
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.app.ActivityCompat
import com.example.forgroundservicesdemo.ui.theme.ForgroundServicesDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU)
        {
            ActivityCompat.requestPermissions(this,
                arrayOf(Manifest.permission.POST_NOTIFICATIONS),
                0)
        }
        setContent {
            ForgroundServicesDemoTheme {
                // A surface container using the 'background' color from the theme
                Column( modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {

                    Button(onClick = {
                        Intent(applicationContext, RunningForgroundService::class.java).also {
                            it.action=RunningForgroundService.Action.ONSTART.toString()
                            startService(it) }
                    }) {
                        Text(text = "Start Service")
                    }
                    Button(onClick = {
                        Intent(applicationContext, RunningForgroundService::class.java).also {
                            it.action=RunningForgroundService.Action.ONSTOP.toString()
                            startService(it) }
                    }) {
                        Text(text = "Stop Service")
                    }
                }

            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ForgroundServicesDemoTheme {
        Greeting("Android")
    }
}