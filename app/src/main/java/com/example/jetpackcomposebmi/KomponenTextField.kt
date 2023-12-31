package com.example.jetpackcomposebmi

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposebmi.ui.theme.Green
import com.example.jetpackcomposebmi.ui.theme.White


@Composable
fun KomponenTextField(
    inputValue: String,
    metric: String,
    label: String,
    onValueChange: (String) -> Unit
){
    Row(
        Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
    verticalAlignment = Alignment.Bottom,
    horizontalArrangement = Arrangement.Center
    ) {
        TextField(
            value = inputValue,
            onValueChange = onValueChange,
            label = { Text(label, color = White) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Green,
                unfocusedIndicatorColor = Color.White,
                textColor = Green
            ),
        )
        Text(
            text = metric,
            Modifier.padding(horizontal = 8.dp),
            color = White
        )
    }

}