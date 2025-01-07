package principioInvescaoDependencia;

public class Computador {
    private DispositivoEntrada dispositivoEntrada;

    public Computador(DispositivoEntrada dispositivoEntrada) {
        this.dispositivoEntrada = dispositivoEntrada;
    }

    public void interagir() {
        dispositivoEntrada.usar();
    }
}
