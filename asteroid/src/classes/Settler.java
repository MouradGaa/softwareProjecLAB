package classes;

import java.util.Scanner;

public class Settler extends Operator {
	Scanner scanner = new Scanner(System.in);

	private Asteroid asteroid ;
	private Inventory inventory ;
	private boolean Isdead ;
	private Field currentfield ;


	public Settler()
	{
		setInventory(new Inventory());
		System.out.println("Settler created");
	}
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
	public void Drill (Asteroid a)
	{

		if(a.getDepth()==1 && a.getState()== Asteroid.PERIHELION)
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
	// field getters and setters
	public Field getCurrentfield(Field f)
	{
		return currentfield ;
	}

	public void setCurrentfield(Field f)
	{
		this.currentfield = f ;
	}
	public Field getCurrentfield()
	{
		return currentfield ;
	}
	public void Travel (Field f, String s)
	{

		setCurrentfield(f);
		System.out.println("settler moved 1 unit " + s);

	}
	public void Hide (Asteroid a) {
		System.out.println("settler hided successfully");
	}
	public void Die()
	{
		main.WriteFunctionName("Settler died");
		Isdead = true ;
		if(inventory!=null )
		{
			if (inventory.Gates.size()>0)
			{
				inventory.Gates.get(0).destroy();
				getCurrentfield().RemoveOperator(this);
			}

		}

		/*if(Isdead)
		{
			currentfield.RemoveOperator(this) ; System.out.println("RemoveOperator() method in field is called ");
			System.out.println("Settler is removed from the game");
		}*/
	}
	public void Teleport(Asteroid a, Field f) {
		setCurrentfield(f);
		setAsteroid(a);
		System.out.println("settler teleported to the second gate");
		/*if (this.CollideWith(asteroid))
		{
			CollideWith(asteroid) ; main.WriteFunctionName("CollideWith() is called");
			System.out.println("Settler teleported");
		}
		else
		{
			System.out.println("can't travel");
		}*/
	}
	public boolean CollideWith(EntityBase e) {return true;}
	public void Mine(Asteroid a) {
		if (a.getDepth()>0)
		{
			System.out.println("The asteroid cannot be mined yet, because the depth of the asteroid is: "+a.getDepth());
		}
		else
		{
			if (a.getIsHollow()) System.out.println("The asteroid cannot be mined, because it core is empty (this is a hollow asteroid)");
			else {
				if (a.getState()==1)a.explode();
				else {
					this.getInventory().setResources(a.getResource());
					System.out.println("The asteroid is succesfully mined");
				}
			}
		}
	}

	public void Mine(Asteroid a, Inventory i)
	{
		if(a.getDepth()==0 )
		{
			i.setResources(a.removeResource()); // remove resource from asteroid and set it in inventory
		}
	}

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
		a.addMaterial(r);
		System.out.println("depth: "+a.getDepth()+ "   state: "+a.getState() );
		if(a.getDepth()==0 && a.getState()== Asteroid.PERIHELION)
		{
			a.explode();
			this.Die();
		}
		/*main.WriteFunctionName("HideResource() method is called ");
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
		}*/
	}
	//mourad
}