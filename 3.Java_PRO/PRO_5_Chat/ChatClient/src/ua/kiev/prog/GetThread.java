package ua.kiev.prog;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

class GetThread extends Thread {
	private int n;

	@Override
	public void run() {
		try {
			while (!isInterrupted()) {
				URL url = new URL("http://localhost:8888/get?from=" + n);
				HttpURLConnection http = (HttpURLConnection) url.openConnection();

				InputStream is = http.getInputStream();
				try {
					int sz = is.available();
					if (sz > 0) {
						byte[] buf = new byte[is.available()];
						is.read(buf);

						Gson gson = new GsonBuilder().create();
						Message[] list = gson.fromJson(new String(buf), Message[].class);

						for (Message m : list) {
							System.out.println(m);
							n++;
						}
					}
				} finally {
					is.close();
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return;
		}
	}
}

