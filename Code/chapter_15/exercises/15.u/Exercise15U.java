import java.util.*;
import java.time.*;
import java.text.*;

public class Exercise15U extends TimerTask {
    
    private Timer timer;
    
    public Exercise15U () {
        timer = new Timer();
    }

    @Override
    public void run() {
        DateFormat timeFormatter = DateFormat.getTimeInstance(DateFormat.DEFAULT, Locale.getDefault());
        System.out.println("Wake Up! It's "+ LocalTime.now());
        timer.cancel();
    }

    public static void main(String args[]) throws Exception {
        int seconds = Integer.parseInt(args[0])*1000;
        Exercise15U timerTask = new Exercise15U();
        timerTask.timer.schedule(timerTask, seconds);
    }
}