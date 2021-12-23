package subway.domain.line;

import java.util.List;
import java.util.Objects;

import subway.domain.station.Station;

public class Line {
	private String name;
	private List<Station> stations;

	private Line(String name) {
		this.name = name;
	}

	private Line(String name, List<Station> stations) {
		this.name = name;
		this.stations = stations;
	}

	public static Line fromString(String name) {
		return new Line(name);
	}

	public static Line of(String lineName, List<Station> stations) {
		return new Line(lineName, stations);
	}

	public void addStation(int value, Station station) {
		stations.add(value, station);
	}

	public void deleteStation(Station station) {
		isValidateStationsSize();
		stations.removeIf(registerStation -> registerStation.isEqualTo(station));
	}

	private void isValidateStationsSize() {
		if (stations.size() <= 2) {
			throw new IllegalArgumentException("[ERROR] 노선에 등록된 역이 2개이므로 더 이상 제거 할 수 없습니다.");
		}
	}

	public Station isValidateExistStations(String stationName) {
		return stations.stream()
			.filter(station -> station.isEqualTo(stationName))
			.findAny()
			.orElseThrow(() -> new IllegalStateException("[ERROR] 라인에 역을 먼저 제거해주세요."));
	}

	public boolean isEqualTo(Line line) {
		return Objects.equals(this.name, line.name);
	}

	public boolean isEqualTo(String name) {
		return Objects.equals(this.name, name);
	}

	public String getName() {
		return name;
	}

	public List<Station> getStations() {
		return stations;
	}
}
