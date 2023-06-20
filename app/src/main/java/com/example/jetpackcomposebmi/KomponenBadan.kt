package com.example.jetpackcomposebmi

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposebmi.ui.theme.Green
import com.example.jetpackcomposebmi.ui.theme.White

@Preview(showBackground = true)
@Composable
fun Badan(){
//    state full sifatnya statis
//    state less sifatnya dinamis

//   membuat variable agar nilainya kosong
    var tinggi by remember { mutableStateOf("") }
    var berat by remember { mutableStateOf("") }
    var klasifikasi by remember { mutableStateOf("") }
    var perhitungan by remember { mutableStateOf(0.0f) }
    var kemajuan by remember { mutableStateOf(0.0f) }
    var warnaKlasifikasi by remember { mutableStateOf(Color.White) }

//    Column adalah salah satu komponen dalam Android Jetpack Compose yang
//    digunakan untuk mengatur tata letak vertikal dari elemen-elemen UI(TABLE).
//    Column Array Tabel vertical(kebawah)
//    ROW Array Table Horizontal(kekanan)
//    fillMaxWidth() adalah salah satu modifier dalam Android Jetpack Compose yang
//    digunakan untuk mengatur lebar komponen agar mengisi seluruh lebar yang tersedia.
    Column(
        Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Perhitungan BMI",
            color = Green,
            fontSize = 32.sp,
            fontWeight = FontWeight.Medium
        )
        Text(
            text = "Ukuran Eropa",
            color = White,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium
        )
        KomponenTextField(
            inputValue = tinggi,
            metric = "cm",
            label = "Tinggi",
            onValueChange = {
                tinggi = it
                if (tinggi.isEmpty()|| berat.isEmpty()){
                    perhitungan = 0f
                    klasifikasi = ""
                    kemajuan = 0f
                }else{
                    perhitungan = hitung(tinggi,berat)
                    klasifikasi = klasifikasiBMI(perhitungan)
                    warnaKlasifikasi = ambilklasifikasiWarna(perhitungan)
                    kemajuan = ambilKemajuan(perhitungan)
                }
            }
        )
        KomponenTextField(
            inputValue = berat,
            metric = "kg",
            label = "Berat",
            onValueChange = {
                berat = it
                if (tinggi.isEmpty()|| berat.isEmpty()){
                    perhitungan = 0f
                    klasifikasi = ""
                    kemajuan = 0f
                }else{
                    perhitungan = hitung(tinggi,berat)
                    klasifikasi = klasifikasiBMI(perhitungan)
                    warnaKlasifikasi = ambilklasifikasiWarna(perhitungan)
                    kemajuan = ambilKemajuan(perhitungan)
                }
            }
        )
        Box(
            modifier = Modifier.padding(vertical = 16.dp),
            contentAlignment = Alignment.Center
        ){
            Text(text = klasifikasi,
            color = warnaKlasifikasi,
            fontSize = 32.sp,
            fontWeight = FontWeight.Medium)
        }
        Box(
            modifier = Modifier
                .padding(
                    horizontal = 16.dp,
                    vertical = 64.dp
                )
                .size(250.dp),
            contentAlignment = Alignment.Center
        ){
            CircularProgressIndicator(
                progress = kemajuan,
                color = warnaKlasifikasi,
                strokeWidth = 16.dp,
                modifier = Modifier.fillMaxSize()
            )
            Text(
                text = String.format("%.2f", perhitungan),
                color = White,
                fontSize = 64.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Medium
            )
        }
    }
}