package Calculator;

import java.util.List;

public class Calculator {
    private static List<Element> formula;
    private static int position;

    public Calculator(List<Element> data) {
        formula = data;
        position = 0;
    }

    /**
     * Запускает обход по выражению и находит решение выражения
     * @return решение выражения
     */
    public int expression() {
        Element elem = formula.get(position);
        if (elem.type.equals("end")) {
            return 0;
        } else {
            return summation();
        }
    }

    /**
     * Возвращает значение суммы или разности в выражении.
     * @return решение суммы или разности
     * @throws RuntimeException если введен неверный символ
     */
    public int summation() {
        int result = this.multiplication();
        while (true) {
            Element elem = formula.get(position++);
            switch (elem.type) {
                case "oper_plus":
                    result += this.multiplication();
                    break;
                case "oper_minus":
                    result -= this.multiplication();
                    break;
                case "right_bracket":
                case "end":
                    position--;
                    return result;
                default:
                    throw new RuntimeException("Unknown element: " + elem
                            + " at position: " + --position);
            }
        }
    }

    /**
     * Возвращает значение умножения или деления в выражении.
     * @return решение умножения или деления
     * @throws RuntimeException если введен неверный символ
     */
    public int multiplication() {
        int result = this.factor();
        while (true) {
            Element elem = formula.get(position++);
            switch (elem.type) {
                case "oper_mul":
                    result *= this.factor();
                    break;
                case "oper_del":
                    result /= this.factor();
                    break;
                case "right_bracket":
                case "oper_plus":
                case "oper_minus":
                case "end":
                    position--;
                    return result;
                default:
                    throw new RuntimeException("Unknown element: " + elem
                            + " at position: " + --position);
            }
        }
    }

    /**
     * Возвращает число или решение выражения в скобках.
     * @return число или решение выражения в скобках
     * @throws RuntimeException если введен неверный символ
     */
    public int factor() {
        Element elem = formula.get(position++);
        if (elem.type.equals("number"))
            return Integer.parseInt(elem.value);
        if (elem.type.equals("left_bracket")){
            int result = this.summation();
            elem = formula.get(position++);
            if (!elem.type.equals("right_bracket")) {
                throw new RuntimeException("Unknown element: " + elem
                        + " at position: " + --position);
            }
            return result;
        }
        else {
            throw new RuntimeException("Unknown element: " + elem
                    + " at position: " + --position);
        }
    }
}
