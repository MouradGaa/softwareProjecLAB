import java.io.*;
import java.util.Scanner;
import java.util.Vector;

public class TestingUtility {

    public static void ReadFile(String filename, Vector<String> cmdList) {
        BufferedReader reader;
        try {
            InputStream input = TestingUtility.class.getResourceAsStream(filename);
            BufferedReader br = new BufferedReader(new InputStreamReader(input));
            StringBuffer sb = new StringBuffer();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
                sb.append("\n");
                cmdList.add(line);
            }
            input.close();    //closes the stream and release the resources
        } catch (Exception e) {
            System.out.println("Wrong file name");
        }
    }

    public static void main(String[] args) {
        Map map = new Map();
        map.create_map(10, 10);
        while (true) {
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
                                    case "hollow" -> {
                                        map.getMapField(x, y).getAsteroid().setHollow(true);
                                        System.out.println("The core of the asteroid is set to be hollow");

                                    }
                                }
                            }
                            case 'S' -> {
                                //write some code
                            }
                        }
                    }
                    break;
                    //bor3i
                    case "hide": {
                        String s1 = splited[1];
                        String s2 = splited[2];
                        int x1 = Character.getNumericValue(s1.charAt(1));
                        int y1 = Character.getNumericValue(s1.charAt(2));
                        int x2 = Character.getNumericValue(s2.charAt(1));
                        int y2 = Character.getNumericValue(s2.charAt(2));
                        if (x1 == x2 && y1 == y2) {
                            map.getMapField(x1,y1).getOperator().Hide(map.getMapField(x1,y1).getAsteroid());
                        } else {
                            System.out.println("settler and asteroid not in the same position");
                        }

                    }
                    break;
                    //bor3i
                    case "win":
                    {
                        map.Win();
                    }
                    break;
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
                        if (s.charAt(0) == 'S') {
                            switch (splited[1]) {
                                case "G" -> map.getMapField(x, y).getOperator().getInventory().setGates(new TeleportationGate());
                            }
                        }
                    }
                    break;
                    case "carry": {
                        String s2 = splited[2];
                        int x = Character.getNumericValue(s2.charAt(0));
                        int y = Character.getNumericValue(s2.charAt(1));
                        switch (splited[1]) {
                            case "U" -> map.getMapField(x, y).getOperator().getInventory().setResources(new Uranium());
                            case "C" -> map.getMapField(x, y).getOperator().getInventory().setResources(new Carbon());
                            case "I" -> map.getMapField(x, y).getOperator().getInventory().setResources(new Iron());
                            case "W" -> map.getMapField(x, y).getOperator().getInventory().setResources(new WaterIce());
                            case "G" -> map.getMapField(x, y).getOperator().getInventory().setGates(new TeleportationGate());


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
                        if(s1.charAt(0)=='R' || s1.charAt(0)=='S') {
                            if (x1 == x2 && y1 == y2) {
                                map.getMapField(x1, y1).getOperator().setCurrentfield( map.getMapField(x1, y1));
                                map.getMapField(x1, y1).getOperator().Drill(map.getMapField(x2, y2).getAsteroid());
                            } else {
                                System.out.println("Operator and asteroid not in the same position");
                            }
                        }

                    }
                    break;
                    case "mine": {
                        String s1 = splited[1];
                        String s2 = splited[2];
                        int x1 = Character.getNumericValue(s1.charAt(1));
                        int y1 = Character.getNumericValue(s1.charAt(2));
                        int x2 = Character.getNumericValue(s2.charAt(1));
                        int y2 = Character.getNumericValue(s2.charAt(2));
                        if(s1.charAt(0)=='R' || s1.charAt(0)=='S') {
                            if (x1 == x2 && y1 == y2) {
                                Operator op =map.getMapField(x1, y1).getOperator() ;
                                op.setInventory(new Inventory());
                                op.Mine(map.getMapField(x2, y2).getAsteroid(),op.getInventory());
                            } else {
                                System.out.println("cannot mine");
                            }
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
                    break;

                    case "travel": {
                        String s1 = splited[2];
                        String s2 = splited[3];
                        int x = Character.getNumericValue(s1.charAt(0));
                        int y = Character.getNumericValue(s2.charAt(0));
                        int x1 = x + 1;
                        int x2 = x - 1;
                        int y1 = y + 1;
                        int y2 = y - 1;
                        switch (splited[1]) {
                            case "up" -> map.getMapField(x, y).getOperator().Travel(map.getMapField(x, y1), "up");
                            case "down" -> map.getMapField(x, y).getOperator().Travel(map.getMapField(x, y2), "down");
                            case "left" -> map.getMapField(x, y).getOperator().Travel(map.getMapField(x1, y), "left");
                            case "right" -> map.getMapField(x, y).getOperator().Travel(map.getMapField(x2, y), "right");
                        }
                    }
                    break;
                    case "teleport": {
                        String s1 = splited[1];
                        String s2 = splited[2];
                        int x1 = Character.getNumericValue(s1.charAt(1));
                        int y1 = Character.getNumericValue(s1.charAt(2));
                        int x2 = Character.getNumericValue(s2.charAt(1));
                        int y2 = Character.getNumericValue(s2.charAt(2));
                        map.getMapField(x1, y1).getOperator().Teleport(map.getMapField(x2, y2).getAsteroid(), map.getMapField(x2, y2));

                    }
                    break;

                    case "hideresrc": {
                        String s1 = splited[1];
                        String s2 = splited[2];
                        int x1 = Character.getNumericValue(s1.charAt(1));
                        int y1 = Character.getNumericValue(s1.charAt(2));
                        int x2 = Character.getNumericValue(s2.charAt(1));
                        int y2 = Character.getNumericValue(s2.charAt(2));
                        if (x1 == x2 && y1 == y2) {
                            map.getMapField(x1, y1).getOperator().HideResource(map.getMapField(x2, y2).getAsteroid(), map.getMapField(x1, y1).getOperator().getInventory().getResource(0));
                        } else {
                            System.out.println("settler and asteroid not in the same position");
                        }

                            //System.out.println("settler and asteroid not in the same position");

                    }
                    break;
                    case "deploy": {
                        String s1 = splited[1];
                        String s2 = splited[2];
                        int x1 = Character.getNumericValue(s1.charAt(1));
                        int y1 = Character.getNumericValue(s1.charAt(2));
                        int x2 = Character.getNumericValue(s2.charAt(1));
                        int y2 = Character.getNumericValue(s2.charAt(2));
                        if (x1 == x2 && y1 == y2) {
                            map.getMapField(x1, y1).getAsteroid().setGate(map.getMapField(x1, y1).getAsteroid().getGate());

                        } else {
                            System.out.println("settler and asteroid not in the same position");
                        }
                    }
                        break;
                    case "SunStorm": {
                        String s1 = splited[1];
                        String s2 = splited[2];
                        int x1 = Character.getNumericValue(s1.charAt(1));
                        int y1 = Character.getNumericValue(s1.charAt(2));
                        int x2 = Character.getNumericValue(s2.charAt(0));
                        int y2 = Character.getNumericValue(s2.charAt(1));
                        if (x1 == x2 && y1 == y2) {
                            SunStorm s = new SunStorm();
                            map.getMapField(x1, y1).getOperator().setCurrentfield( map.getMapField(x1, y1));
                            map.getMapField(x1, y1).addSunStorm(s);
                            s.Hit(map.getMapField(x1, y1).getOperator());

                        } else {
                            System.out.println("settler is not in sunstorm area");
                        }
                    }
                    break;
                }
            }
        }
    }
}