import java.io.*;
import java.util.Scanner;
import java.util.Vector;

public class TestingUtility {

    public static void ReadFile(String filename,Vector<String> cmdList)
    {
        BufferedReader reader;
        try {
            InputStream input = TestingUtility.class.getResourceAsStream(filename) ;
            BufferedReader br = new BufferedReader(new InputStreamReader(input)) ;
            StringBuffer sb=new StringBuffer();
            String line;
            while ((line=br.readLine())!=null)
            {
                sb.append(line);
                sb.append("\n") ;
                cmdList.add(line) ;
            }
            input.close();    //closes the stream and release the resources
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        Map map = new Map();
        map.create_map(10, 10);
        while(true) {
            Vector<String> commandList = new Vector<String>();

            System.out.print("Enter file name: ");
            Scanner scanner = new Scanner(System.in);
            String name = scanner.nextLine();

            ReadFile(name, commandList);
            for (int i = 0; i < commandList.size(); i++) {
            String cmd = commandList.elementAt(i);
            String[] splited = cmd.split("\\s+");
            // Scanner sc = new Scanner(System.in);
            //System.out.print("Enter a command: ");
            //String cmd = sc.nextLine();

            //System.out.print("You have entered: " + cmd+"\r\n");

            switch (splited[0]) {
                case "create": {
                    int x = Integer.parseInt(splited[2]);
                    int y = Integer.parseInt(splited[3]);
                    switch (splited[1]) {
                        case "A" -> map.getMapField(x, y).addAsteroid(new Asteroid());
                        case "S" -> map.getMapField(x, y).addOperator(new Settler());
                        case "R" -> map.getMapField(x, y).addOperator(new Robot());
                        case "G" -> map.getMapField(x, y).getAsteroid().setGate(new TeleportationGate());
                    }
                }
                break;
                case "modify": {
                    String s = splited[1];
                    int x = Character.getNumericValue(s.charAt(1));
                    int y = Character.getNumericValue(s.charAt(2));
                    switch (s.charAt(0)) {
                        case 'A' -> {
                            switch (splited[2]) {
                                case "depth" -> {
                                    int d = Integer.parseInt(splited[3]);
                                    map.getMapField(x, y).getAsteroid().setDepth(d);
                                }
                                case "state" -> {
                                    int state = Integer.parseInt(splited[3]);
                                    if (state == 1) {
                                        map.getMapField(x, y).getAsteroid().setState(Asteroid.PERIHELION);
                                    }
                                }
                                case "zebi" -> {
                                    System.out.println("ahlawenti");
                                }
                            }
                        }
                        case 'S' -> {
                            //write some code
                        }
                    }
                }
                case "add": {
                    String s = splited[2];
                    int x = Character.getNumericValue(s.charAt(1));
                    int y = Character.getNumericValue(s.charAt(2));
                    if (s.charAt(0) == 'A') {
                        switch (splited[1]) {
                            case "U" -> map.getMapField(x, y).getAsteroid().addMaterial(new Uranium());
                            case "C" -> map.getMapField(x, y).getAsteroid().addMaterial(new Carbon());
                            case "I" -> map.getMapField(x, y).getAsteroid().addMaterial(new Iron());
                            case "W" -> map.getMapField(x, y).getAsteroid().addMaterial(new WaterIce());
                        }
                    }
                }
                break;
                case "drill": {
                    String s1 = splited[1];
                    String s2 = splited[2];
                    int x1 = Character.getNumericValue(s1.charAt(1));
                    int y1 = Character.getNumericValue(s1.charAt(2));
                    int x2 = Character.getNumericValue(s2.charAt(1));
                    int y2 = Character.getNumericValue(s2.charAt(2));
                    if (x1 == x2 && y1 == y2) {
                        map.getMapField(x1, y1).getOperator().Drill(map.getMapField(x2, y2).getAsteroid());
                    } else {
                        System.out.println("settler and asteroid not in the same position");
                    }

                }
                case "activate": {
                    String g1 = splited[1];
                    String g2 = splited[2];
                    if (g1.charAt(0) == 'G') {
                        int x1 = Character.getNumericValue(g1.charAt(1));
                        int y1 = Character.getNumericValue(g1.charAt(2));
                        int x2 = Character.getNumericValue(g2.charAt(1));
                        int y2 = Character.getNumericValue(g2.charAt(2));
                        TeleportationGate gate1 = map.getMapField(x1, y1).getAsteroid().getGate();
                        TeleportationGate gate2 = map.getMapField(x2, y2).getAsteroid().getGate();
                        gate1.setPair(gate2);
                        gate2.setPair(gate1);

                    }
                }

            }
        }
        }
    }
}