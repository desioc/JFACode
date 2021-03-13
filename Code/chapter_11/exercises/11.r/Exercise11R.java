public enum Exercise11R implements Interface {
    ONE {
        @Override
        public int method() {
            return 29 + 7 + 74;
        }
    } ,
    TWO, 
    THREE{
        @Override
        public int method() {
            return 12 + 11 + 6;
        }
    };
    @Override
    public int method() {
        return 14 + 4 + 4;
    }

    public static void main(String args[]) {
        Interface i = Exercise11R.THREE;
        System.out.println(i.method());    
    }
}

interface Interface {
    int method();
}