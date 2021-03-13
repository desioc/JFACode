public class MechanicNoInner {
    private CarNoInner car;
    public MechanicNoInner (CarNoInner car){
        this.car = car;
    }
    public void repairEngine() {
        car.setEngineState("good");
    }
}