public class BankAccount {
    private String money ="5000000 Euro";
    private int code = 1234;
    private int insertedCode;
    public void setInsertedCode(int cod) {
        insertedCode = cod;
    }
    public int getInsertedCode() {
        return insertedCode;
    }
    public String getMoney() {
        if (insertedCode == code) {
            return money;
        }
        else {
            return"wrong code!!!";
        }
    }
 //   . . .
}