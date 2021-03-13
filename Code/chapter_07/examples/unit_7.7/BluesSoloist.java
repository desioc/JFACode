public interface BluesSoloist extends Soloist {
    default void executeSolo() {
      //Blues scale in C
        System.out.println("C Eb F Gb G Bb C");
    }
}