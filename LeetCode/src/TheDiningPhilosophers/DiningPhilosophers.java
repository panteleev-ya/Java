package TheDiningPhilosophers;

public class DiningPhilosophers {
    private int num = 0;

    public DiningPhilosophers() {

    }

    // call the run() method of any runnable to execute its code
    public synchronized void wantsToEat(int philosopher,
                                        Runnable pickLeftFork,
                                        Runnable pickRightFork,
                                        Runnable eat,
                                        Runnable putLeftFork,
                                        Runnable putRightFork) throws InterruptedException {
        while (philosopher != num) {
            this.wait();
        }

        pickLeftFork.run();
        pickRightFork.run();

        eat.run();

        putLeftFork.run();
        putRightFork.run();

        num++;
        if (num > 4) {
            num = 0;
        }
        this.notifyAll();
    }
}
