import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Ficheiro {
    private File ficheiro;
    public Ficheiro(String nome) throws IOException{
        criarFicheiro(nome);
    }

    public void criarFicheiro(String nome) throws IOException {
        File novo = new File(nome);
        novo.createNewFile();
        ficheiro = novo;
    }

    public Registro obterRegistros() throws Exception
	{
        Registro reg = new Registro();
		Scanner ler = new Scanner(new FileReader(ficheiro));
		
        while(ler.hasNext())
            reg.adicionar(new Mensagem(ler.next(), ler.next().replaceAll("-", " ")));
		
        return reg;
	}

	public void adicionar(Mensagem msg) throws Exception
	{
		if(msg==null) return;
        
		PrintWriter arq = new PrintWriter(new FileWriter(ficheiro,true));
        arq.printf("%s %s%n",msg.getIdEmissor(),msg.getConteudo().replaceAll(" ", "-"));
        arq.close();
	}
}
