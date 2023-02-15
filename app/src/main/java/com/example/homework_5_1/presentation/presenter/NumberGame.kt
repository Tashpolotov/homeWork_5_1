package com.example.homework_5_1.presentation.presenter

import com.example.homework_5_1.domain.Card
import com.example.homework_5_1.domain.Game

class NumberGame {

    private val game= Game (listOf(1,2,3,4,5,6).shuffled())
    fun getCards()= game.getCards()
    fun onCardClick(card:Card<Int>){
        game.onCardClick(card)
    }
}