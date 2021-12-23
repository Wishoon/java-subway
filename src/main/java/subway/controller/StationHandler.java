package subway.controller;

import subway.domain.station.Station;
import subway.domain.station.StationRepository;
import subway.domain.station.StationService;
import subway.view.InputView;
import subway.view.OutputView;

public class StationHandler {

	public static void addStation() {
		String inputStationName = InputView.getAddStationName();
		StationService.add(Station.fromString(inputStationName));
		OutputView.printAddStationMessage();
	}

	public static void deleteStation() {
		String inputStation = InputView.getDeleteStationName();
		StationService.delete(inputStation);
		OutputView.printDeleteStationMessage();
	}

	public static void selectStation() {
		OutputView.printShowStations(StationRepository.stations());
	}

	public static void backMainView() {
		return;
	}
}
