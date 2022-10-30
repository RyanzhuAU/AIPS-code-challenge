package model;

import java.time.LocalDateTime;

public class TrafficData {
	
	private LocalDateTime recordTimeStamp;
	
	private Integer carRecord;
	
	public TrafficData() {
		
	}
	
	public TrafficData(LocalDateTime recordTimeStamp, Integer carRecord) {
		this.recordTimeStamp = recordTimeStamp;
		this.carRecord = carRecord;
	}

	public LocalDateTime getRecordTimeStamp() {
		return recordTimeStamp;
	}

	public void setRecordTimeStamp(LocalDateTime recordTimeStamp) {
		this.recordTimeStamp = recordTimeStamp;
	}

	public Integer getCarRecord() {
		return carRecord;
	}

	public void setCarRecord(Integer carRecord) {
		this.carRecord = carRecord;
	}
	
	
}
