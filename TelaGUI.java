public class TelaGUI{
    final private static int MAXCHAR = 8;
	final private static int QUANTIDADE_TELA = 2;
    public static void main(String[] args)
    {
        mostrar(QUANTIDADE_TELA);
    }
    private static void mostrar(int n)
    {
        for( int i = 0 ; i<n ; i++ )
        {
            EnvioGUI tela = new EnvioGUI(gerarCodigo(MAXCHAR));
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
