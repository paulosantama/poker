import Model.Mao
import Model.Mesa
import Service.Baralho
import Service.Combinacoes

Baralho baralho = new Baralho()
baralho.embaralhar()

Mao mao1 = new Mao()
mao1.cartas << baralho.pegarCarta()
mao1.cartas << baralho.pegarCarta()

Mao mao2 = new Mao()
mao2.cartas << baralho.pegarCarta()
mao2.cartas << baralho.pegarCarta()

Mao mao3 = new Mao()
mao3.cartas << baralho.pegarCarta()
mao3.cartas << baralho.pegarCarta()

Mesa mesa = new Mesa()
mesa.cartas << baralho.pegarCarta()
mesa.cartas << baralho.pegarCarta()
mesa.cartas << baralho.pegarCarta()
mesa.cartas << baralho.pegarCarta()
mesa.cartas << baralho.pegarCarta()

int pontuacaoMao1 = 0
int pontuacaoMao2 = 0
int pontuacaoMao3 = 0

pontuacaoMao1+= Combinacoes.verificaPar(mao1.cartas+mesa.cartas)
pontuacaoMao2+= Combinacoes.verificaPar(mao2.cartas+mesa.cartas)
pontuacaoMao3+= Combinacoes.verificaPar(mao3.cartas+mesa.cartas)

pontuacaoMao1+= Combinacoes.verifica2Pares(mao1.cartas+mesa.cartas)
pontuacaoMao2+= Combinacoes.verifica2Pares(mao2.cartas+mesa.cartas)
pontuacaoMao3+= Combinacoes.verifica2Pares(mao3.cartas+mesa.cartas)

pontuacaoMao1+= Combinacoes.verificaTrio(mao1.cartas+mesa.cartas)
pontuacaoMao2+= Combinacoes.verificaTrio(mao2.cartas+mesa.cartas)
pontuacaoMao3+= Combinacoes.verificaTrio(mao3.cartas+mesa.cartas)

pontuacaoMao1+= Combinacoes.verificaFullHouse(mao1.cartas+mesa.cartas)
pontuacaoMao2+= Combinacoes.verificaFullHouse(mao2.cartas+mesa.cartas)
pontuacaoMao3+= Combinacoes.verificaFullHouse(mao3.cartas+mesa.cartas)

pontuacaoMao1+= Combinacoes.verificaQuadra(mao1.cartas+mesa.cartas)
pontuacaoMao2+= Combinacoes.verificaQuadra(mao2.cartas+mesa.cartas)
pontuacaoMao3+= Combinacoes.verificaQuadra(mao3.cartas+mesa.cartas)

pontuacaoMao1+= Combinacoes.verificaFlush(mao1.cartas+mesa.cartas)
pontuacaoMao2+= Combinacoes.verificaFlush(mao2.cartas+mesa.cartas)
pontuacaoMao3+= Combinacoes.verificaFlush(mao3.cartas+mesa.cartas)

String mesaStr = ''
mesa.cartas.each {
    mesaStr += it.descricao+it.naipe+'    '
}
println(mesaStr)

String mao1Str = ''
mao1.cartas.each {
    mao1Str += it.descricao+it.naipe+'    '
}
println(mao1Str)
println(pontuacaoMao1)

String mao2Str = ''
mao2.cartas.each {
    mao2Str += it.descricao+it.naipe+'    '
}
println(mao2Str)
println(pontuacaoMao2)

String mao3Str = ''
mao3.cartas.each {
    mao3Str += it.descricao+it.naipe+'    '
}
println(mao3Str)
println(pontuacaoMao3+'\n')

Integer [] pontuacoes = [pontuacaoMao1, pontuacaoMao2, pontuacaoMao3]
println(pontuacoes.max())