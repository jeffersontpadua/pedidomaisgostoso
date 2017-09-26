package com.medium.jeffersontpadua.pedidomaisgostoso.dashboard.fragments.cardapio.ui

import android.support.v7.widget.StaggeredGridLayoutManager
import com.medium.jeffersontpadua.pedidomaisgostoso.dashboard.Prato
import com.medium.jeffersontpadua.pedidomaisgostoso.dashboard.fragments.cardapio.CardapioFragment
import com.medium.jeffersontpadua.pedidomaisgostoso.dashboard.ItemSelecionadoCallback
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.dip
import org.jetbrains.anko.padding
import org.jetbrains.anko.recyclerview.v7.recyclerView

class CardapioUI(val pratos: List<Prato>, val callback: ItemSelecionadoCallback) : AnkoComponent<CardapioFragment> {
    override fun createView(ui: AnkoContext<CardapioFragment>) = ui.apply {
        recyclerView {
            layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
            adapter = CardapioAdapter(pratos, callback)

            padding = dip(8)
        }
    }.view
}