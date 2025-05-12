package org.example;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Runnable runnable1 = () -> {
            long generate1 = Snowflake.generate(System.currentTimeMillis());
            System.out.println(generate1);
        };

        Runnable runnable2 = () -> {
            long generate1 = Snowflake.generate(System.currentTimeMillis());
            System.out.println(generate1);
        };

        Runnable runnable3 = () -> {
            long generate1 = Snowflake.generate(System.currentTimeMillis());
            System.out.println(generate1);
        };


        Runnable runnable4 = () -> {
            long generate1 = Snowflake.generate(System.currentTimeMillis());
            System.out.println(generate1);
        };


        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);
        Thread thread3 = new Thread(runnable3);
        Thread thread4 = new Thread(runnable4);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}
