package com.medium.jeffersontpadua.pedidomaisgostoso.dashboard

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.medium.jeffersontpadua.pedidomaisgostoso.R
import com.medium.jeffersontpadua.pedidomaisgostoso.dashboard.fragments.cardapio.CardapioFragment
import com.medium.jeffersontpadua.pedidomaisgostoso.dashboard.service.PratoService
import com.medium.jeffersontpadua.pedidomaisgostoso.dashboard.ui.DashboardUI
import org.jetbrains.anko.setContentView

class DashboardActivity : AppCompatActivity(), ItemSelecionadoCallback, ValorTotalListener {
    lateinit var ui: DashboardUI

    val pratosSelecionados: MutableList<Prato> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        ui = DashboardUI(this)
        ui.setContentView(this)

        setSupportActionBar(ui.toolbarView)

        supportActionBar?.let {
            it.setDisplayHomeAsUpEnabled(true)
            it.setHomeAsUpIndicator(R.drawable.ic_arrow_back_white_24dp)
        }

        supportFragmentManager
                .beginTransaction()
                .replace(ui.ID_FRAME_LAYOUT, CardapioFragment.newInstance(PratoService))
                .commit()
    }

    override fun onItemSelecionado(prato: Prato) {
        pratosSelecionados.add(prato)

        ui.atualizarValorTotal()
    }

    override fun onItemRemovido(prato: Prato) {
        pratosSelecionados.remove(prato)

        ui.atualizarValorTotal()
    }

    override fun getValorTotal(): Double = pratosSelecionados.sumByDouble { it.preco }
}