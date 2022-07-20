import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {

        //Conexão HTTP com API imdb 
        String url = "https://api.mocki.io/v2/549a5d8b";
        URI endereco = URI.create(url);
        HttpClient client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();
        System.out.println(body);


        
        //extrair os dados que interessam 
        var parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(body);
       
       //exibir e manipular 
       
       for (Map<String,String> filme  : listaDeFilmes) {
        String urlImagem = filme.get("image"); 
        String titulo = filme.get("title");
      

             InputStream inputStream = new URL (urlImagem).openStream();
             String nomeArquivo = titulo + ".png";

             var geradora = new GeradoraDeFigurinhas();
             geradora.cria(inputStream, nomeArquivo);

             
            System.out.println(filme.get("title"));
            System.out.println(filme.get("image"));
            System.out.println(filme.get("imDbRating"));
            System.out.println();
       }
    }
}