package com.example.jetpackcomposebmi

import androidx.compose.ui.graphics.Color
import com.example.jetpackcomposebmi.ui.theme.Blue
import com.example.jetpackcomposebmi.ui.theme.Green
import com.example.jetpackcomposebmi.ui.theme.Maroon
import com.example.jetpackcomposebmi.ui.theme.Red
import com.example.jetpackcomposebmi.ui.theme.White
import kotlin.math.pow

fun hitung(tinggi:String,berat:String):Float{
//    konfersi string menggunakan :Float
    val hitung:Float
    val nilaiBerat = berat.toFloat()
    val nilaiTinggi = tinggi.toFloat() / 100
    hitung = (nilaiBerat / nilaiTinggi.pow(2))
    return hitung
}

fun klasifikasiBMI(perhitungan: Float):String{
    var klasifikasi = ""
    if(perhitungan < 18.5){
        klasifikasi = "Kurus"
    }else if (perhitungan >= 18.5 && perhitungan < 24.9){
        klasifikasi = "Sehat"
    }else if (perhitungan >= 24.9 && perhitungan < 30){
        klasifikasi = "Kegemukan"
    }else if (perhitungan >= 30){
        klasifikasi = "Menderita Obesitas"
    }
    return klasifikasi
}
//  shortcut untuk mengubah data yang sama shift+f6=blok
fun ambilklasifikasiWarna(perhitungan: Float):Color{
    var warnaKlasifikasi = White
    if(perhitungan < 18.5){
        warnaKlasifikasi = Blue
    }else if (perhitungan >= 18.5 && perhitungan < 24.9){
        warnaKlasifikasi = Green
    }else if (perhitungan >= 24.9 && perhitungan < 30){
        warnaKlasifikasi = Red
    }else if (perhitungan >= 30){
        warnaKlasifikasi = Maroon
    }
    return warnaKlasifikasi
}

fun ambilKemajuan(perhitungan: Float):Float {
    var kemajuan = 0f
    if (perhitungan < 18.5) {
        kemajuan = .25f
    } else if (perhitungan >= 18.5 && perhitungan < 24.9) {
        kemajuan = .5f
    } else if (perhitungan >= 24.9 && perhitungan < 30) {
        kemajuan = .75f
    } else if (perhitungan >= 30) {
        kemajuan = 1f
    }
    return kemajuan
}