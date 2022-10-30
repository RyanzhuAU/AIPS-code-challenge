package solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
		
		this.sortTrafficDataList();
		List<TrafficData> topThreeTrafficRecords = this.trafficDataList.stream().limit(3).collect(Collectors.toList());
		
		outputData.setTopThreeTrafficRecords((ArrayList<TrafficData>)topThreeTrafficRecords);
		
		return outputData;
	}
	
	private void sortTrafficDataList() {
        Collections.sort(this.trafficDataList, new Comparator<TrafficData>(){
        	public int compare(TrafficData td1, TrafficData td2) {
        		return td2.getCarRecord() - td1.getCarRecord();
            }
        });
	}
	
}
