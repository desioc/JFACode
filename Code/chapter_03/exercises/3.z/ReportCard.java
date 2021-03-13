import java.util.Arrays;

public class ReportCard {
    public Student student;
    public String[][] tableOfVotes;
    
    public ReportCard (Student stu, String [][] tab){
        student = stu;
        tableOfVotes = tab;        
    }
    
    public void printReportCard() {
        System.out.println(student.toString());
        System.out.println(Arrays.toString(tableOfVotes[0]));
        System.out.println(Arrays.toString(tableOfVotes[1]));
        System.out.println(Arrays.toString(tableOfVotes[2]));
        System.out.println(Arrays.toString(tableOfVotes[3]));
        System.out.println(Arrays.toString(tableOfVotes[4]));
        System.out.println(Arrays.toString(tableOfVotes[5]));
        System.out.println(Arrays.toString(tableOfVotes[6]));
    }
}