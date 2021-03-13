import java.util.*;

public class SimpleOptionalTest {
    public static String getUppercaseTitleOpt(String title) {
        Optional<String> opt = Optional.ofNullable(title);
//        return opt.orElse("NO TITLE").toUpperCase();
//        return opt.orElseGet(() ->"NO TITLE").toUpperCase();
        return opt.orElseThrow(IllegalArgumentException::new).toUpperCase();
    }

    public static boolean isJavaTitle(ModifiableObject o) {
        return Optional.ofNullable(o)
        .map(ModifiableObject::getTitle)
        .filter(t -> t.contains("Java"))
        .isPresent();
    }
    
    public static Optional<String> getTitleOpt(ModifiableObject o) {
        return Optional.ofNullable(o.getTitle());
    }

    public static boolean isJavaTitleFM(ModifiableObject o) {
        return Optional.ofNullable(o)
        .flatMap(SimpleOptionalTest::getTitleOpt)
        .filter(t -> t.contains("Java"))
        .isPresent();
    }

    public static String getUppercaseTitle(String title) {
        if (title != null) {
            return  title.toUpperCase();
        }
        return"NO TITLE";
    }

    public static void main(String args[]) {
//        System.out.println(getUppercaseTitle("title"));
//        System.out.println(getUppercaseTitle(null));

        System.out.println(getUppercaseTitleOpt("title"));
        System.out.println(getUppercaseTitleOpt(null)); //lancia l'eccezione

//        ModifiableObject o = new ModifiableObject("Java");
//        System.out.println(isJavaTitle(o));
//        o.saetTitle("SQL");
//        System.out.println(isJavaTitle(o));
//        o.saetTitle(null);
//        System.out.println(isJavaTitle(o));
//        o = null;
//        System.out.println(isJavaTitle(o));

        ModifiableObject o = new ModifiableObject("Java");
        System.out.println(isJavaTitleFM(o));
        o.setTitle("SQL");
        System.out.println(isJavaTitleFM(o));
        o.setTitle(null);
        System.out.println(isJavaTitleFM(o));
        o = null;
        System.out.println(isJavaTitleFM(o));
    }
}