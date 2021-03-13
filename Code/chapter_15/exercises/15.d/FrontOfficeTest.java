package com.claudiodesio.frontoffice.test;

import com.claudiodesio.frontoffice.data.Applicant;

public class FrontOfficeTest {
    
    public static void main(String args[]){
        final Applicant[] richiedenti = getApplicants();
        for (Applicant applicant : richiedenti) {
            applicant.start();
        }
    }
    
    private static Applicant[] getApplicants() {
        Applicant[] applicants = {
            new Applicant("Ciro"),
            new Applicant("Mario"),
            new Applicant("Massimo"),
            new Applicant("Chicco"),
            new Applicant("Enrico"),
            new Applicant("Lorenzo"),
            new Applicant("Emanuele"),
            new Applicant("Cosimo"),
            new Applicant("Alessandro"),
            new Applicant("Salvatore")};
        return applicants;
    }
}