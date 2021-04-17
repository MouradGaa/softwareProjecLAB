
public class TeleportationGate extends EntityBase {
	private boolean activated;
	private TeleportationGate pair ;

	public void setActivated(boolean activated) {
		this.activated = activated;
	}

	public TeleportationGate(){
		main.WriteFunctionName("New Teleportation gate object is created");
	}
	boolean CheckGatePair() {
		return true;}

	public void setPair(TeleportationGate pair) {
		this.pair = pair;
	}
}
