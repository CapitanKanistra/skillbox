import FileParser.FileParser;
import FileParser.Stations;
import MoscowUndergroundParser.ParseMoscowUnderground;
import MoscowUndergroundParser.Underground;
import SearchFiles.SearchFileInFolders;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        String path = "D:/data/";

        String[] JSONPath = {"D:/data/2/4/depths-1.json", "D:/data/4/6/depths-3.json", "D:/data/7/1/depths-2.json"};
        String[] CSVPath = {"D:/data/0/5/dates-2.csv", "D:/data/4/6/dates-1.csv", "D:/data/9/6/dates-3.csv"};

        try {
            SearchFileInFolders searchFileInFolders = new SearchFileInFolders(path);

            ParseMoscowUnderground parseMoscowUnderground = new ParseMoscowUnderground();
            FileParser fileParser = new FileParser();

            ObjectMapper objectMapper = new ObjectMapper();
            ObjectWriter writer = objectMapper.writer(new DefaultPrettyPrinter());
            writer.writeValue(new File("D:/DataCollector/map.json"), new Underground(parseMoscowUnderground.parseStations(), parseMoscowUnderground.parseLine()));
            writer.writeValue(new File("D:/DataCollector/stations.json"), new Stations(fileParser.parser(JSONPath, CSVPath)));
        } catch (Exception ex) {
            System.out.println("Что-то пошло не так...\n" + ex.getMessage());
            ex.printStackTrace();

        }
    }
}