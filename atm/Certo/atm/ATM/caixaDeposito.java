public class caixaDeposito
{
    private boolean recebido;
    
    public caixaDeposito()
    {
        recebido=false;
    }
    
    public void oEnvelopeFoiRecebido()
    {
        recebido=true;
    }
    
    public boolean getEstado()
    {
        return recebido;
    }
}