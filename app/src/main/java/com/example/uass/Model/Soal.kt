package com.example.uass.Model

import com.google.firebase.database.PropertyName

class Soal {
    @PropertyName(value = "id")
    var id: String =""

    @PropertyName("soal")
    var soal: String = ""

    @PropertyName("a")
    var a: String = ""

    @PropertyName("b")
    var b: String = ""

    @PropertyName("c")
    var c: String = ""

    @PropertyName("d")
    var d: String = ""


}