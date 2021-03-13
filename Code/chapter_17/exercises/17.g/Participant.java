package com.claudiodesio.observatory.data;

import com.claudiodesio.observatory.metadata.Status;

public class Participant extends Thread {

    private Status status;

    private final Telescope telescope;

    public Telescope getTelescope() {
        return telescope;
    }

    public Participant(String name, Telescope telescope) {
        setName(name);
        this.telescope = telescope;
        this.setStatus(Status.WAITING);
        status();
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public void run() {
        telescope.allowObservation(this);
    }
    
    public void status(){
        System.out.println(getName() + " says: " + status.getMessage());
    }
}