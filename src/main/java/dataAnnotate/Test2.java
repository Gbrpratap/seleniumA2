package dataAnnotate;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Test2 {

    public Map<String, Character> gridData;
    public int coordinateX;
    public int coordinateY;

    public Test2() {
        this.gridData = new HashMap<>();
        this.coordinateX = 0;
        this.coordinateY = 0;
    }

    public static void main(String[] args) throws IOException {
        Test2 hgm = new Test2();
        String url = "https://docs.google.com/document/d/e/2PACX-1vTMOmshQe8YvaRXi6gEPKKlsC6UpFJSMAk4mQjLm_u1gmHdVVTaeh7nBNFBRlui0sTZ-snGwZM4DBCT/pub";
        hgm.showHiddenMessage(url);
    }

    public void showHiddenMessage(String url) throws IOException {
            Document doc = Jsoup.connect(url).get();
            Elements rows = doc.select("tr");

            for (Element row : rows) {
                Elements cells = row.select("td");

                if (cells.size() <= 2) {
                    continue;
                }

                String xStr = cells.get(0).text().replace("\u00A0", "").trim();
                String charStr = cells.get(1).text().trim();
                String yStr = cells.get(2).text().replace("\u00A0", "").trim();

                if (!xStr.matches("\\d+") || !yStr.matches("\\d+")) {
                    continue;
                }

                int x = Integer.parseInt(xStr);
                int y = Integer.parseInt(yStr);

                char ch = charStr.charAt(0);

                gridData.put(x + "," + y, ch);
                if (x > coordinateX) coordinateX = x;
                if (y > coordinateY) coordinateY = y;
            }

            for (int y = coordinateY; y >= 0; y--) {
                StringBuilder rowString = new StringBuilder();
                for (int x = 0; x <= coordinateX; x++) {
                    String key = x + "," + y;
                    rowString.append(gridData.getOrDefault(key, ' '));
                }
                System.out.println(rowString.toString());
            }
    }
}
