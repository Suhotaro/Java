package Doc;

import java.util.Random;

public class DigitalScanner extends Thread {
	Document doc;
	
	public DigitalScanner(Document doc) {
		this.doc = doc;
	}
	
	public void run() {
		System.out.println("Scanning the document....");

		// эмитируем бурную деятельность...
		// типа сканируем документ...
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		byte[] data = new byte[1000];
		new Random().nextBytes(data);

		synchronized (doc) {
			doc.setData(data);
			// сообщаем всем, кто ждет, что документ готов
			doc.notifyAll();
		}
	}
}
