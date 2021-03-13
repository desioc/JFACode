public class CustomerVarArgs {
    private String name;
    private String address;
    private String phoneNumber;

    public CustomerVarArgs(String... par) {
        if (par != null) {
            if (par[0] != null) {
                this.name = par[0];
            }
            if (par[1] != null) {
                this.address = par[1];
            } if (par[2] != null) {
                this.phoneNumber = par[2];
            }
        }
    }
//    . . .
} 