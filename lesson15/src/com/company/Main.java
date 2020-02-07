package com.company;

public class Main {

    public static void main(String[] args) {

        // многопоточность

        //засекаем время перед началом цикла
        long t = System.currentTimeMillis();
        for (int i = 0; i < 100000000; i++) {
            double d = Math.atan(13) * Math.cos(79) + Math.exp(23 - i) +
                    Math.sqrt(i);
        }
        System.out.println(System.currentTimeMillis() - t);

        ////создаем новый поток

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 50000000; i++) {
                    double d = Math.atan(13) * Math.cos(79) + Math.exp(23 - i) +
                            Math.sqrt(i);
                }
            }
        }
        );
        MyThread t2 = new MyThread();
        long tt = System.currentTimeMillis();
        t1.start();
        t2.start();

        try {
            t1.join();//основной поток ожидает завершения остальных потоков
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(System.currentTimeMillis() - tt);




    //синхронизация потоков

    MyClass m = new MyClass();
    MyClass mm = new MyClass();
    Thread tt1 = new Thread(new Runnable() {
        @Override
        public void run() {
            for (int i = 0; i < 100000; i++) {
                m.calc(1);
                m.calc2(1,"A");
            }
        }
    });

    Thread tt2 = new Thread(new Runnable() {
        @Override
        public void run() {
            for (int i = 0; i < 100000; i++) {
                m.calc(-1);
                m.calc2(-1,"B");
            }
        }
    });
    tt1.start();
    tt2.start();

        try {
            tt1.join();
            tt2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(m.value);
        System.out.println(m.value2);


    }

}
