package com.example.homework_5_1.domain

data class Card<Content>(
    val id: Int,
    var isFacedUp:Boolean = false,
    var isMatched:Boolean = false,
    var content:Content
)
