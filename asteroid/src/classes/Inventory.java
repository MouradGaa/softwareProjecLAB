package classes;

import java.util.ArrayList;

public class Inventory {
	ArrayList<MaterialBase> Resources;
	ArrayList<TeleportationGate> Gates;


	//mourad
	public Inventory()
	{
		Resources = new ArrayList<>() ;
		Gates = new ArrayList<>();
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
