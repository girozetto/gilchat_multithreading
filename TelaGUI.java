public class TelaGUI{
    final private static int MAX = 8;
    public static void main(String[] args)
    {
        EnvioGUI tela1 = new EnvioGUI(gerarCodigo(MAX));
        EnvioGUI tela2 = new EnvioGUI(gerarCodigo(MAX));
        tela1.setVisible(true);
        tela2.setVisible(true);
    }
    private static String gerarCodigo(int n)
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
