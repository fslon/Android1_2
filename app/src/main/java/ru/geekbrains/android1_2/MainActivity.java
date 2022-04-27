package ru.geekbrains.android1_2;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // при нажатии кнопки запись в строку
    // при нажатии оператора parseInt() в переменную
    // мб параллельно append в textField

    Counter counter;

    String actualValue; // текущее значение (при нажатии цифры записывается сюда)

    TextView display; // поле с отображением значений и операций //todo мб равно аппендить снизу + менее яркий текст (либо стирать полностью / показывать снизу все время ответ)

    // все записываается в массив, потом по нему пройтись, выцепить операторы, (мб запомнить соседние элементы),
    // потом запустить в мат. порядке при нажатии кнопки равно


    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;
    Button button0;
    Button buttonPoint;
    Button buttonEqual;
    Button buttonDivide;
    Button buttonReset;
    Button buttonDeleteFromLeft;
    Button buttonPlus;
    Button buttonMinus;
    Button buttonMultiply;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("***", "222222222222222222");
        initViews();

//        counter = new Counter(getApplicationContext());

        counter = new Counter(this);

        //counter.convertStringToDouble(); //todo убрать
    }

    public void initViews() {
        display = findViewById(R.id.display);

        button1 = findViewById(R.id.buttonOne);
        button1.setOnClickListener(this);
        button2 = findViewById(R.id.buttonTwo);
        button2.setOnClickListener(this);
        button3 = findViewById(R.id.buttonThree);
        button3.setOnClickListener(this);
        button4 = findViewById(R.id.buttonFour);
        button4.setOnClickListener(this);
        button5 = findViewById(R.id.buttonFive);
        button5.setOnClickListener(this);
        button6 = findViewById(R.id.buttonSix);
        button6.setOnClickListener(this);
        button7 = findViewById(R.id.buttonSeven);
        button7.setOnClickListener(this);
        button8 = findViewById(R.id.buttonEight);
        button8.setOnClickListener(this);
        button9 = findViewById(R.id.buttonNine);
        button9.setOnClickListener(this);
        button0 = findViewById(R.id.buttonZero);
        button0.setOnClickListener(this);
        buttonPoint = findViewById(R.id.buttonPoint);
        buttonPoint.setOnClickListener(this);
        buttonEqual = findViewById(R.id.buttonEqual);
        buttonEqual.setOnClickListener(this);
        buttonDivide = findViewById(R.id.buttonDivide);
        buttonDivide.setOnClickListener(this);
        buttonReset = findViewById(R.id.buttonReset);
        buttonReset.setOnClickListener(this);
        buttonDeleteFromLeft = findViewById(R.id.buttonDeleteFromLeft);
        buttonDeleteFromLeft.setOnClickListener(this);
        buttonPlus = findViewById(R.id.buttonPlus);
        buttonPlus.setOnClickListener(this);
        buttonMinus = findViewById(R.id.buttonMinus);
        buttonMinus.setOnClickListener(this);
        buttonMultiply = findViewById(R.id.buttonMultiply);
        buttonMultiply.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case (R.id.buttonOne):
                display.append(button1.getText());
                counter.appendToNumber("1");

                break;

            case (R.id.buttonTwo):
                display.append(button2.getText());
                counter.appendToNumber("2");

                break;

            case (R.id.buttonThree):
                display.append(button3.getText());
                counter.appendToNumber("3");

                break;
            case (R.id.buttonFour):
                display.append(button4.getText());
                counter.appendToNumber("4");
                break;
            case (R.id.buttonFive):
                display.append(button5.getText());
                counter.appendToNumber("5");
                break;
            case (R.id.buttonSix):
                display.append(button6.getText());
                counter.appendToNumber("6");
                break;
            case (R.id.buttonSeven):
                display.append(button7.getText());
                counter.appendToNumber("7");
                break;
            case (R.id.buttonEight):
                display.append(button8.getText());
                counter.appendToNumber("8");
                break;
            case (R.id.buttonNine):
                display.append(button9.getText());
                counter.appendToNumber("9");
                break;
            case (R.id.buttonZero):
                display.append(button0.getText());
                counter.appendToNumber("0");
                break;
            case (R.id.buttonReset):
                display.setText("");
                counter.number = "";
                counter.currentCounter = 0;
                counter.list.clear();
                break;
            case (R.id.buttonPoint):
                display.append(buttonPoint.getText());
                break;
            case (R.id.buttonEqual):
                display.append(buttonEqual.getText());
                break;
            case (R.id.buttonDivide):
                display.append(buttonDivide.getText());
                counter.convertStringToDouble();
                counter.addOperator("÷");
                break;
            case (R.id.buttonDeleteFromLeft): //todo не везде сделано удаление

                    display.setText(deleteLastSymbolOfString(display.getText().toString(), 1));

                if (counter.number.length() != 0)
                    counter.number = counter.number.substring(0, counter.number.length() - 1);

                if (counter.list.toArray().length != 0) {
                    Log.d("/////////", "1111");
                    Log.d("***----", counter.list.toString());
                    if (counter.list.get(counter.list.toArray().length - 1).getClass() == Double.class) {
                        Log.d("/////////", "2222");

                        counter.list.set(counter.list.toArray().length - 1, Double.parseDouble( deleteLastSymbolOfString( counter.list.get(counter.list.toArray().length - 1).toString(), 3)));
                        Log.d("***", counter.list.toString());



                    } else if (counter.list.get(counter.list.toArray().length - 1).getClass() == String.class) {
                        counter.list.remove(counter.list.toArray().length-1);
                        counter.list.remove(counter.list.toArray().length-2);
                    }
                }

                break;

            case (R.id.buttonPlus):
                display.append(buttonPlus.getText());
//                display.append("--- " + counter.number + " ---"); // todo убрать
                counter.convertStringToDouble();
                counter.addOperator("+");

                counter.currentCounter=0;
                counter.addNumber();
                break;
            case (R.id.buttonMinus):
                display.append(buttonMinus.getText());
                counter.convertStringToDouble();
                counter.addOperator("-");
                break;
            case (R.id.buttonMultiply):
                display.append(buttonMultiply.getText());
                counter.convertStringToDouble();
                counter.addOperator("*");
                break;

        }
    }

    private String deleteLastSymbolOfString(String stringForDelete, int number) { // удаляет последний символ в строке
        Log.e("111", stringForDelete);
        if (stringForDelete.length() != 0)
            stringForDelete = stringForDelete.substring(0, stringForDelete.length() - number);
        Log.e("222", stringForDelete);
        return stringForDelete;
    }

}