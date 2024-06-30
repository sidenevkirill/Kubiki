package ru.lisdevs.myapplication;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class Test extends AppCompatActivity {

    public static LinearLayout button;
    public static LinearLayout button1;
    public static TextView textView;
    public static ImageView img1, img2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        if(Build.VERSION.SDK_INT >= 19)
        {
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }

        // массив для хранения изображений кубиков
        final int dice[] = {R.drawable.one, R.drawable.to, R.drawable.free,
                R.drawable.fo, R.drawable.five, R.drawable.six};

        // привязка кнопки прокрутки к ее идентификатору
        button = findViewById(R.id.btVar1);

        // связывание результирующего textview с его идентификатором
        textView = findViewById(R.id.tvVar1);

        // связывание обоих изображений
        // изображения кубиков из его идентификатора
        img1 = findViewById(R.id.ivVar1);
        img2 = findViewById(R.id.ivVar2);

        // вызов функции onclick
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // сгенерируйте два случайных числа
                // использование случайной функции
                Random random = new Random();
                int num1 = random.nextInt(6);
                Random random1 = new Random();
                int num2 = random.nextInt(6);

                // большее число будет отображено в
                // TextView как победитель розыгрыша в противном случае
                if (num1 > num2) {
                   // textView.setText("ИГРОК 1");
                } else if (num2 > num1) {
                   // textView.setText("ИГРОК 2");
                } else {
                   // textView.setText("НИЧЬЯ");
                }
                // установите изображения из массива по индексу
                // положение сгенерированных чисел
                img1.setImageResource(dice[num1]);
                img2.setImageResource(dice[num2]);
            }
        });
    }

    public void onBack(View v) {
        Intent intent = new Intent(this, MenuActivity.class);
        startActivityForResult(intent, 0);
    }

    public void goToSettings(View v){
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivityForResult(intent, 2);
    }

    public void onPlus(View v) {
        //создаём и отображаем текстовое уведомление
        Toast toast = Toast.makeText(getApplicationContext(),
                "Еще в разработке!",
                Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 700);
        toast.show();

    }

    public void onMinus(View v) {
        //создаём и отображаем текстовое уведомление
        Toast toast = Toast.makeText(getApplicationContext(),
                "Еще в разработке!",
                Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 700);
        toast.show();

    }
}