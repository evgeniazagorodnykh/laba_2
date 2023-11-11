package Calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Check {
    public static List<Element> checking(String data) {
        Stack<Integer> brackets = new Stack<>();
        ArrayList<Element> elements = new ArrayList<>();
        int index = 0;
        while (index < data.length()) {
            char symbol = data.charAt(index);
            switch (symbol) {
                case '(':
                    elements.add(new Element("left_bracket", symbol));
                    brackets.push(1);
                    index++;
                    continue;
                case ')':
                    elements.add(new Element("right_bracket", symbol));
                    if (brackets.empty())
                        throw new RuntimeException("The brackets are placed incorrectly!");
                    brackets.pop();
                    index++;
                    continue;
                case '+':
                    elements.add(new Element("oper_plus", symbol));
                    index++;
                    continue;
                case '-':
                    elements.add(new Element("oper_minus", symbol));
                    index++;
                    continue;
                case '*':
                    elements.add(new Element("oper_mul", symbol));
                    index++;
                    continue;
                case '/':
                    elements.add(new Element("oper_del", symbol));
                    index++;
                    continue;
                default:
                    if (symbol <= '9' && symbol >= '0') {
                        StringBuilder number = new StringBuilder();
                        do {
                            number.append(symbol);
                            index++;
                            if (index >= data.length()) {
                                break;
                            }
                            symbol = data.charAt(index);
                        } while (symbol <= '9' && symbol >= '0');
                        elements.add(new Element("number", number.toString()));
                    } else {
                        if (symbol != ' ') {
                            throw new RuntimeException("Unknown element: " + symbol);
                        }
                        index++;
                    }
            }
        }
        if (!brackets.empty())
            throw new RuntimeException("The brackets are placed incorrectly!");
        elements.add(new Element("end", ""));
        return elements;
    }
}
