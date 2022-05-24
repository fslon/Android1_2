package ru.geekbrains.android1_2;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

public class SettingsActivity extends AppCompatActivity implements View.OnClickListener, InterfaceWithValues {

    Button changeThemeBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        initViews();
        firstLaunch();
    }

    private void firstLaunch() {
        if (getAppTheme(codeLightTheme) == 0)
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        else AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
    }

    private void initViews() {
        changeThemeBtn = findViewById(R.id.changeThemeButton);
        changeThemeBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        setResult(RESULT_OK);

        if (getAppTheme(codeLightTheme) == 0) {
            editAppThemeInPreferences(codeNightTheme);
        } else editAppThemeInPreferences(codeLightTheme);

        firstLaunch();
        recreate();

    }

    private void editAppThemeInPreferences(int themeCode) {
        SharedPreferences sharedPref = getSharedPreferences(nameSharedPreference, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit(); // Настройки сохраняются посредством специального класса editor.
        editor.putInt(themeInSharedPreference, themeCode);
        editor.apply();
    }

    public int getAppTheme(int themeCode) {
        SharedPreferences sharedPref = getSharedPreferences(nameSharedPreference, MODE_PRIVATE); // Работаем через специальный класс сохранения и чтения настроек
        return sharedPref.getInt(themeInSharedPreference, themeCode); // Прочитать тему, если настройка не найдена - взять по умолчанию
    }


}