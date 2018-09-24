
package infra;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import model.Aresta;

/*******************************************************************************
 * @author Ednaldo                                                             *
 *  data: 22.09.2018                                                           *
 ******************************************************************************/
public class Arquivo 
{
    private final Path loadPath;
    private final Charset utf8 = StandardCharsets.UTF_8;
    
    public Arquivo (String loadPath) 
    {
        this.loadPath = Paths.get(loadPath);
    }
    
    /***************************************************************************
     * MST: Minimum Soanning Tree                                              *
     * i: primeiro vertice                                                     *
     * j: segundo vertice                                                      *
     * k: valor do peso da aresta que estah ligando os vertice 'i' e 'j'       *
     * @return arvore                                                          *
     * @throws IOException                                                     *
     **************************************************************************/
    public List <Aresta> carregarMST() throws IOException 
    {
        List<Aresta> listaPesoAresta = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(loadPath, utf8))
        {
            String line = null;
            for(int i = 0; (line = reader.readLine()) != null; i++) 
            {
                String[] parametro = line.split(" ");
                for(int j = i+1, k = 0; k < parametro.length; k++, j++)
                    listaPesoAresta.add(   new Aresta(i, j, Long.parseLong(parametro[k]), 0 )   );
            }
            reader.close();         
        }
        catch(FileNotFoundException ex) {System.err.println("Arquivo não encontrado");}
        catch(NumberFormatException ex) {System.err.println("Erro de formato de numeros");}
        catch(IOException ex) {System.err.println("Erro de leitura");}
        
        return listaPesoAresta;
    }
    
}