package base_models;

import java.util.List;

public abstract class BasePlane {
	public int hitCount;
	// plane status
	public boolean crashed;
	public int headX, headY;
	public String direction;
	// list part of plane
	public List<PlanePart> listPlanePart;
	// list part be hited
	public List<PlanePart> listPartHited;

	public abstract void initPlanePart();

	public abstract List<PlanePart> getPlanePart();
	
	public abstract List<PlanePart> getPartHited();
}
