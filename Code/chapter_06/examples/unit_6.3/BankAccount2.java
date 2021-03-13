public class BankAccount2 {
    private String money = "5000000 Euro";
    private int code = 1234;
    private int insertedCode;
    public void setInsertedCode(int cod) {
        insertedCode = cod;
    }
    public String getMoney(int codeToCheck) {
        return checkCode(codeToCheck);
    }
    private String checkCode(int codeToCheck) {
        if (codeToCheck == code) {
            return money;
        }
        else {
            return "wrong code!!!";
        }
    }
}