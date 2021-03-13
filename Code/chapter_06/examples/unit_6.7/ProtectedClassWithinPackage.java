package com.cdsc.test;

public class ProtectedClassWithinPackage {
    public void methodThatUsesProtected() {
        var protectedWithinClass = new ProtectedWithinClass();
        protectedWithinClass.protectedMethod();
        System.out.println(protectedWithinClass.protectedVariable);
    }
}