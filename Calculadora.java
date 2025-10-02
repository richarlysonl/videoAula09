import java.util.Scanner;
public class Calculadora {
    public static void main(String[] args) {
        int tamanho_maximo = 15;
        double resultado = 0;
        String operacao;
        System.out.println("digite o modelo desejado(infixa, pos_fixa ou pre_fixa):");
        Scanner scanner = new Scanner(System.in);
        String modelo = scanner.nextLine();
        switch(modelo){
            case "infixa":
                System.out.println("Você escolheu o modelo Infixa. digite agora a operação desejada:\n");
                operacao = scanner.nextLine();
                Infixa calculo_infixa = new Infixa();
                resultado = calculo_infixa.calculadora(operacao, tamanho_maximo);
                System.out.println("resultado: "+resultado);
                break;
            case "pos_fixa":
                System.out.println("Você escolheu o modelo Pós-fixa. digite agora a operação desejada:\n");
                operacao = scanner.nextLine();
                Pos_fixa calculo_pos_fixa = new Pos_fixa();
                resultado = calculo_pos_fixa.calculadora(operacao, tamanho_maximo);
                System.out.println("resultado: "+resultado);
                break;
            case "pre_fixa":
                System.out.println("Você escolheu o modelo Pré-fixa. digite agora a operação desejada:\n");
                operacao = scanner.nextLine();
                Pre_fixa calculo_pre_fixa = new Pre_fixa();
                resultado = calculo_pre_fixa.calculadora(operacao,  tamanho_maximo);
                System.out.println("resultado: "+resultado);
                break;
        }
    }
}