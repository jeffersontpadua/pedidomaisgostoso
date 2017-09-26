package com.medium.jeffersontpadua.pedidomaisgostoso.dashboard.service

import com.medium.jeffersontpadua.pedidomaisgostoso.dashboard.Prato
import com.medium.jeffersontpadua.pedidomaisgostoso.dashboard.Service

object PratoService : Service<Prato> {
    override fun getData(): List<Prato> {
        return listOf(Prato("Arroz", 5.50, "https://www.dicasdemulher.com.br/wp-content/uploads/2017/06/arroz-simples.jpg"),
                Prato("Feijão", 4.50, "http://g.glbimg.com/og/gs/gsat5/f/thumbs/tag/2015/07/14/feijao-620_1.jpg"),
                Prato("Salada", 8.95, "http://fabianascaranzi.com.br/wp-content/uploads/2016/01/salada-1.png"),
                Prato("Churrasco", 14.90, "http://d3hjny6johi4mp.cloudfront.net/wp-content/uploads/2016/06/os-melhores-cortes-de-carne-para-churrasco.jpg"),
                Prato("Macarronada", 7.99, "https://abrilclaudia.files.wordpress.com/2010/04/macarronada.jpg?quality=85&strip=info&w=680&h=453&crop=1"),
                Prato("Lasagna", 9.80, "https://assets.bonappetit.com/photos/57adf3c353e63daf11a4dfa2/16:9/w_1000,c_limit/lasagna-bolognese.jpg"))
    }
}