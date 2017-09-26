package com.medium.jeffersontpadua.pedidomaisgostoso.dashboard.ui

import android.support.v7.widget.Toolbar
import android.view.Gravity
import android.widget.FrameLayout
import android.widget.TextView
import com.medium.jeffersontpadua.pedidomaisgostoso.R
import com.medium.jeffersontpadua.pedidomaisgostoso.dashboard.DashboardActivity
import com.medium.jeffersontpadua.pedidomaisgostoso.dashboard.ValorTotalListener
import com.medium.jeffersontpadua.pedidomaisgostoso.dashboard.color
import com.medium.jeffersontpadua.pedidomaisgostoso.dashboard.supportToolbar
import org.jetbrains.anko.*
import org.jetbrains.anko.design.appBarLayout
import org.jetbrains.anko.design.coordinatorLayout
import org.jetbrains.anko.design.floatingActionButton
import org.jetbrains.anko.design.snackbar
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.support.v4.drawerLayout

class DashboardUI(val totalListener: ValorTotalListener) : AnkoComponent<DashboardActivity> {
    lateinit var toolbarView: Toolbar
    lateinit var frameLayout: FrameLayout
    lateinit var valorTotal: TextView

    val ID_FRAME_LAYOUT: Int = 1

    override fun createView(ui: AnkoContext<DashboardActivity>) = ui.apply {
        drawerLayout {
            coordinatorLayout {
                verticalLayout {
                    appBarLayout {
                        toolbarView = supportToolbar {
                            elevation = dip(4).toFloat()

                            setTitleTextColor(color(android.R.color.white))
                        }

                        valorTotal = textView(getTotalFormatado()) {
                            textSize = sp(14).toFloat()
                            textColor = color(android.R.color.white)
                        }.lparams {
                            marginStart = dip(72)
                            bottomMargin = dip(16)
                        }
                    }

                    frameLayout = frameLayout {
                        id = ID_FRAME_LAYOUT
                    }
                }.lparams(width = matchParent)

                floatingActionButton {
                    imageResource = R.drawable.ic_done_all_white_24dp

                    onClick {
                        alert {
                            title = ctx.getString(R.string.confirmar_pedido_title)
                            message = ctx.getString(R.string.confirmar_pedido, totalListener.getValorTotal())
                            noButton { it.dismiss() }
                            yesButton {
                                snackbar(this@coordinatorLayout, ctx.getString(R.string.pedido_confirmado, totalListener.getValorTotal()))
                            }
                        }.show()
                    }
                }.lparams {
                    gravity = Gravity.BOTTOM or Gravity.END
                    bottomMargin = dip(16)
                    rightMargin = dip(16)
                }
            }
        }
    }.view

    private fun getTotalFormatado() = "R$ %.2f".format(totalListener.getValorTotal())

    fun atualizarValorTotal() {
        this.valorTotal.text = getTotalFormatado()
    }
}