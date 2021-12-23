package subway.dto;

import java.util.List;

import subway.domain.line.Line;
import subway.domain.station.Station;

public class LinesStationsDto {

	private String linesStations;

	public static void test(List<Line> lines) {
		StringBuilder sb = new StringBuilder();
		for (Line line : lines) {
			sb.append(line.getName()).append("\n");
			sb.append("---").append("\n");
			sb.append(makeStation(line.getStations())).append("\n");
		}
	}

	private static String makeStation(List<Station> lines) {
		StringBuilder sb = new StringBuilder();
		for (Station line : lines) {
			sb.append(line.getName()).append("\n");
		}

		return sb.toString();
	}
}
