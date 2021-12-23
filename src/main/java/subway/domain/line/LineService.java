package subway.domain.line;

import subway.domain.station.Station;
import subway.domain.station.StationRepository;

public class LineService {

	public static void add(Line line) {
		isValidateDuplicateLine(line);
		isValidateExistStations(line);
		LineRepository.addLine(line);
	}

	private static void isValidateDuplicateLine(Line line) {
		boolean isDuplicated = LineRepository.lines().stream()
			.anyMatch(registerLine -> registerLine.isEqualTo(line));

		if (isDuplicated) {
			throw new IllegalArgumentException("");
		}
	}

	private static void isValidateExistStations(Line line) {
		line.getStations().stream()
			.forEach(station -> isValidateExistStation(station));
	}

	public static void isValidateExistStation(Station station) {
		StationRepository.stations().stream()
			.filter(registerStation -> registerStation.isEqualTo(station))
			.findAny()
			.orElseThrow(() -> new IllegalStateException());
	}

	public static void delete(String lineName) {
		isValidateExistLine(lineName);
		LineRepository.deleteLineByName(lineName);
	}

	public static void isValidateExistLine(String lineName) {
		LineRepository.lines().stream()
			.filter(line -> line.isEqualTo(lineName))
			.findAny()
			.orElseThrow(() -> new IllegalStateException(""));
	}
}
