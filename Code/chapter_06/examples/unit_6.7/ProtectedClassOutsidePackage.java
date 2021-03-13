package com.cdsc;

import com.cdsc.test.*;

public class ProtectedClassOutsidePackage {
    public void methodThatUsesProtected() {
        var protectedWithinClass = new ProtectedWithinClass();
        protectedWithinClass.protectedMethod();
        System.out.println(protectedWithinClass.protectedVariable);
    }
}