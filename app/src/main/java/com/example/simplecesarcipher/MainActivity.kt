package com.example.simplecesarcipher


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.simplecesarcipher.ui.theme.SimpleCesarCipherTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.font.FontWeight

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimpleCesarCipherTheme {
                Surface(
                    //...
                ) {
                    TipTimeScreen()
                }
            }
        }
    }
}

@Preview
@Composable
fun TipTimeScreen(){
    var amountInput by remember {mutableStateOf("")}
    val tip = calc(amountInput)
    Column(
        modifier = Modifier.padding(32.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ){
        Text(
            text = stringResource(R.string.calculate_tip),
            fontSize = 24.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Spacer(Modifier.height(16.dp))
        EditNumberField(value = amountInput,
            onValueChange = {amountInput = it} )
        Spacer(Modifier.height(25.dp))
        Text(
            text = stringResource(R.string.tip_amount,tip),
            modifier = Modifier.align(Alignment.CenterHorizontally),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
    }

}

@Composable
fun EditNumberField(value: String,
                    onValueChange: (String) -> Unit){

    TextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(stringResource(R.string.cost_of_service)) },
        modifier = Modifier.fillMaxWidth(),
        singleLine = true,
    )
}

private fun calc(input: String): String {
    val out = input
    return out
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview(){
    SimpleCesarCipherTheme{
        TipTimeScreen()

    }
}