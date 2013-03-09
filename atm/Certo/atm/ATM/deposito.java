public class deposito extends transacao
{
    private double quantidade;
    private teclado novo;
    private caixaDeposito caixaDep;

    public deposito(String numeroConta, ecran novoEcran, baseDadosContas baseDados, teclado novoTeclado, caixaDeposito novaCaixaDeposito)
    {
        super(numeroConta, novoEcran, baseDados);
        novo=novoTeclado;
        caixaDep=novaCaixaDeposito;
    }

    public void realizar()
    {
        quantidade=obterQuantidadeADepositar();

        if (quantidade!=0)
        {
            super.getEcran().mostrarMensagemParagrafo("\nPor favor insira o envelope com as notas no interior, não introduza moedas ");
            super.getEcran().mostrarMensagemEuros(quantidade);
            super.getEcran().mostrarMensagemParagrafo(".");

            caixaDep.oEnvelopeFoiRecebido();
            if (caixaDep.getEstado()==true)
            {
                String mensagem="\nEnvelope recebido com sucesso!";
                mensagem+="\nIMPORTANTE: O dinheiro que depositou só vai estar disponivel depois de verificado.";

                super.getEcran().mostrarMensagemParagrafo(mensagem);
                super.getBaseDados().depositar(super.getNumeroConta(), quantidade);
            }
            else
            {
                super.getEcran().mostrarMensagemParagrafo("\nNão inseriou nenhum envelope, a operação vai ser cancelada!");
            }
        }
        else
        {
            super.getEcran().mostrarMensagemParagrafo("\nDeposito cancelado!");
        }
    }

    private double obterQuantidadeADepositar()
    {
        super.getEcran().mostrarMensagemParagrafo( "\nInsira total a depositar em centimos (0 para cancelar) " );
        int total=Integer.parseInt(novo.getInput());

        if (total==0)
        {
            return 0;
        }
        else
        {
            return (double)total/100;
        }
    }
}