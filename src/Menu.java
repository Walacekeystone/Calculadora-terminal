import java.util.Scanner;

public class Menu {
    public void exibir() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Calculadora Avançada ---");
            System.out.println("1. Adição");
            System.out.println("2. Subtração");
            System.out.println("3. Multiplicação");
            System.out.println("4. Divisão");
            System.out.println("5. Sair");

            System.out.print("Escolha uma opção: ");

            // Verifica se a entrada é um número inteiro
            if (!scanner.hasNextInt()) {
                System.out.println("Entrada inválida! Digite um número entre 1 a 5.");
                scanner.next(); // Descarta a entrada inválida
                continue; // Reinicia o loop
            }

            int opcao = scanner.nextInt();

            if (opcao == 5) {
                System.out.println("Encerrando a calculadora...");
                break;
            }

            processarOpcao(opcao, scanner);
        }
        scanner.close(); // Fecha o Scanner quando terminar
    }

    private void processarOpcao(int opcao, Scanner scanner) {
        try {
            double num1, num2;

            if (opcao >= 1 && opcao <= 4) {
                System.out.print("Digite o primeiro número: ");
                while (!scanner.hasNextDouble()) {
                    System.out.println("Entrada inválida! Digite um número válido:");
                    scanner.next();
                }
                num1 = scanner.nextDouble();

                System.out.print("Digite o segundo número: ");
                while (!scanner.hasNextDouble()) {
                    System.out.println("Entrada inválida! Digite um número válido:");
                    scanner.next();
                }
                num2 = scanner.nextDouble();
            } else {
                System.out.println("Opção inválida!");
                return;
            }

            // Criando as operações após receber os valores
            Adicao ad = new Adicao(num1, num2);
            Subtracao su = new Subtracao(num1, num2);
            Multiplicacao mu = new Multiplicacao(num1, num2);
            Divisao di = new Divisao(num1, num2);

            double resultado = switch (opcao) {
                case 1 -> ad.somar();
                case 2 -> su.subtrair();
                case 3 -> mu.multiplicar();
                case 4 -> di.dividir();
                default -> throw new IllegalArgumentException("Opção inválida!");
            };

            System.out.println("Resultado: " + resultado);
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
