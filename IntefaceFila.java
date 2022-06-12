/**
 * IntefaceFila
 */
public interface IntefaceFila<T> {
  void adicionar(T generico) throws Exception;

  T remove() throws Exception;

  T consultar() throws Exception;

  boolean cheia();

  boolean vazia();

  void mostrar();
}