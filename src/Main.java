import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("\n##### Calcular Salário Líquido V:0.1 #####\n");
        Scanner scanner = new Scanner(System.in);

        double salario_1 = receberSalarioInput(scanner);
        double salario_2 = receberSalarioInput(scanner);
        double salario_3 = receberSalarioInput(scanner);
        double salario_4 = receberSalarioInput(scanner);
        double salario_5 = receberSalarioInput(scanner);

        calcularSalarioLiquido(salario_1);
        calcularSalarioLiquido(salario_2);
        calcularSalarioLiquido(salario_3);
        calcularSalarioLiquido(salario_4);
        calcularSalarioLiquido(salario_5);

        scanner.close();
    }

    static double receberSalarioInput(Scanner scanner) {
        System.out.print("Informe o salário bruto: ");
        return scanner.nextDouble();
    }

    static void calcularSalarioLiquido(double salario) {
        double descontoINSS = calcularINSS(salario);
        double descontoIRPF = calcularIRPF(salario);

        double salarioLiquido = salario - descontoINSS - descontoIRPF;

        System.out.println("\n-------- Cálculo do Salário Líquido --------");
        System.out.println("Proventos...................................");
        System.out.printf("- Salário Bruto: R$ %.2f\n", salario);
        System.out.println("Descontos...................................");
        System.out.printf("- Desconto INSS: R$ %.2f\n", descontoINSS);
        System.out.printf("- Desconto IRPF: R$ %.2f\n", descontoIRPF);
        System.out.println("............................................");
        System.out.printf("- Salário Líquido: R$ %.2f\n", salarioLiquido);
        System.out.println("------------------- FIM --------------------\n");
    }

    static double calcularINSS(double salario) {
        double auxSalario = salario;
        double totalDesconto = 0.0;

        final double PISO_FAIXA_4 = 3641.04;
        final double PISO_FAIXA_3 = 2427.36;
        final double PISO_FAIXA_2 = 1212.01;

        final double TETO_FAIXA_3 = 3641.03;
        final double TETO_FAIXA_2 = 2427.35;
        final double TETO_FAIXA_1 = 1212.00;

        final double ALIQUOTA_FAIXA_4 = 14 / 100;
        final double ALIQUOTA_FAIXA_3 = 12 / 100;
        final double ALIQUOTA_FAIXA_2 = 9 / 100;
        final double ALIQUOTA_FAIXA_1 = 7.5 / 100;

        double faixa_1;
        double faixa_2;
        double faixa_3;
        double faixa_4;

        double descontoFaixa_1;
        double descontoFaixa_2;
        double descontoFaixa_3;
        double descontoFaixa_4;

        if (salario >= PISO_FAIXA_4) {
            faixa_4 = auxSalario - TETO_FAIXA_3;
            auxSalario -= faixa_4;
            descontoFaixa_4 = faixa_4 * ALIQUOTA_FAIXA_4;
            totalDesconto += descontoFaixa_4;
        }

        if (salario >= PISO_FAIXA_3) {
            faixa_3 = auxSalario - TETO_FAIXA_2;
            auxSalario -= faixa_3;
            descontoFaixa_3 = faixa_3 * ALIQUOTA_FAIXA_3;
            totalDesconto += descontoFaixa_3;
        }

        if (salario >= PISO_FAIXA_2) {
            faixa_2 = auxSalario - TETO_FAIXA_1;
            auxSalario -= faixa_2;
            descontoFaixa_2 = faixa_2 * ALIQUOTA_FAIXA_2;
            totalDesconto += descontoFaixa_2;
        }

        faixa_1 = auxSalario;
        descontoFaixa_1 = faixa_1 * ALIQUOTA_FAIXA_1;
        totalDesconto += descontoFaixa_1;

        return totalDesconto;
    }


    static double calcularIRPF(double salario) {
        double auxSalario = salario;
        double totalDesconto = 0.0;

        final double PISO_FAIXA_5 = 4664.69;
        final double PISO_FAIXA_4 = 3751.06;
        final double PISO_FAIXA_3 = 2826.66;
        final double PISO_FAIXA_2 = 1903.99;

        final double TETO_FAIXA_4 = 4664.68;
        final double TETO_FAIXA_3 = 3751.05;
        final double TETO_FAIXA_2 = 2826.65;
        final double TETO_FAIXA_1 = 1903.98;

        final double ALIQUOTA_FAIXA_5 = 27.5 / 100;
        final double ALIQUOTA_FAIXA_4 = 22.5 / 100;
        final double ALIQUOTA_FAIXA_3 = 15 / 100;
        final double ALIQUOTA_FAIXA_2 = 7.5 / 100;
        final double ALIQUOTA_FAIXA_1 = 0 / 100;


        double faixa_1;
        double faixa_2;
        double faixa_3;
        double faixa_4;
        double faixa_5;

        double descontoFaixa_1;
        double descontoFaixa_2;
        double descontoFaixa_3;
        double descontoFaixa_4;
        double descontoFaixa_5;

        if (salario >= PISO_FAIXA_5) {
            faixa_5 = auxSalario - TETO_FAIXA_4;
            auxSalario -= faixa_5;
            descontoFaixa_5 = faixa_5 * ALIQUOTA_FAIXA_5;
            totalDesconto += descontoFaixa_5;
        }

        if (salario >= PISO_FAIXA_4) {
            faixa_4 = auxSalario - TETO_FAIXA_3;
            auxSalario -= faixa_4;
            descontoFaixa_4 = faixa_4 * ALIQUOTA_FAIXA_4;
            totalDesconto += descontoFaixa_4;
        }

        if (salario >= PISO_FAIXA_3) {
            faixa_3 = auxSalario - TETO_FAIXA_2;
            auxSalario -= faixa_3;
            descontoFaixa_3 = faixa_3 * ALIQUOTA_FAIXA_3;
            totalDesconto += descontoFaixa_3;
        }

        if (salario >= PISO_FAIXA_2) {
            faixa_2 = auxSalario - TETO_FAIXA_1;
            auxSalario -= faixa_2;
            descontoFaixa_2 = faixa_2 * ALIQUOTA_FAIXA_2;
            totalDesconto += descontoFaixa_2;
        }

        faixa_1 = auxSalario;
        descontoFaixa_1 = faixa_1 * ALIQUOTA_FAIXA_1;
        totalDesconto += descontoFaixa_1;

        return totalDesconto;
    }
}