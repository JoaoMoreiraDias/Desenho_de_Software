public class levantar extends transacao
{
    private int quantidade;
    private teclado novo;
    private caixaDinheiro nova;

    public levantar(String numeroConta, ecran ecranNovo, baseDadosContas baseDados, teclado tecladoNovo, caixaDinheiro novaCaixaDinheiro)
    {
        super(numeroConta, ecranNovo, baseDados);
        novo=tecladoNovo;
        nova=novaCaixaDinheiro;
    }

    public void realizar()
    {
        boolean realizado=false;

        while (realizado==false)
        {
            quantidade=escolherQuantidade();
            if (quantidade!=0)
            {
                if (quantidade<=super.getBaseDados().getSaldoDisponivel(super.getNumeroConta()))
                {
                    if (nova.existeNotasSuficientes(quantidade)==true)
                    {
                        super.getBaseDados().levantar(super.getNumeroConta(), quantidade);

                        nova.levantar(quantidade);
                        realizado=true;

                        super.getEcran().mostrarMensagemParagrafo("\nOperação efectuada com sucesso! \nPor favor retira dinheiro.");
                    }
                    else
                    {
                        super.getEcran().mostrarMensagemParagrafo("\nLamentamos mas não temos a quantia pedida. \nPor favor introduza uma quantia mais pequena.");
                    }
                }
                else
                {
                    super.getEcran().mostrarMensagemParagrafo("\nSaldo insufuciente! nPor favor introduza uma quantia mais pequena." );
                }
            }
            else
            {
                super.getEcran().mostrarMensagemParagrafo("\nA cancelar operação...");
                return;
            }
        }
    }

    private int escolherQuantidade()
    {
        int escolha=0;
        int resultado=0;

        while (resultado==0)
        {
            super.getEcran().mostrarMensagemParagrafo("\nQuantias:");
            super.getEcran().mostrarMensagemParagrafo("1 - 20€");
            super.getEcran().mostrarMensagemParagrafo("2 - 40€");
            super.getEcran().mostrarMensagemParagrafo("3 - 60€");
            super.getEcran().mostrarMensagemParagrafo("4 - 100€");
            super.getEcran().mostrarMensagemParagrafo("5 - 200€");
            super.getEcran().mostrarMensagemParagrafo("6 - Cancelar operação");
            super.getEcran().mostrarMensagemParagrafo("\nEscolha quantidade: ");

            escolha = Integer.parseInt(novo.getInput());

            switch (escolha)
            {
                case 1: resultado=20;
                break;
                case 2: resultado=40;
                break;
                case 3: resultado=50;
                break;
                case 4: resultado=100;
                break;  
                case 5: resultado=200;
                break;
                case 6: escolha=0;
                break;
                default:super.getEcran().mostrarMensagemParagrafo("\nOpção invalida. Seleccione outra.");
                break;
            }
        }
        return resultado;
    }
}