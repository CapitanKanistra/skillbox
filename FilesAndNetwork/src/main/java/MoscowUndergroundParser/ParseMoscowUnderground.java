package MoscowUndergroundParser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.*;

public class ParseMoscowUnderground {
    private final String url = "https://skillbox-java.github.io";;
    private static final String idBrowser = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/106.0.0.0 Safari/537.36 OPR/92.0.0.0";
    private final Document document = Jsoup.connect(url).userAgent(idBrowser).referrer("http://www.google.com").get();

    public ParseMoscowUnderground() throws IOException {
    }

    public Map<String, String[]> parseStations() {
        Elements stationsUnderground = document.select("div.js-metro-stations.t-metrostation-list-table");

        Map<String, String[]> allStations = new HashMap<>();
        String[] stations;

        for (Element e : stationsUnderground) {
            stations = e.text().substring(3).split("(\\s[0-9]+.\\s+)");
            allStations.put(e.attr("data-line"), stations);
        }

        return allStations;
    }

    public List<Line> parseLine() {
        Elements linesUnderground = document.select("span.js-metro-line.t-metrostation-list-header.t-icon-metroln");

        List<Line> lineAndNum = new ArrayList<>();

        for (Element e : linesUnderground)
            lineAndNum.add(new Line(e.attr("data-line"), e.text().replaceAll("[А-я]+$", "")));


        return lineAndNum;
    }

    public boolean hasConnections(String nameStation){
        Elements stationsUnderground = document.select("div.js-metro-stations.t-metrostation-list-table");
        Elements connections = stationsUnderground.select("p.single-station");

        for (Element e : connections) {
            if (!e.select("span.t-icon-metroln").attr("title").isEmpty() && e.select("span.name").text().equalsIgnoreCase(nameStation)){
                return true;
            }
        }
        return false;
    }
}