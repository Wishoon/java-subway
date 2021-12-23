package subway.dto;

import java.util.List;
import java.util.stream.Collectors;

import subway.domain.station.Station;

public class StationsDto {
	private List<String> stationsName;

	public StationsDto(List<String> stationsName) {
		this.stationsName = stationsName;
	}

	public static StationsDto fromList(List<Station> stations) {
		List<String> stationsName = stations.stream()
			.map(station -> station.getName())
			.collect(Collectors.toList());

		return new StationsDto(stationsName);
	}

	public List<String> getStationsName() {
		return stationsName;
	}
}
