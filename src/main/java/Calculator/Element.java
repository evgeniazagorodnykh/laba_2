package Calculator;

public class Element {
    String type;
    String value;

    public Element(String type, String value) {
        this.type = type;
        this.value = value;
    }

    public Element(String type, Character value) {
        this.type = type;
        this.value = value.toString();
    }

    @Override
    public String toString() {
        return "type = " + type + ", value = " + value;
    }
}