package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class OutputData {
	
	private int totalCarRecords = 0;
	
	private Map<LocalDate, Integer> dailyTrafficRecords = new HashMap<>();
	
	private ArrayList<TrafficData> topThreeTrafficRecords;
	
	private ArrayList<TrafficData> leastThreeContiguousRecords; // The 1.5 hour period with least cars (i.e. 3 contiguous half hour records)
	
	public OutputData() {
		
	}

	public int getTotalCarRecords() {
		return totalCarRecords;
	}

	public void addTotalCarRecords(int carRecords) {
		this.totalCarRecords += carRecords;
	}

	public Map<LocalDate, Integer> getDailyTrafficRecord() {
		return dailyTrafficRecords;
	}

	public void addDailyTrafficRecord(TrafficData dailyTrafficRecord) {
		LocalDate recordDate = dailyTrafficRecord.getRecordTimeStamp().toLocalDate();
		int carRecord = dailyTrafficRecord.getCarRecord();
		
		if (this.dailyTrafficRecords.containsKey(recordDate)) {
			int dailyRecordNum = this.dailyTrafficRecords.get(recordDate);
			this.dailyTrafficRecords.put(recordDate, dailyRecordNum + carRecord);
		} else {
			this.dailyTrafficRecords.put(recordDate, carRecord);
		}
	}

	public ArrayList<TrafficData> getTopThreeTrafficRecord() {
		return topThreeTrafficRecords;
	}

	public void setTopThreeTrafficRecords(ArrayList<TrafficData> topThreeTrafficRecord) {
		this.topThreeTrafficRecords = topThreeTrafficRecord;
	}

	public ArrayList<TrafficData> getLeastThreeContiguousRecords() {
		return leastThreeContiguousRecords;
	}

	public void setLeastThreeContiguousRecords(ArrayList<TrafficData> leastCarRecords) {
		this.leastThreeContiguousRecords = leastCarRecords;
	}
}
