package pt.ul.fc;

import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;

/** Utilizar uma máquina de café. */
@StateSet({"desligada", "pronta", "aFazerCafe"})
public class MaquinaCafe {

    @StateRefinement(to="desligada()")
    public MaquinaCafe() {}

    /** Descalcifica a máquina (continua desligada). */
    @StateRefinement(from="desligada()", to="desligada()")
    public void descalcificar() {}

    /** Recolhe a chávena; a máquina fica pronta. */
    @StateRefinement(from="aFazerCafe()", to="pronta()")
    public void recolher() {}

    /** Desliga a máquina (cancela o café, se houver). */
    @StateRefinement(from="pronta() || aFazerCafe()", to="desligada()")
    public void desligar() {}

    /** Começa a fazer um café. */
    @StateRefinement(from="pronta()", to="aFazerCafe()")
    public void fazerCafe() {}

    /** Liga a máquina. */
    @StateRefinement(from="desligada()", to="pronta()")
    public void ligar() {}
}
