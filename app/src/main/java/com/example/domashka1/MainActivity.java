package com.example.domashka1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // создание полей для вывода на экран нужных значений
    private TextView textCount; // окно вывода значения счётчика
    private Button button; // кнопка счётчика
    private int count = 0; // переменная счётчика
    private static final String KEY_COUNT ="key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // присваивание переменным активити элементов представления activity_main
        textCount = findViewById(R.id.textCount);
        button = findViewById(R.id.button);

        // выполнение действий при нажатии кнопки
        button.setOnClickListener(listener);
    }

    // объект обработки нажатия кнопки (слушатель)
    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            count++; // инкрементирование счётчика
            textCount.setText(Integer.toString(count));
        }
    };
    @Override
    protected  void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_COUNT, count);
    }
    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        count = savedInstanceState.getInt(KEY_COUNT);
    }
}