import java.io.File;

public class   Field {
	private Operator operator ;
	private Asteroid asteroid ;
	public Field()
	{

	}
	public Field(Operator o,Asteroid a)
	{
		operator = o ;
		asteroid = a ;
	}
	void addAsteroid(Asteroid a)
	{
		asteroid=a ;
	}
	Asteroid getAsteroid()
	{
		return asteroid ;
	}
	void addOperator(Operator o)
	{
		operator = o ;
	}
	Operator getOperator()
	{
		return operator ;
	}
	//mourad
	void RemoveOperator(Operator o)
	{
		this.operator = null ;

	}
	//mourad
	void RemoveEntity(EntityBase e) {}

	public void addSunStorm(SunStorm s) {
	}
}
