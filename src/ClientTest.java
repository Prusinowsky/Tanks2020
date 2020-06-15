import java.io.IOException;

public class ClientTest {

    Client client = new Client();

    public ClientTest() {

    }

    public void test() {
        try {
            System.out.println(client.getAmountOfMaps());
            System.out.println(client.getRanking());
            System.out.println(client.getRankingSize());
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
