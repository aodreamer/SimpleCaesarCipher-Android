package com.example.simplecesarcipher


import android.content.ClipData
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.simplecesarcipher.ui.theme.SimpleCesarCipherTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.font.FontWeight
import java.util.*
import android.content.ClipboardManager
import android.content.Context
import android.content.Context.CLIPBOARD_SERVICE
import android.widget.Toast
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.text.AnnotatedString
import androidx.core.content.ContextCompat.getSystemService

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
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

@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
fun TipTimeScreen(){
    var amountInput by remember {mutableStateOf("")}
    val tip = calc(amountInput)
    val clipboardManager: androidx.compose.ui.platform.ClipboardManager = LocalClipboardManager.current
    Column(
        modifier = Modifier.padding(32.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ){
        Text(
            text = stringResource(R.string.Base64_App),
            fontSize = 24.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Spacer(Modifier.height(16.dp))
        EditNumberField(value = amountInput,
            onValueChange = {amountInput = it} )
        Spacer(Modifier.height(25.dp))
        Text(
            text = stringResource(R.string.Result,tip),
            modifier = Modifier.align(Alignment.CenterHorizontally),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Button(onClick = {
            clipboardManager.setText(AnnotatedString((tip)))
        }) {
            Text("Copy")
        }
    }

}

@Composable
fun EditNumberField(value: String,
                    onValueChange: (String) -> Unit){

    TextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(stringResource(R.string.Input_Here)) },
        modifier = Modifier.fillMaxWidth(),
        singleLine = true,
    )
}

@RequiresApi(Build.VERSION_CODES.O)
private fun calc(input: String): String {
    val out = Base64.getEncoder().encodeToString(input.toByteArray())
    return out
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun DefaultPreview(){
    SimpleCesarCipherTheme{
        TipTimeScreen()

    }
}
