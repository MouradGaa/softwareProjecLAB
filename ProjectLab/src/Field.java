import java.io.File;

public class Field {
	private Operator operator ;
	private Asteroid asteroid ;
	public Field(Operator o,Asteroid a)
	{
		operator = o ;
		asteroid = a ;
	}
	void addAsteroid(Asteroid a) {}
	//mourad
	void RemoveOperator(Operator o)
	{
		this.operator = null ;

	}
	//mourad
	void RemoveEntity(EntityBase e) {}

}
