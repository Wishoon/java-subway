package subway.controller.menu;

import java.util.Arrays;

import subway.controller.StationHandler;

public enum StationMenu {
	INPUT_MANAGE("1", StationHandler::addStation),
	DELETE_MANAGE("2", StationHandler::deleteStation),
	SELECT_MANAGE("3", StationHandler::selectStation),
	BACK_MAIN_VIEW("B", StationHandler::backMainView);

	private final String command;
	private Runnable runnable;

	StationMenu(String command, Runnable runnable) {
		this.command = command;
		this.runnable = runnable;
	}

	public static StationMenu findByCommand(String command) {
		return Arrays.stream(StationMenu.values())
			.filter(stationMenu -> stationMenu.command.equals(command))
			.findFirst()
			.orElseThrow(() -> new IllegalStateException());
	}

	public void run() {
		this.runnable.run();
	}
}
