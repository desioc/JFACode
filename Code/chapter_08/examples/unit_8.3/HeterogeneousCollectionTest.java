public class HeterogeneousCollectionTest {
    public static void main(String args[]) {
//        Employee [] programmers = new Programmer[60];
        Employee [] arr = new Employee [180];
        arr[0] = new Manager();
        arr[1] = new Programmer();
        arr[2] = new SalesAgent();
        //...
        for (int i = 3; i < 180; i++) {
            arr[i] = new Programmer();
        }

        HeterogeneousCollectionTest obj = new HeterogeneousCollectionTest();
        for (Employee employee : arr) {
            obj.payEmployee(employee);
        }
    }

    public void payEmployee(Employee emp) {
        if (emp instanceof Programmer) {
            emp.setSalary(1500);
        }
        else if (emp instanceof Manager) {
            emp.setSalary(3000);
        }
        else if (emp instanceof SalesAgent) {
            emp.setSalary(1000 +emp.getSalary()  );
        }
        System.out.println(emp.getClass().getName() + " - Salary = " + emp.getSalary());
        //. . .
    }
}