package lista2.quest8;

import java.util.Scanner;

import lista2.quest1.stack.StackArray;

//Lista de Exercícios da Primeira Unidade de Estrutura de Dados I

//Aluno: Jacó Gonzaga Brasil Neto
//Questão 8

/*
Desenvolva um programa que implemente o algoritmo que leia uma expressão já na forma pós-fixa e a resolva.
Nesta questão, considere cada operando com apenas um algarismo.
Exemplo: Expressão infixa: 8 + 1 - 2 Expressão pós-fixa: 8 1 + 2 - Resultado: 7
Algoritmo:
1. Inicialize pilha vazia
2. Varra a expressão:
2.1. Se for operando, empilhe o valor.
2.2. Se for operador, desempilhe dois valores da pilha, efetue a operação com eles e empilhe o resultado.
3. Ao final, exiba o elemento no topo da pilha, que é o resultado da expressão.

*/

public class Quest8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		StackArray<Integer> stack = new StackArray<Integer>(5);
		
		String expression;
		int result = 0;
		
		System.out.println("Vamos fazer uma operação pós-fixa entre 3 números");
		System.out.println("***********Exemplo: 8 1 + 2 - ***************");
		System.out.println("***********Operações aceitas: + - * / ***************");
		
		expression = scanner.nextLine();
		
		String[] split = expression.split(" ");
		
		for(int i = 0; i < split.length; i++) {
			if (isInteger(split[i])) {
				stack.push(Integer.parseInt(split[i]));
				//System.out.println(stack.peek());
			} else {
				int number2 = stack.pop();
				//System.out.println(stack.peek());
				int number1 = stack.pop();
				//System.out.println(stack.peek());
				
				if (split[i].equals("+")) {
					result = number1 + number2;
				} else if (split[i].equals("-")){
					result = number1 - number2;
				} else if (split[i].equals("*")) {
					result = number1 * number2;
				} else {
					result = number1/number2;
				}
				
				stack.push(result);
				
			}
		}
		
		System.out.println("Resultado: " + result);
		
	}
	
	public static boolean isInteger( String input ) {
	    try {
	        Integer.parseInt( input );
	        return true;
	    }
	    catch( Exception e ) {
	        return false;
	    }
	}

}
