
package util;

import java.util.List;

import model.Aresta;

/*******************************************************************************
 * @author Ednaldo                                                             *
 *  date: 23.09.2018                                                           *
 ******************************************************************************/
public interface AlgoritmoGuloso {
    public long [] gerarMST (List <Aresta> listaAresta);
}