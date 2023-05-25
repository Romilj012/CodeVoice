import java.util.*;
import com.squareup.javapoet.*;
public class DataTypes{
    public static HashMap<String,TypeName> dataTypes=new HashMap<>();
    static{
        dataTypes.put("int", TypeName.INT);
        dataTypes.put("ent", TypeName.INT);
        dataTypes.put("inte", TypeName.INT);
        dataTypes.put("ant", TypeName.INT);
        dataTypes.put("ENT", TypeName.INT);
        dataTypes.put("char", TypeName.CHAR);
        dataTypes.put("double",TypeName.DOUBLE);
        dataTypes.put("long",TypeName.LONG);
        dataTypes.put("float", TypeName.FLOAT);
        dataTypes.put("fruit",TypeName.FLOAT);
        dataTypes.put("void", TypeName.VOID);
        dataTypes.put("white",TypeName.VOID);
        dataTypes.put("wide",TypeName.VOID);
        dataTypes.put("string",TypeName.get(String.class));
        dataTypes.put("object", TypeName.get(Object.class));
        dataTypes.put("integer",TypeName.get(Integer.class));
        dataTypes.put("character", TypeName.get(Character.class));
        
    }
}