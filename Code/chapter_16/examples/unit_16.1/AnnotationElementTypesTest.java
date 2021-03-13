import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Target(ElementType.TYPE)
public @interface AnnotationElementTypesTest {
    enum ProvaEnum{VERO, FALSO} ;
    ProvaEnum annotationElement0() default ProvaEnum.FALSO;
    String annotationElement1() default "A";
    byte annotationElement2()  default '0';
    char[] annotationElement3() default 'A';
    //String[][] annotationElement4(); // Errore! Non è possibile utilizzare array multidimensionali
    //Object[] annotationElement5(); // Errore! Non è possibile utilizzare tipi Object
    Class<Test> annotationElement6();
    @AnnotationElementTypesTest(annotationElement6 = Test.class) class AAA{}
}

