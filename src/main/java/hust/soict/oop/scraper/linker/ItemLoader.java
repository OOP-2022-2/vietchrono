package hust.soict.oop.scraper.linker;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ItemLoader<T> {

	private List<T> items = new ArrayList<>();

	public ItemLoader(String dataFilePath, Class<T[]> type) {
		loadItems(dataFilePath, type);
	}

	public void loadItems(String dataFilePath, Class<T[]> type) {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			items = Arrays.asList(objectMapper.readValue(Paths.get(dataFilePath).toFile(), type));
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<T> getItems() {
		return items;
	}
}
