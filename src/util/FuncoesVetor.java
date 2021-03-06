
package util;

import java.util.List;
import model.Aresta;

/*******************************************************************************
 * @author Ednaldo                                                             *
 *  date: 24.09.2018                                                           *
 ******************************************************************************/
public class FuncoesVetor {
    
    public static void swap ( Aresta [] list, int i, int j )
    {
        Aresta temp = list[j];
        list[j] = list[i];
        list[i] = temp;
    }
    
    public static void copiarLista ( List <Aresta> original, Aresta [] copia )
    {   //a posicao 0 guarda o numero de vertices
        if(copia.length >= original.size()-1)
        {
            for(int i = 0; i < copia.length; i++)
                copia[i] = original.get(i+1);
        }
        else
            System.err.println("Nao foi possivel copiar o array original, pois o array orginal eh maior do que o vetor copia");
    }
    
    //copiar apenas um lado da matriz para um novo vetor 
    public static void copiarMatriz ( Aresta[][] matriz, Aresta [] vetor)
    {
        int k = 0;
        for(int i = 0; i < matriz.length; i++)
            for(int j = i+1; j < matriz.length; j++)
                vetor[k++] =  matriz[i][j];
    }
    
    public static void iniciarVetor(Aresta[] vetor)
    {
        for(int i = 0; i < vetor.length; i++)
            vetor[i] = new Aresta( Long.MAX_VALUE, 0 );
    }
    
    public static void iniciarMatriz(Aresta[][] matriz)
    {
        for(int i = 0; i < matriz.length; i++)
            for(int j = 0; j < matriz.length; j++)
                matriz[i][j] =  new Aresta( 0,0,0,0 );
    }

    public static int tamanhoLadoMatriz (Aresta [][] matriz)
    {
        int k = 0;
        for(int i = 0; i < matriz.length; i++)
            for(int j = i+1; j < matriz.length; j++)
                if(matriz[i][j].getPeso() != 0)
                    k++;
        return k;
    }
    
}
