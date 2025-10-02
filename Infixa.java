import java.util.Stack;

public class Infixa {
     public Double calculadora(String expressao, int tamanho_maximo) {
        Stack<Double> valores = new Stack<>();
        Stack<Character> operadores = new Stack<>();
        char[] caracteres = expressao.toCharArray();
        for (int i = 0; i < caracteres.length; i++) {
            char c = caracteres[i];
            if (Character.isWhitespace(c)) continue;
            if (Character.isDigit(c)) {
                valores.push((double) (c - '0')); 
                if (valores.size() > tamanho_maximo) {
                    System.out.println("Pilha cheia");
                    return null;
                }
            }
            else if (c == '(' || c == '[' || c == '{') {
                operadores.push(c);
            }
            else if (c == ')' || c == ']' || c == '}') {
                while (!operadores.isEmpty() && !(operadores.peek() == '(' || operadores.peek() == '[' || operadores.peek() == '{')) {
                    aplicarOperador(valores, operadores.pop());
                }
                if (!operadores.isEmpty()) {
                    char abridor = operadores.pop();
                    if (!((abridor == '(' && c == ')') || 
                          (abridor == '[' && c == ']') || 
                          (abridor == '{' && c == '}'))) {
                        System.out.println("Erro: Agrupadores não correspondem.");
                        return null;
                    }
                }
            }
            else if (c == '+' || c == '-' || c == '*' || c == '/') {
                int precAtual = (c == '+' || c == '-') ? 1 : 2;
                while (!operadores.isEmpty()) {
                    char topo = operadores.peek();
                    int precTopo = (topo == '+' || topo == '-') ? 1 : (topo == '*' || topo == '/') ? 2 : 0;
                    if (precTopo >= precAtual) {
                        aplicarOperador(valores, operadores.pop());
                    } else break;
                }
                operadores.push(c);
            }
        }
        while (!operadores.isEmpty()) {
            if (operadores.peek() == '(' || operadores.peek() == '[' || operadores.peek() == '{') {
                System.out.println("Erro: Agrupador não fechado.");
                return null;
            }
            aplicarOperador(valores, operadores.pop());
        }

        return valores.isEmpty() ? null : valores.pop();
    }

    private void aplicarOperador(Stack<Double> valores, char operador) {
        double b = valores.pop();
        double a = valores.pop();
        switch (operador) {
            case '+': valores.push(a + b); break;
            case '-': valores.push(a - b); break;
            case '*': valores.push(a * b); break;
            case '/': 
                if (b != 0) valores.push(a / b);
                else throw new ArithmeticException("Divisão por zero");
                break;
        }
    }
}