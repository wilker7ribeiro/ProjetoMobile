import java.util.Scanner;

public class Main {

	/**
	 * Scanner para pegar variáveis digitadas
	 */
	static Scanner sc = new Scanner(System.in);

	/**
	 * Método main executado ao rodar o programa
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		// Executa até a opção 7 for digitada
		boolean executando = true;
		do {
			// Mostra as opções
			System.out.println("1. Soma");
			System.out.println("2. Subtração");
			System.out.println("3. Divisão");
			System.out.println("4. Faixa etária");
			System.out.println("5. Números primos");
			System.out.println("6. Mudança de Base");
			System.out.println("7. Sair");
			System.out.println();
			// Escaneia a escolha
			int escolha = escanearInteger("");
			switch (escolha) {
			case 1:
				// Executa o código do Soma
				executarSoma();
				break;
			case 2:
				// Executa o código da Subtração
				executarSubtracao();
				break;
			case 3:
				// Executa o código da Divisão
				executarDivisao();
				break;
			case 4:
				// Executa o código da Faixa etária
				executarFaixaEtaria();
				break;
			case 5:
				// Executa o código da Soma dos Número Primos
				executarSomaNumerosPrimos();
				break;
			case 6:
				// Executa o código da Mudança de base
				executarMudancaDeBase();
				break;
			case 7:
				// Finaliza o programa
				executando = false;
				break;
			default:
				System.err.println("Opção inválida!");
			}
			System.out.println();
		} while (executando);

	}

	/**
	 * Código da mudança de base
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
				String tipo = escanearString("Digite d se o valor está em decimal ou b se o valor está em binário: ");
				if (tipo.equals("d")) {
					// Mostra a conversão para binário
					System.out.println(Integer.toBinaryString(valorN));
					codigoInvalido = false;
				} else if (tipo.equals("b")) {
					// Mostra a conversão para decimal
					System.out.println(Integer.parseInt(valorN.toString(), 2));
					codigoInvalido = false;
				} else {
					System.err.println("Código inválido!");
					codigoInvalido = true;
				}
			} while (codigoInvalido);
			System.out.println();
		}

	}
	
	/**
	 * Executa o código da soma de numeros primos
	 */
	private static void executarSomaNumerosPrimos() {
		int numero = escanearInteger("Digite o número: ");
		int soma = 0;
		for (int i = 0; i < numero; i++) {
			if (ehPrimo(i)) {
				soma += i;
			}
		}
		System.out.println("Soma de números primos: " + soma);
	}

	/**
	 * Retorna se o número passado é primo
	 * @param numero
	 * @return true se for primo, false se não for primo
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
	 * Executa o código da faixa etária
	 */
	private static void executarFaixaEtaria() {

		// Quantidade de pessoas que será digitado
		int quantidade = escanearInteger("Digite a quantidade de pessoas: ");
		
		// Inicializa variáveis
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
				
				// Escaneia o gêmero
				int codSexo = escanearInteger("Digite 1 para Masculino e 2 para Feminino: ");
				if (codSexo == 1) {
					// Atualiza as variáveis de pessoas do sexo Masculino
					somaIdadeMasculino += idade;
					somaIdadeTotal += idade;
					quantidadeMasculino++;
					codigoInvalido = false;
				} else if (codSexo == 2) {
					// Atualiza as variáveis de pessoas do sexo feminino
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
		
		// Mostra a média total
		System.out.println("Media total: " + somaIdadeTotal / quantidade);
		if (quantidadeMasculino > 0) {
			// Mostra a média do sexo Masculino caso algum tenha sido digitado
			System.out.println("Media do sexo Masculino: " + somaIdadeMasculino / quantidadeMasculino);
		} else {
			System.out.println("Não houve nenhum do sexo Masculino");
		}
		if (quantidadeFeminino > 0) {
			// Mostra a média do sexo Feminino caso algum tenha sido digitado
			System.out.println("Media do sexo Feminino: " + somaIdadeFeminino / quantidadeFeminino);
		} else {
			System.out.println("Não houve nenhum do sexo Feminino");
		}

	}
	
	/**
	 * Executa o codigo de divisão
	 */
	private static void executarDivisao() {
		Double primeiroNumero = escanearDouble("Digite o primeiro número: ");
		Double segundoNumero = escanearDouble("Digite o segundo número: ");
		System.out.println(primeiroNumero / segundoNumero);
	}

	/**
	 * Executa o codigo de subtração
	 */
	private static void executarSubtracao() {
		Double primeiroNumero = escanearDouble("Digite o primeiro número: ");
		Double segundoNumero = escanearDouble("Digite o segundo número: ");
		System.out.println(primeiroNumero - segundoNumero);

	}

	/**
	 * Executa o codigo de Soma
	 */
	private static void executarSoma() {
		Double primeiroNumero = escanearDouble("Digite o primeiro número: ");
		Double segundoNumero = escanearDouble("Digite o segundo número: ");
		System.out.println(primeiroNumero + segundoNumero);
	}

	/**
	 * Mostra uma mensagem e retorna o número inteiro digitado
	 * @param mensagem a ser apresentada
	 * @return número inteiro digitado
	 */
	public static Integer escanearInteger(String mensagem) {
		System.out.print(mensagem);
		return sc.nextInt();
	}

	/**
	 * Mostra uma mensagem e retorna o número decimal digitado
	 * @param mensagem a ser apresentada
	 * @return número decimal digitado
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