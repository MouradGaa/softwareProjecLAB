
public class Robot extends Operator {
	void Drill (Asteroid a) {}
	void Travel (Asteroid a) {}
	void Hide (Asteroid a) {}
	void Die() {}
	void Teleport(TeleportationGate g) {}
	boolean CollideWith(EntityBase e) {
		return false;}
		public Robot()
		{
			System.out.println("Robot created");
		}

}
