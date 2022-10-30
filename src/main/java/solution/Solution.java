package solution;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

import model.TrafficData;

public class Solution {
	public static void main(String[] args) {

//		ClassLoader classLoader = getClass().getClassLoader();
//		File file = new File(classLoader.getResource("test_data.txt").getFile());
		FileReader fileReader;
		try {
			fileReader = new FileReader("test_data.txt");
			FileLoader fileLoader = new FileLoader();
			
			ArrayList<TrafficData> trafficDataList = fileLoader.loadRecordFile(fileReader);
			
			System.out.print(trafficDataList.size());
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			// TODO: error handler
		}
		
    }
}