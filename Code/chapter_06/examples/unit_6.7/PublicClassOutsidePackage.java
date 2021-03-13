package com.cdsc;

import com.cdsc.test.*;

public class PublicClassOutsidePackage {
    public void methodThatUsesPublic() {
        var publicWithinClass = new PublicWithinClass();
        publicWithinClass.publicMethod();
        System.out.println(publicWithinClass.publicVariable);
    }
}