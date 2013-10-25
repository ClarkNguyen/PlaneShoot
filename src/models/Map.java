package models;

import java.util.List;

import base_models.BasePlane;
import base_models.PlanePart;

public class Map {

	private int rows, cols;
	private int[][] arrMap;
	private List<BasePlane> listPlanes;

	public Map(int rows, int cols, List<BasePlane> listPlanes) {
		this.rows = rows;
		this.cols = cols;
		arrMap = new int[rows][cols];
		this.listPlanes = listPlanes;
		combineAllPlaneInMap();
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getCols() {
		return cols;
	}

	public void setCols(int cols) {
		this.cols = cols;
	}

	public int[][] getArrMap() {
		return arrMap;
	}

	public void setArrMap(int[][] arrMap) {
		this.arrMap = arrMap;
	}

	public List<BasePlane> getListPlane() {
		return listPlanes;
	}

	public void setListPlane(List<BasePlane> listPlanes) {
		this.listPlanes = listPlanes;
	}

	public boolean shoot(int x, int y) {
		boolean hited = false;
		if (x < 0 || y < 0 || x > arrMap.length - 1 || y > arrMap[0].length - 1) {
			return hited;
		}
		arrMap[x][y] = 0;
		for (BasePlane basePlane : listPlanes) {
			if (basePlane instanceof Helicopter) {
				Helicopter he = (Helicopter) basePlane;
				if (he.crashed) {
					continue;
				} else {
					if (he.takeShoot(x, y)) {
						hited = true;
						he.saveBlackBox(x, y);
					}
				}
			} else if (basePlane instanceof Fighter) {
				Fighter fi = (Fighter) basePlane;
				if (fi.crashed) {
					continue;
				} else {
					if (fi.takeShoot(x, y)) {
						hited = true;
						fi.saveBlackBox(x, y);
					}
				}
			} else if (basePlane instanceof Bomber) {
				Bomber bo = (Bomber) basePlane;
				if (bo.crashed) {
					continue;
				} else {
					if (bo.takeShoot(x, y)) {
						hited = true;
						bo.saveBlackBox(x, y);
					}
				}
			}
		}
		return hited;
	}

	// combine all plane on map
	public void combineAllPlaneInMap() {
		for (BasePlane basePlane : listPlanes) {
			List<PlanePart> listPlaneParts = basePlane.getPlanePart();
			for (PlanePart planePart : listPlaneParts) {
				if (planePart.x < 0 || planePart.y < 0
						|| planePart.x > rows - 1 || planePart.y > cols - 1) {
					planePart.inMap = false;
					continue;
				}
				arrMap[planePart.x][planePart.y] = planePart.value;
			}
		}
	}

	// show map on console screen
	public void showMap() {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				System.out.print(arrMap[i][j] + " ");
			}
			System.out.print("\n");
		}
	}

	public void refreshMap() {
		// if plane crash, set shape on map to default
		for (BasePlane basePlane : listPlanes) {
			if (basePlane.crashed) {
				for (PlanePart pl : basePlane.getPlanePart()) {
					if (pl.inMap) {
						arrMap[pl.x][pl.y] = 0;
					}
				}
			}
		}

		// draw remain plane on map
		for (BasePlane basePlane : listPlanes) {
			if (basePlane.crashed) {
				continue;
			} else {
				for (PlanePart pl : basePlane.getPlanePart()) {
					if (pl.inMap) {
						arrMap[pl.x][pl.y] = 1;
					}
				}
			}
		}

		// draw shoot hited plane on map
		for (BasePlane basePlane : listPlanes) {
			for (PlanePart part : basePlane.getPartHited()) {
				if (part.inMap) {
					arrMap[part.x][part.y] = 0;
				}
			}
		}
	}

	// check if game is over
	public boolean isOver() {
		for (BasePlane basePlane : listPlanes) {
			if (!basePlane.crashed) {
				return false;
			}
		}
		return true;
	}
}
