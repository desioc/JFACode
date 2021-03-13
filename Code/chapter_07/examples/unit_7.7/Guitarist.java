public class Guitarist implements BluesSoloist, RockSoloist {
    public void executeSolo() {
       //Pentatonic scale + blues scale in C
        RockSoloist.super.executeSolo();
        BluesSoloist.super.executeSolo();
    }
}