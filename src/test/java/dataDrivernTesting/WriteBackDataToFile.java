package dataDrivernTesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class WriteBackDataToFile {

	public static void main(String[] args) throws IOException {
		//Convert the physical file to java obj
		FileInputStream fis = new FileInputStream("./src/test/resources/DemoApps.properties");
		
		//
		Properties p = new Properties();
		
		//
		p.load(fis);
		
		//
		p.put("Author", "Pratap");
		
		//
		FileOutputStream fos = new FileOutputStream("./src/test/resources/DemoApps.properties");
		
		p.store(fos, "First update");
		

	}

}
