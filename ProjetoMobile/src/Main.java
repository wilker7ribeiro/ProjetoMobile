import java.util.Scanner;

public class Main {

	/**
	 * Scanner para pegar vari�veis digitadas
	 */
	static Scanner sc = new Scanner(System.in);

	/**
	 * M�todo main executado ao rodar o programa
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		// Executa at� a op��o 7 for digitada
		boolean executando = true;
		do {
			// Mostra as op��es
			System.out.println("1. Soma");
			System.out.println("2. Subtra��o");
			System.out.println("3. Divis�o");
			System.out.println("4. Faixa et�ria");
			System.out.println("5. N�meros primos");
			System.out.println("6. Mudan�a de Base");
			System.out.println("7. Sair");
			System.out.println();
			// Escaneia a escolha
			int escolha = escanearInteger("");
			switch (escolha) {
			case 1:
				// Executa o c�digo do Soma
				executarSoma();
				break;
			case 2:
				// Executa o c�digo da Subtra��o
				executarSubtracao();
				break;
			case 3:
				// Executa o c�digo da Divis�o
				executarDivisao();
				break;
			case 4:
				// Executa o c�digo da Faixa et�ria
				executarFaixaEtaria();
				break;
			case 5:
				// Executa o c�digo da Soma dos N�mero Primos
				executarSomaNumerosPrimos();
				break;
			case 6:
				// Executa o c�digo da Mudan�a de base
				executarMudancaDeBase();
				break;
			case 7:
				// Finaliza o programa
				executando = false;
				break;
			default:
				System.err.println("Op��o inv�lida!");
			}
			System.out.println();
		} while (executando);

	}

	/**
	 * C�digo da mudan�a de base
	 */
	private static void executarMudancaDeBase() {
		// Quantidade de valores a ser convertido
		int quantidade = escanearInteger("Digite a quantidade de valores: ");
		for (int i = 0; i < quantidade; i++) {
			// Captura o valor digitado
			Integer valorN = escanearInteger("Digite o valor " + (i + 1) + ": ");
			boolean codigoInvalido = false;
			do {
				// Captura o tipo do valor
				String tipo = escanearString("Digite d se o valor est� em decimal ou b se o valor est� em bin�rio: ");
				if (tipo.equals("d")) {
					// Mostra a convers�o para bin�rio
					System.out.println(Integer.toBinaryString(valorN));
					codigoInvalido = false;
				} else if (tipo.equals("b")) {
					// Mostra a convers�o para decimal
					System.out.println(Integer.parseInt(valorN.toString(), 2));
					codigoInvalido = false;
				} else {
					System.err.println("C�digo inv�lido!");
					codigoInvalido = true;
				}
			} while (codigoInvalido);
			System.out.println();
		}

	}
	
	/**
	 * Executa o c�digo da soma de numeros primos
	 */
	private static void executarSomaNumerosPrimos() {
		int numero = escanearInteger("Digite o n�mero: ");
		int soma = 0;
		for (int i = 0; i < numero; i++) {
			if (ehPrimo(i)) {
				soma += i;
			}
		}
		System.out.println("Soma de n�meros primos: " + soma);
	}

	/**
	 * Retorna se o n�mero passado � primo
	 * @param numero
	 * @return true se for primo, false se n�o for primo
	 */
	private static boolean ehPrimo(int numero) {
		if (numero <= 1) {
			return false;
		}
		for (int divisor = 2; divisor <= numero / 2; divisor++) {
			if (numero % divisor == 0) {
				return false;
			}
		}
		return true;
	}
	
	
	/**
	 * Executa o c�digo da faixa et�ria
	 */
	private static void executarFaixaEtaria() {

		// Quantidade de pessoas que ser� digitado
		int quantidade = escanearInteger("Digite a quantidade de pessoas: ");
		
		// Inicializa vari�veis
		int somaIdadeTotal = 0;
		int somaIdadeMasculino = 0;
		int somaIdadeFeminino = 0;
		int quantidadeMasculino = 0;
		int quantidadeFeminino = 0;
		
		for (int i = 0; i < quantidade; i++) {
			
			// Pra cada pessoa escaneia a idade
			int idade = escanearInteger("Digite a idade da pessoa " + (i + 1) + ": ");
			boolean codigoInvalido = false;
			do {
				
				// Escaneia o g�mero
				int codSexo = escanearInteger("Digite 1 para Masculino e 2 para Feminino: ");
				if (codSexo == 1) {
					// Atualiza as vari�veis de pessoas do sexo Masculino
					somaIdadeMasculino += idade;
					somaIdadeTotal += idade;
					quantidadeMasculino++;
					codigoInvalido = false;
				} else if (codSexo == 2) {
					// Atualiza as vari�veis de pessoas do sexo feminino
					somaIdadeFeminino += idade;
					somaIdadeTotal += idade;
					quantidadeFeminino++;
					codigoInvalido = false;
				} else {
					codigoInvalido = true;
				}
			} while (codigoInvalido);
			// Pula linha
			System.out.println();
		}
		
		// Mostra a m�dia total
		System.out.println("Media total: " + somaIdadeTotal / quantidade);
		if (quantidadeMasculino > 0) {
			// Mostra a m�dia do sexo Masculino caso algum tenha sido digitado
			System.out.println("Media do sexo Masculino: " + somaIdadeMasculino / quantidadeMasculino);
		} else {
			System.out.println("N�o houve nenhum do sexo Masculino");
		}
		if (quantidadeFeminino > 0) {
			// Mostra a m�dia do sexo Feminino caso algum tenha sido digitado
			System.out.println("Media do sexo Feminino: " + somaIdadeFeminino / quantidadeFeminino);
		} else {
			System.out.println("N�o houve nenhum do sexo Feminino");
		}

	}
	
	/**
	 * Executa o codigo de divis�o
	 */
	private static void executarDivisao() {
		Double primeiroNumero = escanearDouble("Digite o primeiro n�mero: ");
		Double segundoNumero = escanearDouble("Digite o segundo n�mero: ");
		System.out.println(primeiroNumero / segundoNumero);
	}

	/**
	 * Executa o codigo de subtra��o
	 */
	private static void executarSubtracao() {
		Double primeiroNumero = escanearDouble("Digite o primeiro n�mero: ");
		Double segundoNumero = escanearDouble("Digite o segundo n�mero: ");
		System.out.println(primeiroNumero - segundoNumero);

	}

	/**
	 * Executa o codigo de Soma
	 */
	private static void executarSoma() {
		Double primeiroNumero = escanearDouble("Digite o primeiro n�mero: ");
		Double segundoNumero = escanearDouble("Digite o segundo n�mero: ");
		System.out.println(primeiroNumero + segundoNumero);
	}

	/**
	 * Mostra uma mensagem e retorna o n�mero inteiro digitado
	 * @param mensagem a ser apresentada
	 * @return n�mero inteiro digitado
	 */
	public static Integer escanearInteger(String mensagem) {
		System.out.print(mensagem);
		return sc.nextInt();
	}

	/**
	 * Mostra uma mensagem e retorna o n�mero decimal digitado
	 * @param mensagem a ser apresentada
	 * @return n�mero decimal digitado
	 */
	public static Double escanearDouble(String mensagem) {
		System.out.print(mensagem);
		return sc.nextDouble();
	}

	/**
	 * Mostra uma mensagem e retorna o texto digitado
	 * @param mensagem a ser apresentada
	 * @return texto digitado
	 */
	private static String escanearString(String mensagem) {
		System.out.print(mensagem);
		sc.nextLine();
		return sc.nextLine();
	}

}