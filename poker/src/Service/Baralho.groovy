package Service

import Model.Carta

class Baralho {
    Stack<Carta> cartas

    Baralho() {
        String[] naipes = ['O', 'E', 'P', 'C']
        Stack<Carta> cartasIniciais = []
        for (int j = 0; j < naipes.size(); j++) {
            String naipeAtual = naipes[j]
            for (int i = 2; i <= 14; i++) {
                Carta carta = new Carta()
                carta.valor = i
                carta.naipe = naipeAtual
                if (i <= 10) {
                    carta.descricao = i.toString()
                } else {
                    switch (i) {
                        case 11:
                            carta.descricao = 'J'
                            break
                        case 12:
                            carta.descricao = 'Q'
                            break
                        case 13:
                            carta.descricao = 'K'
                            break
                        case 14:
                            carta.descricao = 'A'
                            break
                    }
                }
                cartasIniciais << carta
            }
        }
        this.cartas = cartasIniciais
    }
    void embaralhar(){
        Collections.shuffle(this.cartas)
    }
    Carta pegarCarta(){
        return this.cartas.pop()
    }
}