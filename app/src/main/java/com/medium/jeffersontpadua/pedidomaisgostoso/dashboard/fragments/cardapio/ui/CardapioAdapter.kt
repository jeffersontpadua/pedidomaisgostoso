package com.medium.jeffersontpadua.pedidomaisgostoso.dashboard.fragments.cardapio.ui

import android.support.v7.widget.RecyclerView
import android.support.v7.widget.StaggeredGridLayoutManager
import android.view.ViewGroup
import com.medium.jeffersontpadua.pedidomaisgostoso.dashboard.Prato
import com.medium.jeffersontpadua.pedidomaisgostoso.dashboard.ItemSelecionadoCallback

class CardapioAdapter(val pratos: List<Prato>, val callback: ItemSelecionadoCallback) : RecyclerView.Adapter<CardapioViewHolder>() {
    override fun onBindViewHolder(holder: CardapioViewHolder, position: Int) = holder.bind(pratos[position])

    override fun getItemCount(): Int = pratos.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)  = CardapioViewHolder(CardapioItemUI(parent), callback)

    override fun onViewAttachedToWindow(holder: CardapioViewHolder?) {
        super.onViewAttachedToWindow(holder)

        if(holder != null) {
            val layoutParams = holder.item.itemView.layoutParams

            resizeIfUsingStaggeredGridLayoutManager(layoutParams, holder.layoutPosition)
        }
    }

    private fun resizeIfUsingStaggeredGridLayoutManager(layoutParams: ViewGroup.LayoutParams, layoutPosition: Int) {
        if(layoutParams is StaggeredGridLayoutManager.LayoutParams && layoutPosition % 3 == 0){
            layoutParams.isFullSpan = true
        }
    }
}