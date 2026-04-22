package edu.temple.counter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import edu.temple.counter.ui.theme.CounterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CounterTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {innerPadding ->
                    Counter(
                        modifier = Modifier.padding(innerPadding)
                    )
                }

            }
        }
    }
}

@Composable
fun Counter(modifier: Modifier = Modifier) {

    var counterVal : Int by rememberSaveable { mutableStateOf(0) }

    Column(horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center, modifier = modifier.fillMaxSize()) {
        Button(
            modifier = modifier.padding(16.dp),
            onClick = {
                counterVal++

            }
        ) {
            Image(painterResource(android.R.drawable.arrow_up_float), "Up arrow")
        }
        Text(
            text = counterVal.toString(),
            fontSize = 72.sp,
            modifier = modifier
        )
        Button(
            modifier = modifier.padding(16.dp),
            onClick = {
                if(counterVal > 0){
                    counterVal--
                }

            }
        ) {
            Image(painterResource(android.R.drawable.arrow_down_float), "Down arrow")
        }

    }

}

@Preview(showBackground = true)
@Composable
fun CounterPreview() {
    CounterTheme (dynamicColor = false){
        val context = LocalContext.current
        Counter()
    }
}