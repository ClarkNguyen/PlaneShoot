package models;

import interfaces.PlaneAction;

import java.util.ArrayList;
import java.util.List;

import base_models.BasePlane;
import base_models.PlanePart;

public class Helicopter extends BasePlane implements PlaneAction {

	public Helicopter(String name, int headX, int headY, String direction) {
		this.name = name;
		this.headX = headX;
		this.headY = headY;
		this.direction = direction;
		listPlanePart = new ArrayList<PlanePart>();
		listPartHited = new ArrayList<PlanePart>();
		setShape();
	}

	@Override
	public void setShape() {
		NormalPart n0 = null, n1 = null, n2 = null, n3 = null, n4 = null, n5 = null, n6 = null, n7 = null, n8 = null, n9 = null;

		n0 = new NormalPart(headX, headY);

		if (direction.equalsIgnoreCase("E")) {
			n1 = new NormalPart(headX, headY - 1);
			n2 = new NormalPart(headX, headY - 2);
			n3 = new NormalPart(headX, headY - 3);
			n4 = new NormalPart(headX, headY - 4);
			n5 = new NormalPart(headX, headY - 5);
			n6 = new NormalPart(headX - 1, headY - 1);
			n7 = new NormalPart(headX - 1, headY - 2);
			n8 = new NormalPart(headX + 1, headY - 1);
			n9 = new NormalPart(headX + 1, headY - 2);

		} else if (direction.equalsIgnoreCase("W")) {
			n1 = new NormalPart(headX, headY + 1);
			n2 = new NormalPart(headX, headY + 2);
			n3 = new NormalPart(headX, headY + 3);
			n4 = new NormalPart(headX, headY + 4);
			n5 = new NormalPart(headX, headY + 5);
			n6 = new NormalPart(headX - 1, headY + 1);
			n7 = new NormalPart(headX - 1, headY + 2);
			n8 = new NormalPart(headX + 1, headY + 1);
			n9 = new NormalPart(headX + 1, headY + 2);

		} else if (direction.equalsIgnoreCase("N")) {
			n1 = new NormalPart(headX + 1, headY);
			n2 = new NormalPart(headX + 2, headY);
			n3 = new NormalPart(headX + 3, headY);
			n4 = new NormalPart(headX + 4, headY);
			n5 = new NormalPart(headX + 5, headY);
			n6 = new NormalPart(headX + 1, headY - 1);
			n7 = new NormalPart(headX + 2, headY - 1);
			n8 = new NormalPart(headX + 1, headY + 1);
			n9 = new NormalPart(headX + 2, headY + 1);

		} else if (direction.equalsIgnoreCase("S")) {
			n1 = new NormalPart(headX - 1, headY);
			n2 = new NormalPart(headX - 2, headY);
			n3 = new NormalPart(headX - 3, headY);
			n4 = new NormalPart(headX - 4, headY);
			n5 = new NormalPart(headX - 5, headY);
			n6 = new NormalPart(headX - 1, headY - 1);
			n7 = new NormalPart(headX - 2, headY - 1);
			n8 = new NormalPart(headX - 1, headY + 1);
			n9 = new NormalPart(headX - 2, headY + 1);
		}

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
				pl.value = 0;
				crashed = true;
				return true;
			}
		}
		return false;
	}
	
	@Override
	public void saveBlackBox(int x, int y) {
		NormalPart part = new NormalPart(x, y);
		part.value = 0;
		listPartHited.add(part);
		
//		for (PlanePart pl : listPlanePart) {
//			if (pl.x < 0 || pl.y < 0 || pl.x > shape.length
//					|| pl.y > shape[0].length) {
//				continue;
//			}
//			shape[pl.x][pl.y] = pl.value;
//		}
//
//		for (int i = 0; i < shape.length; i++) {
//			for (int j = 0; j < shape[i].length; j++) {
//				System.out.print(shape[i][j] + " ");
//			}
//			System.out.print("\n");
//		}
	}
	
	@Override
	public List<PlanePart> getPartHited() {
		return listPartHited;
	}

	public static void main(String[] args) {
		Helicopter he = new Helicopter("Helicopter01", 6, 0, "S");
		int[][] map = new int[10][10];
		for (PlanePart pl : he.getPlanePart()) {
			if (pl.x < 0 || pl.y < 0 || pl.x > 9 || pl.y > 9) {
				continue;
			}
			map[pl.x][pl.y] = 1;
		}

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.print("\n");
		}
	}

}
