import java.util.Scanner;

public class Settler extends Operator {
	Scanner scanner = new Scanner(System.in);

	private Asteroid asteroid ;
	private Inventory inventory ;
	private boolean Isdead ;
	private Field currentfield ;
 // asteroid getters and setters
	public void setAsteroid(Asteroid asteroid)
	{
		this.asteroid = asteroid ;
	}
	public Asteroid getAsteroid()
	{
		return asteroid ;
	}
	// inventory getters and setters
	public void setInventory(Inventory inventory)
	{
		this.inventory = inventory ;
	}
	public Inventory getInventory()
	{
		return inventory;
	}
	public void Drill (Asteroid a){}
	// field getters and setters
	public void setCurrentfield(Field f)
	{
		this.currentfield = f ;
	}
	public Field getCurrentfield()
	{
		return currentfield ;
	}
	//Mourad
	public void Travel (Asteroid a)
	{
		main.WriteFunctionName("Travel() method is called ");
		if (asteroid.checkNeighbor(a))
		{
			setAsteroid(a); main.WriteFunctionName("SetAsteroid() is called");
			CollideWith(a) ; main.WriteFunctionName("CollideWith() is called");
			System.out.println("Settler traveled");
		}
		else
		{
			System.out.println("can't travel");
		}

	}
	//Mourad
	public void Hide (Asteroid a) {}
	public void Die()
	{
		main.WriteFunctionName("Die() method is called ");
		Isdead = true ;
		if(Isdead)
		{
			currentfield.RemoveOperator(this) ; System.out.println("RemoveOperator() method in field is called ");
			System.out.println("Settler is removed from the game");
		}
	}
	public void Teleport(TeleportationGate g) {
		main.WriteFunctionName("Teleport() method is called");
		if (this.CollideWith(asteroid))
		{
			CollideWith(asteroid) ; main.WriteFunctionName("CollideWith() is called");
			System.out.println("Settler teleported");
		}
		else
		{
			System.out.println("can't travel");
		}
	}
	public boolean CollideWith(EntityBase e) {return true;}
	public void Mine(Asteroid a, Inventory i) {}
	public void BuildRobot(Factory f, Inventory i) {}
	public void BuildGate(Factory f) {
		System.out.println("Is the settler at the factory ");
		if(this.CollideWith(f))
		main.WriteFunctionName("BuildGate() method is called");
	}
	public void DeployGate(TeleportationGate g){ main.WriteFunctionName("DeployGate() method is called");};
	//mourad
	public void HideResource(Asteroid a, MaterialBase r)
	{
		main.WriteFunctionName("HideResource() method is called ");
		System.out.println("Is the asteroid mantle completely drilled through ?");
		System.out.println("1-Yes");
		System.out.println("2-No");
		int msg = scanner.nextInt();
		if(msg==1)
		{
			asteroid.DecreaseDepth(); main.WriteFunctionName("DecreaseDepth() is called");
			if (a.getIsHollow())
			{
				main.WriteFunctionName("getDepth() is called");
				a.addMaterial(r);  main.WriteFunctionName("addMaterial() method in asteroid is called");
				inventory.RemoveResources(0); main.WriteFunctionName("RemoveResources() method in inventory is called");
				System.out.println("The Material is hidden");
			}
			else
			{
				return;
			}

		}
		else
		{
			System.out.println("The asteroid is not completely drilled through, you can't hide resource");
		}
	}
	//mourad
}