package classes;

public class Map {

	private Field[][] map= new Field[10][10] ;

	void AddField(Field f) {}
	public void Win(){
		main.WriteFunctionName("Win() method is called");
	};
	public void create_map(int rowNum , int colNum)
	{
		for(int row = 0;row<rowNum;row++)
		{
			for(int col = 0;col<colNum;col++)
			{
				map[row][col] = new Field() ;
			}
		}
	}

	Field getMapField(int x, int y)
	{
		return map[x][y] ;
	}
}
