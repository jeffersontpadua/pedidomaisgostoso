package com.medium.jeffersontpadua.pedidomaisgostoso.dashboard.fragments.cardapio

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.medium.jeffersontpadua.pedidomaisgostoso.dashboard.ItemSelecionadoCallback
import com.medium.jeffersontpadua.pedidomaisgostoso.dashboard.Prato
import com.medium.jeffersontpadua.pedidomaisgostoso.dashboard.fragments.cardapio.ui.CardapioUI
import com.medium.jeffersontpadua.pedidomaisgostoso.dashboard.Service
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.support.v4.ctx

class CardapioFragment : Fragment(), ItemSelecionadoCallback {
    private lateinit var service: Service<Prato>

    private val itemSelecionadoObserver: ItemSelecionadoCallback?
        get() = if (activity is ItemSelecionadoCallback) activity as ItemSelecionadoCallback else null

    companion object {
        fun newInstance(service: Service<Prato>): CardapioFragment {
            val fragment = CardapioFragment()
            fragment.service = service

            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return CardapioUI(service.getData(), this).createView(AnkoContext.create(ctx, this))
    }

    override fun onItemSelecionado(prato: Prato) {
        itemSelecionadoObserver?.onItemSelecionado(prato)
    }

    override fun onItemRemovido(prato: Prato) {
        itemSelecionadoObserver?.onItemRemovido(prato)
    }
}