public class OuterProp5 {
    private String outerString = "JAVA";
    public void outerMethod() {
        int intLocal = 7;
        StringBuilder sbLocal = new StringBuilder("Andrea");
        int array [] = {intLocal} ;
        class Inner {
            public void innerMethod() {
//                System.out.println(outerString+ " " + (++intLocal));
                System.out.println(outerString +" "+ (++array[0]));
//                sbLocal = new StringBuffer("Simone");
                sbLocal.append("Simone");
            }
        }
    }
}