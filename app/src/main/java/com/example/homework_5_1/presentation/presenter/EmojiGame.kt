package com.example.homework_5_1.presentation.presenter

import com.example.homework_5_1.domain.Card
import com.example.homework_5_1.domain.Game


class EmojiGame {
    private val emojiGame= Game (listOf("\uD83D\uDE01","\uD83E\uDD17","\uD83E\uDEE0","\uD83D\uDE07","\uD83E\uDD76","\uD83E\uDD22").shuffled())
    fun emojiCard()=emojiGame.getCards()
    fun emojiCardClick(cardModel: Card<String>){
        emojiGame.onCardClick(cardModel)
    }
}