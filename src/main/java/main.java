import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class main {
    public static void main(String[] args) {
        try {
            Client klient = Client.create();
            WebResource webzrodlo = klient.resource("https://animechan.vercel.app/api/random");
            ClientResponse odpowiedz = webzrodlo.accept("application/json").get(ClientResponse.class);
            if (odpowiedz.getStatus() != 200) {
                throw new RuntimeException("Błąd" + odpowiedz.getStatus());
            }
            String pobrany = odpowiedz.getEntity(String.class);
            System.out.println(pobrany);
            String [] actualValue = pobrany.split("\"");
            String link = ("https://api.jikan.moe/v3/search/anime?q="+actualValue[3]);
            if (link.contains(" ")) {
                String[] spacje = link.split(" ");
                int dlugosc = (spacje.length);
                int i = 1;
                link = (spacje[0]);
                while (dlugosc>i){
                link = (link+"%20"+spacje[i]);
                i++;
                }

            }
            Client klient2 = Client.create();
            WebResource webzrodlo2 = klient2.resource(link);
            ClientResponse odpowiedz2 = webzrodlo2.accept("application/json").get(ClientResponse.class);
            if (odpowiedz2.getStatus() != 200) {
                throw new RuntimeException("Błąd" + odpowiedz2.getStatus());
            }
            String pobrany2 = odpowiedz2.getEntity(String.class);
            String [] actualValue1 = pobrany2.split("\"");
            String mal = (actualValue1[15]);
            String img = (actualValue1[19]);
            String [] mal1 = mal.split("\\\\");
            String [] img1 = img.split("\\\\");
            int im = 1;
            int ii = 1;
            String mal2 = mal1[0];
            String img2 = img1[0];
            int maldlugosc = mal1.length;
            int imgdlugosc = img1.length;
            while (maldlugosc>im) {
                mal2 = mal2+mal1[im];
                im++;

            }
            while (imgdlugosc>ii) {
                img2 = img2+img1[ii];
                ii++;
            }
            System.out.println(img2);
            System.out.println(mal2);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }}