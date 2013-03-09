import java.util.ArrayList;
public class baseDadosContas
{
    private ArrayList<conta> contas;
    
    public baseDadosContas()
    {
        contas=new ArrayList<conta>();
        contas.add(new conta("12345", "José", "54321", 1000, 1000));
        contas.add(new conta("67890", "João", "09876", 2000, 2000));
        contas.add(new conta("14725", "Luis", "52741", 1500, 1500));
    }
    
    public conta getConta(String numeroConta)
    {
        for (conta cada : contas)
        {
            if (cada.getNumeroConta().compareTo(numeroConta)==0)
            {
                return cada;
            }
        }
        return null;
    }
    
    public boolean autenticarConta(String numeroConta, String pin)
    {
        conta contaAAutenticar=getConta(numeroConta);
        
        if(contaAAutenticar!=null)
        {
            boolean temp=contaAAutenticar.pinValido(pin);
            return temp;
        }
        return false;
    }
    
    public double getSaldoDisponivel(String numeroConta)
    {
        return getConta(numeroConta).getSaldoDisponivel();
    }
    
    public double getSaldoTotal(String numeroConta)
    {
        return getConta(numeroConta).getSaldoTotal();
    }
    
    public void depositar(String numeroConta, double quantidade)
    {
        getConta(numeroConta).depositar(quantidade);
    }
    
    public void levantar(String numeroConta, double quantidade)
    {
        getConta(numeroConta).levantar(quantidade); 
    }
}