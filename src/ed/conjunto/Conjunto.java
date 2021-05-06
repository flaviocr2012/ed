package ed.conjunto;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public class Conjunto {

    // Guaradar 26 listas dentro da tabela
    private ArrayList<LinkedList<String>> tabela = new ArrayList<LinkedList<String>>();

    public Conjunto() {
        for (int i = 0; i < 26; i++) {
            tabela.add(new LinkedList<String>());
        }
    }

    public void adiciona(String palavra) {

        if (!contem(palavra)) {
            int indice = calculaIndiceDaTabela(palavra);
            List<String> lista = tabela.get(indice);
            lista.add(palavra);
        }
    }

    public void remove(String palavra) {
        if (contem(palavra)) {
            int indice = calculaIndiceDaTabela(palavra);
            List<String> lista = tabela.get(indice);
            lista.remove(palavra);
        }
    }

    private boolean contem(String palavra) {
        int indice = calculaIndiceDaTabela(palavra);
        return tabela.get(indice).contains(palavra);
    }

    // função que espalha os dados
    private int calculaIndiceDaTabela(String palavra) {
        // retorna o resto da divisão por 26, que será um número de 0 a 25.
        return palavra.toLowerCase().charAt(0) % 26;
    }

    @Override
    public String toString() {
        return tabela.toString();
    }
}

// A vantagem do Arraylist é que posso pegar (get) um elemento em qualquer posicao na lista e é rápido.
// Na linkedlist teria que percorrer a lista inteira. A vantangem era que pra inserir ou deletar alguém
// da lista era mais fácil por conta da referência da célula.

// Conjunto são estruturas de dados que não aceitam elementos repetidos. Precisa saber se o elemento já existe,
// pra isso precisa executar a função de espalhamento. Se espalha bem, ela vai olhar pra menos elementos no conjunto
// e a execução do programa será mais rápida.
