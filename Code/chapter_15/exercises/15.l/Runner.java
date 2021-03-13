public class Runner extends Thread {
    
    private boolean goAhead;
    
    private boolean inAction;
    
    private int gap;
    
    public Runner(){
        inAction = true;
        gap = 1000;
    }

    public void run() {
        while (inAction) {
            try {
                Thread.sleep(gap);
                if (goAhead) {
                    System.out.println("|");
                    Thread.sleep(gap);
                    System.out.println("  |");
                }
            } catch (InterruptedException exc) {
                assert false;
            }
        }
    }
    
    public void startTraining() {
        start();
    }

    public void startRunning() {
        System.out.println("Ok, let's go...");
        gap = 400;
        goAhead = true;
    }

    public void takeABreath() {
        System.out.println("Ok, I'm standing here.");
        System.out.println("| |");
        goAhead = false;
    }

    public void walk() {
        System.out.println("Ok, I'm, walking...");
        gap = 1000;
        goAhead = true;
    }

    public void stopTraining(){
        System.out.println("Good! I couldn't take it anymore...");
        inAction = false;
    }
    
    public void cannotUnderstand(String command){
        System.out.println("Sorry! I cannot understand the command " + command +  "\nPlease use only run, walk, stop or end");
        inAction = true;
    }
}