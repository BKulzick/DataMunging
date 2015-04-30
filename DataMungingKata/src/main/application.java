package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class application {

	public static void main(String[] args) {

		String url = "http://codekata.com/data/04/weather.dat";
		String url2 = "http://codekata.com/data/04/football.dat";

		try {
			application.getDataFileFromURL(url2);
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public static void getDataFileFromURL(String url) throws IOException {

		URL URLtarget = new URL(url);

		InputStreamReader inputStreamReader = new InputStreamReader(
				URLtarget.openStream());

		BufferedReader bReader = new BufferedReader(inputStreamReader);

		String zeroLine = bReader.readLine();

		String firstLine;
		String nextLine;
		StringTokenizer st;

		ArrayList checkThisRow = new ArrayList<Object>();
		ArrayList minimumChangeDay = new ArrayList<Object>();
		int spotsInArray = 0;

		while (spotsInArray < 9) {
			checkThisRow.add(0);
			minimumChangeDay.add(0);
			spotsInArray++;
		}
		minimumChangeDay.set(6, 9999);
		minimumChangeDay.set(7, 0);
		System.out.println(checkThisRow.size());
		

		do {
			nextLine = bReader.readLine();

			if (!nextLine.contains("-----------")) {

				st = new StringTokenizer(nextLine, " *-");

				checkThisRow.set(0, st.nextToken()); // add Team #
				checkThisRow.set(1, st.nextToken()); // add Team Name

				for (int i = 2; i < 9; i++) {
					checkThisRow.set(i, Integer.parseInt(st.nextToken()));
				}
				//System.out.println(checkThisRow);
				if (((Math.abs((int)checkThisRow.get(7)) - (int)checkThisRow.get(6))) < Math.abs(((int)minimumChangeDay.get(7) - (int)minimumChangeDay.get(6)))) {
				for (int i = 0; i < minimumChangeDay.size(); i++) {
				 minimumChangeDay.set(i, checkThisRow.get(i));
				 }

			}
			}
		} while (bReader.ready());

		System.out.println(minimumChangeDay);
	}
}

