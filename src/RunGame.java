import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import models.Bomber;
import models.Fighter;
import models.Helicopter;
import models.Map;
import base_models.BasePlane;

public class RunGame {

	private static Scanner scanner;
	private static Scanner in;

	public static void main(String[] args) {
		in = new Scanner(System.in);
		List<BasePlane> listPlanes = new ArrayList<BasePlane>();
		StringBuilder logData;
		String mapFileName = "";
		String logFileName = "";
		int rows = 0;
		int cols = 0;

		if (args.length == 1) {
			mapFileName = args[0];
			logFileName = args[0] + ".log";
		} else if (args.length == 2) {
			mapFileName = args[0];
			logFileName = args[1];
		}

		try {
			scanner = new Scanner(new File("four_h_outside.map"));
			rows = scanner.nextInt();
			cols = scanner.nextInt();
			scanner.nextLine();
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String[] planeData = line.split(" ");
				String type = planeData[0];
				int headX = Integer.valueOf(planeData[1]);
				int headY = Integer.valueOf(planeData[2]);
				String direction = planeData[3];
				if (type.equalsIgnoreCase("H")) {
					Helicopter he = new Helicopter("", headX, headY, direction);
					listPlanes.add(he);
				} else if (type.equalsIgnoreCase("F")) {
					Fighter fi = new Fighter("", headX, headY, direction);
					listPlanes.add(fi);
				} else if (type.equalsIgnoreCase("B")) {
					Bomber bo = new Bomber("", headX, headY, direction);
					listPlanes.add(bo);
				}
			}
			scanner.close();

			Map map = new Map(rows, cols, listPlanes);
			map.showMap();

			while (in.hasNextLine()) {
				System.out.print("Input coordinate: ");
				String input = in.nextLine();
				String[] dataInput = input.split(" ");
				int x = Integer.parseInt(dataInput[0]);
				int y = Integer.parseInt(dataInput[1]);

				logData = new StringBuilder();
				if (map.shoot(x, y)) {
					logData.append(x + "\t" + y + "\thit");
				} else {
					logData.append(x + "\t" + y + "\tmiss");
				}
//				logData.append("\n");
				map.refreshMap();
				map.showMap();

				int[][] arrMap = map.getArrMap();
				for (int i = 0; i < arrMap.length; i++) {
					logData.append("\n");
					for (int j = 0; j < arrMap[0].length; j++) {
						logData.append(arrMap[i][j] + " ");
					}
				}

				// write log to file
				try {
					File logFile = new File(logFileName);
					if (!logFile.exists()) {
						logFile.createNewFile();
					}
					PrintWriter logger = new PrintWriter(new BufferedWriter(
							new FileWriter(logFile, true)));
					logger.print(logData.toString());
					logger.println();
					logger.close();
				} catch (IOException e) {
					e.printStackTrace();
				}

				if (map.isOver()) {
					System.out.println("You win!");
					break;
				}
			}
			System.out.println("Game over!");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		// // Helicopter he = new Helicopter("Helicoper01", 2, 1, "N");
		// Helicopter he = new Helicopter("Helicoper01", 2, 8, "N");
		// Fighter fi = new Fighter("Fighter01", 13, 3, "S");
		// // Fighter fi = new Fighter("Fighter01", 6, 10, "S");
		// Bomber bo = new Bomber("Bomber01", 5, 13, "E");
		//
		// listPlanes.add(he);
		// listPlanes.add(fi);
		// listPlanes.add(bo);
		// Map map = new Map(15, 15, listPlanes);
		//
		// map.showMap();
		//
		// map.shoot(2, 1);
		// map.shoot(5, 8);
		// map.shoot(12, 3);
		// map.shoot(5, 11);
		// System.out.println("after shoot");
		// map.refreshMap();
		// map.showMap();
	}
}
