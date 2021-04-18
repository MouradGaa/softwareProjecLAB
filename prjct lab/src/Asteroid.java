import java.util.Scanner;

public class Asteroid extends EntityBase {
	public static final int PERIHELION = 1 ;
	public static final int APHELION = 0 ;


	Scanner scanner = new Scanner(System.in);
	private int Depth;
	private int State;
	private MaterialBase resource = null ;
	private boolean isRadioactive = true;
	private boolean isHollow;
	private Settler settler ;
	private TeleportationGate gate ;

	public int getState() {
		return State;
	}

	public Asteroid()
	{

		System.out.println("New Asteroid is created");
	}
	public Asteroid(int d) {
		Depth = d;
	}

	public void DecreaseDepth()
	{
		Depth-- ;
		if(Depth==0 && resource ==null)
		{
			isHollow= true ;
		}
	}
	public void explode() {
		if (State ==1)
		main.WriteFunctionName("explode() method is called");
		main.WriteFunctionName("asteroid exploded");
	}
	public void addSettler(Settler s)
	{
		this.settler = s ;
	}
	public void setGate(TeleportationGate g)
	{
		gate = g ;
	}

	public TeleportationGate getGate() {
		return gate;
	}

	//MOURAD
	public void addMaterial(MaterialBase m)
	{
		this.resource= m ;
		System.out.println("material added to the asteroid");
	}
	public MaterialBase removeResource()
	{
		MaterialBase r = resource ;
		resource = null ;
		return r ;
	}

	public boolean checkNeighbor(Asteroid a2)
	{
		System.out.println("checkNeighbor() function is called ");
		System.out.println("Is the the asteroid a neighbor to the current asteroid ?");
		System.out.println("1-Yes");
		System.out.println("2-No");
		int msg = scanner.nextInt();
		if(msg==1)
		{
			return true ;
		}
		return false ;
	}

	public int getDepth() {
		return Depth;
	}
	public void setDepth(int d)
	{
		Depth = d ;
		System.out.println("depth is set");
	}
	public boolean getIsHollow()
	{
		return isHollow ;
	}
	public void setState(int s )
	{
		State = s ;
		System.out.println("state changed");
	}

	//Mourad

}
