import javax.swing.JFrame;

public class TelaGUI extends JFrame{
    public static void main(String[] args)
    {

    }
    public TelaGUI(String nome)
    {
        super(nome);
        gerarCodigo(5);
    }
    private String gerarCodigo(int n)
    {
        String alfnum = "abcdefghijklmnopqrstuvwxyz0123456789";
        String cod="";
        for(int i=0 ; i < n ; i++){
            int ind = (int)(Math.random()*(alfnum.length()+1));
            boolean minus = Math.random() < 0.5;
            cod+= minus ? alfnum.toLowerCase().charAt(ind) : alfnum.toUpperCase().charAt(ind);
        }
        return cod;
    }
}
