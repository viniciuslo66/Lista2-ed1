public class Main {

  public static void main(String[] args) {
    int retorno = 1;

    InterfacePilha<Integer> pilha = new VetorPilha<Integer>(3);

    pilha.empilhar(1);
    pilha.empilhar(2);
    pilha.empilhar(3);

    retorno = pilha.consultarPilha();
    System.out.println("Elemento do topo: " + retorno);

    pilha.mostrar();

    retorno = pilha.desempilhar();
    System.out.println("Desempilhado: " + retorno);

    retorno = pilha.desempilhar();
    System.out.println("Desempilhado: " + retorno);

    retorno = pilha.desempilhar();
    System.out.println("Desempilhado: " + retorno);

    pilha.mostrar();

    System.out.println("Cheio?" + pilha.cheia());
    System.out.println("Vazio?" + pilha.vazia());
  }
}
