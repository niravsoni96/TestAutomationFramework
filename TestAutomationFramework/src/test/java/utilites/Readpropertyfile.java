package utilites;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Readpropertyfile {

	public static void main(String[] args) throws IOException {
		
		FileReader fr= new FileReader("D:\\New folder (2)\\TestAutomationFramework\\src\\test\\resources\\configfiles\\config.properties");
		Properties pr= new Properties();
		pr.load(fr);
		
		
	}

}
