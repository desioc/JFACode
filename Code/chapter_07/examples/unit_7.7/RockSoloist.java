public interface RockSoloist extends Soloist {
    default void executeSolo() {
       //Pentatonic scale in c
        System.out.println("C D E G A C");
    }
}