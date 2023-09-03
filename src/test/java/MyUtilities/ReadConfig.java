package MyUtilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	Properties pro;
	
	public ReadConfig() {
		File src = new File("./Configurations/config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
		    pro = new Properties();
		    pro.load(fis);
	    } catch(Exception e) {
		    System.out.println("Exception is: " + e.getMessage());
	    }
	}
	
	public String getApplicationURL() {
		String url = pro.getProperty("baseURL");
		return url;
		}
	
	public String getUsername() {
		String un = pro.getProperty("username");
		return un;	
	}
	
	public String getPassword() {
		String pw = pro.getProperty("password");
		return pw;
	}
	
	public String getFname() {
		String fn = pro.getProperty("fname1");
		return fn;
	}
	
	public String getLname() {
		String ln = pro.getProperty("lname1");
		return ln;
	}
	
	public String getPostalCode() {
		String pc = pro.getProperty("pcode1");
		return pc;
	}
	
}
