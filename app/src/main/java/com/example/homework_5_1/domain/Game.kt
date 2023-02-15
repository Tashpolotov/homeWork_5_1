package com.example.homework_5_1.domain

class Game <Content>(
    private val list: List<Content>){
    private var cards:ArrayList<Card<Content>> = ArrayList()

    init {
        list.forEachIndexed { index, cardContent ->
            cards.add(Card(id = index*index , content = cardContent))
            cards.add(Card(id = index*index+2, content = cardContent))
        }
    }
    fun getCards() = cards
    fun onCardClick(card :Card<Content>) {
        card.isFacedUp = !card.isFacedUp
        cards.forEach{
            if (it.isFacedUp&&card.id!=it.id){
                if (card.content==it.content){
                    cards[cards.indexOf(card)].isFacedUp=true
                    it.isFacedUp= true
                    cards[cards.indexOf(card)].isMatched=true
                    it.isMatched= true
                }else if (!it.isMatched){
                    cards[cards.indexOf(card)].isFacedUp=false
                    it.isFacedUp= false
                }}
        }
    }
}