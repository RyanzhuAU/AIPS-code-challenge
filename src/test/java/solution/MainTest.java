package solution;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Map;

import org.junit.Test;

import model.OutputData;
import model.TrafficData;

public class MainTest {
	@Test
	public void firstTest() {
		assertTrue(true);
	}
	
	@Test
	public void shouldLoadRecordFile() throws FileNotFoundException {
		ArrayList<TrafficData> trafficDataList = this.loadTrafficTestData();
		
		assertEquals(trafficDataList.size(), 9);
	}
	
	@Test
	public void shouldGetCorrectOutputFromAnalysis() throws FileNotFoundException {
		ArrayList<TrafficData> trafficDataList = this.loadTrafficTestData();

		TrafficDataAnalyzer dataAnalyzer = new TrafficDataAnalyzer(trafficDataList);
		OutputData outputData = dataAnalyzer.analysisTrafficData();
		
		assertEquals(outputData.getTotalCarRecords(), 94);
		
		Map<LocalDate, Integer> dailyRecord = outputData.getDailyTrafficRecord();
		int dailyNum = dailyRecord.get(LocalDate.parse("2021-12-01"));
		assertEquals(dailyNum, 16);

		dailyNum = dailyRecord.get(LocalDate.parse("2021-12-05"));
		assertEquals(dailyNum, 47);
		
		dailyNum = dailyRecord.get(LocalDate.parse("2021-12-08"));
		assertEquals(dailyNum, 27);
		
		dailyNum = dailyRecord.get(LocalDate.parse("2021-12-09"));
		assertEquals(dailyNum, 4);
		
		ArrayList<TrafficData> topThreeTrafficRecord = outputData.getTopThreeTrafficRecord();
		assertEquals(topThreeTrafficRecord.size(), 3);
		
		TrafficData data = topThreeTrafficRecord.get(0);
		assertEquals(data.getRecordTimeStamp(), LocalDateTime.parse("2021-12-05T09:30:00"));
		assertEquals(data.getCarRecord(), 18);
		
		data = topThreeTrafficRecord.get(1);
		assertEquals(data.getRecordTimeStamp(), LocalDateTime.parse("2021-12-08T22:00:00"));
		assertEquals(data.getCarRecord(), 16);
		
		data = topThreeTrafficRecord.get(2);
		assertEquals(data.getRecordTimeStamp(), LocalDateTime.parse("2021-12-05T15:30:00"));
		assertEquals(data.getCarRecord(), 15);
		
	}
	
	private ArrayList<TrafficData> loadTrafficTestData() throws FileNotFoundException {
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("test_data.txt").getFile());
		FileReader fileReader = new FileReader(file);
		
		FileLoader fileLoader = new FileLoader();
		ArrayList<TrafficData> trafficDataList = fileLoader.loadRecordFile(fileReader);
		
		return trafficDataList;
	}
}
