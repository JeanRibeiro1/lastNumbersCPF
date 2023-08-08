import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite os 9 primeiros dígitos do CPF (apenas números): ");
        String novePrimeirosDigitos = scanner.nextLine();


        while (novePrimeirosDigitos.length() != 9 || !novePrimeirosDigitos.matches("[0-9]+")) {
            System.out.print("Por favor, digite 9 dígitos numéricos válidos: ");
            novePrimeirosDigitos = scanner.nextLine();

        }
        scanner.close();

        int primeiroDigito = calcularPrimeiroDigitoVerificador(novePrimeirosDigitos);
        int segundoDigito = calcularSegundoDigitoVerificador(novePrimeirosDigitos + primeiroDigito);



        System.out.println("Primeiro dígito verificador: " + primeiroDigito);
        System.out.println("Segundo dígito verificador: " + segundoDigito);
        System.out.println("Seu CPF completo é "+novePrimeirosDigitos.substring(0,3)+"."+novePrimeirosDigitos.substring(3,6)+"."+novePrimeirosDigitos.substring(6)+"-"+primeiroDigito+segundoDigito);
    }

    public static int calcularPrimeiroDigitoVerificador(String base) {
        int soma = 0;
        int multiplicador = 10;

        for (int i = 0; i < base.length(); i++) {
            int digito = Character.getNumericValue(base.charAt(i));
            soma += digito * multiplicador;
            multiplicador--;
        }

        int resto = soma % 11;
        return (resto < 2) ? 0 : 11 - resto;
    }

    public static int calcularSegundoDigitoVerificador(String base) {
        int soma = 0;
        int multiplicador = 11;

        for (int i = 0; i < base.length(); i++) {
            int digito = Character.getNumericValue(base.charAt(i));
            soma += digito * multiplicador;
            multiplicador--;
        }

        int resto = soma % 11;
        return (resto < 2) ? 0 : 11 - resto;
    }
}