package solution;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

import org.junit.Test;

import model.TrafficData;

public class MainTest {
	@Test
	public void firstTest() {
		assertTrue(true);
	}
	
	@Test
	public void shouldLoadRecordFile() throws FileNotFoundException {
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("test_data.txt").getFile());
		FileReader fileReader = new FileReader(file);
		
		FileLoader fileLoader = new FileLoader();
		ArrayList<TrafficData> trafficDataList = fileLoader.loadRecordFile(fileReader);
		
		assertEquals(trafficDataList.size(), 24);
	}
}
