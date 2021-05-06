package ed.listaligada;

public class ListaLigada {

    private Celula primeira;
    private Celula ultima;
    private int totalDeElementos;

    public void adicionaNoComeco(Object elemento) {
        // Se a lista estiver vazia
        if (this.totalDeElementos == 0) {
        // cria-se uma nova célula e o próximo é nulo
            Celula nova = new Celula(elemento);
                this.primeira =nova;
                this.ultima =nova;
            } else { // Se não estiver vazia, cria-se uma nova célula cuja a próxima é a primeira.
                Celula nova = new Celula(elemento, this.primeira);
                // seto a anterior a primeira como nova
                this.primeira.setAnterior(nova);
                this.primeira = nova;
            }
            this.totalDeElementos++;
        }

    @Override
    public String toString() {
        if (this.totalDeElementos == 0) {
            return "[]";
        }

        Celula atual = primeira;

        StringBuilder builder = new StringBuilder("[");

        for (int i = 0; i < totalDeElementos; i++) {
            builder.append(atual.getElemento());
            builder.append(",");

            atual = atual.getProxima();
        }

        builder.append("]");

        return builder.toString();
    }

    // adiciona no final
    public void adiciona(Object elemento) {

        if (this.totalDeElementos == 0) {
            adicionaNoComeco(elemento);
        } else {
            Celula nova = new Celula(elemento);
            this.ultima.setProxima(nova);
            nova.setAnterior(this.ultima);
            this.ultima = nova;
            this.totalDeElementos++;

        }
        }

    private boolean posicaoOcupada(int posicao) {
        return posicao >= 0 && posicao < totalDeElementos;
    }

    private Celula pegaCelula(int posicao) {
        if (!posicaoOcupada(posicao)) {
            throw new IllegalArgumentException("posicao inexistente");
        }

        Celula atual = primeira;
        for (int i = 0; i < posicao; i++) {
            atual = atual.getProxima();
        }
        return atual;
    }

    // adiciona no meio
    public void adiciona(int posicao, Object elemento) {

        if (posicao == 0) {
            adicionaNoComeco(elemento);
        } else if (posicao == this.totalDeElementos) {
            adiciona(elemento);
        } else {

            Celula anterior = pegaCelula(posicao - 1);
            Celula proxima = anterior.getProxima();

            Celula nova = new Celula(elemento, anterior.getProxima());
            nova.setAnterior(anterior);
            anterior.setProxima(nova);
            proxima.setAnterior(nova);
            this.totalDeElementos++;

//            // Primeira celula (paulo)
//            Celula anterior = this.pegaCelula(posicao - 1);
//            // Celula do meio (Gabriel)
//            Celula nova = new Celula(elemento, anterior.getProximo());
//            // O próximo do Paulo é o Gabriel e não mais o Maurício
//            anterior.setProximo(nova);
//            this.totalDeElementos++;
        }
    }

    public Object pega(int posicao) {

        return this.pegaCelula(posicao).getElemento();
    }

    public void removeDoComeco() {

        if (this.totalDeElementos == 0) {
            throw new IllegalArgumentException("lista vazia");
        }

        this.primeira = this.primeira.getProxima();
        this.totalDeElementos--;

        if (this.totalDeElementos == 0) {
            this.ultima = null;
        }

    }

    public void remove(int posicao) {
        if(posicao == 0) {
            this.removeDoComeco();
        } else if( posicao == this.totalDeElementos -1) {
            this.removeDoFim();
        } else {

            Celula anterior = this.pegaCelula(posicao -1);
            Celula atual = anterior.getProxima();
            Celula proxima = atual.getProxima();

            anterior.setProxima(proxima);
            proxima.setAnterior(anterior);

            this.totalDeElementos--;
        }

    }

    public int tamanho() {

        return this.totalDeElementos;
    }

    public boolean contem(Object elemento) {
        Celula atual = this.primeira;

        while (atual != null) {
            if(atual.getElemento().equals(elemento)) {
                return true;
            }
            atual = atual.getProxima();
        }

        return false;
    }

    public void removeDoFim() {
        if(totalDeElementos == 1) {
            this.removeDoComeco();
        } else {
            Celula penultima = this.ultima.getAnterior();
            penultima.setProxima(null);
            this.ultima = penultima;
            this.totalDeElementos--;
        }

    }

    }
