public class LeituraThread extends Thread{

    public LeituraThread(Leitura leitura) {
        super(leitura);
        setPriority(6);
    }
    
}
