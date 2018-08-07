/**
 * @author: haoliu on 07/08/2018 21:51
 */
public class Client {
    public static void main(String[] args) {
        Pairable<String> test = new Pairable<String>() {
            @Override
            public String getFirst() {
                return null;
            }

            @Override
            public String getSecond() {
                return null;
            }

            @Override
            public void changeOrder() {

            }
        };
    }
}
