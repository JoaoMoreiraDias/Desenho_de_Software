public class caixaDinheiro
{
    private final static int totalNotasInicial=500;
    private int totalNotas;
    
    public caixaDinheiro()
    {
        totalNotas=totalNotasInicial;
    }
    
    public void levantar(int quantidade)
    {
        int notas=quantidade/20; 
        totalNotas-=notas; 
    } 

    public boolean existeNotasSuficientes(int quantidade)
    {
        int notasNecessarias=quantidade/20; 
        if (totalNotas>=notasNecessarias)
        {
            return true;
        }
        else
        {
            return false;
        }
    } 
}