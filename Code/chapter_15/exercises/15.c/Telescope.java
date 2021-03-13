package com.claudiodesio.observatory.data;

import com.claudiodesio.observatory.metadata.Status;

public class Telescope {

    public synchronized void allowObservation(Participant participant) {
        participant.setStatus(Status.OBSERVATION);
        participant.status();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        participant.setStatus(Status.DONE);
        participant.status();
    }
}