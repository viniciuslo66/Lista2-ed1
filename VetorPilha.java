public class VetorPilha<T> {
  Object[] pilha;
  int topo = -1;

  public VetorPilha(int tamanho) {
    this.pilha = new Object[tamanho];
  }

  public void push(Object valor) {
    if (isFull()) {
      System.out.println("Pilha Cheia");
    } else {
      topo++;
      pilha[topo] = valor;
    }
  }

  public Object pop() {
    if (isEmpty()) {
      System.out.println("A pilha já está vazia");
      return null;
    } else {
      Object retirado = pilha[topo];
      pilha[topo] = null;
      topo--;
      return retirado;
    }
  }

  public Object top() {
    if (isEmpty()) {
      System.out.println("Pilha vazia");
      return null;
    } else {
      return pilha[topo];
    }
  }

  public String print() {
    String valores = "";
    for (int i = topo; i > -1; i--) {
      valores = valores + pilha[i] + " ";
    }
    return valores;
  }

  public boolean isFull() {
    return topo == pilha.length - 1;
  }

  public boolean isEmpty() {
    return topo == -1;
  }

  public int size() {
    return topo + 1;
  }

}