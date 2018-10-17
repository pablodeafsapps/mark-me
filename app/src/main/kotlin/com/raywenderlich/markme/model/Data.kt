package com.raywenderlich.markme.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "class")
class Student(
        @PrimaryKey(autoGenerate = true)
        val uid: Int?,
        val name: String,
        val grade: Int)

val studentList = listOf(
        "Buddy Copland",
        "Ila Willison",
        "Cuc Harrelson",
        "Buddy Copland",
        "Ila Willison",
        "Cuc Harrelson",
        "Delila Adam",
        "Lea Cichon",
        "Zita Mcferrin",
        "Megan Casey",
        "Elton Keister",
        "Jammie Sidhu",
        "Love Hauge",
        "Larisa Urman",
        "Wen Truehart",
        "Angie Vanbeek",
        "Demetrius Olander",
        "Kassandra Helt",
        "Kazuko Heineman",
        "Laci Stroup",
        "Bao Dillion",
        "Virgil Fett",
        "Jessia Carbone"
)
