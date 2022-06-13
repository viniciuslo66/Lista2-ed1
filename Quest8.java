import java.util.Scanner;

public class Quest8 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		VetorPilha<Integer> stack = new VetorPilha<Integer>(5);

		String expression;
		int result = 0;

		System.out.println("Vamos fazer uma operação pós-fixa entre 3 números");
		System.out.println("***********Exemplo: 8 1 + 2 - ***************");
		System.out.println("***********Operações aceitas: + - * / ***************");

		expression = scanner.nextLine();

		String[] split = expression.split(" ");

		for (int i = 0; i < split.length; i++) {
			if (isInteger(split[i])) {
				stack.push(Integer.parseInt(split[i]));
				// System.out.println(stack.peek());
			} else {
				int number2 = (int) stack.pop();
				// System.out.println(stack.peek());
				int number1 = (int) stack.pop();
				// System.out.println(stack.peek());

				if (split[i].equals("+")) {
					result = number1 + number2;
				} else if (split[i].equals("-")) {
					result = number1 - number2;
				} else if (split[i].equals("*")) {
					result = number1 * number2;
				} else {
					result = number1 / number2;
				}

				stack.push(result);

			}
		}

		System.out.println("Resultado: " + result);

	}

	public static boolean isInteger(String input) {
		try {
			Integer.parseInt(input);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
