import principioResponsabilidadeUnica.EnvioPorEmail;
import principioResponsabilidadeUnica.RelatorioFinanceiro;

public class Main {
    public static void main(String[] args) {
        RelatorioFinanceiro relatorioFinanceiro = new RelatorioFinanceiro();
        EnvioPorEmail envioPorEmail = new EnvioPorEmail();
        relatorioFinanceiro.gerarRelatorio();
        envioPorEmail.enviarPorEmail();


    }
}