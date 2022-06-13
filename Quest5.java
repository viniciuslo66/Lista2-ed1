package lista2.quest5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;

import lista2.quest3.linked.LinkedListSingly;

//Lista de Exercícios da Primeira Unidade de Estrutura de Dados I

//Aluno: Jacó Gonzaga Brasil Neto
//Questão 5

/*
Desenvolva um programa que conte a frequência de cada palavra de um texto. Leia esse texto de um arquivo.
Utilize uma lista simplesmente encadeada.
Este programa deve permitir salvar o resultado em um arquivo binário e ler este arquivo binário.
*/

public class Quest5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String assetInput = "src/assets/text2.txt";
		String assetOutput = "src/assets/output_bin.jgbn";

		String textInput;

		try {
			textInput = reader(assetInput);
			textInput.toLowerCase(); // passa tudo pra lower case pra facilitar

			System.out.println(textInput);

			String[] textSplit = textInput.split(" "); // separa a frase em partes
			String stringAux = ""; // string auxiliar
			
			LinkedListSingly<String> linkedListSingly = new LinkedListSingly<String>();

			for (int i = 0; i < textSplit.length; i++) {

				/*
				 * a ideia dessse algoritmo foi de realizar um teste a partir da string auxiliar
				 * em cada iteração, caso ainda não exista a palavra na string, ela será
				 * adicionada e então o vetor das palavras é percorrido, e se tiver alguma
				 * palavra igual aumenta o contador caso a palavra da iteração já exista na
				 * auxiliar, nada será feito, pois o número de vezes da que a palavra aparece já
				 * foi contado antes
				 */

				if (!(stringAux.contains(textSplit[i]))) {
					int auxCont = 0;

					for (int j = 0; j < textSplit.length; j++) {
						if (textSplit[i].equals(textSplit[j])) {
							auxCont++;
						}
					}
					linkedListSingly.addFirst(textSplit[i] + "," + auxCont + "\n"); // passa o resultado pra uma linked list
					stringAux += textSplit[i] + " ";
				}
			}
			
			writer(assetOutput, linkedListSingly);	// escreve o a lista no arquivo binário
			linkedListSingly.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Deu erro");
			e.printStackTrace();
		}

	}

	public static String reader(String asset) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new FileReader(asset));

		StringBuffer sbResult = new StringBuffer();
		String line = "";

		while (line != null) {
			sbResult.append(line + "\n");
			line = bufferedReader.readLine();
		}

		bufferedReader.close();

		return sbResult.toString();
	}

	public static void writer(String path, LinkedListSingly<String> list) throws IOException 
	{
		File file = new File(path);
    	file.delete();
        file.createNewFile();

        ObjectOutputStream objOutput = new ObjectOutputStream(new FileOutputStream(file));
        
        objOutput.writeObject(list);
        objOutput.close();
	}

}