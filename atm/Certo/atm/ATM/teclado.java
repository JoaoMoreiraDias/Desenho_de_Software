import java.util.Scanner;

public class teclado
{
    private Scanner entrada;
    
    public teclado()
    {
        entrada=new Scanner(System.in);
    }
    
    public String getInput()
    {
        return entrada.next();
    }
}