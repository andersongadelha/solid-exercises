import principioAbertoFechado.Calculadora;
import principioAbertoFechado.Multiplicacao;
import principioAbertoFechado.Operacao;
import principioAbertoFechado.Soma;
import principioAbertoFechado.Subtracao;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, Operacao> operacoes = new HashMap<>();
        operacoes.put("soma", new Soma());
        operacoes.put("subtracao", new Subtracao());
        operacoes.put("multiplicacao", new Multiplicacao());
        Calculadora calculadora = new Calculadora(operacoes);

        System.out.println("Teste de operações");
        System.out.println("Soma:  2 + 5 = " + calculadora.calcular(2,5, "soma"));
        System.out.println("Subtração:  2 - 5 = " + calculadora.calcular(2,5, "subtracao"));
        System.out.println("Multiplicação:  2 * 5 = " + calculadora.calcular(2,5, "multiplicacao"));
    }
}