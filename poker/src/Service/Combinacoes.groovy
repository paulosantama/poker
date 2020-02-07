package Service

import Model.Carta

class Combinacoes {
    static final int pontuacaoPar = 100
    static final int pontuacaoTrio = 300
    static final int pontuacaoSequencia = 400
    static final int pontuacaoFlush = 500
    static final int pontuacaoFullHouse = 600
    static final int pontuacaoQuadra = 700
    static final int pontuacaoStraightFlush = 800
    static final int pontuacaoRoyalFlush = 900

    static int verificaPar(List<Carta> cartas){
        int pontuacao = 0
        Map<String,List<Carta>> pares = cartas.groupBy {it.descricao}.findAll {it.value.size()==2}
        if (pares.size()>0) {
            pontuacao += pontuacaoPar
            pontuacao += pares.values().max { it.first().valor }.first().valor
        }
        return pontuacao
    }
    static int verifica2Pares(List<Carta> cartas){
        int pontuacao = 0
        Map<String,List<Carta>> pares = cartas.groupBy {it.descricao}.findAll {it.value.size()==2}
        if (pares.size()>1) {
            pontuacao += 2*pontuacaoPar
            pontuacao += pares.values().sum{it.first().valor}
        }
        return pontuacao
    }
    static int verificaTrio(List<Carta> cartas){
        int pontuacao = 0
        Map<String,List<Carta>> trios = cartas.groupBy {it.descricao}.findAll {it.value.size()==3}
        if (trios.size()>0) {
            pontuacao += pontuacaoTrio
            pontuacao += trios.values().max { it.first().valor }.first().valor
        }
        return pontuacao
    }
    static int verificaFullHouse(List<Carta> cartas) {
        int pontuacao = 0
        Map<String, List<Carta>> trios = cartas.groupBy { it.descricao }.findAll { it.value.size() == 3 }
        if (trios.size() > 0) {
            int pontuacaoTrio = trios.values().max { it.first().valor }.first().valor
            cartas =  cartas - trios.values().flatten()
            int pontuacaoPar = (verificaPar(cartas) - pontuacaoPar)

            if (pontuacaoTrio && pontuacaoPar) pontuacao = pontuacaoTrio + pontuacaoPar + pontuacaoFullHouse
        }
        return pontuacao
    }
    static int verificaQuadra(List<Carta> cartas) {
        int pontuacao = 0
        Map.Entry<String,List<Carta>> quadra = cartas.groupBy {it.descricao}.find {it.value.size()==4}
        if (quadra) {
            pontuacao += pontuacaoQuadra
            pontuacao += quadra.value.first().valor
        }
        return pontuacao
    }
    static int verificaFlush(List<Carta> cartas) {
        int pontuacao = 0
        Map.Entry<String,List<Carta>> flush = cartas.groupBy {it.naipe}.find {it.value.size()==5}
        if (flush) {
            pontuacao += pontuacaoFlush
            pontuacao += flush.value.valor.max()
        }
        return pontuacao
    }
}
