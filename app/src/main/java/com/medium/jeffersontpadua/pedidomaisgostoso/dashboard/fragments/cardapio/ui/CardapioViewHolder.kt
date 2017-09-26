package com.medium.jeffersontpadua.pedidomaisgostoso.dashboard.fragments.cardapio.ui

import android.content.Context
import android.support.v7.widget.RecyclerView
import com.medium.jeffersontpadua.pedidomaisgostoso.R
import com.medium.jeffersontpadua.pedidomaisgostoso.dashboard.Prato
import com.medium.jeffersontpadua.pedidomaisgostoso.dashboard.ItemSelecionadoCallback
import com.medium.jeffersontpadua.pedidomaisgostoso.dashboard.color
import org.jetbrains.anko.backgroundColor
import org.jetbrains.anko.toast

class CardapioViewHolder(val item: CardapioItemUI, val callback: ItemSelecionadoCallback, val context: Context = item.itemView.context) : RecyclerView.ViewHolder(item.itemView) {
    fun bind(prato: Prato) {
        item.updateLayout(prato)

        item.itemView.setOnClickListener {
            item.itemView.isSelected = !item.itemView.isSelected

            if(item.itemView.isSelected) {
                item.itemView.backgroundColor = context.color(R.color.card_selected_background)
                callback.onItemSelecionado(prato)
                context.toast(R.string.item_adicionado)
            }else {
                item.itemView.backgroundColor = context.color(R.color.card_default_background)
                callback.onItemRemovido(prato)
                context.toast(R.string.item_removido)
            }
        }
    }


}