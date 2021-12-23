package subway.controller;

import static subway.dto.SectionDto.SectionDeleteDto.*;

import subway.domain.section.SectionService;
import subway.dto.SectionDto.SectionAddDto;
import subway.dto.SectionDto.SectionDeleteDto;
import subway.view.InputView;
import subway.view.OutputView;

public class SectionHandler {

	public static void addSection() {
		SectionAddDto sectionAddDto = SectionAddDto.of(
			InputView.getAddSectionLineName(),
			InputView.getAddSectionStationName(),
			InputView.getAddSectionSequence()
		);
		SectionService.add(sectionAddDto);
		OutputView.printAddSectionMessage();
	}

	public static void deleteSection() {
		SectionDeleteDto sectionDeleteDto = of(
			InputView.getDeleteSectionLineName(),
			InputView.getDeleteSectionStationName()
		);
		SectionService.delete(sectionDeleteDto);
		OutputView.printDeleteSectionMessage();
	}

	public static void backMainView() {
		return;
	}
}
