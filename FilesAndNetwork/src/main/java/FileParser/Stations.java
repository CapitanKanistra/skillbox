package FileParser;

import java.util.List;

public class Stations {
    List<Station> stations;

    public List<Station> getStations() {
        return stations;
    }

    public void setStations(List<Station> stations) {
        this.stations = stations;
    }

    public Stations(List<Station> stations) {
        this.stations = stations;
    }
}