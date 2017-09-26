package com.medium.jeffersontpadua.pedidomaisgostoso.dashboard

data class Prato(val descricao: String, val preco: Double, val imageURL: String)

interface ItemSelecionadoCallback {
    fun onItemSelecionado(prato: Prato)
    fun onItemRemovido(prato: Prato)
}

interface ValorTotalListener {
    fun getValorTotal(): Double
}

interface Service<T> {
    fun getData() : List<T>
}