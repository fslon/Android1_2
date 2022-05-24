package ru.geekbrains.android1_2;

public interface InterfaceWithValues {
    int codeLightTheme = 0;
    int codeNightTheme = 1;
    String nameSharedPreference = "THEMES"; // название файла в preferences куда все записывается
    String themeInSharedPreference = "CURRENT_THEME"; // ключ по которому можно получить доступ к полю с темой
    int REQUEST_CODE_SETTING_ACTIVITY = 99;
}
