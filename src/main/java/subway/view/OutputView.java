package subway.view;

import java.util.List;

import subway.domain.line.Line;
import subway.domain.station.Station;

public class OutputView {
	public static final String INFO = "[INFO] ";

	public static void printMainPageMessage() {
		System.out.println();
		System.out.println(""
			+ "## 메인 화면\n"
			+ "1. 역 관리\n"
			+ "2. 노선 관리\n"
			+ "3. 구간 관리\n"
			+ "4. 지하철 노선도 출력\n"
			+ "Q. 종료");
	}

	public static void printStationPageMessage() {
		System.out.println();
		System.out.println(""
			+ "## 역 관리 화면\n"
			+ "1. 역 등록\n"
			+ "2. 역 삭제\n"
			+ "3. 역 조회\n"
			+ "B. 돌아가기");
	}

	public static void printLinePageMessage() {
		System.out.println();
		System.out.println(""
			+ "## 노선 관리 화면\n"
			+ "1. 노선 등록\n"
			+ "2. 노선 삭제\n"
			+ "3. 노선 조회\n"
			+ "B. 돌아가기");
	}

	public static void printSectionPageMessage() {
		System.out.println();
		System.out.println(""
			+ "## 구간 관리 화면\n"
			+ "1. 구간 등록\n"
			+ "2. 구간 삭제\n"
			+ "B. 돌아가기");
	}

	public static void printAddLineMessage() {
		System.out.println();
		System.out.println(INFO + "지하철 노선이 등록되었습니다.");
	}

	public static void printDeleteLineMessage() {
		System.out.println();
		System.out.println(INFO + "지하철 노선이 삭제되었습니다.");
	}

	public static void printShowLines(List<Line> lines) {
		System.out.println();
		System.out.println("## 노선 목록");
		for (Line line : lines) {
			System.out.println(INFO + " " + line.getName());
		}
	}

	public static void printShowStations(List<Station> stations) {
		System.out.println();
		System.out.println("## 역 목록");
		for (Station station : stations) {
			System.out.println(INFO + station.getName());
		}
	}

	public static void printShowSubwayLines(List<Line> lines) {
		lines.forEach(
			line -> printShowLineAndStations(line)
		);
	}

	private static void printShowLineAndStations(Line line) {
		System.out.println();
		System.out.println(INFO + line.getName());
		System.out.println(INFO + "---");
		for (Station station : line.getStations()) {
			System.out.println(INFO + station.getName());
		}
	}

	public static void printAddSectionMessage() {
		System.out.println();
		System.out.println(INFO + "구간이 등록되었습니다.");
	}

	public static void printDeleteSectionMessage() {
		System.out.println();
		System.out.println(INFO + "구간이 삭제되었습니다.");
	}

	public static void printAddStationMessage() {
		System.out.println();
		System.out.println(INFO + "지하철 역이 등록되었습니다.");
	}

	public static void printDeleteStationMessage() {
		System.out.println();
		System.out.println(INFO + "지하철 역이 삭제되었습니다.");
	}

	public static void printErrorMessage() {

	}
}
