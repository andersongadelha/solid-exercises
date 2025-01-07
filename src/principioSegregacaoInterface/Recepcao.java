package principioSegregacaoInterface;

public class Recepcao implements Atendente {
    @Override
    public void atender() {
        System.out.println("Atendendo cliente...");
    }
}
