package com.claudiodesio.observatory.test;

import com.claudiodesio.observatory.data.Participant;
import com.claudiodesio.observatory.data.Telescope;

public class Observation {

    public static void main(String args[]) {
        Telescope telescope = new Telescope();
        Participant[] participants = getParticipants(telescope);
        for (Participant participant : participants) {
            participant.start();
        }
    }

    private static Participant[] getParticipants(Telescope telescope) {
        Participant[] participants = {
            new Participant("Ciro", telescope),
            new Participant("Gianluca", telescope),
            new Participant("Pierluigi", telescope),
            new Participant("Gigi", telescope),
            new Participant("Nicola", telescope) {
                @Override
                public void run() {
                    System.out.println(getName() + " I'm ready!");
                    super.run();
                }
            },
            new Participant("Pino", telescope),
            new Participant("Maurizio", telescope),
            new Participant("Raffaele", telescope),
            new Participant("Fabio", telescope),
            new Participant("Vincenzo", telescope)};
        return participants;
    }
}