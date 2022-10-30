package model;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OutputData {
	
	private int totalCarRecords = 0;
	
	private Map<LocalDate, Integer> dailyTrafficRecords = new HashMap<>();
	
	private List<TrafficData> topThreeTrafficRecord;
	
	private List<TrafficData> leastCarRecords; // The 1.5 hour period with least cars (i.e. 3 contiguous half hour records)
	
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

	public List<TrafficData> getTopThreeTrafficRecord() {
		return topThreeTrafficRecord;
	}

	public void setTopThreeTrafficRecord(List<TrafficData> topThreeTrafficRecord) {
		this.topThreeTrafficRecord = topThreeTrafficRecord;
	}

	public List<TrafficData> getLeastCarRecords() {
		return leastCarRecords;
	}

	public void setLeastCarRecords(List<TrafficData> leastCarRecords) {
		this.leastCarRecords = leastCarRecords;
	}
}
