package pt.ul.fc;

import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;

/** Verter o conteúdo de uma garrafa. */
@StateSet({"selada", "aberta", "aVerter", "vazia", "tapada"})
public class Garrafa {

    @StateRefinement(to="selada()")
    public Garrafa() {}

    /** Inclina a garrafa e começa a verter. */
    @StateRefinement(from="aberta()", to="aVerter()")
    public void inclinar() {}

    /** Volta a pôr a tampa (definitivo). */
    @StateRefinement(from="aberta() || vazia()", to="tapada()")
    public void tapar() {}

    /** Tira a tampa da garrafa. */
    @StateRefinement(from="selada()", to="aberta()")
    public void abrir() {}

    /** O último conteúdo sai da garrafa. */
    @StateRefinement(from="aVerter()", to="vazia()")
    public void esvaziar() {}

    /** Endireita a garrafa e pára de verter. */
    @StateRefinement(from="aVerter()", to="aberta()")
    public void endireitar() {}
}
