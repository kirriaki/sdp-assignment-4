package assign4.second2;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Memento {
    private final String text;

    public Memento(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}

class History {
    private final List<Memento> mementos = new ArrayList<>();
    private int currentIndex = -1;

    public void save(Memento memento) {
        while (mementos.size() > currentIndex + 1) {
            mementos.remove(mementos.size() - 1);
        }
        mementos.add(memento);
        currentIndex++;
    }

    public Memento undo() {
        if (currentIndex > 0) {
            currentIndex--;
            return mementos.get(currentIndex);
        }
        return null;
    }

    public Memento redo() {
        if (currentIndex < mementos.size() - 1) {
            currentIndex++;
            return mementos.get(currentIndex);
        }
        return null;
    }
}
class TextEditor {
    private String text;
    private final History history;

    public TextEditor() {
        this.history = new History();
        this.text = "";
    }

    public void type(String newText) {
        history.save(new Memento(text));
        text += newText;
    }

    public void undo() {
        Memento memento = history.undo();
        if (memento != null) {
            text = memento.getText();
        } else {
            JOptionPane.showMessageDialog(null, "No more actions to undo.");
        }
    }

    public void displayText() {
        JOptionPane.showMessageDialog(null, "Current Text: " + text);
    }

    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        Scanner scanner = new Scanner(System.in);
        String command;

        do {
            command = JOptionPane.showInputDialog("Enter text to type ('undo' to undo, 'exit' to quit):");
            if (command != null) {
                if (command.equalsIgnoreCase("undo")) {
                    editor.undo();
                } else if (!command.equalsIgnoreCase("exit")) {
                    editor.type(command);
                }
                editor.displayText();
            }
        } while (command != null && !command.equalsIgnoreCase("exit"));

        scanner.close();
    }
}
