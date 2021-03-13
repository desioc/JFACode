package com.cdsc.test;

public class ProtectedSubclassWithinPackage extends ProtectedWithinClass {
    public void methodThatUsesProtected() {
        protectedMethod();
        System.out.println(protectedVariable);
    }
}