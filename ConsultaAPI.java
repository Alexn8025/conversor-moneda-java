import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ConsultaAPI {

    String apiKey = "TU_API_KEY";

    public double convertir(int opcion, double valor){

        String base = "";
        String destino = "";

        switch(opcion){

            case 1:
                base="USD";
                destino="ARS";
                break;

            case 2:
                base="ARS";
                destino="USD";
                break;

            case 3:
                base="USD";
                destino="BRL";
                break;

            case 4:
                base="BRL";
                destino="USD";
                break;

            case 5:
                base="USD";
                destino="COP";
                break;

            case 6:
                base="COP";
                destino="USD";
                break;

        }

        try{

            String url = "https://v6.exchangerate-api.com/v6/"+apiKey+"/pair/"+base+"/"+destino;

            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            HttpResponse<String> response =
                    client.send(request, HttpResponse.BodyHandlers.ofString());

            JsonObject json = JsonParser.parseString(response.body()).getAsJsonObject();

            double tasa = json.get("conversion_rate").getAsDouble();

            return valor * tasa;

        }

        catch(IOException | InterruptedException e){

            System.out.println("Error en la conversión");

        }

        return 0;

    }

}