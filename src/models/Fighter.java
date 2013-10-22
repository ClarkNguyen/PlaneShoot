package models;

import interfaces.PlaneAction;

import java.util.ArrayList;
import java.util.List;

import base_models.BasePlane;
import base_models.PlanePart;

public class Fighter extends BasePlane implements PlaneAction {

	public Fighter(int headX, int headY, String direction) {
		this.name = "Fighter";
		this.headX = headX;
		this.headY = headY;
		this.direction = direction;
		listPlanePart = new ArrayList<PlanePart>();
		setShape();
	}

	@Override
	public void setShape() {
		NormalPart n0 = null, n1 = null, n2 = null, n3 = null, n4 = null, n5 = null, n6 = null, n7 = null;
		Pilot p = null;
		Turbojet r = null;

		n0 = new NormalPart(headX, headY);

		if (direction.equalsIgnoreCase("N")) {
			p = new Pilot(headX + 1, headY);
			r = new Turbojet(headX + 3, headY);
			n1 = new NormalPart(headX + 1, headY - 1);
			n2 = new NormalPart(headX + 1, headY + 1);
			n3 = new NormalPart(headX + 2, headY - 2);
			n4 = new NormalPart(headX + 2, headY + 2);
			n5 = new NormalPart(headX + 2, headY);
			n6 = new NormalPart(headX + 3, headY - 1);
			n7 = new NormalPart(headX + 3, headY + 1);

		} else if (direction.equalsIgnoreCase("S")) {
			p = new Pilot(headX - 1, headY);
			r = new Turbojet(headX - 3, headY);
			n1 = new NormalPart(headX - 1, headY - 1);
			n2 = new NormalPart(headX - 1, headY + 1);
			n3 = new NormalPart(headX - 2, headY - 2);
			n4 = new NormalPart(headX - 2, headY + 2);
			n5 = new NormalPart(headX - 2, headY);
			n6 = new NormalPart(headX - 3, headY - 1);
			n7 = new NormalPart(headX - 3, headY + 1);

		} else if (direction.equalsIgnoreCase("E")) {
			p = new Pilot(headX, headY - 1);
			r = new Turbojet(headX, headY - 3);
			n1 = new NormalPart(headX - 1, headY - 1);
			n2 = new NormalPart(headX + 1, headY - 1);
			n3 = new NormalPart(headX - 2, headY - 2);
			n4 = new NormalPart(headX + 2, headY - 2);
			n5 = new NormalPart(headX, headY - 2);
			n6 = new NormalPart(headX - 1, headY - 3);
			n7 = new NormalPart(headX + 1, headY - 3);

		} else if (direction.equalsIgnoreCase("W")) {
			p = new Pilot(headX, headY + 1);
			r = new Turbojet(headX, headY + 3);
			n1 = new NormalPart(headX - 1, headY + 1);
			n2 = new NormalPart(headX + 1, headY + 1);
			n3 = new NormalPart(headX - 2, headY + 2);
			n4 = new NormalPart(headX + 2, headY + 2);
			n5 = new NormalPart(headX, headY + 2);
			n6 = new NormalPart(headX + 1, headY + 3);
			n7 = new NormalPart(headX - 1, headY + 3);
		}

		listPlanePart.add(p);
		listPlanePart.add(r);
		listPlanePart.add(n0);
		listPlanePart.add(n1);
		listPlanePart.add(n2);
		listPlanePart.add(n3);
		listPlanePart.add(n4);
		listPlanePart.add(n5);
		listPlanePart.add(n6);
		listPlanePart.add(n7);
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
				if (pl instanceof Pilot || pl instanceof Turbojet || hitCount == 4) {
					crashed = true;
				}
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Fighter fi = new Fighter(3, 3, "E");
		int[][] map = new int[10][10];
		for (PlanePart pl : fi.getPlanePart()) {
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
