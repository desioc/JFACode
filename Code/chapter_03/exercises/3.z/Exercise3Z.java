public class Exercise3Z {
    public static void main(String args[]) {
        Student student1 = new Student("Giovanni","Battista","5A");
        String [][] tabellaVoti1 = {
            {"English","7","Does not engage too much."}, 
            {"Maths","9","He is very fit for this subject."} , 
            {"History","7","He could do more."} , 
            {"Geography","8","Passionate."} ,
            {"French","9", "Able to support dialogues."},
            {"Physical Education and Sports","6", "Vote of encouragement."},
            {"Music","7", "He has passion for the subject."}
        };
        ReportCard reportCard1 = new ReportCard (student1, tabellaVoti1);

        Student student2 = new Student("Daniele","Sapore","2A");
        String [][] tabellaVoti2 = {
            {"English","8","He shows enthusiasm for the subject."}, 
            {"Maths","5","Not at all interested."} , 
            {"History","6","Interested, but makes little effort."} , 
            {"Geography","6","He could do more."} ,
            {"French","8", "Excellent pronunciation."},
            {"Physical Education and Sports","7", "A bit lazy."},
            {"Music","9", "He plays different instruments and has a great voice."}
        };
        
        ReportCard reportCard2 = new ReportCard (student2, tabellaVoti2);
        
        reportCard1.printReportCard();
        reportCard2.printReportCard();
        
    }
}