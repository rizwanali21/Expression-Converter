
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
public class PostToPre {
    
    String temp="";
    
    //checking if operator
    private boolean isOperator(String c){
        return c.equals("+")||c.equals("-")||c.equals("*")||c.equals("/");
    }
    
    public String PostToPre(String ex){
        StringTokenizer str=new StringTokenizer(ex,"+ * - /",true);             //tokenizing
        Stack<String> operand=new Stack<>();                                    //operand stack
        
        //loop till it have more tokens
        while(str.hasMoreTokens()){ 
            String c=str.nextToken();
            if(c.equals(" ")){
                c=c;
            }
            else if(!isOperator(c)){
                operand.push(c);
            }
            else{
                try{                                                             //if stack is empty will catch
                    String op2=operand.pop();
                    String op1=operand.pop();
                    temp=c+" "+op1+" "+op2;
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
