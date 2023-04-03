import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class SeccaoMensagem extends JPanel implements Runnable, Actualizacao{
    private Registro registro;
    private String id;
    
    public SeccaoMensagem(String id, Ficheiro ficheiro)
    {
        super();
        this.id=id;
        registro = new Registro();
        new EventoLer(ficheiro, this);
        new Thread(this).start();
    }

    @Override
    public void run() {
        this.repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        System.out.println("Desenhando");
        setBackground(new Color(0xFF1E1E1E));
        Graphics2D g2d = (Graphics2D) g;
        this.registro.desenhar(g2d,this.getBounds().width,this.getBounds().height, this.id, this);
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
    public void receber(Registro msgs) {
        registro.unirRegistro(msgs);
        new Thread(this).start();
    }

    @Override
    public void redimensionar(int addAltura, int addLargura) {
        setBounds(getBounds().x, getBounds().y, getBounds().width + addLargura, getBounds().height + addAltura);
    }

    

}
