import java.util.*;

public class CommandRedirect{
    static List cmdDefineClass=Arrays.asList("define a class","define class","define necklace","define applause","define oculus","define across","define iglas","define a glass","define akash","define atlas");
    static List cmdSave=Arrays.asList("save","save save","shape","Save","safe","Safe","sev","Sev","sabe","seb","zev","saif");
    static List cmdRun=Arrays.asList("run","Run","ranch","kiran","ran","rang");
    static List cmdPrint=Arrays.asList("print message","print message print message","print message print message print message","print","print print","print statement","print statement print statement","print statement print statement print statement","print log");
    static List cmdAddMethod=Arrays.asList("add a method","Add a method","add method","add function","atom method","at a method","at method");
    static List cmdAddMain=Arrays.asList("add main method","add main","Add Main","Add main","ad mean","admin","at main");
    static List cmdAddVar=Arrays.asList("add variable","add a variable","at variable","at a variable","admirable");
    static List cmdChangeContext=Arrays.asList("change context","context change","change the context","Change the context","Change context");
    static List cmdCallFunction=Arrays.asList("call function","call","call method");
    

    public static int redirectCommand(String s)throws Exception{
        if (cmdDefineClass.contains(s)) {
            return Actions.defineClass();
        } 
        else if(cmdSave.contains(s)){
            return Actions.saveFile();
        }
        else if(cmdRun.contains(s)){
            return Actions.executeFile();
        }
        else if(cmdPrint.contains(s)){
            return Actions.printMessage();
        }
        else if(cmdAddMethod.contains(s)){
            return Actions.addMethodToClass();

        }else if(cmdAddVar.contains(s)){
            return Actions.addVariable();
        }
        else if(cmdAddMain.contains(s)){
            return Actions.addMainMethod();
        }
        else if(cmdChangeContext.contains(s)){
            return Actions.changeContext();
        }
        else if(cmdCallFunction.contains(s)){
            return Actions.callFunction();
        }
        else {
            System.out.println("\"" + s + "\" is not a valid command");
            return 0;
        }
    }
}