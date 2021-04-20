
public class Robot extends Operator {
	void Drill (Asteroid a)
	{
		if(a.getDepth()==1 && a.getState()==Asteroid.PERIHELION)
		{
			a.DecreaseDepth();
			System.out.println("drill() method is called   depth: " + a.getDepth()+ " state: "+ a.getState()) ;
			a.explode();
			this.Die();
			return ;
		}
		if (a.getDepth()==0)
		{
			System.out.println("asteroid is hollow");
			return;
		}
		a.DecreaseDepth();
		System.out.println("drill() method is called   depth: " + a.getDepth()+ " state: "+ a.getState()) ;
	}
	void Travel (Asteroid a) {}
	void Hide (Asteroid a) {}
	void Die() {
		System.out.println("Robot Died");
    getCurrentfield().RemoveOperator(this);
	}
	private Field currentfield ;

	public Field getCurrentfield() {
		return currentfield;
	}

	public void setCurrentfield(Field currentfield) {
		this.currentfield = currentfield;
	}

	void Teleport(TeleportationGate g) {}
	boolean CollideWith(EntityBase e) {
		return false;}

	@Override
	public void Mine(Asteroid a, Inventory i) {

	}

	@Override
	public Inventory getInventory() {
		Inventory inv = new Inventory() ;
		return inv;
	}

	@Override
	public void HideResource(Asteroid a, MaterialBase r) {}

	@Override
	public void setInventory(Inventory inventory) {

	}



	public Robot()
		{
			System.out.println("Robot created");
		}

}
