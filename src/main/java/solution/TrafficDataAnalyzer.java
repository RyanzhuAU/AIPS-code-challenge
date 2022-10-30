package solution;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import model.CombinedTrafficRecord;
import model.OutputData;
import model.TrafficData;

public class TrafficDataAnalyzer {

	private ArrayList<TrafficData> trafficDataList;
	
	private ArrayList<CombinedTrafficRecord> combinedRecordsList = new ArrayList<>();
	
	public TrafficDataAnalyzer(ArrayList<TrafficData> trafficDataList) {
		this.trafficDataList = trafficDataList;
	}
	
	public OutputData analysisTrafficData() {
		OutputData outputData = new OutputData();
		
		// this map is used for checking three contiguous records
		Map<LocalDateTime, Integer> trafficDataMap = this.trafficDataList.stream().collect(
                Collectors.toMap(TrafficData::getRecordTimeStamp, TrafficData::getCarRecord));
		
		for (TrafficData data: this.trafficDataList) {
			outputData.addTotalCarRecords(data.getCarRecord());
			outputData.addDailyTrafficRecord(data);
			
			// prepare the combinedRecordsList here
			this.analysisLeastThreeContiguousRecords(data, trafficDataMap);
		}
		
		// sort the data list to get the top 3 records.
		this.sortTrafficDataListByRecord();
		List<TrafficData> topThreeTrafficRecords = this.trafficDataList.stream().limit(3).collect(Collectors.toList());
		
		outputData.setTopThreeTrafficRecords((ArrayList<TrafficData>)topThreeTrafficRecords);
		
		// based on the combinedRecordsList to get the least 1.5 hrs records
		CombinedTrafficRecord leastCombinedRecord = this.getLeastCombinedRecord();
		outputData.setLeastThreeContiguousRecords(leastCombinedRecord.getContiguousTrafficData());
		
		return outputData;
	}
	
	private void sortTrafficDataListByRecord() {
        Collections.sort(this.trafficDataList, new Comparator<TrafficData>(){
        	public int compare(TrafficData td1, TrafficData td2) {
        		return td2.getCarRecord() - td1.getCarRecord();
            }
        });
	}
	
	// For this task, I only check three contiguous period. 
	private void analysisLeastThreeContiguousRecords(TrafficData trafficData, Map<LocalDateTime, Integer> trafficDataMap) {
		LocalDateTime firstCheckTime = trafficData.getRecordTimeStamp();
		LocalDateTime secondCheckTime = firstCheckTime.plusMinutes(30);
		LocalDateTime thirdCheckTime = secondCheckTime.plusMinutes(30);
		
		if (trafficDataMap.get(secondCheckTime) == null ||
				trafficDataMap.get(thirdCheckTime) == null) { return; }
		
		CombinedTrafficRecord combinedTrafficRecord = new CombinedTrafficRecord();
		combinedTrafficRecord.addContiguousTrafficData(new TrafficData(firstCheckTime, trafficDataMap.get(firstCheckTime)));
		combinedTrafficRecord.addContiguousTrafficData(new TrafficData(secondCheckTime, trafficDataMap.get(secondCheckTime)));
		combinedTrafficRecord.addContiguousTrafficData(new TrafficData(thirdCheckTime, trafficDataMap.get(thirdCheckTime)));
		
		this.combinedRecordsList.add(combinedTrafficRecord);
	}
	
	private CombinedTrafficRecord getLeastCombinedRecord() {
		Collections.sort(this.combinedRecordsList, new Comparator<CombinedTrafficRecord>(){
        	public int compare(CombinedTrafficRecord ctd1, CombinedTrafficRecord ctd2) {
        		return ctd1.getTotalRecords() - ctd2.getTotalRecords();
            }
        });
		
		return this.combinedRecordsList.get(0);
	}
	
}
