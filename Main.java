import javax.swing.JOptionPane;

public class Main {

  public static <T> void main(String[] args) {

    VetorFila<T> fila = new VetorFila<T>(3);

    fila.enfileirar("A");
    fila.enfileirar("B");
    fila.enfileirar("C");
    fila.imprimir();
    fila.desenfileirar();
    fila.imprimir();

    VetorPilha<T> pilha = new VetorPilha<T>(3);
    boolean continua = true;

    while (continua) {
      String escolha = JOptionPane.showInputDialog("1: Inserir  \n2: Remover \n3: Exibir \n4: Quantidade \n5: Topo \n6: Encerrar");
      switch (escolha) {
        case "1":
          String valor = JOptionPane.showInputDialog("Qual o valor a ser inserido?");
          pilha.push(valor);
          break;
        case "2":
          JOptionPane.showMessageDialog(null, "O valor removido foi:" + pilha.pop());
          break;
        case "3":
          JOptionPane.showMessageDialog(null, pilha.print());
          break;
        case "4":
          JOptionPane.showMessageDialog(null, "Quantidade de Elementos é:" + pilha.size());
          break;
        case "5":
          JOptionPane.showMessageDialog(null, "O topo é o elemento: " + pilha.top());
          break;
        case "6":
          JOptionPane.showMessageDialog(null, "obrigado!");
          continua = false;
          break;
        default:
          JOptionPane.showMessageDialog(null, "Por favor, informe um valor válido");
          break;
      }
    }
  }
}
