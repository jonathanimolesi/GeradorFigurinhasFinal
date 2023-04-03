/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aluraimersaojavaaula04;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author jonathani
 */
public class ExtratorConteudoNasa implements ExtratorDeConteudo {
    public List<Conteudo> extraiConteudos(String json) {
                // extrair só os dados que interessam (titulo, poster e classificação)

        JsonParse parser = new JsonParse();
        List<Map<String, String>> listaDeAtributos = parser.parse(json);
        
        List<Conteudo> conteudos = new ArrayList<>();
        
        // popular a lista de conteudos
        for (Map<String, String> atributos : listaDeAtributos) {
            String titulo = atributos.get("title");
            String urlImagem = atributos.get("url");
            
            Conteudo conteudo = new Conteudo(titulo, urlImagem);
            
            conteudos.add(conteudo);
        }
        
        return conteudos;
        
    }
    
}
