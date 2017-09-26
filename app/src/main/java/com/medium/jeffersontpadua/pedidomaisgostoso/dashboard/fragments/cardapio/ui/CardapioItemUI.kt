package com.medium.jeffersontpadua.pedidomaisgostoso.dashboard.fragments.cardapio.ui

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.medium.jeffersontpadua.pedidomaisgostoso.R
import com.medium.jeffersontpadua.pedidomaisgostoso.dashboard.Prato
import com.medium.jeffersontpadua.pedidomaisgostoso.dashboard.color
import com.squareup.picasso.Picasso
import org.jetbrains.anko.*
import org.jetbrains.anko.cardview.v7.cardView

class CardapioItemUI(val parent: ViewGroup) : AnkoComponent<ViewGroup> {
    var itemView: View

    private lateinit var descricao: TextView
    private lateinit var preco: TextView
    private lateinit var imagem: ImageView

    init {
        itemView = createView(AnkoContext.create(parent.context, parent))
    }

    private val ID_IMAGEM: Int = 1

    private val ID_DESCRICAO: Int = 2

    override fun createView(ui: AnkoContext<ViewGroup>) = ui.apply {
        cardView {
            backgroundColor = color(R.color.card_default_background)
            verticalLayout {
                relativeLayout {
                    imagem = imageView {
                        id = ID_IMAGEM
                        adjustViewBounds = true
                    }.lparams(matchParent)

                    preco = textView("Text") {
                        setBackgroundColor(color(R.color.colorAccent))
                        textColor = color(android.R.color.white)
                        textSize = sp(6).toFloat()
                        padding = dip(4)
                    }.lparams {
                        alignParentTop()

                        margin = dip(8)
                    }
                }

                verticalLayout {
                    padding = dip(16)

                    descricao = textView {
                        id = ID_DESCRICAO
                        textSize = sp(8).toFloat()
                    }
                }
            }

            cardElevation = dip(4).toFloat()

        }.layoutParams = LinearLayout.LayoutParams(matchParent, wrapContent).apply {
            val defaultMargin = dip(8)
            setMargins(defaultMargin, defaultMargin, defaultMargin, defaultMargin)
        }
    }.view

    fun updateLayout(prato: Prato) {
        descricao.text = prato.descricao.toUpperCase()
        preco.text = parent.context.getString(R.string.preco_em_reais, prato.preco)
        Picasso.with(parent.context).load(prato.imageURL).into(imagem)
    }
}