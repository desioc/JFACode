public enum Exercise11S {
    A, B, C;
    public class Inner{
        public static enum InnerEnum {
            D, E, F;
        }
    }
    public static void main(String args[]) {      
        for (Exercise11S.Inner.InnerEnum item : Exercise11S.Inner.InnerEnum.values()) {
            System.out.println(item);
        }
    }
}