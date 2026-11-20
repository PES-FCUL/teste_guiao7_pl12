package pt.ul.fc;

import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;

/** Emprestar um livro da biblioteca. */
@StateSet({"disponivel", "requisitado", "atrasado", "perdido"})
public class EmprestimoLivro {

    @StateRefinement(to="disponivel()")
    public EmprestimoLivro() {}

    /** Devolve o livro à biblioteca. */
    @StateRefinement(from="requisitado()", to="disponivel()")
    public void devolver() {}

    /** Renova o empréstimo (o livro continua requisitado). */
    @StateRefinement(from="requisitado()", to="requisitado()")
    public void renovar() {}

    /** Marca o empréstimo como atrasado. */
    @StateRefinement(from="requisitado()", to="atrasado()")
    public void marcarAtraso() {}

    /** Dá o livro como perdido (definitivo). */
    @StateRefinement(from="atrasado()", to="perdido()")
    public void declararPerdido() {}

    /** Requisita o livro. */
    @StateRefinement(from="disponivel()", to="requisitado()")
    public void requisitar() {}
}
