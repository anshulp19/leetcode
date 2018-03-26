/**
 * Created by anshul on 17/03/18.
 */
import java.util.Stack;

public class Stacks {
    public void StockSpanProblem(int price[], int S[]) {
        Stack<Integer> st = new Stack<>();
        st.push(0);
        S[0] = 1;

        for(int i = 1; i < price.length; i++) {
            while(!st.empty() && price[st.peek()] <= price[i])
                st.pop();
            S[i] = (st.empty()) ? (i + 1) : (i - st.peek());
            st.push(i);
        }
    }

    public void printArray(int arr[]) {
        for(int item: arr)
            System.out.print(item + " ");
        System.out.println();
    }

    private boolean isMatchingPair(char exp1, char exp2) {
        if(exp1 == '(' && exp2 == ')')
            return true;
        else if(exp1 == '{' && exp2 == '}')
            return true;
        else if(exp1 == '[' && exp2 == ']')
            return true;
        return false;
    }

    public boolean isBalanced(char exp[]) {
        Stack<Character> st = new Stack<>();

        for(int i = 0; i < exp.length; i++){
            if(exp[i] == '(' || exp[i] == '{' || exp[i] == '[')
                st.push(exp[i]);

            if(exp[i] == ')' || exp[i] == '}' || exp[i] == ']') {
                if(st.empty())
                    return false;
                else if(!isMatchingPair(st.pop(), exp[i]))
                    return false;
            }
        }
        if(st.empty())
            return true;
        return false;
    }

    public static void main(String []args) {
        int price[] = {10, 4, 5, 90, 120, 80};
        char exp[] = {'{','(',')','}','[',']'};
        int S[] = new int[price.length];
        Stacks s = new Stacks();

        /*s.StockSpanProblem(price, S);
        s.printArray(S);*/

        /*if(s.isBalanced(exp))
            System.out.println("Balanced");
        else
            System.out.println("Not Balanced");*/
    }
}
