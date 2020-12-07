package threading;

public class Activity1 {
    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            MyThread thread = new MyThread(i);
            thread.setName("MyThread-" + i);
            thread.start();
        }
    }
}

class MyThread extends Thread {
    int stt;
    boolean started = false;

    public MyThread(int stt) {
        this.stt = stt;
    }

    @Override
    public void run() {
        while (true) {
            if (started == false) {
                System.out.println(Thread.currentThread().getName() + " started");
                started = true;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

