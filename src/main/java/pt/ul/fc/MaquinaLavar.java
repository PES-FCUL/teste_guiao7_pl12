package pt.ul.fc;

import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;

/** Lavar roupa numa máquina de lavar. */
@StateSet({"vazia", "carregada", "aLavar", "terminada"})
public class MaquinaLavar {

    @StateRefinement(to="vazia()")
    public MaquinaLavar() {}

    /** Descarrega a roupa; a máquina fica vazia. */
    @StateRefinement(from="carregada() || terminada()", to="vazia()")
    public void descarregar() {}

    /** Termina a lavagem. */
    @StateRefinement(from="aLavar()", to="terminada()")
    public void terminar() {}

    /** Interrompe a lavagem; a roupa fica na máquina. */
    @StateRefinement(from="aLavar()", to="carregada()")
    public void interromper() {}

    /** Carrega a roupa. */
    @StateRefinement(from="vazia()", to="carregada()")
    public void carregar() {}

    /** Inicia a lavagem. */
    @StateRefinement(from="carregada()", to="aLavar()")
    public void iniciar() {}
}
