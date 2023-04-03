public class TelaGUI{
    final private static int MAX = 8;
    public static void main(String[] args)
    {
        mostrar(2);
    }
    private static void mostrar(int n)
    {
        for( int i = 0 ; i<n ; i++ )
        {
            EnvioGUI tela = new EnvioGUI(gerarCodigo(MAX));
            tela.setSize(400,600);
            tela.setVisible(true);
        }
    }
    private static String gerarCodigo(int n)
    {
        String alfnum = "abcdefghijklmnopqrstuvwxyz0123456789";
        String cod="";
        for(int i=0 ; i < n ; i++){
            int ind = (int)(Math.random()*(alfnum.length()));
            boolean minus = Math.random() < 0.5;
            cod+= minus ? alfnum.toLowerCase().charAt(ind) : alfnum.toUpperCase().charAt(ind);
        }
        return cod;
    }
}
