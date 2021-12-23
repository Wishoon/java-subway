package subway.controller;

import java.util.List;

import subway.controller.menu.LineMenu;
import subway.controller.menu.SectionMenu;
import subway.controller.menu.StationMenu;
import subway.domain.line.Line;
import subway.domain.line.LineRepository;
import subway.view.InputView;
import subway.view.OutputView;

public class MainHandler {

	public static void stationManage() {
		OutputView.printStationPageMessage();
		String inputCommand = InputView.getInputFunction();
		StationMenu.findByCommand(inputCommand).run();
	}

	public static void lineManage() {
		OutputView.printLinePageMessage();
		String inputCommand = InputView.getInputFunction();
		LineMenu.findByCommand(inputCommand).run();
	}

	public static void sectionManage() {
		OutputView.printSectionPageMessage();
		String inputCommand = InputView.getInputFunction();
		SectionMenu.findByCommand(inputCommand).run();
	}

	public static void lineShowManage() {
		List<Line> lines = LineRepository.lines();
		OutputView.printShowSubwayLines(lines);
	}

	public static void programExit() {
		System.exit(0);
	}
}
