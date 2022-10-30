package solution;

import java.util.ArrayList;

import model.OutputData;
import model.TrafficData;

public class TrafficDataAnalyzer {

	private ArrayList<TrafficData> trafficDataList;
	
	public TrafficDataAnalyzer(ArrayList<TrafficData> trafficDataList) {
		this.trafficDataList = trafficDataList;
	}
	
	public OutputData analysisTrafficData() {
		OutputData outputData = new OutputData();
		
		for (int n = 0; n < this.trafficDataList.size(); n++) {
			TrafficData data = this.trafficDataList.get(n);
			
			outputData.addTotalCarRecords(data.getCarRecord());
			outputData.addDailyTrafficRecord(data);
		}
		
		return outputData;
	}
	
}
