public class Exercise15H {
    public static void main(String args[]) throws Exception {
        Countdown countdown = new Countdown();
        int seconds = 10;
        if(args.length > 0) {
            try {
                seconds = Integer.parseInt(args[0]); 
            }
            catch (Exception exc) {
                System.out.println("The input must be a positive " +
                "integer number, let’s use the 10 default value...");
            }
        }
        countdown.run(seconds);
    }
}