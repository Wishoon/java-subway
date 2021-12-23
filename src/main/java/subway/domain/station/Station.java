package subway.domain.station;

import java.util.Objects;

public class Station {
    private String name;

    public Station(String name) {
        this.name = name;
    }

    public static Station fromString(String name) {
        return new Station(name);
    }

    public boolean isEqualTo(Station station) {
        return Objects.equals(this.name, station.name);
    }

    public boolean isEqualTo(String name) {
        return Objects.equals(this.name, name);
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
    public boolean hasName() {
        return name == null;
    }
}
