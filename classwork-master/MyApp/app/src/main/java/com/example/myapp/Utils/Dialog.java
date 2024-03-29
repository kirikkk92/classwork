package com.example.myapp.Utils;

import android.content.Context;
import android.content.DialogInterface;
import android.widget.CalendarView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;

import com.example.myapp.R;
import com.example.myapp.model.CalendarDate;

public class Dialog {

    public interface  onDateChangeListener {
        void onDateChange(int year,int month,int day);
    }

     public static void showErrorDialog (Context ctx, String error) {
        AlertDialog.Builder alert = new AlertDialog.Builder(ctx);       //Создание всплывающего диалога с ошибкой, нужно передать context, чтобы было понятно из какого активити он вызван
        alert.setMessage(error);
        alert.setTitle("Ошибка!");
        alert.setCancelable(true);      //задаем возможность скрыть диалог, нажатием на пустой экран
        alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {       //в диалоге создается кнопка, для закрытия диалога, передаем текст, которй буте на ней и слушателя
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }      //если оставить метод пустым, диалог просто исчезнет при нажатии кнопки
        });
        //alert.setIcon() //метод позволяет задать иконку для диалога
        alert.create().show();

    }

    public static void showDialog (Context ctx, String message ) {
        AlertDialog.Builder alert = new AlertDialog.Builder(ctx);       //Создание всплывающего диалога с ошибкой, нужно передать context, чтобы было понятно из какого активити он вызван
        alert.setMessage(message);
        alert.setCancelable(true);      //задаем возможность скрыть диалог, нажатием на пустой экран
        alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {       //в диалоге создается кнопка, для закрытия диалога, передаем текст, которй буте на ней и слушателя
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }      //если оставить метод пустым, диалог просто исчезнет при нажатии кнопки
        });
        //alert.setIcon() //метод позволяет задать иконку для диалога
        alert.create().show();

    }

    public static void showCalendarDialog (Context ctx, final onDateChangeListener listener) {
        AlertDialog.Builder alert = new AlertDialog.Builder(ctx);
        alert.setView(R.layout.calendar_layot);     //задаем внешний вид в виде календаря
        alert.setCancelable(true);      //задаем возможность скрыть диалог, нажатием на пустой экран
        final CalendarDate date = new CalendarDate();
        alert.setPositiveButton("Okay", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (!date.isEmpty()) {
                    listener.onDateChange(date.year, date.month, date.day);
                }
            }
        });
        AlertDialog dialog = alert.create();
        dialog.show();
        CalendarView calendar = dialog.findViewById(R.id.calendarView);
        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int y, int m, int d) {
                date.year = y;
                date.month = m;
                date.day = d;
            }
        });
    }

}
