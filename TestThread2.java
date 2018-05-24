
public class TestThread2 implements Runnable {
	private Schuessel schuessel;

	public TestThread2(Schuessel schuessel) {
		this.schuessel = schuessel;
	}

	public void run() {
		while (!Thread.currentThread().isInterrupted()) {
			synchronized (schuessel) {
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {

				}
				schuessel.setSchluessel(false);
				schuessel.notifyAll();
			}
		}
	}

}
