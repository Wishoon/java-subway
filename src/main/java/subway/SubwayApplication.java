package subway;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import subway.controller.menu.MainMenu;
import subway.domain.line.Line;
import subway.domain.line.LineRepository;
import subway.domain.station.Station;
import subway.domain.station.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;

public class SubwayApplication {
	public void run() {
		init();
		while (true) {
			try {
				OutputView.printMainPageMessage();
				MainMenu.findByCommand(InputView.getInputFunction()).run();
			} catch (IllegalArgumentException e) {
				System.out.println();
				System.out.println(e.getMessage());
				OutputView.printErrorMessage();
			}
		}
	}

	private void init() {
		List<String> stations = Arrays.asList("교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역");
		List<String> lines = Arrays.asList(
			"2호선,교대역,강남역,역삼역",
			"3호선,교대역,남부터미널역,양재역,매봉역",
			"신분당선,강남역,양재역,양재시민의숲역"
		);
		makeStations(stations);
		makeLinesData(lines);
	}

	private static void makeLinesData(List<String> linesAndStations) {
		linesAndStations.stream()
			.map(lineData -> Arrays.asList(lineData.split(",")))
			.forEach(line -> makeLines(line));
	}

	private static void makeLines(List<String> lines) {
		List<Station> stations = new ArrayList<>();
		for (int i = 1; i < lines.size(); i++) {
			stations.add(Station.fromString(lines.get(i)));
		}
		Line line = Line.of(lines.get(0), stations);
		LineRepository.addLine(line);
	}

	private static void makeStations(List<String> stations) {
		stations.stream()
			.map(stationName -> Station.fromString(stationName))
			.forEach(station -> StationRepository.addStation(station));
	}
}
