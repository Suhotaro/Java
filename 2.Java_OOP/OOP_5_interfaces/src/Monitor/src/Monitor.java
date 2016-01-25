package Monitor.src;
import java.io.File;
import java.io.IOException;
import java.nio.file.attribute.FileTime;
import java.text.SimpleDateFormat;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.lang.Runtime;



public class Monitor {
	String file;
	IFileEvent event;
	
	public Monitor(String file, IFileEvent event) {
		this.file = file;
		this.event = event;
	}
	
	public void start() {
		while (true) {
			File f = new File(file);

			if (f.exists() && f.isFile()) {
				if (event != null)
					event.onFileAdded(file);

				System.out.println("Absolute path: " + f.getAbsolutePath());
				System.out.println("Date of creating: " + f.lastModified());

				SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

				System.out.println("Last accessed at: " + sdf.format(f.lastModified()));

				Path file_dir = Paths.get("D:\\tmp");
				Path fl = file_dir.resolve("1.txt");

				BasicFileAttributes bfa = null;

				try {
					bfa = Files.readAttributes(fl, BasicFileAttributes.class);
				} catch (IOException ex) {
					System.out.println("EXEPTION: " + ex.getMessage());
				}

				FileTime ft = bfa.creationTime();
				System.out.println("Date of creation :" + sdf.format(ft.toMillis()));

				break;
			}

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}

			System.out.println("Waiting...");
		}
	}

	public void start_more_then_one() {
		while (true) {

			String[] tokens = file.split("&");

			for( String file_name : tokens )
			{
				File f = new File(file_name);

				if (f.exists() && f.isFile()) {
					if (event != null)
						event.onFileAdded(file_name);
				}
			}


			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {}

			System.out.println("Waiting...");

			try {
				Runtime.getRuntime().exec("cls.exe");
			} catch (IOException e) { }


		}
	}
}
