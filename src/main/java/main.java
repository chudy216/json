import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import java.util.Scanner;

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
            String [] actualValue = pobrany.split("\"");
            System.out.println(actualValue[11]+" ~"+actualValue[7]);
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
            Scanner myObj = new Scanner(System.in);
            System.out.println("1. End");
            System.out.println("2. Get link to mal");
            System.out.println("3. Get anime image");
            System.out.println("4. Get link to mal and image");
            String wyborek = myObj.nextLine();
            new api2(link, wyborek);


        } catch (Exception e) {
            e.printStackTrace();
        }

    }}