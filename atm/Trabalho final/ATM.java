public class ATM
{
    private boolean estaAutenticado;
    private String numeroConta;
    private ecran ecranNovo;
    private teclado tecladoNovo;
    private caixaDinheiro caixaDinheiroNova;
    private caixaDeposito caixaDepositoNova;
    private baseDadosContas baseDados;

    public ATM()
    {
        estaAutenticado=false;
        numeroConta="";
        ecranNovo=new ecran();
        tecladoNovo = new teclado();
        caixaDinheiroNova = new caixaDinheiro();
        caixaDepositoNova = new caixaDeposito();
        baseDados = new baseDadosContas();
    }

    public void executar()
    {
        while (true)
        {
            while (estaAutenticado==false)
            {
                ecranNovo.mostrarMensagemParagrafo("\nBem vindo!");
                autenticarUtilizador();
            }

            menuTransacoes();
            estaAutenticado=false;
            numeroConta="";
            ecranNovo.mostrarMensagemParagrafo("\nObrigado! Volte sempre!");
        }
    }

    private void autenticarUtilizador()
    {
        ecranNovo.mostrarMensagemParagrafo("\nInserir numero conta: ");
        String numeroContaVerificar = tecladoNovo.getInput();
        ecranNovo.mostrarMensagemParagrafo("\nInserir Pin: ");
        String pinVerificar=tecladoNovo.getInput();

        estaAutenticado=baseDados.autenticarConta(numeroContaVerificar, pinVerificar);

        if (estaAutenticado==true)
        {
            numeroConta=numeroContaVerificar;
        }
        else
        {
            ecranNovo.mostrarMensagemParagrafo("Número da conta ou Pin errados. Tente novamente.");
        }
    }

    private void menuTransacoes()
    {
        transacao transacaoActual=null;

        boolean escolheuSair=false;

        while (escolheuSair==false)
        {
            int escolha = menuOperacoes();

            switch (escolha)
            {
                case 1: 
                transacaoActual=criarTransacao(1);
                transacaoActual.realizar();
                break;
                case 2:
                transacaoActual=criarTransacao(2);
                transacaoActual.realizar();
                break;
                case 3:
                transacaoActual=criarTransacao(3);
                transacaoActual.realizar();
                break;
                case 4:
                ecranNovo.mostrarMensagemParagrafo("\nA terminar sessão..." );
                escolheuSair=true;
                break;
                default:
                ecranNovo.mostrarMensagemParagrafo("\nOpção invalida. Seleccione outra." );
                break;
            }
        }
    }

    private int menuOperacoes()
    {
        ecranNovo.mostrarMensagemParagrafo("\nMenu:");
        ecranNovo.mostrarMensagemParagrafo("1 - Ver informação conta");
        ecranNovo.mostrarMensagemParagrafo("2 - Levantar dinheiro");
        ecranNovo.mostrarMensagemParagrafo("3 - Depositar dinheiro");
        ecranNovo.mostrarMensagemParagrafo("4 - Sair\n");
        ecranNovo.mostrarMensagemParagrafo("Escolher opção: ");
        return Integer.parseInt(tecladoNovo.getInput());
    }

    private transacao criarTransacao(int numeroTransacao)
    {
        transacao temp=null;

        switch (numeroTransacao)
        {
            case 1:
            temp=new informacaoConta(numeroConta, ecranNovo, baseDados);
            break;
            case 2:
            temp=new levantar(numeroConta, ecranNovo, baseDados, tecladoNovo, caixaDinheiroNova);
            break;
            case 3:
            temp=new deposito(numeroConta, ecranNovo, baseDados, tecladoNovo, caixaDepositoNova);
            break;
        }

        return temp;
    }
}