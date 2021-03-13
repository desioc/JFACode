package com.cdsc;

import com.cdsc.test.*;

public class ProtectedSubclassOutsidePackage extends ProtectedWithinClass {
    public void methodThatUsesProtected() {
        protectedMethod();
        System.out.println(protectedVariable);
    }
/* public void invalidMethod() {
        var pic = new ProtectedWithinClass();
        pic.protectedMethod();
    } */
}