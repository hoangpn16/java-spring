package threading;

public class Activity2 {
    public static void main(String[] args) {
        MyThread2 myThread1= new MyThread2("ABC",3500);
        myThread1.setName("ABC");
        Thread myThread2= new MyThread2("DEF" ,2500);
        myThread2.setName("DEF");

        myThread1.start();
        myThread2.start();
    }
}
class MyThread2 extends Thread{
    String name;
    int sleep;

    public MyThread2(String name, int sleep) {
        this.name = name;
        this.sleep = sleep;
    }

    @Override
    public void run() {
        while (true){
            System.out.println(currentThread().getName());
            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}