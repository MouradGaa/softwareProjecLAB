package classes;

import java.util.ArrayList;

public class Inventory {
	ArrayList<MaterialBase> Resources;
	ArrayList<TeleportationGate> Gates;
	int[] resourceNumber = {0,0,0,0};


	//mourad
	public Inventory()
	{
		Resources = new ArrayList<>();
		Resources.add(new empty());
		Gates = new ArrayList<>();
	}

	public int getResourceNumber(int i) {
		return resourceNumber[i];
	}

	public void setResourceNumber(int i) {
		this.resourceNumber[i] ++ ;
	}

	public void setResources(MaterialBase mb)
	{
		Resources.add(mb) ;
		System.out.println("resource added to the inventory");
	}
	public MaterialBase getResource(int index)
	{
		return Resources.get(index) ;
		}


	// check if the player has the needed resource to win the game


		public void setGates(TeleportationGate g)
		{
			Gates.add(g) ;
			System.out.println("gate added to the inventory");
		}

		public void RemoveResources(int index)
	{
		Resources.remove(index) ;
	}
	//mourad
}
