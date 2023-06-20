package com.example.jetpackcomposebmi
import android.os.Bundle
import android.view.Gravity
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposebmi.ui.theme.Black
import com.example.jetpackcomposebmi.ui.theme.JetpackComposeBMITheme
import com.example.jetpackcomposebmi.ui.theme.White

// BMI : Body Max Index

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            CanvasComponent()
            JetpackComposeBMITheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Black
                ) {
//                    Greeting("Aji")
                    Badan()
                }
            }
        }
    }
}

// nama_varible : tipe data(parameter) dan tipe_data = Value_data(nilai)
//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Selamat Datang $name!",
//        fontSize = 30.sp,
//        color = Color.Blue,
//        fontWeight = FontWeight.Bold,
//        textAlign = TextAlign.Center,
//        modifier = modifier
//    )
//}
//
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    JetpackComposeBMITheme {
//        Greeting("Aji")
//    }
//}
//// menambahkan canvas
//@Composable
//fun CanvasComponent(){
//    Canvas(Modifier.fillMaxSize()){
//        //Kode Untuk Menggambar di canvas
//        drawCircle(Color.Red, radius = 100f, center = center)
//    }
//}