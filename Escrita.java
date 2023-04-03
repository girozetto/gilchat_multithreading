import java.io.IOException;

import javax.swing.JOptionPane;

public class Escrita implements Runnable{
    private Ficheiro ficheiro;
    private Mensagem msg;
    public Escrita(Ficheiro ficheiro, Mensagem msg)
    {
        this.ficheiro = ficheiro;
        this.msg = msg;
    }
    @Override
    public void run() {
        try {
            ficheiro.adicionar(msg);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Não conseguiu adicionar a mensagem no buffer.");
        }
    }
    
}
