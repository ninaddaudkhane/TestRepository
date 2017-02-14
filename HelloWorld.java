import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class HelloWorld {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello World !!");
		
		// Configure the logger
    	BasicConfigurator.configure();
    	
		// Logger
	    final Logger logger = Logger.getLogger("HelloWorld");
	    logger.info("--------------------- START -------------------------");
	    logger.info("Hello World log file !!");
	    logger.info("--------------------- END -------------------------");
	    
	    File directory = new File("./");
	    logger.info("AbsolutePath " + directory.getAbsolutePath());
	    
	    // get the file content
	 	StringBuffer lineBuffer = new StringBuffer();
	 		
	    try {
        	// Open the reader
        	BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("/midnas01/userhomedir/a246988/cpqbatch/config/LastExtractDateTime_DEV.txt")));
        	
        	// Read the String Content until EOF
        	String nextLine;
            while ((nextLine = reader.readLine()) != null) {
            	lineBuffer.append(nextLine);
            }
            
            // Close the reader
            reader.close();
            
            logger.info("File content" + lineBuffer.toString());
        }
        catch (IOException ioEx) {
        	logger.error(ioEx.getMessage());
        }
	}

}
