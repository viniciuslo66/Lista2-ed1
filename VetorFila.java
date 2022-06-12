public class VetorFila<T> {

  private Object[] vetor;
  int inicio;
  int fim;
  int tamanho;

  public VetorFila(int tamanho) {
    this.vetor = new Object[tamanho];
    this.tamanho = 0;
    this.inicio = 0;
    this.fim = -1;
  }

  void enfileirar(Object valor) {
    if (tamanho == vetor.length) {
      System.out.println("Fila cheia");
    } else {
      if (fim == vetor.length - 1) {
        fim = -1;
      }
    }

    fim++;
    vetor[fim] = valor;
    tamanho++;
  }

  Object desenfileirar() {
    if (!isEmpty()) {
      Object tep = vetor[inicio];
      vetor[inicio] = null;
      inicio++;
      if (inicio == vetor.length) {
        inicio = 0;
      }
      tamanho--;
      return tep;
    } else {
      System.out.println("Fila vazia");
      return null;
    }
  }

  public boolean isEmpty() {
    return tamanho == 0;
  }

  public Object frente() {
    if (!isEmpty()) {
      return vetor[inicio];
    } else {
      System.out.println("Fila vazia");
      return null;
    }
  }

  public int size() {
    System.out.println("Quantidade de elementos :" + tamanho);
    return tamanho;
  }

  public void imprimir() {
    for (int i = 0; i < tamanho; i++) {
      System.out.println(frente() + " ");
      enfileirar(desenfileirar());
    }

    System.out.println();
  }
}
