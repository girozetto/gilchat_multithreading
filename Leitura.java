import java.io.IOException;

import javax.swing.JOptionPane;

public class Leitura implements Runnable{
    private Ficheiro ficheiro;
    private Actualizacao act;
    public Leitura(Ficheiro f, Actualizacao act)
    {
        this.act=act;
        this.ficheiro=f;
    }


    @Override
    public void run() {
        try {
            act.receber(ficheiro.obterRegistros());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível Ler o Ficheiro");
        }
    }
}
