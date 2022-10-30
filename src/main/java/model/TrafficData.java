package model;

import java.time.LocalDateTime;

public class TrafficData {
	
	private LocalDateTime recordTimeStamp;
	
	private int carRecord;
	
	public TrafficData() {
		
	}
	
	public TrafficData(LocalDateTime recordTimeStamp, int carRecord) {
		this.recordTimeStamp = recordTimeStamp;
		this.carRecord = carRecord;
	}

	public LocalDateTime getRecordTimeStamp() {
		return recordTimeStamp;
	}

	public void setRecordTimeStamp(LocalDateTime recordTimeStamp) {
		this.recordTimeStamp = recordTimeStamp;
	}

	public int getCarRecord() {
		return carRecord;
	}

	public void setCarRecord(int carRecord) {
		this.carRecord = carRecord;
	}
	
	
}
