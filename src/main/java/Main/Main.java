package Main;

import TravelAgency.*;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		TravelAgency travelAgency = new TravelAgency();
		travelAgency.userMenu();
	}

	public static int enterIntValue(String hint, int min, int max) {
		Scanner in = new Scanner(System.in);

		while (true) {
			System.out.print(hint);

			if (in.hasNextInt()) {
				int value = in.nextInt();
				in.nextLine();

				if (value >= min && value <= max) {
					return value;
				}
			} else {
				in.nextLine();
			}
		}
	}

	public static String enterStringValue(String hint) {
		Scanner in = new Scanner(System.in);
		System.out.print(hint);

		return in.nextLine();
	}

}
