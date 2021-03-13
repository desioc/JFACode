public class Action {
    private String name;
    public static final Action FORWARD = new Action("FORWARD");
    public static final Action BACK = new Action("BACK");
    public static final Action STOP = new Action("STOP");
    public Action(String name){
        setName(name);
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
}