package ru.geekbrains.android1_2;

import java.util.ArrayList;

public class Counter {


    MainActivity main;

    int checkForEnd = 0; // если стоит 1, то сбросить все (1 ставится после нажатия "равно")

    ArrayList<Object> list = new ArrayList<>(); // массив для примеров (что нужно вычислить)

    public Counter(MainActivity main) {
        this.main = main;
    }

    public void appendNumberToList(double numberToAdd) {
        if (checkForEnd == 1) { // проверка на "равно" чуть раньше, т.е. после нажатия "равно" нужно выполнить действия внутри
            main.display.setText(String.valueOf(numberToAdd).substring(0, String.valueOf(numberToAdd).length() - 2));
            list.clear();
            checkForEnd = 0;
        }
        list.add(numberToAdd);
    }

    public void appendOperatorToList(String operatorToAdd) {

        if (checkForEnd == 1) { // проверка на "равно" чуть раньше, т.е. после нажатия "равно" нужно выполнить действия внутри
            main.display.setText("");
            list.clear();
            checkForEnd = 0;
        }

        if (list.toArray().length > 0) {
            if (list.get(list.toArray().length - 1).getClass() == operatorToAdd.getClass()) { // проверка на повторение операторов
                list.remove(list.toArray().length - 1);
                main.backspaceDisplay();
            }
            list.add(operatorToAdd);
            main.display.append(operatorToAdd);
        }
    }

    public void startCalculations() { // при нажатии "равно" срабатывает этот метод

        transformArrayForCalculations();
        performCalculations();

        if (list.get(0).getClass() == Double.class) {
            if (list.get(0).toString().subSequence(list.get(0).toString().length() - 2, list.get(0).toString().length()).equals(".0")) { // округление до целого числа, если это необходимо
                list.set(0, list.get(0).toString().substring(0, list.get(0).toString().length() - 2));
            }
            main.display.append(list.get(0).toString());
        }
        checkForEnd = 1;
    }


    public void transformArrayForCalculations() { // преобразование массива для вычислений (собирание соседних ячеек с числами в одну)

        for (int i = 0; i < list.toArray().length - 1; ) {
            if (list.get(i).getClass() == Double.class & list.get(i).getClass() == list.get(i + 1).getClass()) { // если соседние элементы равны double.class, то первый из них сливается со следующим, а ячейка второго удаляется

                list.set(i, Double.parseDouble(list.get(i).toString().substring(0, list.get(i).toString().length() - 2) + list.get(i + 1).toString().substring(0, list.get(i + 1).toString().length() - 2)));

                list.remove(i + 1);

            } else i++;
            if (list.get(i).toString().equals(main.buttonPoint.getText().toString())) { // если текущая ячейка это точка, то в нее складываются соседние ячейки, потом соседние ячейки удаляются

                list.set(i, Double.parseDouble(list.get(i - 1).toString().substring(0, list.get(i - 1).toString().length() - 2) + list.get(i).toString()));

                for (int j = i + 1; j < list.toArray().length - 1; j++) {
                    if (list.get(j).getClass() == Double.class) {
                        if (j == i + 1) {
                            list.set(i, Double.parseDouble(list.get(i).toString().substring(0, list.get(i).toString().length() - 1) + list.get(j).toString().substring(0, list.get(j).toString().length() - 2)));
                        } else {
                            list.set(i, Double.parseDouble(list.get(i).toString() + list.get(j).toString().substring(0, list.get(j).toString().length() - 2)));
                            j--;
                            list.remove(j);
                        }
                    } else {
                        j = list.toArray().length;
                    }
                }
                list.remove(i + 1);
                list.remove(i - 1);
            }
        }
    }


    public void performCalculations() { // непосредственно выполнение расчетов

        for (int i = 0; i < list.toArray().length; i++) { // цикл для умножить или делить
            if (list.get(i).getClass() == String.class) {
                if (list.get(i).toString().equals(main.buttonMultiply.getText().toString())) {
                    list.set(i, ((double) list.get(i - 1)) * ((double) list.get(i + 1)));
                    list.remove(i + 1);
                    list.remove(i - 1);
                    i--;
                } else if (list.get(i).toString().equals(main.buttonDivide.getText().toString())) {
                    list.set(i, ((double) list.get(i - 1)) / ((double) list.get(i + 1)));
                    list.remove(i + 1);
                    list.remove(i - 1);
                    i--;
                }

            }
        }

        for (int i = 0; i < list.toArray().length; i++) { // цикл для плюс или минус
            if (list.get(i).getClass() == String.class) {
                if (list.get(i).toString().equals(main.buttonMinus.getText().toString())) {
                    list.set(i, ((double) list.get(i - 1)) - ((double) list.get(i + 1)));
                    list.remove(i + 1);
                    list.remove(i - 1);
                    i--;
                } else if (list.get(i).toString().equals(main.buttonPlus.getText().toString())) {
                    list.set(i, ((double) list.get(i - 1)) + ((double) list.get(i + 1)));
                    list.remove(i + 1);
                    list.remove(i - 1);
                    i--;
                }
            }
        }


    }


}























