public class ToCompleteImpl implements ToComplete {
    private String description;
    private String assignedTo = "yet to assign";
    public String description() {
        return description;
    }
    public String assignedTo() {
        return assignedTo;
    }
}

interface ToComplete{}