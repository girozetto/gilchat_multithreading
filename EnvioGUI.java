import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class EnvioGUI extends JFrame{
    final public String F_BACKUP = "backchat";
    final public String F_BUFFER = "buffchat";

    private String id;
    private SeccaoMensagem secmsg;
    private JTextArea caixamsg;
    private Ficheiro backup;

    public EnvioGUI(String id)
    {
        super(id);
        gerarFicheiros();
        secmsg = new SeccaoMensagem(id, this.backup);
        caixamsg = new JTextArea();

        
        JPanel painelInferior = new JPanel();
        JButton botaoEnviar = new JButton();
        botaoEnviar.setIcon(new ImageIcon("recursos/envicon.png"));
        botaoEnviar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                enviarMensagem(caixamsg.getText());
            }
        });


        painelInferior.setLayout(new BorderLayout(1,4));
        painelInferior.add(caixamsg, BorderLayout.CENTER);
        painelInferior.add(botaoEnviar, BorderLayout.EAST);
        painelInferior.setSize(getWidth(),(int) (getHeight()*0.3));

        setLayout(new BorderLayout(0, 1));
        add(new JScrollPane(secmsg), BorderLayout.CENTER);
        add(painelInferior, BorderLayout.SOUTH);

        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void gerarFicheiros()
    {
        try{
            backup = new Ficheiro(F_BACKUP);
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, e+"Erro ao criar uma dos ficheiros");
        }
    }

    private void enviarMensagem(String msg)
    {
        Escrita escrita = new Escrita(backup, new Mensagem(getId(), msg));
        EscritaThread escThread = new EscritaThread(escrita);
        escThread.start();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
