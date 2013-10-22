package base_models;

import java.util.List;

public abstract class BasePlane {
	public int hitCount;
	public boolean crashed;
	public int headX, headY;
	public String name;
	public String direction;
	public List<PlanePart> listPlanePart;
	public int[][] shape;

	public abstract void setShape();

	public abstract List<PlanePart> getPlanePart();
}
