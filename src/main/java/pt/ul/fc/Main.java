package pt.ul.fc;

/**
 * Cliente de {@link Canteiro}. NÃO ALTERE ESTE FICHEIRO (nem sequer espaços ou comentários):
 * a nota depende das linhas exatas deste ficheiro.
 * Cada sequenciaN() usa um objeto novo e termina com uma chamada que viola o protocolo.
 */
public class Main {

    public static void main(String[] args) {
        sequencia1();
        sequencia2();
        sequencia3();
        sequencia4();
    }


    /** Sequência inválida: a última chamada viola o protocolo. */
    static void sequencia1() {
        Canteiro canteiro = new Canteiro();
        canteiro.semear();
    }

    /** Sequência inválida: a última chamada viola o protocolo. */
    static void sequencia2() {
        Canteiro canteiro = new Canteiro();
        canteiro.lavrar();
        canteiro.semear();
        canteiro.colher();
        canteiro.colher();
    }

    /** Sequência inválida: a última chamada viola o protocolo. */
    static void sequencia3() {
        Canteiro canteiro = new Canteiro();
        canteiro.lavrar();
        canteiro.adubar();
        canteiro.semear();
        canteiro.repousar();
    }

    /** Sequência inválida: a última chamada viola o protocolo. */
    static void sequencia4() {
        Canteiro canteiro = new Canteiro();
        canteiro.adubar();
    }
}
