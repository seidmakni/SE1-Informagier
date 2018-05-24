
public class TestThread1 implements Runnable {

	private Schuessel schuessel;

	public TestThread1(Schuessel schuessel) {
		this.schuessel = schuessel;
	}

	public void run() {
		while (!Thread.currentThread().isInterrupted()) {
			synchronized (schuessel) {
				if (schuessel.isSchluessel()) {
					try {
						schuessel.wait();
					} catch (InterruptedException e) {

					}
				} else {
					System.out.println("Läuft wieder");
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e1) {

					}
				}
			}
		}
	}

}
