import java.util.HashMap;
import javax.lang.model.element.Modifier;
public class Modifiers{

    public static  HashMap<String,Modifier> modifiers=new HashMap<>();
    static{
        modifiers.put("public",Modifier.PUBLIC);
        modifiers.put("private", Modifier.PRIVATE);
        modifiers.put("protected", Modifier.PROTECTED);
        modifiers.put("default", Modifier.DEFAULT);
        modifiers.put("static", Modifier.STATIC);
        modifiers.put("final", Modifier.FINAL);
        modifiers.put("synchronised", Modifier.SYNCHRONIZED);
        modifiers.put("abstract", Modifier.ABSTRACT);
    }
}