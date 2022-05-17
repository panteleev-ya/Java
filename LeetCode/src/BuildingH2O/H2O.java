package BuildingH2O;

import java.util.concurrent.Semaphore;

public class H2O {

    private final Semaphore hydrogen;
    private final Semaphore oxygen;

    public H2O() {
        this.hydrogen = new Semaphore(2);
        this.oxygen = new Semaphore(1);
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {

        hydrogen.acquire();
        releaseHydrogen.run();
        if (hydrogen.availablePermits() == 0) // if both hydrogens are acquired(HH) release oxugne
            oxygen.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {

        oxygen.acquire();
        releaseOxygen.run();
        hydrogen.release(2); // ogygen is acquired relase HH for next molecule
    }
}
