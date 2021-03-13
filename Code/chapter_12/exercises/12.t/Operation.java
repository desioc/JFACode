public class Operation<Integer, O extends Operator> {
    
    private Integer operand1;
    private O operator;
    private Integer operand2;   
    
    public Operation(Integer operand1, O operator, Integer operand2) {
        this.operand1 = operand1;
        this.operator = operator;
        this.operand2 = operand2;
    }
    
    public void print(){
        System.out.println(operand1  +  " " + operator +  " " + operand2);
    }
}