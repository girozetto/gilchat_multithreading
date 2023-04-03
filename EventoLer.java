import javax.swing.JOptionPane;

public class EventoLer implements Runnable{
    private Ficheiro ficheiro;
    private Actualizacao act;
    public EventoLer(Ficheiro ficheiro, Actualizacao act)
    {
        this.act = act;
        this.ficheiro = ficheiro;
        new Thread(this).start();
    }

    @Override
    public void run() {
        while(true)
        {
            try {
                if(this.ficheiro.mudancaFicheiro())
                    new LeituraThread(new Leitura(ficheiro, act)).start();
                Thread.sleep(700);
            } catch (InterruptedException e) {
               JOptionPane.showMessageDialog(null, "A Thread está interrompida");
            }
        }
    }
    
}
