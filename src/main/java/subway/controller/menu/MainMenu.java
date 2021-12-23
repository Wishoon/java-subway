package subway.controller.menu;

import java.util.Arrays;

import subway.controller.MainHandler;

public enum MainMenu {
	STATION_MANAGE("1", MainHandler::stationManage),
	LINE_MANAGE("2", MainHandler::lineManage),
	SECTION_MANAGE("3", MainHandler::sectionManage),
	LINE_SHOW_MANAGE("4", MainHandler::lineShowManage),
	PROGRAM_EXIT("Q", MainHandler::programExit);

	private final String command;
	private final Runnable runnable;

	MainMenu(String command, Runnable runnable) {
		this.command = command;
		this.runnable = runnable;
	}

	public static MainMenu findByCommand(String command) {
		return Arrays.stream(MainMenu.values())
			.filter(mainMenu -> mainMenu.command.equals(command))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException());
	}

	public void run() {
		this.runnable.run();
	}
}
