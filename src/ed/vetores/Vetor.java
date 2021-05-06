package ed.vetores;

import java.util.Arrays;

public class Vetor {

    private Aluno [] alunos = new Aluno[100];
    // começo a guardar a posicao desde o começo.
    // O o aponta quantos alunos eu tenho cadastrado no Array e a próxima posição vazia.
    private int totalDeAlunos = 0;

    public void adiciona(Aluno aluno) {
        this.garanteEspaco();
        // Essa solução leva tempo constante. Independente do tamanho do array, a performance será sempre a mesma.
        this.alunos[totalDeAlunos] = aluno;
        totalDeAlunos++;

    }
        // Esse algoritmo é O de N. Inserir um aluno depende do tamanho da lista. Quanto maior, mais devagar é o programa.
        // A melhor solução é rodar um algoritmo com tempo constante. Independe do número de elementos.
//        for(int i = 0; i <= alunos.length; i++) {
//            if(alunos[i] == null) {
//                alunos[i] = aluno;
//                break;
//            }
//        }
    // Método pra validar o método adiciona
    private boolean posicaoValida(int posicao) {
        return posicao >= 0 && posicao < totalDeAlunos;
    }

    private void garanteEspaco() {
        if(totalDeAlunos == alunos.length) {
            // Criei um novo array e recebi o array antigo e atribuí um novo valor
            Aluno [] novoArray = new Aluno[alunos.length * 2];
                for(int i = 0; i < alunos.length; i++) {
                    novoArray [i] = alunos[i];
                }
                this.alunos = novoArray;
        }
    }
    public void adiciona(int posicao, Aluno aluno) {
        this.garanteEspaco();
        if(!posicaoValida(posicao)) {
            throw new IllegalArgumentException("Posição Inválida");
        }
        // Itero a lista da útima posição com elemento até a posição que quero inserir o aluno e vou decrementando.
        // o for empurra todo mundo pra direita.
        for(int i = totalDeAlunos - 1; i >= posicao; i -= 1) {
            // aqui é a abertura do espaço
            alunos[i+1] = alunos[i];
        }
        // aqui eu insiro o novo aluno na posição que vagou
        alunos[posicao] = aluno;
        totalDeAlunos++;
    }


    private boolean posicaoOcupada(int posicao) {
        return posicao >= 0 && posicao < totalDeAlunos;
    }
    public Aluno pega (int posicao) {

        if(!posicaoOcupada(posicao)) {
            throw new IllegalArgumentException("posição inválida");
        }
        return alunos[posicao];
    }

    public void remove (int posicao) {
        for(int i = posicao; i < totalDeAlunos; i++) {
            alunos[i] = alunos[i +1];

        }
        totalDeAlunos--;
    }

    public boolean contem(Aluno aluno) {
        // Ao chamar o a3 dá Null Pointer Exception. A solução é rodar o Array até a posição que há elementos.
        for(int i = 0; i < totalDeAlunos; i++){
            if(aluno.equals(alunos[i])) {
                return true;
            }
        }
        return false;
    }

    public int tamanho () {
        return totalDeAlunos;
    }

    public String toString() {
        return Arrays.toString(alunos);
    }
}
