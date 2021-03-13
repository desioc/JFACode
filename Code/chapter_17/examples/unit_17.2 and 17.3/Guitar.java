public class Guitar {
    private String brand;
    public Guitar (){}
    public Guitar (String brand){
        this.brand = brand;
        System.out.println("Guitar created: " + brand);
    }

    public void play(){
        System.out.printf("I'm playing a %s ...", brand);;
    }
}