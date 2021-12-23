package subway.domain.section;
import subway.domain.line.Line;
import subway.domain.line.LineRepository;
import subway.domain.station.Station;
import subway.domain.station.StationRepository;
import subway.dto.SectionDto.SectionAddDto;
import subway.dto.SectionDto.SectionDeleteDto;

public class SectionService {
	public static void add(SectionAddDto sectionAddDto) {
		Station station = getStation(sectionAddDto.getStationName());
		Line line = getLine(sectionAddDto.getLineName());
		line.addStation(sectionAddDto.getSequenceStation() - 1, station);
	}

	public static void delete(SectionDeleteDto sectionDeleteDto) {
		Station station = getStation(sectionDeleteDto.getStationName());
		Line line = getLine(sectionDeleteDto.getLineName());
		line.deleteStation(station);
	}

	private static Station getStation(String stationName) {
		return StationRepository.stations().stream()
			.filter(registerStation -> registerStation.getName().equals(stationName))
			.findAny()
			.orElseThrow(() -> new IllegalArgumentException("[ERROR] 존재하지 않는 역입니다."));
	}

	private static Line getLine(String lineName) {
		return LineRepository.lines().stream()
			.filter(registerLine -> registerLine.getName().equals(lineName))
			.findAny()
			.orElseThrow(() -> new IllegalArgumentException("[ERROR] 존재하지 않는 노선 입니다."));
	}
}