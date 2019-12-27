package com.company;

public class Main {

    public static void main(String[] args) {
        User u = new User();
        u.language = Language.EN;
        switch (u.language) {
            case EN:
                System.out.println("Выбран иностранный язык");
                break;
            case RU:
            case BY:
            case UA:
                System.out.println("Выбран не иностранный язык");
        }
        System.out.println(Language.RU);
        //
        u.color = Color.BLACK;
        System.out.println(u.color.getValue());
        //
        Math m = Math.SUM;
        System.out.println(m.action(3,7));
        m = Math.MULTIPLY;
        System.out.println(m.action(3,7));

        //String
        //объявление строк

        String s = "hello";
        String s2 = new String("not recommended");

        //StringBuilder
        StringBuilder sb = new StringBuilder("ggg");
        sb.append("tttt");//добавляет значение в конец исходной строки

        //StringBuffer == StringBuilder, но он потокобезопасный

        //String

        String str = "    hello world    ";
        System.out.println(str.charAt(6));//возвращает символ строки по указанному индексу

        System.out.println(str.codePointAt(6));//возвращает код символа интекса

        byte[] b =  str.getBytes();//возвращает массив байт
        for (int i =0;i < b.length; i++) {
            System.out.print(b[i]);
        }
        //преобразование массива байт в строку
        String strFromByte = new String(b);
        //str.equalsIgnoreCase()- сравнивает 2 строки между собой без учета регистра
        System.out.println(" ");
        System.out.println("asdF".equalsIgnoreCase("ASdf"));

        System.out.println(str.indexOf("wor"));//возвращает индекс по символу?
        //если совпадений не найдено,то возвращает -1

        //LASTiNDEXoF == indexOf, но поиск начинается с конца строки
        System.out.println("hello".lastIndexOf("l"));

        //replase - заменяеет подстроку в исходней строке
        String str2 = str.replace("hello","hi");
        System.out.println(str2);
        //split() - разделяет строку по  символу либо строке
        "hello all hi".split(" ");//вернет массив состоящий из 3 значений:hello, all, hi. без роазделителя(пробела)
        String [] chunks = str.split(" ");
        for (int i = 0;i<chunks.length;i++){
            System.out.println(chunks[i]);
        }
        System.out.println(str.substring(1,5));//выделяет подстроку в строке

    }
}




