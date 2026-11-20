package pt.ul.fc;

/**
 * Cliente de {@link MaquinaCafe}. NÃO ALTERE ESTE FICHEIRO (nem sequer espaços ou comentários):
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
        MaquinaCafe maquinaCafe = new MaquinaCafe();
        maquinaCafe.ligar();
        maquinaCafe.fazerCafe();
        maquinaCafe.desligar();
        maquinaCafe.fazerCafe();
    }

    /** Sequência inválida: a última chamada viola o protocolo. */
    static void sequencia2() {
        MaquinaCafe maquinaCafe = new MaquinaCafe();
        maquinaCafe.recolher();
    }

    /** Sequência inválida: a última chamada viola o protocolo. */
    static void sequencia3() {
        MaquinaCafe maquinaCafe = new MaquinaCafe();
        maquinaCafe.descalcificar();
        maquinaCafe.ligar();
        maquinaCafe.desligar();
        maquinaCafe.desligar();
    }

    /** Sequência inválida: a última chamada viola o protocolo. */
    static void sequencia4() {
        MaquinaCafe maquinaCafe = new MaquinaCafe();
        maquinaCafe.descalcificar();
        maquinaCafe.descalcificar();
        maquinaCafe.ligar();
        maquinaCafe.descalcificar();
    }
}
