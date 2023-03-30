import java.awt.Font;
import java.awt.Graphics2D;

public class Mensagem
{
    final private int FONT_SIZE = 2;  
    private String idEmissor;
    private String conteudo;
    private Font fonte;
    
    
    public Mensagem(String idEmissor, String conteudo)
    {
        this.idEmissor = idEmissor;
        this.conteudo = conteudo;
        this.fonte = new Font(Font.MONOSPACED,Font.PLAIN,FONT_SIZE);
    }

    //Manipulacao de Imagens com Graphics2D
    public void molde(Graphics2D g, int x, int y, int max){
        int lin = this.conteudo.length()/max + (this.conteudo.length()%max>0 ? 1 : 0 );
        g.setFont( this.fonte );
        g.drawRect( x, y, max * this.fonte.getSize(), (lin + 3) * this.fonte.getSize());
        for(int i=0 ; i < lin ; i++)
            g.drawString(conteudo.substring(i*max, (i*max + max > this.conteudo.length() ? this.conteudo.length() : i*max + max )), x + this.fonte.getSize(), y + i*this.fonte.getSize());
    }

    //Set e Get da Fonte da Mensagem
    public Font getFonte() {
        return fonte;
    }

    public void setFonte(Font fonte) {
        this.fonte = fonte;
    }

    //Set e Get do Autor da Mensagem
    public String getIdEmissor() {
        return idEmissor;
    }
    public void setIdEmissor(String idEmissor) {
        this.idEmissor = idEmissor;
    }

    //Set e Get do Conteudo da Mensagem
    public String getConteudo() {
        return conteudo;
    }
    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }
}