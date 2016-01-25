package Doc;

public class Sender extends Thread {
	Document doc;
	String email;
	
	public Sender(Document doc, String email) {
		this.doc = doc;
		this.email = email;
	}
	
	public void run() {
		System.out.println("Waiting for document #" + getId() + "...");
		
		synchronized (doc) {
			try {
				while ( ! doc.ready()) {
					doc.wait();
					System.out.println("*");
				}
			} catch (InterruptedException e) {
				return;
			}
		}
		
		System.out.println("Got document! Sending it to " + email + " ...");
	}
}
