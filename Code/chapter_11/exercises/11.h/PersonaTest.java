public class PersonaTest {
    public static void main(String args[]) {
        System.out.println(new Person("Arjen Anthony","Lucassen","03/04/1960","Composer","Holland") {
            @Override
            public String toString() {
                String string ="Name: \t\t\t"+ getName();
                string +="\nSurname: \t\t"+ getSurname();
                string +="\nOccupation: \t\t"+ getOccupation();
                string +="\nBirth Date \t\t"+ getBirthDate();
                string +="\nAddress: \t\t"+ getAddress();
                return string;
            }
        } );
    }
}