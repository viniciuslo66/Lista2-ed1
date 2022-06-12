/**
 * pilhaArray
 */
public class VetorPilha<T> implements InterfacePilha<T> {

  int tamanho;
  private Object[] vetor;
  int topo;

  public VetorPilha(int tamanho) {
    this.tamanho = tamanho;
    this.vetor = new Object[tamanho];
    this.topo = -1;
  }

  @Override
  public void empilhar(T valor) throws Exception {

    if (topo == tamanho - 1) {
      throw new Exception("\nError: pilha cheia [valor=" + valor + "]!!!\n");
    }

    topo += 1;
    vetor[topo] = valor;
  }

  @SuppressWarnings("unchecked")
  public T desempilhar() throws Exception {
    T retorno;

    if (topo == -1) {
      throw new Exception("\nError: pilha vazia!!!\n");
    }

    retorno = (T) vetor[topo];
    topo -= 1;

    return retorno;
  }

  @SuppressWarnings("unchecked")
  public T consultarPilha() {
    T retorno;

    if (topo == -1) {
      throw new Exception("\nError: pilha vazia\n");
    }

    retorno = (T) vetor[topo];

    return retorno;
  }

  @Override
  public boolean vazia() {
    if (topo == -1) {
      return true;
    } else {
      return false;
    }
  }

  @Override
  public boolean cheia() {
    if (topo == tamanho - 1) {
      return true;
    } else {
      return false;
    }
  }

  @Override
  public void mostrar() {
    int i;

    System.out.println("\nExibindo...\n");

    for (i = 0; i <= topo; i++) {
      System.out.println("posicao " + i + " = " + vetor[i]);
    }

    System.out.println("topo index = " + topo);
    System.out.println("--------------------");
  }
}