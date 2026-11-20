# Ramo `fc65646`: Utilizar uma máquina de café

Este ramo é só seu. Contém um pequeno projeto Java 21 / Maven que usa o LiquidJava.

> **Não altere o `Main.java`** (nem sequer espaços ou comentários) **nem a pasta `.github/`.**
> A nota é calculada exclusivamente a partir do registo da GitHub Action *Análise estática
> LiquidJava* do seu PR, que depende das linhas exatas do `Main.java`. Um PR que altere um destes
> ficheiros tem 0 pontos neste exercício.

## A máquina de estados

A máquina tem de ser ligada antes de fazer café. Enquanto faz café, tem de se recolher a chávena para poder fazer outro. Pode ser desligada quando está pronta ou a fazer café (cancelando-o). A descalcificação só se faz com a máquina desligada.

Em `src/main/java/pt/ul/fc/MaquinaCafe.java` está a classe `MaquinaCafe`, anotada com `@StateSet` com os estados abaixo.

- `desligada`: desligada
- `pronta`: ligada e pronta
- `aFazerCafe`: a fazer café

O protocolo da classe (a *única* fonte de verdade) é este:

| Método | Estado de origem permitido | Estado de destino | O que faz |
|---|---|---|---|
| Construtor `MaquinaCafe()` | — | `desligada` | Cria o objeto. |
| `ligar()` | `desligada` | `pronta` | Liga a máquina. |
| `fazerCafe()` | `pronta` | `aFazerCafe` | Começa a fazer um café. |
| `recolher()` | `aFazerCafe` | `pronta` | Recolhe a chávena; a máquina fica pronta. |
| `desligar()` | `pronta` ou `aFazerCafe` | `desligada` | Desliga a máquina (cancela o café, se houver). |
| `descalcificar()` | `desligada` | `desligada` | Descalcifica a máquina (continua desligada). |

![Máquina de estados de MaquinaCafe](assets/maquina_estados.png)

O estado inicial é `desligada`. Um método só pode ser chamado nos estados de origem indicados
e, depois de terminar, o objeto fica no estado de destino.

## O que fazer

1. Abra `src/main/java/pt/ul/fc/MaquinaCafe.java`. O método `ligar()` já tem o seu contrato
   (`from="desligada()", to="pronta()"`): serve de exemplo. Os restantes 4 métodos têm
   `@StateRefinement(from="true", to="true")`, que não especifica nada. Preencha, em cada um deles, o `from`
   e o `to` do quadro.
2. Em `src/main/java/pt/ul/fc/Main.java`, os métodos
   `sequencia1()` a `sequencia4()` terminam todos com uma chamada **inválida**, uma por cada método
   que tem de especificar. **Não altere o `Main.java`**: o `main` tem de continuar a chamar os
   métodos da forma errada.
3. Com o ficheiro guardado, confirme no VS Code (extensão LiquidJava) que cada uma das 4 sequências
   inválidas tem **um erro** na última chamada.
4. Não remova o `@StateSet`, não use supressões e não mude as assinaturas dos métodos.
5. Faça *commit* e *push* do seu ramo: `git push origin fc65646`.
6. Abra um PR para o repositório original, com o ramo `fc65646` como destino.

Quando o seu trabalho estiver correto, a GitHub Action **Análise estática LiquidJava** do PR
**falha**: é o resultado esperado, porque o `Main` viola de propósito o protocolo.
Se a Action passar, os seus contratos estão demasiado permissivos.

A nota é dada pelo número de sequências inválidas que o LiquidJava rejeita no registo dessa
Action (até 4 pontos, um por cada método especificado). Confirme no separador *Checks* do PR que a
Action correu.

Use mensagens de *commit* com significado.

## Comandos úteis

```
java -version                 # deve ser JDK 21
mvn -version                  # Maven 3.9 ou superior, com JDK 21
mvn clean compile             # só compila o Java; a verificação LiquidJava é feita pela extensão
git fetch origin
git checkout fc65646
git add -A
git commit -m "Mensagem"
git push origin fc65646
./setup.sh "Nome" "email"     # configura o git (se ainda não o fez)
```

`mvn compile` não executa o LiquidJava: um projeto que compila pode ter erros de refinamento.
