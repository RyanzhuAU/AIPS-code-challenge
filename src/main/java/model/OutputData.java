package model;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class OutputData {
	
	private int totalCarRecords = 0;
	
	private Map<Date, Integer> dailyTrafficRecord;
	
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

	public Map<Date, Integer> getDailyTrafficRecord() {
		return dailyTrafficRecord;
	}

	public void setDailyTrafficRecord(Map<Date, Integer> dailyTrafficRecord) {
		this.dailyTrafficRecord = dailyTrafficRecord;
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
