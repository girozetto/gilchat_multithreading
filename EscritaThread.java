public class EscritaThread extends Thread {
    public EscritaThread(Escrita escrita)
    {
        super(escrita);
        setPriority(10);
    }
}
