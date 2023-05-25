/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sudhanshu
 */
import py4j.GatewayServer;

import java.util.ArrayList;
import java.util.Set;

import javax.lang.model.element.Modifier;

import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeName;


public class CodeGenerator {
    static CodeEditorFrame codeEditorFrame;
    static GatewayServer gatewayServer;

    public static void main(String[] args) {
        gatewayServer = new GatewayServer(new CodeGenerator());
        gatewayServer.start();
        System.out.println("JVM started");
    }

    public static void startCodeEditor() {
        codeEditorFrame = CodeEditorFrame.main(new String[] {});
    }

    public static void finishCodeEditor() {
        codeEditorFrame.dispose();
    }

    public void shutdownJVM() {
        System.out.println("Shutting down JVM");
        new Thread(new Runnable() {
            public void run() {
                gatewayServer.shutdown();
            }
        }).start();
    }

    public int processText(String s) throws Exception {
       return CommandRedirect.redirectCommand(s);
    }

    public int setClassName(String cName)throws Exception{
        Actions.className=cName;
        return Actions.defineClass();
    }

    public int setClassModifier(String modifierName)throws Exception{
        if(modifierName.equals("public")){
            Actions.modifier=Modifier.PUBLIC;
        }else if(!modifierName.equals("default")){
            System.out.println("class modifier can either be public or default, try again");
            return ReturnCodes.REQUEST_CLASS_MODIFIER;
        }
        return Actions.defineClass();
    }

    public int printMsg(String s)throws Exception{
        Actions.printMsg=s;
        return Actions.printMessage();
    }

    public int setMethodName(String s)throws Exception{
        Actions.methodName=s;
        return Actions.addMethodToClass();
    }

    public int setMethodReturnType(String s)throws Exception{
        TypeName typeName=DataTypes.dataTypes.get(s);
        if(typeName!=null){
            Actions.methodReturnType=typeName;
            return Actions.addMethodToClass();
        }else{
            System.out.println("\""+s+"\" is not a valid type, try again");
            return ReturnCodes.REQUEST_METHOD_RETURN_TYPE;
        }
    }

    public int setMethodParameterType(String s)throws Exception{
        TypeName typeName=DataTypes.dataTypes.get(s);
        if(typeName!=null){
            Actions.methodParaType=typeName;
            return Actions.addMethodToClass();
        }else{
            System.out.println("\""+s+"\" is not a valid type, try again");
            return ReturnCodes.REQUEST_METHOD_PARAMETER_TYPE;
        }
    }

    public int setMethodParameterName(String s)throws Exception{
        Actions.methodParameterName=s;
        return Actions.addMethodToClass();
    }

    public int setVarType(String s)throws Exception{
        TypeName typeName=DataTypes.dataTypes.get(s);
        if(typeName!=null){
            Actions.varType=typeName;
            return Actions.addVariable();
        }else{
            System.out.println("\""+s+"\" is not a valid type, try again");
            return ReturnCodes.REQUEST_VARIABLE_TYPE;
        }
    }

    public int setVarName(String s)throws Exception{
        Actions.varName=s;
        return Actions.addVariable();
    }
    
    public int setVarModifier(String s)throws Exception{
        Modifier temp=Modifiers.modifiers.get(s);
        if(temp!=null){
            Actions.varModifier=temp;
            return Actions.addVariable();    
        }else{
            System.out.println("\""+s+"\" is not a valid modifier, try again");
            return ReturnCodes.REQUEST_VARIABLE_MODIFIER;
        }
        
    }

    public int setMethodToCall(String s)throws Exception{
        MethodSpec.Builder temp=Actions.methodList.get(s);
        if(temp==null){
            System.out.println("\""+s+"\" is not a valid method name, try again");
            return ReturnCodes.REQUEST_FUNCTION_TO_CALL;
        }else{
            Actions.methodToCall=s;
            return Actions.callFunction();
        }
    }
    public int setWantMoreParameters(String s)throws Exception{
        if(s.equals("yes"))
        Actions.wantMoreParameters=true;
        else if(s.equals("no"))
        Actions.wantMoreParameters=false;
        else{
            System.out.println("\""+s+"\" is not a valid response, try again");
            return ReturnCodes.REQUEST_WANT_MORE_PARAMETERS;
        }
        return Actions.addMethodToClass();
    }

    public int changeContext(String s){
        MethodSpec.Builder temp=Actions.methodList.get(s);
        if(temp==null){
            System.out.println("\""+s+"\" is not a valid context, try again");
            return ReturnCodes.REQUEST_CONTEXT_NAME;
        }else{
            Actions.currentMBuilder=temp;
            return ReturnCodes.TASK_SUCCESSFUL;
        }
    }

}
