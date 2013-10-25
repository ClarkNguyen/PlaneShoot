package models;

import interfaces.PlaneAction;

import java.util.ArrayList;
import java.util.List;

import base_models.BasePlane;
import base_models.PlanePart;

public class Helicopter extends BasePlane implements PlaneAction {

	public Helicopter(int headX, int headY, String direction) {
		this.headX = headX;
		this.headY = headY;
		this.direction = direction;
		listPlanePart = new ArrayList<PlanePart>();
		listPartHited = new ArrayList<PlanePart>();
		initPlanePart();
	}

	@Override
	public void initPlanePart() {
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
				if (pl.value == 0) {
					return false;
				}
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
	}
	
	@Override
	public List<PlanePart> getPartHited() {
		return listPartHited;
	}

}
