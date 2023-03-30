import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class SeccaoMensagem extends JPanel implements Runnable, Actualizacao{
    private Registro registro;
    private String id;
    
    public SeccaoMensagem(String id)
    {
        this.id=id;
        registro = new Registro();
        new Thread(this).start();
    }

    private boolean rodarFrames()
    {
        this.repaint();
        try {Thread.sleep(1000/24);} catch (InterruptedException e) {JOptionPane.showMessageDialog(this.getParent(), "Houve um erro de interrupção da Thread");}
        return true;
    }

    @Override
    public void run() {
        while(rodarFrames());
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        this.registro.desenhar(g2d,this.getBounds().width,this.getBounds().height, this.id);
    }

    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    
    public Registro getRegistro() {
        return registro;
    }

    public void setRegistro(Registro registro) {
        this.registro = registro;
    }

    @Override
    public void receber(Mensagem msg) {
        registro.adicionar(msg);
    }
}
