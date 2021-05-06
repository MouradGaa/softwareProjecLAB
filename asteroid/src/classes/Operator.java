package classes;

public abstract class Operator {
	void Drill (Asteroid a) {
		a.DecreaseDepth();
	}
	void Travel (Field f, String s) {}
	void Hide (Asteroid a) {}
	void Die() {}
	void Teleport(Asteroid a, Field field) {}
	boolean CollideWith(EntityBase e) {
		return false;}

	public abstract void Mine(Asteroid a, Inventory i) ;
	public abstract Inventory getInventory();

	public abstract void HideResource(Asteroid a, MaterialBase r);


	public abstract void setCurrentfield(Field mapField);

	public abstract void setInventory(Inventory inventory);
}
