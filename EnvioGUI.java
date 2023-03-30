import javax.swing.JFrame;

public class EnvioGUI extends JFrame{
    private String id;

    public EnvioGUI(String id)
    {
        super(id);
        
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
