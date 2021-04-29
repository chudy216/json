import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class api2 {
    public api2(String link, String wyborek) {
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
        if (wyborek.equals("1")){
            System.out.println("bay bay");}
        else if (wyborek.equals("2")){

        System.out.println(mal2);

    }
    else if (wyborek.equals("3")){
        System.out.println(img2);
    }
    else if (wyborek.equals("4")){
            System.out.println(img2);
            System.out.println(mal2);

        }
   else {
            System.out.println("Wrong choice");

        }}

}
