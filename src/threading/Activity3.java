package threading;

import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;

public class Activity3 {
    public static LinkedBlockingQueue numQueue = new LinkedBlockingQueue<>();

    public static void main(String[] args) {
        ThreadGenNumber threadGen = new ThreadGenNumber();
        ThreadCheckNumber threadCheck = new ThreadCheckNumber();

        threadGen.start();
        threadCheck.start();
    }
}

class ThreadGenNumber extends Thread {
    @Override
    public void run() {
        while (true) {
            int num = new Random().nextInt(9000) + 999;
            System.out.println("Gen " + num);
            try {
                Activity3.numQueue.put(num);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class ThreadCheckNumber extends Thread {
    @Override
    public void run() {
        while (true) {
            try {
                Integer num = (Integer) Activity3.numQueue.take();
                if(num !=  null){
                    if((num% 400==0) ||(num % 4 == 0 &&  num % 100 != 0))
                    {
                        System.out.println(num + " la nam nhuan");
                    }else {
                        System.out.println(num + " khong la nam nhuan");
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
