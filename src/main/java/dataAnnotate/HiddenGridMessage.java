package dataAnnotate;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HiddenGridMessage {

	public Map<String, Character> tableData;
	public int coordinateX;
	public int coordinateY;

	public HiddenGridMessage() {
		this.tableData = new HashMap<>();
		this.coordinateX = 0;
		this.coordinateY = 0;
	}

	public static void main(String[] args) throws IOException {
		HiddenGridMessage hgm = new HiddenGridMessage();
		String url = "https://docs.google.com/document/d/e/2PACX-1vSvM5gDlNvt7npYHhp_XfsJvuntUhq184By5xO_pA4b_gCWeXb6dM6ZxwN8rE6S4ghUsCj2VKR21oEP/pub";
		hgm.showHiddenMessage(url);
	}

	public void showHiddenMessage(String url) throws IOException {
		Document soupDoc = Jsoup.connect(url).get();
		Elements rows = soupDoc.select("tr");

		for (Element oneRow : rows) {
			Elements cell = oneRow.select("td");

			if (cell.size() <= 2) {
				continue;
			}

			String cleanX = cell.get(0).text().replace("\u00A0", "").trim();
			String cleanChar = cell.get(1).text().trim();
			String cleanY = cell.get(2).text().replace("\u00A0", "").trim();

			if (!cleanX.matches("\\d+") || !cleanY.matches("\\d+")) {
				continue;
			}

			int saveX = Integer.parseInt(cleanX);
			int saveY = Integer.parseInt(cleanY);

			char coordinateValue = cleanChar.charAt(0);

			tableData.put(saveX + "," + saveY, coordinateValue);

			if (saveX > coordinateX)
				coordinateX = saveX;
			if (saveY > coordinateY)
				coordinateY = saveY;
		}

		for (int y = coordinateY; y >= 0; y--) {
			StringBuilder rowBuild = new StringBuilder();
			for (int x = 0; x <= coordinateX; x++) {
				String XkeyY = x + "," + y;
				rowBuild.append(tableData.getOrDefault(XkeyY, ' '));
			}
			System.out.println(rowBuild.toString());
		}

	}

}
