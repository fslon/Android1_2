package ru.geekbrains.android1_2;

import android.widget.Toast;

import java.util.ArrayList;

public class Counter {


    String number = ""; // текущее число до нажатия оператора (+/-/*/÷)
    ///  String operator; // оператор (+/-/*/÷)
    double currentCounter; // текущий счетчик

    MainActivity main;

    ArrayList<Object> list = new ArrayList<>(); // массив для примеров (что нужно вычислить)
    //Context ctx;

//    public Counter(Context ctx) {
//        this.ctx = ctx;
//    }

    public Counter(MainActivity main) {
        this.main = main;
    }

    public String getNumber() {
        return number;
    }

    public void appendToNumber(String number) {
        this.number += number;
    }


    public void convertStringToDouble() { // при нажатии оператора ранее введенные цифры из строки преобразовываются в число
        try {
            currentCounter = Double.parseDouble(number);
            addNumber();
        } catch (NumberFormatException e) {
//            Toast.makeText(ctx, "Введены недопустимые значения", Toast.LENGTH_SHORT).show();
            Toast.makeText(main.getApplicationContext(), "Введены недопустимые значения", Toast.LENGTH_SHORT).show();
        }
    }


    public void addNumber() { // добавление в ArrayList числа
        list.add(currentCounter);
        checkSequence();
        number = "";
        currentCounter = 0;
    }

    public void addOperator(String operator) { // добавление в ArrayList оператора
        list.add(operator);
        checkSequence();

    }


    public boolean checkSequence() { // проверяет на последовательность число-оператор-число-оператор. если подряд идут одинаковые объекты то false

        if (list.toArray().length > 2) {
            if (list.get(list.toArray().length - 1).getClass().equals(list.get(list.toArray().length - 2).getClass())) {
                Toast.makeText(main.getApplicationContext(), "!!!!!!!!!!!!!!", Toast.LENGTH_SHORT).show();
                list.remove(list.toArray().length - 2);
                if (main.display.getText().length() != 0) {
                    String NumberEntered = main.display.getText().toString();
                    NumberEntered = NumberEntered.substring(0, NumberEntered.length() - 2) + NumberEntered.substring(NumberEntered.length() - 1);
                    main.display.setText(NumberEntered);
                }
            }
        }


//        if (list.toArray().length != 0) {
//            for (int i = 0; i < list.toArray().length; i++) {
//
//                if (i % 2 == 1) {
//                    if (list.get(i).getClass() != String.class) {
//                        return false;
//                    }
//                } else {
//                    if (list.get(i).getClass() != Double.class) {
//                        Toast.makeText(main.getApplicationContext(), "HERE", Toast.LENGTH_SHORT).show();
//                        list.remove(i);
//                        if (main.display.getText().length() != 0) {
//                            String NumberEntered = main.display.getText().toString();
//                            NumberEntered = NumberEntered.substring(0, NumberEntered.length() - 1);
//                            main.display.setText("delete");
//                        }
//                        return false;}
//                }
//            }
//        }
        return true;
    }

    public void calculate() {


    }

}
