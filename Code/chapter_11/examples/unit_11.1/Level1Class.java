public class Level1Class {
    private int levelVariable = 1;
    class Level2Class {
        private int levelVariable = 2;
        class Level3Class {
            private int levelVariable = 3;
            private void testThis() {
                System.out.println(Level1Class.this.levelVariable);
                System.out.println(Level2Class.this.levelVariable);
                System.out.println(this.levelVariable);
            }
        }
    }
    public static void main(String args[]) {
        Level1Class l1 = new Level1Class();
        Level1Class.Level2Class l2 = l1.new Level2Class();
        Level1Class.Level2Class.Level3Class l3 = l2.new Level3Class();
        l3.testThis();
    }
}