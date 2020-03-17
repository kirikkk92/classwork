package com.example.lesson2.utils;

import android.content.Context;
import android.content.DialogInterface;

import androidx.appcompat.app.AlertDialog;

import com.example.lesson2.R;

public class Dialog {
    public static void showErrorDialog(Context ctx, String error){
        //создаем всплывающий диалог
        AlertDialog.Builder alert = new AlertDialog.Builder(ctx);//вывод диалогового окна с ошибкой
        alert.setMessage(error);
        alert.setTitle("Ошибка");
        alert.setCancelable(true);
        alert.setPositiveButton("ЯСНО,ПОНЯТНО", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {}//вызов окна про нажатии на кнопку "ЯСНО
        });
        alert.setIcon(R.drawable.ic_launcher_background);//вывод иконки
        alert.create();//создает объект alert dialog
        alert.show();
    }
    public static void showDialog(Context ctx, String message){
        //создаем всплывающий диалог
        AlertDialog.Builder alert = new AlertDialog.Builder(ctx);//вывод диалогового окна с ошибкой
        alert.setMessage(message);
        alert.setCancelable(true);
        alert.create().show();//создает объект alert dialog
    }
}
