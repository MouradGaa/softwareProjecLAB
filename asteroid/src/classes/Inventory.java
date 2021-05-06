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
		// check if the player has the needed resource to win the game
public boolean check_win(){
	Uranium n= new Uranium();
	Carbon c = new Carbon();
	Iron i =new Iron();
	WaterIce w =new WaterIce();
	int nbr_c  = 0;
	int nbr_n = 0;
	int nbr_i  = 0;
	int nbr_w  = 0;

	for( MaterialBase resources : Resources){

		if (resources.equals(c))
			nbr_c++;
		if (resources.equals(n))
			nbr_n++;
		if (resources.equals(i))
			nbr_i++;
		if (resources.equals(w))
			nbr_w++;

	}
	if ( nbr_c ==3 && nbr_n ==3 && nbr_i ==3&& nbr_w ==3)
		return true;
	else
		return false;
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
