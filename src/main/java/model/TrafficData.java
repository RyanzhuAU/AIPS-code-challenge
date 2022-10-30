package model;

import java.util.Date;

public class TrafficData {
	private Date recordTimeStamp;
	
	private Integer carRecord;
	
	public TrafficData(Date recordTimeStamp, Integer carRecord) {
		this.recordTimeStamp = recordTimeStamp;
		this.carRecord = carRecord;
	}

	public Date getRecordTimeStamp() {
		return recordTimeStamp;
	}

	public void setRecordTimeStamp(Date recordTimeStamp) {
		this.recordTimeStamp = recordTimeStamp;
	}

	public Integer getCarRecord() {
		return carRecord;
	}

	public void setCarRecord(Integer carRecord) {
		this.carRecord = carRecord;
	}
	
	
}
