package thread.me;

public class VolatileTest {
    private  boolean shouldExit = false;

    public void setShouldExit(boolean shouldExit) {
        System.out.println("[" + Thread.currentThread().getName() + "] setShouldExit to " + shouldExit);
        this.shouldExit = shouldExit;
    }

    public void waitShouldExit() {
        System.out.println("[" + Thread.currentThread().getName() + "] waitShouldExit");
        System.out.println(this.shouldExit);
        while (!this.shouldExit) {
            System.out.println(this.shouldExit);
        }
        System.out.println(this.shouldExit);
        System.out.println("[" + Thread.currentThread().getName() + "] waitShouldExit end");
    }

    public static void main(String[] args) {
        final VolatileTest t1 = new VolatileTest();
        Runnable target = new Runnable() {
            @Override
            public void run() {
                t1.waitShouldExit();
            }
        };
        Thread thread = new Thread(target,"t-1" );
        thread.start();

        t1.setShouldExit(false);

    }
}
