public class Client {
    ICS x = new DefaultMultipleServer();
    void m() {
        System.out.println("m is calling n...");
        x.n();
    }
}
