package com.example.homework_5_1.presentation.view

import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.homework_5_1.R
import com.example.homework_5_1.databinding.ItemNumberBinding
import com.example.homework_5_1.domain.Card
import com.example.homework_5_1.presentation.presenter.NumberGame

class NumberAdapter: RecyclerView.Adapter<NumberAdapter.ViewHolder>() {

    private val numberGame = NumberGame()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemNumberBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(numberGame.getCards()[position])
    }

    override fun getItemCount(): Int {
        return  numberGame.getCards().size
    }

    inner class ViewHolder (private var binding: ItemNumberBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(card:Card<Int>) {
            if (card.isMatched) {
                onUiUpdate(card,true)
            } else {onUiUpdate(card,card.isFacedUp)}

            if (!card.isMatched){
                binding.itemFrame.setOnClickListener{
                    onUiUpdate(card,!card.isFacedUp)
                    numberGame.onCardClick(card)
                    Handler(Looper.getMainLooper()).postDelayed({
                        notifyDataSetChanged()
                    },1000)}
            }

        }
        private fun onUiUpdate(card: Card<Int>,isFaced:Boolean){
            if (isFaced) {
                binding.itemTv.text = card.content.toString()
            } else { binding.itemTv.text = "" }
            binding.itemFrame.isPressed = isFaced
        }

    }
}