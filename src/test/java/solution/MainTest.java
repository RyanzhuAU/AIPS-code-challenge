package solution;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
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
		
		assertEquals(outputData.getTotalCarRecords(), 95);
		
		Map<LocalDate, Integer> dailyRecord = outputData.getDailyTrafficRecord();
		int dailyNum = dailyRecord.get(LocalDate.parse("2021-12-01"));
		assertEquals(dailyNum, 16);

		dailyNum = dailyRecord.get(LocalDate.parse("2021-12-05"));
		assertEquals(dailyNum, 48);
		
		dailyNum = dailyRecord.get(LocalDate.parse("2021-12-08"));
		assertEquals(dailyNum, 27);
		
		dailyNum = dailyRecord.get(LocalDate.parse("2021-12-09"));
		assertEquals(dailyNum, 4);
		
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
