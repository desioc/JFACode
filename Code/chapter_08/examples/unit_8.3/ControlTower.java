public class ControlTower {
    public void authorizeLanding(Flying v) {
        v.land();
    }
    
    public void authorizeTakeOff(Flying v) {
        v.takeOff();
    }
}