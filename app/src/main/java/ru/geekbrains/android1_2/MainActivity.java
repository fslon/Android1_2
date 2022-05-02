package ru.geekbrains.android1_2;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Counter counter;

    TextView display; // поле с отображением значений и операций // todo мб равно аппендить снизу + менее яркий текст (либо стирать полностью / показывать снизу все время ответ)

    // все записываается в arrayList, при нажатии оператора соседние числа складываются в одну ячейку, при нажатии 'равно' в мат. порядке запускаются все действия (сначала искать * и /, потом + и -)


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

        initViews();

        counter = new Counter(this);

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
                counter.appendNumberToList(Double.parseDouble(button1.getText().toString()));
                break;

            case (R.id.buttonTwo):
                display.append(button2.getText());
                counter.appendNumberToList(Double.parseDouble(button2.getText().toString()));
                break;

            case (R.id.buttonThree):
                display.append(button3.getText());
                counter.appendNumberToList(Double.parseDouble(button3.getText().toString()));
                break;

            case (R.id.buttonFour):
                display.append(button4.getText());
                counter.appendNumberToList(Double.parseDouble(button4.getText().toString()));
                break;

            case (R.id.buttonFive):
                display.append(button5.getText());
                counter.appendNumberToList(Double.parseDouble(button5.getText().toString()));
                break;

            case (R.id.buttonSix):
                display.append(button6.getText());
                counter.appendNumberToList(Double.parseDouble(button6.getText().toString()));
                break;

            case (R.id.buttonSeven):
                display.append(button7.getText());
                counter.appendNumberToList(Double.parseDouble(button7.getText().toString()));
                break;

            case (R.id.buttonEight):
                display.append(button8.getText());
                counter.appendNumberToList(Double.parseDouble(button8.getText().toString()));
                break;

            case (R.id.buttonNine):
                display.append(button9.getText());
                counter.appendNumberToList(Double.parseDouble(button9.getText().toString()));
                break;

            case (R.id.buttonZero):
                display.append(button0.getText());
                counter.appendNumberToList(Double.parseDouble(button0.getText().toString()));
                break;

            case (R.id.buttonReset):
                display.setText("");
                counter.list.clear();
                break;

            case (R.id.buttonPoint): // todo сделать точку (прописать невозможность стоять в пустой строке, после оператора и равно)
                display.append(buttonPoint.getText());
                counter.appendOperatorToList(buttonPoint.getText().toString());
                break;

            case (R.id.buttonEqual): // todo сделать равно (невозможность ставить после оператора (подумать насчет точки), в пустой строке, подумать насчет ситуации без вычислений(пользователь ввел только число и нажал равно))
                display.append(buttonEqual.getText());
                counter.appendOperatorToList(buttonEqual.getText().toString());
                break;

            case (R.id.buttonDivide):
                counter.appendOperatorToList(buttonDivide.getText().toString());
                break;
            case (R.id.buttonDeleteFromLeft):
                backspaceDisplay();

                if (counter.list.toArray().length != 0)
                    counter.list.remove(counter.list.toArray().length - 1);
                break;

            case (R.id.buttonPlus):

                Log.d("+++", counter.list.toString());

                counter.appendOperatorToList(buttonPlus.getText().toString());

                Log.d("+++", counter.list.toString());

                break;


            case (R.id.buttonMinus):
                counter.appendOperatorToList(buttonMinus.getText().toString());
                break;

            case (R.id.buttonMultiply):
                counter.appendOperatorToList(buttonMultiply.getText().toString());
                break;

        }
    }


    public void backspaceDisplay() { // удаляет последний символ на дисплее
        String displayInString = display.getText().toString();
        if (displayInString.length() != 0)
            display.setText(displayInString.substring(0, displayInString.length() - 1));
    }
}