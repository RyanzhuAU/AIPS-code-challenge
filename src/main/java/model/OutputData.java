package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class OutputData {
	
	private int totalCarRecords = 0;
	
	private Map<LocalDate, Integer> dailyTrafficRecords = new LinkedHashMap<>(); // just make sure the daily records are in the date order
	
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
	
	// generate the output report in the console.
	public void generateOutputReport() {
		// Q1
		System.out.println("===== Total cars record =====");
		System.out.println("The total number of cars is " + this.totalCarRecords);
		System.out.println();
		
		// Q2
		System.out.println("===== Daily cars record =====");
		this.dailyTrafficRecords.entrySet().stream()
			.forEach(data -> System.out.println(data.getKey().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) + 
					" " + data.getValue()));
		
		System.out.println();
		
		// Q3
		System.out.println("===== The top 3 half hours with most cars =====");
		this.topThreeTrafficRecords.forEach(record -> record.generateReport());

		System.out.println();
		
		// Q4
		System.out.println("===== The 1.5 hour period with least cars =====");
		this.leastThreeContiguousRecords.forEach(record -> record.generateReport());

		System.out.println();

	}
}
