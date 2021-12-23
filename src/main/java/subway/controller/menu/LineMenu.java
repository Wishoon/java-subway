package subway.controller.menu;

import java.util.Arrays;

import subway.controller.LineHandler;

public enum LineMenu {
	INPUT_MANAGE("1", LineHandler::addLine),
	DELETE_MANAGE("2", LineHandler::deleteLine),
	SELECT_MANAGE("3", LineHandler::selectLine),
	BACK_MAIN_VIEW("B", LineHandler::backMain);

	private final String command;
	private Runnable runnable;

	LineMenu(String command, Runnable runnable) {
		this.command = command;
		this.runnable = runnable;
	}

	public static LineMenu findByCommand(String command) {
		return Arrays.stream(LineMenu.values())
			.filter(lineMenu -> lineMenu.command.equals(command))
			.findFirst()
			.orElseThrow(() -> new IllegalStateException(""));
	}

	public void run() {
		this.runnable.run();
	}
}
