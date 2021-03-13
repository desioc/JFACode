public class Exercise2R_OK {

    public int var1;
    public int var2;
    
    public Exercise2R_OK(){
        
    }
    
    public Exercise2R_OK(int a , int b){
        var1 = b;
        var2 = a;
    }

    public static void main(String args[]){
        Exercise2R_OK exercise2R = new Exercise2R_OK(4,7);
        System.out.println(exercise2R.var1);
        System.out.println(exercise2R.var2);
    }
  
}