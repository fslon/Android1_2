package ru.geekbrains.android1_2;

import java.util.ArrayList;

public class Counter {


    MainActivity main;

    ArrayList<Object> list = new ArrayList<>(); // массив для примеров (что нужно вычислить)

    public Counter(MainActivity main) {
        this.main = main;
    }

    public void appendNumberToList(double numberToAdd) {
        list.add(numberToAdd);
    }

    public void appendOperatorToList(String operatorToAdd) {

        if (list.toArray().length > 0) {
            if (list.get(list.toArray().length - 1).getClass() == operatorToAdd.getClass()) { // проверка на повторение операторов
                list.remove(list.toArray().length - 1);
                main.backspaceDisplay();
            }
            list.add(operatorToAdd);
            main.display.append(operatorToAdd);
        }
    }

    public void transformArrayForCalculations() { // преобразование массива для вычислений (собирание соседних ячеек с числами в одну)

        // todo сделать при нажатии равно преобразование чисел (учесть точку)

    }


}























