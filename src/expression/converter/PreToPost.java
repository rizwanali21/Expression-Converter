/*
       * Devontae Robinson
       * CMSC 350 Project 1
       * 23-03-2021
       * This class contains the code for converting postfix expression to prefix expression.
       * It simply recieves a string, tokenizes it and return the results.
    */
package expression.converter;

import java.util.EmptyStackException;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 *
 * @author iTTaste
 */
public class PreToPost {
    
    //checking that whether it is an operator or not
    private boolean isOperator(String c){
        return c.equals("+")||c.equals("-")||c.equals("*")||c.equals("/");
    }
    
    public String PreToPost(String ex){
        StringTokenizer str=new StringTokenizer(ex,"+ * - /",true);             //tokenizing the string
        Stack<String> reverse=new Stack<>();                                    //stack for reversing
        Stack<String> operand=new Stack<>();                                    //stack for operands
        //Stack<String> operator=new Stack<String>();
        String temp="";
        while(str.hasMoreTokens()){                                             //loop for putting all tokens in a stack
            String s=str.nextToken();
            if(s.equals(" "))continue;                                          //excludes the spaces
            reverse.push(s);
        }
        
        //loop for actual conversion
        while(!(reverse.isEmpty())){
            String c=reverse.pop();
            if(!isOperator(c)){
                operand.push(c);
            }
            else{
                try{
                    temp=operand.pop()+" "+operand.pop()+" "+c;                 //if stack is empty will catch         
                    operand.push(temp);
                }
                catch(EmptyStackException e){                                   //returns if pop from empty stack
                    return "0";
                }
            }
            
        }
        temp=operand.pop();
        if(!(operand.isEmpty())){                                               //if still elements left in the stack
            return "1";
        }
        else
            return temp;
    }
    
    
    
}
