
public class Robot extends Operator {
	void Drill (Asteroid a) {}
	void Travel (Asteroid a) {}
	void Hide (Asteroid a) {}
	void Die() {}
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
