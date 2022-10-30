package solution;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.time.LocalDateTime;
import java.util.ArrayList;

import model.TrafficData;

public class FileLoader {
	public FileLoader() {
		
	}
	
	public ArrayList<TrafficData> loadRecordFile(String filePath) {
		ArrayList<TrafficData> records = new ArrayList<>();
		
		try {
			FileReader fileReader = new FileReader(filePath);
			records = this.loadRecordFile(fileReader);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			//TODO: Add error handler
		}
		
		return records;
	}
	
	public ArrayList<TrafficData> loadRecordFile(Reader fileReader) {
		ArrayList<TrafficData> records = new ArrayList<>();

		try {
			BufferedReader br = new BufferedReader(fileReader);
			String line = br.readLine();
			
	        while (line != null) {
	        	// Split the line with space as the example file using the space as the separator
	        	String[] recordData = line.split(" ");
	        	
	        	TrafficData trafficData = new TrafficData();
	        	trafficData.setRecordTimeStamp(LocalDateTime.parse(recordData[0]));
	        	trafficData.setCarRecord(Integer.valueOf(recordData[1]));
	            
	        	records.add(trafficData);
	            
	            line = br.readLine();
	        }
	        
	        br.close();
	        
		} catch (IOException e) {
			// TODO add error handler
			e.printStackTrace();
		}
		
		
		return records;
	}
}
