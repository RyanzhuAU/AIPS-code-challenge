package solution;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

import model.OutputData;
import model.TrafficData;

public class Solution {
	public static void main(String[] args) {
		try {
			if (args.length == 0) {
				System.out.print("Please input the filename.");
				return;
			}
			
			String filepath = args[0];
			FileReader fileReader = new FileReader(filepath);
			FileLoader fileLoader = new FileLoader();
			
			ArrayList<TrafficData> trafficDataList = fileLoader.loadRecordFile(fileReader);
			
			TrafficDataAnalyzer dataAnalyzer = new TrafficDataAnalyzer(trafficDataList);
			OutputData outputData = dataAnalyzer.analysisTrafficData();
			
			outputData.generateOutputReport();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			// TODO: error handler
		}
		
    }
}