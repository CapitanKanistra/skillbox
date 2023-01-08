package FileParser;

import MoscowUndergroundParser.ParseMoscowUnderground;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileParser {

    public List<Station> parser(String[] pathJSON, String[] pathCSV) throws IOException {

        List<Station> stationsInfo = new ArrayList<>();
        List<String> lines;
        Map<String, String> stationInfo = new HashMap<>();
        Station station = new Station();
        ParseMoscowUnderground parser = new ParseMoscowUnderground();

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonFile = Files.readString(Paths.get("D:/DataCollector/map.json"));
        JsonNode jsonData = objectMapper.readTree(jsonFile);
        JsonNode stationNmae = jsonData.get("stations");
        JsonNode lineName = jsonData.get("lines");

        for (int i = 0; i < (pathJSON.length + pathCSV.length) / 2; i++) {
            String jsonText = Files.readString(Paths.get(pathJSON[i]));
            JSONFile[] jsonFiles = objectMapper.readValue(jsonText, JSONFile[].class);

            lines = Files.readAllLines(Paths.get(pathCSV[i]));

            String firstLine = null;
            for (String line : lines) {
                if (firstLine == null) {
                    firstLine = line;
                    continue;
                }

                String[] nameAndDate = line.split(",");
                String nameStation = nameAndDate[0];
                String dateStation = nameAndDate[1];

                stationInfo.put(nameStation, dateStation);
            }

            for (JSONFile file : jsonFiles) {
                for (String name : stationInfo.keySet()) {
                    String date = stationInfo.get(name);
                    if (file.getStation_name().equalsIgnoreCase(name)) {
                        file.setStation_name(name);
                        station.setDate(date);
                    }

                    if (station.getDate() == null) {
                        station.setDate("it's unknown");
                    }

                    if (file.getDepth().equalsIgnoreCase("?")) {
                        file.setDepth("0");
                    }
                }

                for (JsonNode line : lineName) {
                    String lineNumber = line.get("number").asText();
                    String lineNames = line.get("line").asText();
                    JsonNode stationList = stationNmae.get(lineNumber);

                    for (JsonNode stationName : stationList) {
                        if (file.getStation_name().equalsIgnoreCase(stationName.asText().replaceAll("\"+", "").trim())) {
                            station.setLine(lineNames);
                        }
                    }

                }

                stationsInfo.add(new Station(file.getStation_name(), station.getLine(), station.getDate(), file.getDepth(), parser.hasConnections(file.getStation_name())));

            }
        }
        return stationsInfo;
    }
}