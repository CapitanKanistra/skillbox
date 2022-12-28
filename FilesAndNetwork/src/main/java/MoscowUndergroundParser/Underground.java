package MoscowUndergroundParser;

import java.util.List;
import java.util.Map;

public class Underground {
    Map<String, String[]> stations;
    List<Line> lines;

    public Map<String, String[]> getStations() {
        return stations;
    }

    public void setStations(Map<String, String[]> stations) {
        this.stations = stations;
    }

    public List<Line> getLines() {
        return lines;
    }

    public void setLines(List<Line> lines) {
        this.lines = lines;
    }

    public Underground(Map<String, String[]> stations, List<Line> lines){
        this.stations = stations;
        this.lines = lines;
    }
}