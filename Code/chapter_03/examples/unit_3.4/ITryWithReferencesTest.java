public class ITryWithReferencesTest {
    public static void main(String args[]) {
        ITryWithReferences obj = new ITryWithReferences();
        Date birthday = new Date();
        birthday.day = 14;
        birthday.month = 4;
        birthday.year = 2004;
        obj.changeReference(birthday);
        System.out.println("Birthday = "
            + birthday.day + "-"+ birthday.month
            + "-" +birthday.year );
    }
}