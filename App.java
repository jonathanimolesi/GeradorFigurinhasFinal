/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package aluraimersaojavaaula04;


import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Map;

/**
 *
 * @author jonathani
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        // fazer uma conexão http e buscar os filmes
        
        //String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        //ExtratorDeConteudo extrator = new ExtratorConteudoImdb();
        
        //String url = "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&start_date=2022-06-12&end_date=2022-06-14";
        //ExtratorDeConteudo extrator = new ExtratorConteudoNasa();
        
        //String url = "https://valorant-api.com/v1/agents";
        //ExtratorDeConteudo extrator = new ExtratorValorant();
        
        String url = "http://localhost:8080/linguagens";
        ExtratorDeConteudo extrator = new ExtratorConteudoLinguagens();

        ClienteHttp http = new ClienteHttp();
        String json = http.buscaDados(url);


        
        


        // exibir e manipular os dados
        
        
        List<Conteudo> conteudos = extrator.extraiConteudos(json);
        
        GeradorDeFigurinhas geradora = new GeradorDeFigurinhas();
        File diretorio = new File("figurinhas/");
        diretorio.mkdir();

        for (int i = 0; i < 3; i++) {
            
            Conteudo conteudo = conteudos.get(i);
                                
            InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();
            String nomeArquivo = "figurinhas/" + conteudo.getTitulo().replace(":", "-") + ".png";
            
            geradora.cria(inputStream, nomeArquivo);
            
            System.out.println(conteudo.getTitulo());
            System.out.println();
        }
    }
    
}
