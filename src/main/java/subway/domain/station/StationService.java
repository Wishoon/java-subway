package subway.domain.station;

import java.util.List;

import subway.domain.line.Line;
import subway.domain.line.LineRepository;

public class StationService {

	public static void add(Station station) {
		isValidateDuplicateStation(station);
		StationRepository.addStation(station);
	}

	private static void isValidateDuplicateStation(Station station) {
		boolean isDuplicated = StationRepository.stations().stream()
			.anyMatch(registerStation -> registerStation.isEqualTo(station));

		if (isDuplicated) {
			throw new IllegalArgumentException("[ERROR] 이미 등록된 라인 입니다.");
		}
	}

	public static void delete(String stationName) {
		isValidateSameStation(stationName);
		isValidateExistLine(stationName);
		StationRepository.deleteStation(stationName);
	}

	private static void isValidateSameStation(String stationName) {
		StationRepository.stations().stream()
			.filter(station -> station.isEqualTo(stationName))
			.findAny()
			.orElseThrow(() -> new IllegalArgumentException("[ERROR] 등록된 라인이 없습니다."));
	}

	private static void isValidateExistLine(String stationName) {
		List<Line> lines = LineRepository.lines();
		lines.forEach(line -> line.isValidateExistStations(stationName));
	}
}
