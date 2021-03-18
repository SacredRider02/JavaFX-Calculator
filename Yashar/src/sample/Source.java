package sample;

public class Source {
    public int calculate(int number1, int number2, String operator) {
        switch (operator) {
            case "+":
                return number1 + number2;

            case "-":
                return number1 - number2;

            case "/":
                if (number2 == 0) {
                    return 0;
                }
                return number1 / number2;

            case "*":
                return number1 * number2;

            default:
                return 0;
        }
    }
}
