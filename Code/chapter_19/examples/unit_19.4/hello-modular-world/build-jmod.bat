javac -d mods/cdsc.mymodule src/cdsc.mymodule/cdsc/mymodule/* src/cdsc.mymodule/module-info.java
jmod create -class-path mods/cdsc.mymodule hello.jmod
pause;