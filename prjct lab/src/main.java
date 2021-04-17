import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        while (true) {
            //Parts
            Scanner scanner = new Scanner(System.in);
            System.out.println("1-Mourad");
            System.out.println("2-bor3i");
            System.out.println("3-kahlanzou");
            System.out.println("4-bouzir");
            int member = scanner.nextInt();
            switch (member) {
                //mourad
                //travel
                //hide resources
                //Die
                case 1: {
                    System.out.println("Choose scenario");
                    System.out.println("1-Travel scenario");
                    System.out.println("2-Hide Resources scenario");
                    System.out.println("3-Operator removed scenario");
                    int scenario = scanner.nextInt();

                    switch (scenario) {
                        case 1: {
                            // operator travels scenario
                            System.out.println("Travel scenario");
                            // Initialization
                            Settler settler = new Settler();
                            Asteroid a1 = new Asteroid();
                            Asteroid a2 = new Asteroid();
                            settler.setAsteroid(a1);
                            // starting the sequence
                            settler.Travel(a2);
                        }
                            break;
                        case 2 :
                        {
                            //operator Hides Resources scenario
                            System.out.println("Hide resources scenario");
                            // Initialization
                            Settler settler = new Settler() ;
                            Asteroid a = new Asteroid(1) ;
                            Inventory i = new Inventory() ;
                            Carbon c = new Carbon() ;
                            i.setResources(c);
                            settler.setInventory(i);
                            settler.setAsteroid(a);
                            //starting the sequence
                            settler.HideResource(a,i.getResource(0)) ;

                        }
                            break ;
                        case 3 :
                        {
                            //Settler dies scenario
                            System.out.println("Operator removed scenario");
                            // Initialization
                            Settler settler = new Settler() ;
                            Asteroid asteroid = new Asteroid() ;
                            Field field = new Field(settler,asteroid) ;
                            settler.setAsteroid(asteroid);
                            settler.setCurrentfield(field);
                            asteroid.addSettler(settler);
                            //starting the sequence
                            System.out.println("Is the settler dead ?");
                            System.out.println("1-Yes");
                            System.out.println("2-No");
                            int msg = scanner.nextInt();
                            if(msg==1)
                            {
                            settler.Die() ;
                            }
                            else
                            {
                                System.out.println("Settler is not dead, you can't remove it from the game");
                            }

                        }
                        break ;

                        default :

                        }
                    }
                    break ;
                case 2:
                    System.out.println("Choose scenario");
                    //bor3i
                    break;
                case 3: {
                    // Yassine
                    System.out.println("Choose scenario");
                    System.out.println("1-Build gate scenario");
                    System.out.println("2-Deploy gate scenario");
                    System.out.println("3-Asteroid explode scenario");
                    System.out.println("4-Teleport scenario");
                    System.out.println("5-Win scenario");
                    int scenario = scanner.nextInt();
                    switch (scenario) {
                        case 1: {
                            // Build gate scenario
                            System.out.println("build gate scenario ");
                            // Initialization
                            Settler settler = new Settler();
                            Factory f = new Factory();
                            Inventory i = new Inventory();
                            Iron iron = new Iron();
                            WaterIce waterIce = new WaterIce();
                            Uranium uranium = new Uranium();
                            i.setResources(iron);
                            i.setResources(waterIce);
                            i.setResources(uranium);
                            settler.setInventory(i);

                            // starting the sequence
                            System.out.println("Does the settler have 2 unit of iron, 1 unit of waterIce and 1 unit of uranium ? ");
                            System.out.println("1- yes");
                            System.out.println("2- no");
                            int res = scanner.nextInt();
                            if(res==1)
                            {
                                settler.BuildGate(f);
                                TeleportationGate teleportationGate = new TeleportationGate();
                                i.Gates.add(teleportationGate);

                            }
                            else
                            {
                                System.out.println("Not enough resources to build the gate");
                            }
                        }
                        break;
                        case 2: {
                            //Deploy gate scenario scenario

                            System.out.println("Deploy gate scenario scenario");
                            // Initialization
                            Settler settler = new Settler();
                            Asteroid a = new Asteroid();
                            TeleportationGate teleportationGate = new TeleportationGate();
                            settler.setAsteroid(a);
                            //starting the sequence
                            System.out.println("\n");
                            settler.DeployGate(teleportationGate);
                            System.out.println("Is the parallel gate deployed ?");
                            System.out.println("1- yes");
                            System.out.println("2- no");
                            int res = scanner.nextInt();
                            if(res==1)
                            {
                                teleportationGate.setActivated(true);
                                System.out.println("gate pair are activated");

                            }
                            else
                            {
                                System.out.println("Gate is not activated yet");
                            }
                        }
                        break;
                        case 3: {
                            //3-Asteroid explode scenario"
                            System.out.println("3-Asteroid explode scenario\"");
                            // Initialization
                            Settler settler = new Settler();
                            Asteroid asteroid = new Asteroid();
                            MaterialBase mb = new MaterialBase();
                            Field field = new Field(settler,asteroid) ;
                            WaterIce waterIce = new WaterIce();
                            settler.setAsteroid(asteroid);
                            settler.setCurrentfield(field);
                            //starting the sequence
                            asteroid.getDepth();
                            System.out.println("GetDepth() method is called\n");
                            System.out.println("Is the asteroid drilled through?");
                            System.out.println("1-Yes");
                            System.out.println("2-No");
                            int res = scanner.nextInt();
                            if (res == 1) {

                                System.out.println("is the asteroid radioactive ?");
                                System.out.println("1-Yes");
                                System.out.println("2-No");
                                int rest = scanner.nextInt();
                                if (rest == 1) {
                                    System.out.println("The asteroid at aphelion or perihelion ?");
                                    System.out.println("1-perihelion");
                                    System.out.println("2-aphelion");
                                    int result = scanner.nextInt();
                                    if (result == 1) {
                                        asteroid.explode();
                                        System.out.println("Is the settler on the asteroid and not hidden");
                                        System.out.println("1-Yes");
                                        System.out.println("2-No");
                                        int resut = scanner.nextInt();
                                        if (resut == 1)
                                            settler.Die();
                                    } else {
                                        System.out.println("Nothing happens to the asteroid");
                                    }
                                }
                                else {
                                    System.out.println("The asteroid at aphelion or perihelion ?");
                                    System.out.println("1-perihelion");
                                    System.out.println("2-aphelion");
                                    int check = scanner.nextInt();
                                    if (check == 1) {
                                        waterIce.Sublimate();
                                    } else {
                                        System.out.println("Nothing happens to the asteroid");
                                    }
                                }
                            } else {
                                System.out.println("Nothing happens to the asteroid");
                            }

                        }

                        case 4: {
                            // operator teleport scenario
                            System.out.println("operator teleport scenario");
                            // Initialization
                            Settler settler = new Settler();
                            Asteroid a1 = new Asteroid();
                            Asteroid a2 = new Asteroid();
                            TeleportationGate g1 = new TeleportationGate();
                            TeleportationGate g2 = new TeleportationGate();
                            settler.setAsteroid(a1);
                            // starting the sequence
                            g1.CheckGatePair();
                            System.out.println("Are the gate pair activated?");
                            System.out.println("1-Yes");
                            System.out.println("2-No");
                            int result = scanner.nextInt();
                            if (result == 1) {
                                settler.Teleport(g2);
                                settler.CollideWith(g2);
                                settler.setAsteroid(a2);
                            } else {
                                System.out.println("Can not teleport");
                            }
                        }
                        case 5: {
                            // Win scenario
                            System.out.println("Win scenario");
                            // Initialization
                            Inventory i = new Inventory();
                            Iron iron = new Iron();
                            Carbon c = new Carbon();
                            WaterIce waterIce = new WaterIce();
                            Uranium uranium = new Uranium();
                            i.setResources(iron);
                            i.setResources(c);
                            i.setResources(waterIce);
                            i.setResources(uranium);
                            Map map = new Map();
                            // starting the sequence
                            System.out.println("Does the settler have 3 unit of each resource ? ");
                            System.out.println("1- yes");
                            System.out.println("2- no");
                            int res = scanner.nextInt();
                            if(res==1)
                            {
                                map.Win();
                            }
                            else
                            {
                                System.out.println("Not enough resources to Win");
                            }
                        }
                        break;
                        default:

                    }
                }
                    break;
                case 4:
                    System.out.println("Choose scenario");
                    //bouzir
                    break;

            }

        }
    }
        public static void WriteFunctionName (String s )
        {
            System.out.println(s);
        }

}
