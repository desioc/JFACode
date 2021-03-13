public class Printer<T extends Technology> {
    
    private T technology;
    
    public Printer(T technology){
        this.technology = technology;
    }
    
    public void print(){
        technology.print();
    }
    
}