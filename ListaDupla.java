public class ListaDupla<T> {
	// Classe Interna Node
	class Node {
		// Atributos de Node
		T data;
		Node proximo;
		Node anterior; // novidade

		// Construtor de Node
		public Node(T data) {
			this.data = data;
			this.proximo = null;
			this.anterior = null;
		}
	}

	// Atributos de MyLinkedListSingly
	public Node primeiro;
	public Node ultimo;
	public int tamanho;

	// Construtor de MyLinkedListSingly
	public ListaDupla() {
		primeiro = null;
		ultimo = null;
		tamanho = 0;
	}

	public void addLast(T dado) {
		Node novo = new Node(dado);

		// verifica se lista está vazia
		if (primeiro == null) {
			primeiro = novo; // novo será o primeiro elemento
			ultimo = novo; // novo será o último elemento
		} else {
			// Anexa
			novo.anterior = ultimo; // novidade. Lembre-se de começar a anexação pelo novo elemento
			ultimo.proximo = novo;
			ultimo = novo;
		}

		tamanho++;
	}

	public T peekFirst() {
		if (primeiro == null) {
			System.out.println("Lista Vazia!!! \n");
			return null;
		} else {
			return primeiro.data;
		}
	}

	public T peekLast() {
		if (ultimo == null) {
			System.out.println("Lista Vazia!!! \n");
			return null;
		} else {
			return ultimo.data;
		}
	}

	public T search(T criterio) {
		Node p = searchNode(criterio);

		if (p == null) {
			return null;
		} else {
			return p.data;
		}
	}

	private Node searchNode(T criterio) {
		Node p = primeiro; // ponteiro temporario

		while (p != null) {
			if (p.data.equals(criterio)) {
				System.out.println();
				return p;
			}
			p = p.proximo;
		}
		return null;
	}

	public T removeFirst() {
		Node p = primeiro;
		T dadoRetorno = null;

		if (primeiro == null) {
			System.out.println("Lista Vazia!!! \n");
		} else {
			dadoRetorno = p.data;

			if (primeiro == ultimo) {
				System.out.println("Remove unico elemento\n");
				primeiro = null;
				ultimo = null;
			} else {
				System.out.println("Remove primeiro elemento, mas ha mais outros\n");
				primeiro = primeiro.proximo;
				primeiro.anterior = null; // novidade
			}

			p.proximo = null; // isola elemento removido

			tamanho--;
		}

		return dadoRetorno;
	}

	public T removeLast() {
		T dadoRetorno = null;

		if (ultimo == null) {
			System.out.println("Lista Vazia!!! \n");
			return null;
		} else {
			dadoRetorno = ultimo.data;
			if (primeiro == ultimo) {
				System.out.println("Remove unico elemento\n");
				primeiro = null;
				ultimo = null;
			} else {
				System.out.println("Remove ultimo elemento, mas ha mais outros\n");
				Node temp = ultimo.anterior; // novidade
				ultimo.anterior = null; // novidade
				ultimo = temp;
				ultimo.proximo = null;
			}
			tamanho--;
		}

		return dadoRetorno;
	}

	public T remove(T criterio) {
		T dadoRetorno = null;

		if (primeiro == null) {
			System.out.println("Lista Vazia!!! \n");
			return null;
		}

		Node anterior = null;
		Node removido = searchNode(criterio); // null: criterio nao existe OU criterio esta no 1o elemento

		if (removido != null) {
			anterior = removido.anterior; // evita nullpointer
		}

		// OBS: vc pode usar a referencia de removido para alterar os IFs abaixo,
		// porem, mantive a mesma estrutura usada na lista simples para facilitar.

		if (anterior == null) {
			if (primeiro.data.equals(criterio) == false) {
				System.out.println("criterio nao existe!!! \n");
				return null;
			} else {
				return removeFirst();
			}
		} else {
			System.out.println("Remove elemento meio ou ultimo \n");

			if (removido == ultimo) {
				return removeLast();
			} else {
				System.out.println("Remove meio \n");
				Node frente = removido.proximo; // var auxiliar

				// se desliga do elemento removido
				anterior.proximo = frente;
				frente.anterior = anterior; // novidade

				// isola elemento removido
				removido.proximo = null;
				removido.anterior = null; // novidade

				tamanho--;

				dadoRetorno = removido.data;
				return dadoRetorno;
			}
		}

	}

}
