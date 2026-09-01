package dataAnnotate;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DataAnnotate {

    public static void main(String[] args) throws IOException {
        String url = "https://docs.google.com/document/d/e/2PACX-1vTMOmshQe8YvaRXi6gEPKKlsC6UpFJSMAk4mQjLm_u1gmHdVVTaeh7nBNFBRlui0sTZ-snGwZM4DBCT/pub";
        printGridFromUrl(url);
    }

    public static void printGridFromUrl(String urlString) throws IOException {
        Document doc = Jsoup.connect(urlString).get();

        Elements rows = doc.select("tr");

        Map<String, Character> gridData = new HashMap<>();
        int coordinateX = 0;
        int coordinateY = 0;

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
