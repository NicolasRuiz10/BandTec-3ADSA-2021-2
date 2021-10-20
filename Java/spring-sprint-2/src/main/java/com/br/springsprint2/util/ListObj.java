package com.br.springsprint2.util;
public class ListObj<T> {
    //  Atributos
    private T[] vetor;
    private int numeroElementos;

    //  Construtor
    public ListObj (long tamanho) {
        vetor = (T[]) new Object[(int) tamanho];
        numeroElementos = 0;
    }

    //  Métodos
    //  Método adicionar - recebe como argumento um valor a ser inserido na listas
    public Boolean adicionar (T elemento) {
        if (numeroElementos < vetor.length) {
            System.out.println("Adicionado na lista com sucesso ✔");
            vetor[numeroElementos++] = elemento;
            return true;
        } else {
            System.out.println("Lista Cheia ❌");
            return false;
        }
    }

    //  Método exibe - Exibe os elementos da lista
    public void exibe () {
        if (numeroElementos == 0) {
            System.out.println("\n Lista está vazia");
        } else {
            for (int x = 0; x < numeroElementos; x++) {
                System.out.print(vetor[x]+"\t\n");
            }
        }
    }

    //  Método busca - recebe um valor  ser pesquisado no vetor, e retorna o seu indice ou -1 se não estiver no vetor.
    public int busca(T valorPesquisado) {
        for (int i = 0; i < numeroElementos; i++) {
            if (vetor[i].equals(valorPesquisado)) {
                return i;
            }
        }
        return -1;
    }

    //    Método removePeloIndice - receve o indice do valor a ser removido. Retorna true se conseguiu remover e false caso contrário
    public Boolean removePeloIndice (int indice) {
        if (indice < 0 || indice >= numeroElementos) {
            System.out.println("\n\nÍndice inválido ❌");
            return false;
        }
        else {
//          Loop para "deslocar para a esquerda" os valores ao vetor sobrescrevendo o valor removido
            for (int i = indice; i < numeroElementos-1; i++) {
                vetor[i] = vetor[i+1];
            }
            numeroElementos--;
            return true;
        }
    }

    //    Método removeElemento - recebe o elemeto a ser removido
    public Boolean removeElemento (T valor) {
        return removePeloIndice(busca(valor));
    }

    //   Método get Tamanho
    public int getTamanho() {
        if (numeroElementos != 0) {
            return numeroElementos;
        } else {
            return 0;
        }
    }

    public T getElemento(int indice) {
        if (indice < 0 || indice >= numeroElementos) {
            return null;
        } else {
            return vetor[indice];
        }
    }

    public void limpa() {
        numeroElementos = 0;
    }

}
