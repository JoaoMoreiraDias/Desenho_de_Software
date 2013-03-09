public class informacaoConta extends transacao
{
    public informacaoConta(String numeroConta, ecran novo, baseDadosContas baseDados)
    {
        super(numeroConta, novo, baseDados);
    }

    public void realizar()
    {
        double saldoDisponivel=super.getBaseDados().getSaldoDisponivel(super.getNumeroConta());
        double saldoTotal=super.getBaseDados().getSaldoTotal(super.getNumeroConta());

        super.getEcran().mostrarMensagemParagrafo("\nInformação da Conta:");
        super.getEcran().mostrarMensagemParagrafo(" -Saldo disponível: ");
        super.getEcran().mostrarMensagemEuros(saldoDisponivel);
        super.getEcran().mostrarMensagemParagrafo("\n -Saldo total: ");
        super.getEcran().mostrarMensagemEuros(saldoTotal);
        super.getEcran().mostrarMensagemParagrafo("");
    }
}