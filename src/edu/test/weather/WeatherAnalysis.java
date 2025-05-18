package edu.test.weather;

public class WeatherAnalysis {
	public static void main(String[] args) {

		String[] dates = { "01.05.2025", "02.05.2025", "03.05.2025", "04.05.2025", "05.05.2025", "06.05.2025",
				"07.05.2025" };
		int[] morningTemps = { 7, 9, 13, 10, 7, 7, 6 };
		int[] dayTemps = { 11, 16, 18, 15, 8, 12, 9 };
		int[] eveningTemps = { 7, 13, 14, 9, 5, 8, 5 };

		double[] averageTemps = calculateAverageTemps(morningTemps, dayTemps, eveningTemps);

		int[] longestPeriod = findLongestIncreasingPeriod(averageTemps);

		printResult(dates, longestPeriod);
	}

	private static double[] calculateAverageTemps(int[] morning, int[] day, int[] evening) {
		double[] averages = new double[morning.length];
		for (int i = 0; i < morning.length; i++) {
			averages[i] = (morning[i] + day[i] + evening[i]) / 3.0;
		}
		return averages;
	}

	private static int[] findLongestIncreasingPeriod(double[] averages) {
		int maxLength = 1;
		int maxStart = 0;
		int maxEnd = 0;

		int currentLength = 1;
		int currentStart = 0;

		for (int i = 1; i < averages.length; i++) {
			if (averages[i] > averages[i - 1]) {
				currentLength++;
			} else {
				currentStart = i;
				currentLength = 1;
			}

			if (currentLength > maxLength) {
				maxLength = currentLength;
				maxStart = currentStart;
				maxEnd = i;
			}
		}

		return new int[] { maxStart, maxEnd };
	}

	private static void printResult(String[] dates, int[] period) {
		int start = period[0];
		int end = period[1];
		int length = end - start + 1;

		System.out.println("Самый длинный период повышения температуры: " + length + " дня");
		System.out.println("(с " + dates[start] + " по " + dates[end] + ")");
	}
}