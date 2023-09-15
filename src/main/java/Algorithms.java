import javax.swing.*;
import java.awt.event.*;

public class Algorithms extends JFrame {
    private JTextArea console;
    private JPanel panel;
    private JTextField textField1;
    private String line;
    private int task = 0;

    public Algorithms() {
        super("Алгоритмы");
        this.setResizable(false);
        this.setContentPane(panel);
        this.setSize(800, 360);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        textField1.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
                // TODO Auto-generated method stub
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == 0x0A) {
                    lineEntered();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
                // TODO Auto-generated method stub
            }
        });
        console.append("Выберите задание. Для этого введите число 1, 2 или 3 соответственно.\n");
    }

    private void lineEntered() {
        line = textField1.getText();
        console.append(line + "\n");
        if (task == 0 && line != null) {
            if (line.equals("1") || line.equals("2") || line.equals("3")) {
                switch (line) {
                    case ("1"):
                        task = 1;
                        console.setText("");
                        console.append("Задание №1. Если введенное число больше 7, то вывести 'Привет'.\nДля выхода из задания введите 'Выход'\n");
                        console.append("Введите число:\n");
                        break;
                    case ("2"):
                        task = 2;
                        console.setText("");
                        console.append("Задание №2. Если введенное имя совпадает с Вячеслав, то вывести 'Привет, Вячеслав',\nесли нет, то вывести 'Нет такого имени'. Для выхода из задания введите 'Выход'\n");
                        console.append("Введите имя:\n");
                        break;
                    case ("3"):
                        task = 3;
                        console.setText("");
                        console.append("Задание №3. На входе есть числовой массив, необходимо вывести элементы массива кратные 3.\nДля выхода из задания введите 'Выход'\n");
                        console.append("Введите элементы массива через пробел:\n");
                        break;
                }
            } else {
                console.append("Нет такого задания!\n");
            }
            line = null;
        }
        if (task == 1 && line != null) {
            if (line.equalsIgnoreCase("Выход")) {
                task = 0;
                console.setText("");
                console.append("Выберите задание. Для этого введите число 1, 2 или 3 соответственно.\n");
            } else {
                if (isDigit(line)) {
                    double number = Double.parseDouble(line);
                    if (number > 7) console.append("Привет.\n");
                } else {
                    console.append("Это не число!\n");
                }
            }
            line = null;
        }
        if (task == 2 && line != null) {
            if (line.equalsIgnoreCase("Выход")) {
                task = 0;
                console.setText("");
                console.append("Выберите задание. Для этого введите число 1, 2 или 3 соответственно.\n");
            } else {
                if (line.equalsIgnoreCase("Вячеслав")) {
                    console.append("Привет, Вячеслав.\n");
                } else {
                    console.append("Нет такого имени!\n");
                }
            }
            line = null;
        }
        if (task == 3 && line != null) {
            String[] array;
            String result;
            if (line.equalsIgnoreCase("Выход")) {
                task = 0;
                console.setText("");
                console.append("Выберите задание. Для этого введите число 1, 2 или 3 соответственно.\n");
            } else {
                result = "";
                array = line.split(" ");
                for (int i = 0; i < array.length; i++) {
                    if (!isDigit(array[i])) {
                        console.append("Массив введен неверно!\n");
                        break;
                    }
                    if (Double.parseDouble(array[i]) % 3 == 0.0) {
                        result += array[i] + " ";
                    }
                }
                if (result.equals("")) {
                    console.append("Нет элементов, кратных 3.\n");
                } else {
                    console.append("Результат. Элементы массива, кратные 3 это: " + result + "\n");
                }
            }
            line = null;
        }
        textField1.setText("");
    }

    private static boolean isDigit(String str) throws NumberFormatException {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}