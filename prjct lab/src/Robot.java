
public class Robot extends Operator {
	void Drill (Asteroid a) {}
	void Travel (Asteroid a) {}
	void Hide (Asteroid a) {}
	void Die() {}
	void Teleport(TeleportationGate g) {}
	boolean CollideWith(EntityBase e) {
		return false;}

	@Override
	public Inventory getInventory() {
		return null;
	}

	@Override
	public void HideResource(Asteroid a, MaterialBase r) {}

	public Robot()
		{
			System.out.println("Robot created");
		}

}
