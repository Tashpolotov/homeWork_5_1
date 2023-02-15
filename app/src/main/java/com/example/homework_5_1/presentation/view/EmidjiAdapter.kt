package com.example.homework_5_1.presentation.view

import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.homework_5_1.databinding.ItemNumberBinding
import com.example.homework_5_1.domain.Card
import com.example.homework_5_1.presentation.presenter.EmojiGame

class EmojiAdapter : RecyclerView.Adapter<EmojiAdapter.EmojiViewHolder>() {
    private val emojiGame = EmojiGame()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmojiViewHolder {
        return EmojiViewHolder(ItemNumberBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: EmojiViewHolder, position: Int) {
        holder.bind(emojiGame.emojiCard()[position])
    }

    override fun getItemCount(): Int {
        return emojiGame.emojiCard().size
    }

    inner class EmojiViewHolder(private var binding: ItemNumberBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(cardModel: Card<String>) {
            if (cardModel.isMatched) {
                onUiUpdate(cardModel,true)
            } else {onUiUpdate(cardModel,cardModel.isFacedUp)}

            if (!cardModel.isMatched){
                binding.itemFrame.setOnClickListener{
                    onUiUpdate(cardModel,!cardModel.isFacedUp)
                    emojiGame.emojiCardClick(cardModel)
                    Handler(Looper.getMainLooper()).postDelayed({
                        notifyDataSetChanged()
                    },1000)}
            }
        }
        private fun onUiUpdate(cardModel: Card<String>,isFaced:Boolean){
            if (isFaced) {
                binding.itemTv.text = cardModel.content.toString()
            } else { binding.itemTv.text = "" }
            binding.itemFrame.isPressed = isFaced
        }
    }
}