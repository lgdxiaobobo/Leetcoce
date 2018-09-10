import java.util.ArrayList;
import java.util.HashSet;

public class Solution {
    public int evalRPN(String[] tokens) {
        
        HashSet<String> op_set = new HashSet<String>();
        op_set.add("+");
        op_set.add("-");
        op_set.add("*");
        op_set.add("/");
        
        ArrayList<Integer> stack = new ArrayList<Integer>();
        int last_index = -1;
        
        for (String op: tokens){
            if (op_set.contains(op)){
                int val1 = stack.get(last_index--);
                int val2 = stack.get(last_index--);
                int p = operation(val1, val2, op);
                last_index ++;
                stack.add(last_index, p);
            }
            else{
                last_index ++;
                stack.add(last_index, Integer.parseInt(op));
            }
        }        
        
        return stack.get(0);
    }

    public int operation(int val1, int val2, String op) {
        
        if (op.equals("+")) return val1 + val2;
        if (op.equals("-")) return val2 - val1;
        if (op.equals("*")) return val1 * val2;
        if (op.equals("/")) return val2 / val1;
        
        return 0;
    }
}