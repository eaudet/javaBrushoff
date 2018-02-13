package com.jarics.nashorn;

/**
 * Nashorn calls javascript from java and vise-vers-ca.
 * Source: https://www.tutorialspoint.com/java8/java8_nashorn_java_script.htm
 */

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class NashornTest {

    public static void main(String args[]){

        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine nashorn = scriptEngineManager.getEngineByName("nashorn");

        String name = "Mahesh";
        Integer result = null;

        try {
            nashorn.eval("print('" + name + "')");
            result = (Integer) nashorn.eval("10 + 2");

        }catch(ScriptException e){
            System.out.println("Error executing script: "+ e.getMessage());
        }



        System.out.println(result.toString());
    }
}
