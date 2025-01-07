import principioInvescaoDependencia.Computador;
import principioInvescaoDependencia.DispositivoEntrada;
import principioInvescaoDependencia.Teclado;

public class Main {
    public static void main(String[] args) {
        DispositivoEntrada teclado = new Teclado();
        Computador computador = new Computador(teclado);
        computador.interagir();
    }
}