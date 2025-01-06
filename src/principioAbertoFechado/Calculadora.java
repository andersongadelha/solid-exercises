package principioAbertoFechado;

import java.util.HashMap;
import java.util.Map;

public class Calculadora {
    private final Map<String, Operacao> operacoes = new HashMap<>();

    public Calculadora(Map<String, Operacao> novasOp) {
        operacoes.putAll(novasOp);
    }

    public int calcular(int a, int b, String operacao) {
        Operacao op = operacoes.get(operacao);

        return op.calcular(a, b);
    }
}
