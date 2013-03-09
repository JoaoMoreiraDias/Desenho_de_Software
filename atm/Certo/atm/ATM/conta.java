public class conta
{
    private String numeroConta;
    private String nomeUtilizador;
    private String pin;
    private double saldoDisponivel;
    private double saldoTotal;
    
    public conta(String novoNumeroConta, String novoNomeUtilizador, String novoPin, double novoSaldoDisponivel, double novoSaldoTotal)
    {
        numeroConta=novoNumeroConta;
        nomeUtilizador=novoNomeUtilizador;
        pin=novoPin;
        saldoDisponivel=novoSaldoDisponivel;
        saldoTotal=novoSaldoTotal;
    }
    
    public boolean pinValido(String pinVerificar)
    {
        if(pinVerificar.compareTo(pin)==0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public double getSaldoDisponivel()
    {
        return saldoDisponivel;
    }
    
    public double getSaldoTotal()
    {
        return saldoTotal;
    }
    
    public void depositar(double quantia)
    {
        saldoTotal+=quantia;
    }
    
    public void levantar(double quantia)
    {
        saldoDisponivel-=quantia;
        saldoTotal-=quantia;
    }
    
    public String getNumeroConta()
    {
        return numeroConta;
    }
}