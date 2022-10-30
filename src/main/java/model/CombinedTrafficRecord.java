package model;

import java.util.ArrayList;

public class CombinedTrafficRecord {
	
	private ArrayList<TrafficData> contiguousTrafficData = new ArrayList<>();
	
	private int totalRecords = 0;
	
	public CombinedTrafficRecord() {
		
	}

	public ArrayList<TrafficData> getContiguousTrafficData() {
		return contiguousTrafficData;
	}

	public void addContiguousTrafficData(TrafficData contiguousTrafficData) {
		this.contiguousTrafficData.add(contiguousTrafficData);
		this.totalRecords += contiguousTrafficData.getCarRecord();
	}

	public int getTotalRecords() {
		return totalRecords;
	}
	
}
