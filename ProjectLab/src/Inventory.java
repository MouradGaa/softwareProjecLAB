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
	}
	public MaterialBase getResource(int index)
	{
		return Resources.get(index) ;
	}
	public void RemoveResources(int index)
	{
		Resources.remove(index) ;
	}
	//mourad
}
