//Strategy pattern is a behavioural design pattern that enables selecting an algorithm at runtime. 
//It defines a family of algorithms, encapsulates each algorithm, and makes the algorithms interchangeable within that family.

package Behavioural_Design_Pattern;

// Strategy interface
interface TextFormatter {
    String format(String text);
}

// Concrete Strategies
class PlainTextFormatter implements TextFormatter {
    @Override
    public String format(String text) {
        return text;
    }
}

class BoldTextFormatter implements TextFormatter {
    @Override
    public String format(String text) {
        return "**" + text + "**";
    }
}

class ItalicTextFormatter implements TextFormatter {
    @Override
    public String format(String text) {
        return "*" + text + "*";
    }
}

// Context
class TextEditor {
    private TextFormatter textFormatter;

    public void setTextFormatter(TextFormatter textFormatter) {
        this.textFormatter = textFormatter;
    }

    public void publishText(String text) {
        System.out.println(textFormatter.format(text));
    }
}

// Main class to demonstrate
public class TextFormattingSystem {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();

        editor.setTextFormatter(new PlainTextFormatter());
        editor.publishText("Hello, World!");

        editor.setTextFormatter(new BoldTextFormatter());
        editor.publishText("Hello, World!");

        editor.setTextFormatter(new ItalicTextFormatter());
        editor.publishText("Hello, World!");
    }
}
