public class Employee extends Person { //inheritance
    private int id;

    public void setData(String name, int id) {
      setName(name); //reuse and ereditarietà
      setId(id); //reuse
    }

    public void setId(int id) {
        this.id = id; //encapsulation
    }

    public int getId() {
      return id; //encapsulation
    }

    public String getData() {
         //reuse, encapsulation and inheritance
        return getName() +", id: "+ getId();
    }
}