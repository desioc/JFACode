public class ITryWithReferencesTest2 {
    public static void main(String args[]) {
        ITryWithReferences2 obj = new ITryWithReferences2();
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