public class VetorPilha<T> {
  Object[] pilha;
  int topo = -1;

  public VetorPilha(int tamanho) {
    this.pilha = new Object[tamanho];
  }

  public void push(Object valor) {
    if (topo == pilha.length - 1) {
      System.out.println("Pilha Cheia");
    } else {
      topo++;
      pilha[topo] = valor;
    }
  }

  public Object pop() {
    if (topo == -1) {
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
    if (topo == -1) {
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

  public int size() {
    return topo + 1;
  }

}