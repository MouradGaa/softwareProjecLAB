import java.util.Scanner;

public class Asteroid extends EntityBase {
	Scanner scanner = new Scanner(System.in);
	private int Depth;
	private int State;
	private MaterialBase resource;
	private boolean isRadioactive = true;
	private boolean isHollow;
	private Settler settler ;

	public int getState() {
		return State;
	}

	public Asteroid()
	{
		return ;
	}
	public Asteroid(int d) {
		Depth = d;
	}

	public void DecreaseDepth()
	{
		Depth-- ;
		if(Depth==0)
		{
			isHollow= true ;
		}
	}
	public void explode() {
		if (isRadioactive)
		main.WriteFunctionName("explode() method is called");
		main.WriteFunctionName("asteroid exploded");
	}
	public void addSettler(Settler s)
	{
		this.settler = s ;
	}

	//MOURAD
	public void addMaterial(MaterialBase m)
	{
		this.resource= m ;
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
	public boolean getIsHollow()
	{
		return isHollow ;
	}

	//Mourad

}
