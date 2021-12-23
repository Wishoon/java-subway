package subway.view;

import java.util.Scanner;

public class InputView {
	public static String getInputFunction() {
		System.out.println();
		System.out.println("## 원하는 기능을 선택하세요.");
		return new Scanner(System.in).nextLine();
	}

	public static String getAddStationName() {
		System.out.println();
		System.out.println("## 등록할 역 이름을 선택하세요");
		return new Scanner(System.in).nextLine();
	}

	public static String getDeleteStationName() {
		System.out.println();
		System.out.println("## 삭제할 역 이름을 선택하세요");
		return new Scanner(System.in).nextLine();
	}

	public static String getAddLineName() {
		System.out.println();
		System.out.println("## 등록할 노선 이름을 입력하세요.");
		return new Scanner(System.in).nextLine();
	}

	public static String getAddLineUpBoundStation() {
		System.out.println();
		System.out.println("## 등록할 노선의 상행 종점역 이름을 입력하세요.");
		return new Scanner(System.in).nextLine();
	}

	public static String getAddLineDownBoundStation() {
		System.out.println();
		System.out.println("## 등록할 노선의 하행 종점역 이름을 입력하세요.");
		return new Scanner(System.in).nextLine();
	}

	public static String getDeleteLineName() {
		System.out.println();
		System.out.println("## 삭제할 노선 이름을 입력하세요.");
		return new Scanner(System.in).nextLine();
	}

	public static String getAddSectionLineName() {
		System.out.println();
		System.out.println("## 노선을 입력하세요.");
		return new Scanner(System.in).nextLine();
	}

	public static String getAddSectionStationName() {
		System.out.println();
		System.out.println("## 역이름을 입력하세요.");
		return new Scanner(System.in).nextLine();
	}

	public static String getAddSectionSequence() {
		System.out.println();
		System.out.println("## 순서를 입력하세요");
		return new Scanner(System.in).nextLine();
	}

	public static String getDeleteSectionLineName() {
		System.out.println();
		System.out.println("## 삭제할 구간의 노선을 입력하세요.");
		return new Scanner(System.in).nextLine();
	}

	public static String getDeleteSectionStationName() {
		System.out.println();
		System.out.println("## 삭제할 구간의 이름을 입력하세요.");
		return new Scanner(System.in).nextLine();
	}
}
