package app;

import java.util.HashMap;
import calculator.*;

class OperationFactory
{
    static HashMap<String, Operation> inventory = new HashMap<>();

    static {
        inventory.put("+", new Addition()); 
        inventory.put("-", new Subtraction()); 
        inventory.put("*", new Multiplication()); 
        inventory.put("/", new Division()); 
    }
    
    static Operation getComponent(String operation)
    {
        if(inventory.containsKey(operation))
            return inventory.get(operation);
        else
            return null;        
    }

}