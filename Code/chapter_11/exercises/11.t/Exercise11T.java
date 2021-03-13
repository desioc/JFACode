public enum Exercise11T {
    A, B, C;
    public static class Inner{
        public enum InnerEnum {
            D, E, F;
        }
    }
    public static void main(String args[]) {      
//    for (Exercise11T.Inner.InnerEnum item : Exercise11T.Inner.InnerEnum.values()) {
        for (Inner.InnerEnum item : Inner.InnerEnum.values()) {
            System.out.println(item);
        }
    }
}