public interface InterfacePilha<T> {

  void empilhar(T generico);

  T desempilhar();

  T consultarPilha();

  boolean vazia();

  boolean cheia();

  void mostrar();
}
