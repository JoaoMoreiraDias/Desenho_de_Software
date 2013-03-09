public abstract class transacao
{
    private String numeroConta;
    private ecran ecranNovo;
    private baseDadosContas baseDados;
    
    public transacao(String novoNumeroConta, ecran novo, baseDadosContas novaBaseDados)
    {
        numeroConta=novoNumeroConta;
        ecranNovo=novo;
        baseDados=novaBaseDados;
    }
    
    public String getNumeroConta()
    {
        return numeroConta;
    }
    
    public ecran getEcran()
    {
        return ecranNovo;
    }
    
    public baseDadosContas getBaseDados()
    {
        return baseDados;
    }
    
    abstract public void realizar();
}