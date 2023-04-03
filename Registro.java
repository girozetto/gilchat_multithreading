import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

public class Registro {
    
    private List<Mensagem> lista;

    public Registro() {
        this.lista = new ArrayList<>();
    }

    public void setLista(List<Mensagem> lista) {
        this.lista=lista;
    }

    public List<Mensagem> getLista() {
        return lista;
    }

    public void unirRegistro(Registro r)
    {
        for(int i = getLista().size() ; i < r.getLista().size() ; i++)
            adicionar(r.getLista().get(i));
    }

    public Mensagem obterUltima()
    {
        return this.lista.get(this.lista.size()-1);
    }

    public void desenhar(Graphics2D g, int largura, int altura, String id, Actualizacao act)
    {
        int y = g.getFontMetrics().getHeight();
        int margemBaixo = 1;
        for(Mensagem m : this.lista)
        {
            if(y > altura) act.redimensionar(y-altura, 0);
            int x = m.getIdEmissor().equals(id) ? (largura/2) : 0;
            int max = (largura/2)/g.getFontMetrics(m.getFonte()).charWidth('W');
            int lin = m.getConteudo().length()/max + (m.getConteudo().length()%max>0 ? 1 : 0 );
            m.molde(g, x, y, max);
            y += (lin + 3)*m.getFonte().getSize()+margemBaixo;
        }
    }

    public void adicionar(Mensagem mensagem) {
        this.lista.add(mensagem);
    }

    @Override
    public String toString() {
        String str="Lista de Mensagens\n";
        for(Mensagem m: this.lista)
            str += m.toString() + "\n";
        return str;
    }
}
