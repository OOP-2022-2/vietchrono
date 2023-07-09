package hust.soict.oop.scraper.dynasty;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DynastyDataCollector {
	public static void main(String[] args) {

		try {
			String url = "https://vi.wikipedia.org/wiki/C%C3%A1c_cu%E1%BB%99c_chi%E1%BA%BFn_tranh_Vi%E1%BB%87t_Nam_tham_gia";
			String filePath = "src/main/java/hust/soict/oop/scraper/dynasty/data/dynasties.json";
			// Tải nội dung HTML từ trang web
			Document doc = Jsoup.connect(url).get();

			// Lấy tất cả các bảng từ trang web
			Elements tables = doc.select("table");

			// Kiểm tra nếu có bảng trong trang web
			if (!tables.isEmpty()) {
				// Tạo danh sách chứa dữ liệu của tất cả các bảng
//                List<List<Dynasty>> allTableData = new ArrayList<>();
				List<Dynasty> tableData = new ArrayList<>();

				// Lặp qua từng bảng
				for (Element table : tables) {
					// Tạo danh sách chứa dữ liệu của bảng hiện tại

					// Lấy các hàng trong bảng
					Elements rows = table.select("tr");

					// Duyệt qua từng hàng và lấy dữ liệu
					for (Element row : rows) {
						Elements cells = row.select("td");
						if (cells.size() == 4) {
							String xungDot = cells.get(0).text();
							String thoiKy = cells.get(1).text();
							String doiPhuong = cells.get(2).text();
							String ketQua = cells.get(3).text();

							Dynasty rowData = new Dynasty(xungDot, thoiKy, doiPhuong, ketQua);
							tableData.add(rowData);
						}
					}

					// Thêm dữ liệu của bảng hiện tại vào danh sách chung
//                    allTableData.add(tableData);
				}

				// Khởi tạo đối tượng Gson
				Gson gson = new GsonBuilder().setPrettyPrinting().create();

				// Chuyển đổi danh sách đối tượng thành chuỗi JSON
				String json = gson.toJson(tableData);

				// Ghi chuỗi JSON vào tệp
				FileWriter writer = new FileWriter(filePath);
				writer.write(json);
				writer.close();

				System.out.println("Dữ liệu đã được ghi vào tệp dynasties.json.");
			} else {
				System.out.println("Không tìm thấy bảng trên trang web.");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}