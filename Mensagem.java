import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class Mensagem
{
    
    final private int FONT_SIZE = 13;  
    private String idEmissor;
    private String conteudo;
    private Font fonte;
    
    
    public Mensagem(String idEmissor, String conteudo)
    {
        this.idEmissor = idEmissor;
        this.conteudo = conteudo;
        this.fonte = new Font(Font.MONOSPACED,Font.BOLD,FONT_SIZE);
    }

    //Manipulacao de Imagens com Graphics2D
    public void molde(Graphics2D g, int x, int y, int max){
        int lin = this.conteudo.length()/max + (this.conteudo.length()%max>0 ? 1 : 0 );
        int met = g.getFontMetrics(fonte).charWidth('W');
        int maxLess = max - 2;
        int espacoNome = this.fonte.getSize();

        g.setColor(new Color(0xFF1E88E5));
        g.fillRoundRect( x, y + espacoNome, max * met, (lin + 1) * this.fonte.getSize(),10,10);
        g.setFont( this.fonte );
        g.setColor(new Color(0xFFD4D4D4));
        g.drawString(this.idEmissor, x  + met, y);
        for(int i=0 ; i < lin ; i++){
            String subTexto = conteudo.substring(i*maxLess, (i*maxLess + maxLess > this.conteudo.length() ? this.conteudo.length() : i*maxLess + maxLess ));
            g.drawString(subTexto, x  + met, y + (i+1)*this.fonte.getSize() + espacoNome);
        }
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

    @Override
    public String toString() {
        return "Mensagem [idEmissor=" + idEmissor + ", conteudo=" + conteudo + "]";
    }
}