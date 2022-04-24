package ru.geekbrains.android1_2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // при нажатии кнопки запись в строку
    // при нажатии оператора parseInt() в переменную
    // мб параллельно append в textField

    String actualValue; // текущее значение (при нажатии цифры записывается сюда)

    TextView display; // поле с отображением значений и операций //todo мб равно аппендить снизу + менее яркий текст (либо стирать полностью / показывать снизу все время ответ)

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
    }

    public void initViews() {
        display = (TextView) findViewById(R.id.display);

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
                display.setText("1");
                break;

            case (R.id.buttonTwo):

                break;

            case (R.id.buttonThree):

                break;
            case (R.id.buttonFour):

                break;
            case (R.id.buttonFive):

                break;
            case (R.id.buttonSix):

                break;
            case (R.id.buttonSeven):

                break;
            case (R.id.buttonEight):

                break;
            case (R.id.buttonNine):

                break;
            case (R.id.buttonZero):

                break;
            case (R.id.buttonReset):

                break;
            case (R.id.buttonPoint):

                break;
            case (R.id.buttonEqual):

                break;
            case (R.id.buttonDivide):

                break;
            case (R.id.buttonDeleteFromLeft):

                break;
            case (R.id.buttonPlus):

                break;
            case (R.id.buttonMinus):

                break;
            case (R.id.buttonMultiply):

                break;


        }


    }
}