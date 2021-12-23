package subway.controller.menu;

import java.util.Arrays;

import subway.controller.SectionHandler;

public enum SectionMenu {
	INPUT_MANAGE("1", SectionHandler::addSection),
	DELETE_MANAGE("2",SectionHandler::deleteSection),
	BACK_MAIN_VIEW("B",SectionHandler::backMainView);

	private final String command;
	private final Runnable runnable;

	SectionMenu(String command, Runnable runnable) {
		this.command = command;
		this.runnable = runnable;
	}

	public static SectionMenu findByCommand(String inputCommand) {
		return Arrays.stream(SectionMenu.values())
			.filter(sectionMenu -> sectionMenu.command.equals(inputCommand))
			.findFirst()
			.orElseThrow(() -> new IllegalStateException());
	}

	public void run() {
		this.runnable.run();
	}
}
