package subway.dto;

import java.util.List;
import java.util.stream.Collectors;

import subway.domain.line.Line;

public class LinesDto {
	private List<String> linesName;

	public LinesDto(List<String> linesName) {
		this.linesName = linesName;
	}

	public static LinesDto fromList(List<Line> lines) {
		List<String> linesName = lines.stream()
			.map(line -> line.getName())
			.collect(Collectors.toList());

		return new LinesDto(linesName);
	}

	public List<String> getLinesName() {
		return linesName;
	}
}
