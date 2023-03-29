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

    public Mensagem obterUltima()
    {
        return this.lista.get(this.lista.size()-1);
    }

    public void desenhar(Graphics2D g)
    {
        
    }

    public void adicionar(Mensagem mensagem) {
        this.lista.add(mensagem);
    }
}
