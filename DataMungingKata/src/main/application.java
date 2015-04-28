package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.StringTokenizer;

public class application {

	public static void main(String[] args) {

		try {
			application.getDataFileFromURL();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public static void getDataFileFromURL() throws IOException {

		URL URLtarget = new URL("http://codekata.com/data/04/weather.dat");

		InputStreamReader inputStreamReader = new InputStreamReader(
				URLtarget.openStream());

		BufferedReader bReader = new BufferedReader(inputStreamReader);

		String tempString = bReader.readLine();

		String zeroLine = bReader.readLine();
		String firstLine;
		StringTokenizer st;

		int[] checkThisDay = new int[3];
		int[] minimumChangeDay = { 0, 100, 0 };
		
		do {
			firstLine = bReader.readLine();

			if (firstLine.contains("mo"))
				break;

			st = new StringTokenizer(firstLine, " *");
			for (int i = 0; i < 3; i++) {
				checkThisDay[i] = Integer.parseInt(st.nextToken());
			}

			if ((checkThisDay[1] - checkThisDay[2]) < (minimumChangeDay[1] - minimumChangeDay[2])) {
				for (int i = 0; i < minimumChangeDay.length; i++) {
					minimumChangeDay[i] = checkThisDay[i];
				}

				
			}

		} while (bReader.ready());

		System.out.println(Arrays.toString(minimumChangeDay));
	}
}
