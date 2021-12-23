package subway.controller;

import java.util.Arrays;
import java.util.List;

import subway.domain.line.Line;
import subway.domain.line.LineRepository;
import subway.domain.line.LineService;
import subway.domain.station.Station;
import subway.dto.LinesDto;
import subway.view.InputView;
import subway.view.OutputView;

public class LineHandler {

	public static void addLine() {
		String inputLineName = InputView.getAddLineName();
		List<Station> stations = Arrays.asList(
			Station.fromString(InputView.getAddLineUpBoundStation()),
			Station.fromString(InputView.getAddLineDownBoundStation())
		);

		LineService.add(Line.of(inputLineName, stations));
		OutputView.printAddLineMessage();
	}

	public static void deleteLine() {
		String lineName = InputView.getDeleteLineName();
		LineService.delete(lineName);
		OutputView.printDeleteLineMessage();
	}

	public static void selectLine() {
		OutputView.printShowLines(LineRepository.lines());
	}

	public static void backMain() {
		return;
	}
}
