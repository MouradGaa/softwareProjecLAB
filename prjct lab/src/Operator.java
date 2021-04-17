
public class Operator {
	void Drill (Asteroid a) {
		a.DecreaseDepth();
	}
	void Travel (Asteroid a) {}
	void Hide (Asteroid a) {}
	void Die() {}
	void Teleport(TeleportationGate g) {}
	boolean CollideWith(EntityBase e) {
		return false;}

}
