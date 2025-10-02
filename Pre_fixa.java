import java.util.Stack;

public class Pre_fixa {
    public Double calculadora(String operacao,  int tamanho_maximo){
        Stack<Double> pilha = new Stack<>();
        System.out.println("Operação recebida: " + operacao);
        char[] caracteres = operacao.toCharArray();
        // Percorre os caracteres da expressão pré-fixa da direita para a esquerda
        for (int i = caracteres.length - 1; i >= 0; i--) {
            char c = caracteres[i];
            if (c == '+' || c == '-' || c == '*' || c == '/') {
                double a = pilha.pop();
                double b = pilha.pop();
                switch (c) {
                    case '+':
                        pilha.push(a + b);
                        break;
                    case '-':
                        pilha.push(a - b);
                        break;
                    case '*':
                        pilha.push(a * b);
                        break;
                    case '/':
                        if (b != 0) {
                            pilha.push(a / b);
                        } else {
                            System.out.println("Erro: Divisão por zero");
                            return null;
                        }
                        break;
                }
            } else {
                pilha.push((double) Character.getNumericValue(c));
                if(pilha.size() > tamanho_maximo){
                    System.out.println("Pilha cheia");
                    return null;
                }
            }
        }
        return pilha.isEmpty() ? null : pilha.pop();
    }
}