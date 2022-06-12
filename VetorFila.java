public class VetorFila<T> implements IntefaceFila<T> {

  int tamanho;
  private Object[] vetor;
  int primeiro;
  int ultimo;

  public VetorFila(int tamanho) {
    this.tamanho = tamanho;
    this.vetor = new Object[tamanho];
    this.primeiro = -1;
    this.ultimo = -1;
  }

  @Override
  public void adicionar(T valor) throws Exception {
    int ultimoTemp = (ultimo + 1) % tamanho;

    if (ultimoTemp == primeiro) {
      throw new Exception("\nErro: Fila cheia[" + valor + "]\n");
    }

    ultimo = ultimoTemp;
    vetor[ultimo] = valor;

    if (primeiro == -1) {
      primeiro = 0;
    }
  }

  @SuppressWarnings("unchecked")
  public T remove() throws Exception {
    System.out.println("removendo!");
    T retorno;

    if (primeiro == -1) {
      throw new Exception("\nErro: fila vazia!!!!\n");
    }

    retorno = (T) vetor[primeiro];

    if (primeiro == ultimo) {
      primeiro = -1;
      ultimo = -1;
    } else {
      primeiro = (primeiro + 1) % tamanho;
    }

    return retorno;
  }

  @SuppressWarnings("unchecked")
  public T consultar() throws Exception {
    System.out.println("Consultando elemento do inicio");
    T retorno;

    if (primeiro == -1) {
      throw new Exception("\nErro: Fila vazia!!!\n");
    }

    retorno = (T) vetor[primeiro];

    return retorno;
  }

  @Override
  public boolean cheia() {
    int ultimoTemp = (ultimo + 1) % tamanho;

    if (ultimoTemp == primeiro) {
      return true;
    } else {
      return false;
    }
  }

  @Override
  public boolean vazia() {
    if (primeiro == -1) {
      return true;
    } else {
      return false;
    }
  }

  @Override
  public void mostrar() {
    System.out.println("\nExibindo...\n");

    int i = primeiro;

    if (primeiro == -1) {
      return;
    }

    while (i != ultimo) {
      System.out.println("posicao " + i + " = " + vetor[i] + "\n");

      i = (i + 1) % tamanho;
    }
    System.out.println("posicao " + i + " = " + vetor[i] + "\n");

    System.out.println("inicio = " + primeiro + "  fim = " + ultimo + "\n");
  }
}
