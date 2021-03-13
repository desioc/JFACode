public class Pilot {
    private String name;

    public Pilot (String name) {
        this.name = name;
    }

    public void go(Flying flying) {
        flying.takeOff();
        flying.glide();
        flying.land();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    @Override
    public String toString(){
        return getName();
    }
}