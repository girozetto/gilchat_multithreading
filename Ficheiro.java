import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Ficheiro {
    private File ficheiro;
    private long estado;

    public Ficheiro(String nome) throws IOException{
        this.ficheiro = criarFicheiro(nome);
        this.estado = 0;
    }

    public boolean mudancaFicheiro()
    {
        if(estado != this.ficheiro.length()){
            estado = this.ficheiro.length();
            return true;
        }
        return false;
    }

    public File criarFicheiro(  String nome ) throws IOException {
        File novo = new File( nome );
        if (novo.exists()) 
            novo.delete();
        novo.createNewFile();
        return novo;
    }
    
    public void removerRegisto( String tempFich, String id ) throws Exception
    {
        // Leitura do arquivo
        BufferedReader leitor = new BufferedReader(new FileReader(this.ficheiro));

        File faux = tempFich != null ? new Ficheiro(tempFich).getFicheiro() : new Ficheiro("temporario.txt").getFicheiro();
        // Escrita do arquivo sem a linha removida
        BufferedWriter escritor = new BufferedWriter(new FileWriter( faux ));
        
        String linha;
        while(( linha = leitor.readLine()) != null) 
            if(linha.contains(id)) 
                escritor.write(linha + "\n");

        // Fechamento dos readers e writers
        escritor.close();
        leitor.close();

        // Substituição do arquivo original com o arquivo temporário
        this.ficheiro.delete();
        faux.renameTo(this.ficheiro);
    }

    public Registro obterRegistros() throws IOException
	{
        Registro reg = new Registro();
		Scanner ler = new Scanner(new FileReader(ficheiro));
		
        while(ler.hasNext())
            reg.adicionar(new Mensagem(ler.next(), ler.next().replaceAll("-", " ")));
		
        return reg;
	}

    public File getFicheiro() {
        return ficheiro;
    }

    public void setFicheiro(String ficheiro) throws IOException {
        this.ficheiro = criarFicheiro(ficheiro);
    }
    
	public void adicionar(Mensagem msg) throws IOException
	{
		PrintWriter arq = new PrintWriter(new FileWriter(ficheiro,true));
        arq.printf("%s %s%n",msg.getIdEmissor(),msg.getConteudo().replaceAll(" ", "-"));
        arq.close();
	}
}
