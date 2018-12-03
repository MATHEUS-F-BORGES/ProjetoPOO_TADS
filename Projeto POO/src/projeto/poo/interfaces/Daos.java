
package projeto.poo.interfaces;



/**
 *
 * @author victor.gserafim
 * @param <T> objeto generico
 */
public interface Daos <T> {
    
    public void inserir(T objeto);
    
    public void atualizar(T objeto);
    
    public void excluir(int id);
    
    public T procurar(String valor);
    
    public T obter(String valor);
    
     
}
