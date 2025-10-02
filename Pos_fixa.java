import java.util.Stack;

public class Pos_fixa {
    public Double calculadora(String operacao, int tamanho_maximo){
        Stack<Double> pilha = new Stack<>();
        char[] caracteres = operacao.toCharArray();
        for (char c : caracteres) {
            if (c == '+' || c == '-' || c == '*' || c == '/') {
                double b = pilha.pop();
                double a = pilha.pop();
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
                 if(pilha.size() >= tamanho_maximo){
                    System.out.println("Pilha cheia");
                    return null;
                }
                pilha.push((double) Character.getNumericValue(c));
            }
        }
        return pilha.isEmpty() ? null : pilha.pop();
    }
}