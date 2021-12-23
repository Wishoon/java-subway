package subway.dto;

public class SectionDto {

	public static class SectionAddDto {
		private final String lineName;
		private final String stationName;
		private final int sequenceStation;

		public SectionAddDto(String lineName, String stationName, int sequenceStation) {
			this.lineName = lineName;
			this.stationName = stationName;
			this.sequenceStation = sequenceStation;
		}

		public SectionAddDto(String lineName, String stationName, String sequenceStation) {
			this(lineName, stationName, Integer.parseInt(sequenceStation));
		}

		public static SectionAddDto of(String lineName, String stationName, String sequenceStation) {
			return new SectionAddDto(lineName, stationName, sequenceStation);
		}

		public String getLineName() {
			return lineName;
		}

		public String getStationName() {
			return stationName;
		}

		public int getSequenceStation() {
			return sequenceStation;
		}
	}

	public static class SectionDeleteDto {
		private final String lineName;
		private final String stationName;

		public SectionDeleteDto(String lineName, String stationName) {
			this.lineName = lineName;
			this.stationName = stationName;
		}

		public static SectionDeleteDto of(String lineName, String stationName) {
			return new SectionDeleteDto(lineName, stationName);
		}

		public String getLineName() {
			return lineName;
		}

		public String getStationName() {
			return stationName;
		}
	}
}
