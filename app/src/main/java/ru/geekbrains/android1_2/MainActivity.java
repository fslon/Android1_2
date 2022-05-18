package ru.geekbrains.android1_2;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //todo переделать double на BigDecimal, разобраться с 0 (удаляет нули в значениях по типу 15.00000002)

    Counter counter;

    TextView display; // поле с отображением значений и операций

    RadioButton radioButtonLightTheme;
    RadioButton radioButtonNightTheme;

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

    public static final int codeLightTheme = 0;
    public static final int codeNightTheme = 1;
    private static final String nameSharedPreference = "THEMES"; // название файла в preferences куда все записывается
    private static final String themeInSharedPreference = "CURRENT_THEME"; // ключ по которому можно получить доступ к полю с темой

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstLaunch();

        initViews();

        counter = new Counter(this);

    }

    private void firstLaunch() {
        if (getAppTheme(codeLightTheme) == 0)
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        else AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
    }


    private int getAppTheme(int themeCode) {
        SharedPreferences sharedPref = getSharedPreferences(nameSharedPreference, MODE_PRIVATE); // Работаем через специальный класс сохранения и чтения настроек
        return sharedPref.getInt(themeInSharedPreference, themeCode); // Прочитать тему, если настройка не найдена - взять по умолчанию
    }

    private void editAppThemeInPreferences(int themeCode) {
        SharedPreferences sharedPref = getSharedPreferences(nameSharedPreference, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit(); // Настройки сохраняются посредством специального класса editor.
        editor.putInt(themeInSharedPreference, themeCode);
        editor.apply();
    }


    public void initViews() {
        radioButtonLightTheme = findViewById(R.id.radioButtonLightTheme);
        radioButtonLightTheme.setOnClickListener(this);
        radioButtonNightTheme = findViewById(R.id.radioButtonNightTheme);
        radioButtonNightTheme.setOnClickListener(this);
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

            case (R.id.radioButtonLightTheme):
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                editAppThemeInPreferences(codeLightTheme);
                recreate();
                break;

            case (R.id.radioButtonNightTheme):
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                editAppThemeInPreferences(codeNightTheme);
                recreate();
                break;

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

            case (R.id.buttonPoint): // todo сделать так, чтобы было невозможно поставить 2+ точки подряд
                counter.appendOperatorToList(buttonPoint.getText().toString());
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
                counter.appendOperatorToList(buttonPlus.getText().toString());
                break;

            case (R.id.buttonMinus):
                counter.appendOperatorToList(buttonMinus.getText().toString());
                break;

            case (R.id.buttonMultiply):
                counter.appendOperatorToList(buttonMultiply.getText().toString());
                break;

            case (R.id.buttonEqual):
                counter.appendOperatorToList(buttonEqual.getText().toString());
                if (counter.list.toArray().length > 2) counter.startCalculations();
                break;

        }
    }

    public void backspaceDisplay() { // удаляет последний символ на дисплее
        String displayInString = display.getText().toString();
        if (displayInString.length() != 0)
            display.setText(displayInString.substring(0, displayInString.length() - 1));
    }
}
