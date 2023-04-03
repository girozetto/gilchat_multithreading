import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class EnvioGUI extends JFrame{
    final public String F_BACKUP = "backchat.txt";
    final public String F_BUFFER = "buffchat.txt";

    private String id;
    private SeccaoMensagem secmsg;
    private JTextField caixamsg;
    private Ficheiro backup;

    public EnvioGUI(String id)
    {
        super(id);
        gerarFicheiros();
        this.id = id;
        secmsg = new SeccaoMensagem(id, this.backup);
        caixamsg = new JTextField();

        
        JPanel painelInferior = new JPanel();
        JButton botaoEnviar = new JButton();
        JScrollPane jsp = new JScrollPane(secmsg, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        botaoEnviar.setSize(60, 60);
        botaoEnviar.setIcon(new ImageIcon("recursos/envicon.png"));
        botaoEnviar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(validarCampo())
                {
                    enviarMensagem(caixamsg.getText());
                    caixamsg.setText("");
                }
            }
        });


        painelInferior.setLayout(new BorderLayout(0,1));
        painelInferior.add(caixamsg, BorderLayout.CENTER);
        painelInferior.add(botaoEnviar, BorderLayout.EAST);

        setLayout(new BorderLayout(0, 1));
        add(jsp, BorderLayout.CENTER);
        add(painelInferior,  BorderLayout.SOUTH);

        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        pack();
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

    private boolean validarCampo()
    {
        if(!caixamsg.getText().isEmpty())
            return true;
        JOptionPane.showMessageDialog(this, "O campo está vazio, Chefe");
        return false;
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
