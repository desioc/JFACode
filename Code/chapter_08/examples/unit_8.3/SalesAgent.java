public class SalesAgent extends Employee {
    private String [] customerPortfolio;
    private int commissions;

    public void setCommissions(int commissions) {
        this.commissions = commissions;
    }

    public int getCommissions() {
        return commissions;
    }


    public void setCustomerPortfolio(String [] customerPortfolio) {
        this.customerPortfolio = customerPortfolio;
    }

    public String [] getCustomerPortfolio() {
        return customerPortfolio;
    }
}