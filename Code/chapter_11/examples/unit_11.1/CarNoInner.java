public class CarNoInner {
    private String engineState;
    private MechanicNoInner mechanic;

    public CarNoInner () {
        mechanic = new MechanicNoInner(this);
    }

    public void setEngineState(String engineState) {
        this.engineState = engineState;
    }

    public String getEngineState() {
        return engineState;
    }
}