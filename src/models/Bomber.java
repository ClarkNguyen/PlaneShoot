package models;

import interfaces.PlaneAction;

import java.util.ArrayList;
import java.util.List;

import base_models.BasePlane;
import base_models.PlanePart;

public class Bomber extends BasePlane implements PlaneAction {

	private int hitEngineCount = 0;

	public Bomber(int headX, int headY, String direction) {
		this.name = "Fighter";
		this.headX = headX;
		this.headY = headY;
		this.direction = direction;
		listPlanePart = new ArrayList<PlanePart>();
		setShape();
	}

	@Override
	public void setShape() {
		Pilot p = null;
		Turbojet r1 = null, r2 = null, r3 = null;
		NormalPart n0 = null, n1 = null, n2 = null, n3 = null, n4 = null, n5 = null, n6 = null, n7 = null, n8 = null, n9 = null, n10 = null, n11 = null, n12 = null, n13 = null, n14 = null, n15 = null, n16 = null, n17 = null, n18 = null;

		p = new Pilot(headX, headY);
		if (direction.equalsIgnoreCase("N")) {
			r1 = new Turbojet(headX + 2, headY - 2);
			r2 = new Turbojet(headX + 2, headY + 2);
			r3 = new Turbojet(headX + 6, headY);
			n0 = new NormalPart(headX + 1, headY);
			n1 = new NormalPart(headX + 2, headY);
			n2 = new NormalPart(headX + 3, headY);
			n3 = new NormalPart(headX + 4, headY);
			n4 = new NormalPart(headX + 5, headY);
			n5 = new NormalPart(headX + 1, headY - 1);
			n6 = new NormalPart(headX + 1, headY + 1);
			n7 = new NormalPart(headX + 2, headY - 3);
			n8 = new NormalPart(headX + 2, headY + 3);
			n9 = new NormalPart(headX + 2, headY - 1);
			n10 = new NormalPart(headX + 2, headY + 1);
			n11 = new NormalPart(headX + 3, headY - 4);
			n12 = new NormalPart(headX + 3, headY + 4);
			n13 = new NormalPart(headX + 3, headY - 3);
			n14 = new NormalPart(headX + 3, headY + 3);
			n15 = new NormalPart(headX + 3, headY - 2);
			n16 = new NormalPart(headX + 3, headY + 2);
			n17 = new NormalPart(headX + 6, headY - 1);
			n18 = new NormalPart(headX + 6, headY + 1);

		} else if (direction.equalsIgnoreCase("S")) {
			r1 = new Turbojet(headX - 2, headY - 2);
			r2 = new Turbojet(headX - 2, headY + 2);
			r3 = new Turbojet(headX - 6, headY);
			n0 = new NormalPart(headX - 1, headY);
			n1 = new NormalPart(headX - 2, headY);
			n2 = new NormalPart(headX - 3, headY);
			n3 = new NormalPart(headX - 4, headY);
			n4 = new NormalPart(headX - 5, headY);
			n5 = new NormalPart(headX - 1, headY - 1);
			n6 = new NormalPart(headX - 1, headY + 1);
			n7 = new NormalPart(headX - 2, headY - 3);
			n8 = new NormalPart(headX - 2, headY + 3);
			n9 = new NormalPart(headX - 2, headY - 1);
			n10 = new NormalPart(headX - 2, headY + 1);
			n11 = new NormalPart(headX - 3, headY - 4);
			n12 = new NormalPart(headX - 3, headY + 4);
			n13 = new NormalPart(headX - 3, headY - 3);
			n14 = new NormalPart(headX - 3, headY + 3);
			n15 = new NormalPart(headX - 3, headY - 2);
			n16 = new NormalPart(headX - 3, headY + 2);
			n17 = new NormalPart(headX - 6, headY - 1);
			n18 = new NormalPart(headX - 6, headY + 1);

		} else if (direction.equalsIgnoreCase("E")) {
			r1 = new Turbojet(headX - 2, headY - 2);
			r2 = new Turbojet(headX + 2, headY - 2);
			r3 = new Turbojet(headX, headY - 6);
			n0 = new NormalPart(headX, headY - 1);
			n1 = new NormalPart(headX, headY - 2);
			n2 = new NormalPart(headX, headY - 3);
			n3 = new NormalPart(headX, headY - 4);
			n4 = new NormalPart(headX, headY - 5);
			n5 = new NormalPart(headX - 1, headY - 1);
			n6 = new NormalPart(headX + 1, headY - 1);
			n7 = new NormalPart(headX - 3, headY - 2);
			n8 = new NormalPart(headX + 3, headY - 2);
			n9 = new NormalPart(headX - 1, headY - 2);
			n10 = new NormalPart(headX + 1, headY - 2);
			n11 = new NormalPart(headX - 4, headY - 3);
			n12 = new NormalPart(headX + 4, headY - 3);
			n13 = new NormalPart(headX - 3, headY - 3);
			n14 = new NormalPart(headX + 3, headY - 3);
			n15 = new NormalPart(headX - 2, headY - 3);
			n16 = new NormalPart(headX + 2, headY - 3);
			n17 = new NormalPart(headX - 1, headY - 6);
			n18 = new NormalPart(headX + 1, headY - 6);

		} else if (direction.equalsIgnoreCase("W")) {
			r1 = new Turbojet(headX - 2, headY + 2);
			r2 = new Turbojet(headX + 2, headY + 2);
			r3 = new Turbojet(headX, headY + 6);
			n0 = new NormalPart(headX, headY + 1);
			n1 = new NormalPart(headX, headY + 2);
			n2 = new NormalPart(headX, headY + 3);
			n3 = new NormalPart(headX, headY + 4);
			n4 = new NormalPart(headX, headY + 5);
			n5 = new NormalPart(headX - 1, headY + 1);
			n6 = new NormalPart(headX + 1, headY + 1);
			n7 = new NormalPart(headX - 3, headY + 2);
			n8 = new NormalPart(headX + 3, headY + 2);
			n9 = new NormalPart(headX - 1, headY + 2);
			n10 = new NormalPart(headX + 1, headY + 2);
			n11 = new NormalPart(headX - 4, headY + 3);
			n12 = new NormalPart(headX + 4, headY + 3);
			n13 = new NormalPart(headX - 3, headY + 3);
			n14 = new NormalPart(headX + 3, headY + 3);
			n15 = new NormalPart(headX - 2, headY + 3);
			n16 = new NormalPart(headX + 2, headY + 3);
			n17 = new NormalPart(headX - 1, headY + 6);
			n18 = new NormalPart(headX + 1, headY + 6);
		}

		listPlanePart.add(p);
		listPlanePart.add(r1);
		listPlanePart.add(r2);
		listPlanePart.add(r3);
		listPlanePart.add(n0);
		listPlanePart.add(n1);
		listPlanePart.add(n2);
		listPlanePart.add(n3);
		listPlanePart.add(n4);
		listPlanePart.add(n5);
		listPlanePart.add(n6);
		listPlanePart.add(n7);
		listPlanePart.add(n8);
		listPlanePart.add(n9);
		listPlanePart.add(n10);
		listPlanePart.add(n11);
		listPlanePart.add(n12);
		listPlanePart.add(n13);
		listPlanePart.add(n14);
		listPlanePart.add(n15);
		listPlanePart.add(n16);
		listPlanePart.add(n17);
		listPlanePart.add(n18);

	}

	@Override
	public List<PlanePart> getPlanePart() {
		return listPlanePart;
	}

	@Override
	public boolean takeShoot(int x, int y) {
		for (PlanePart pl : listPlanePart) {
			if (pl.x == x && pl.y == y) {
				++hitCount;
				if (pl instanceof Engine) {
					++hitEngineCount;
				}
				if (pl instanceof Pilot || hitEngineCount == 3
						|| hitCount == 10) {
					crashed = true;
				}
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// Bomber bo = new Bomber(1, 5, "N");
		// Bomber bo = new Bomber(8, 5, "S");
		// Bomber bo = new Bomber(5, 8, "E");
		Bomber bo = new Bomber(5, 1, "W");
		int[][] map = new int[10][10];
		for (PlanePart pl : bo.getPlanePart()) {
			if (pl.x < 0 || pl.y < 0 || pl.x > 9 || pl.y > 9) {
				continue;
			}
			if (pl instanceof Pilot) {
				map[pl.x][pl.y] = 2;
			} else if (pl instanceof Turbojet) {
				map[pl.x][pl.y] = 3;
			} else {
				map[pl.x][pl.y] = 1;
			}
		}

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.print("\n");
		}
	}

}
