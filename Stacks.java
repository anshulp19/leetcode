/**
 * Created by anshul on 17/03/18.
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;

class Interval {
    private int start;
    private int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }
}

class IntervalComparator implements Comparator<Interval> {
    public int compare(Interval i1, Interval i2){
        return i1.getStart() - i2.getStart();
    }
}

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

    public void NextGreaterElement(int arr[]) {
        Stack<Integer> s = new Stack<>();
        int element, next;

        s.push(arr[0]);

        for(int i = 1; i < arr.length; i++) {
            next = arr[i];

            if(s.isEmpty() == false) {
                element = s.pop();

                while(element < next) {
                    System.out.println(element + " ---> " + next);
                    if(s.isEmpty() == true)
                        break;
                    element = s.pop();
                }

                if(element > next)
                    s.push(element);
            }
            s.push(next);
        }

        while(s.isEmpty() ==false){
            System.out.println(s.pop() + " ---> " + -1);
        }
    }

    private ArrayList<Interval> mergeOverLappingIntervalsUtil(ArrayList<Interval> intervals) {
        if(intervals.size() == 0 || intervals.size() == 1)
            return intervals;

        Collections.sort(intervals, new IntervalComparator());

        Interval first = intervals.get(0);
        int start  = first.getStart();
        int end = first.getEnd();

        ArrayList<Interval> result = new ArrayList<>();

        for(int i = 1; i < intervals.size(); i++) {
            Interval current = intervals.get(i);
            if(current.getStart() <= end) {
                end = Math.max(current.getEnd(), end);
            } else {
                result.add(new Interval(start, end));
                start = current.getStart();
                end = current.getEnd();
            }
        }

        result.add(new Interval(start, end));

        return result;
    }

    public void mergeOverLappingIntervals(){
        ArrayList<Interval> x = new ArrayList<>();

        x.add(new Interval(1, 3));
        x.add(new Interval(2, 6));
        x.add(new Interval(8, 10));
        x.add(new Interval(15, 18));
        x.add(new Interval(17, 20));

        x = mergeOverLappingIntervalsUtil(x);

        for(Interval i : x)
            System.out.println("[" + i.getStart() + ", " + i.getEnd() + "]");
    }

    public int largestRectangleUnderHistogram(int hist[]) {
        Stack<Integer> s = new Stack<>();
        int max_area = 0;
        int tp;
        int area_with_top, i = 0;

        while(i < hist.length) {
            if(s.isEmpty() || hist[s.peek()] <= hist[i])
                s.push(i++);
            else {
                tp = s.peek();
                s.pop();
                area_with_top = hist[tp] * (s.empty() ? i : i - s.peek() - 1);

                if(max_area < area_with_top)
                    max_area = area_with_top;
            }
        }

        while(!s.isEmpty()) {
            tp = s.peek();
            s.pop();
            area_with_top = hist[tp] * (s.empty() ? i : i - s.peek() - 1);

            if (max_area < area_with_top)
                max_area = area_with_top;

        }

        return max_area;
    }

    public int longestValidParentheses(String str) {
        int n = str.length();

        Stack<Integer> s = new Stack<>();
        s.push(-1);

        int result = 0;

        for(int i = 0; i < n; i++) {

            if(str.charAt(i) == '(')
                s.push(i);
            else {
                s.pop();

                if(!s.isEmpty())
                    result = Math.max(result, i - s.peek());
                else
                    s.push(i);

            }
        }

        return result;
    }

    public static void main(String []args) {
        int price[] = {10, 4, 5, 90, 120, 80};
        char exp[] = {'{','(',')','}','[',']'};
        int hist[] = { 6, 2, 5, 4, 5, 1, 6 };
        int S[] = new int[price.length];
        Stacks s = new Stacks();

        /*s.StockSpanProblem(price, S);
        s.printArray(S);*/

        /*if(s.isBalanced(exp))
            System.out.println("Balanced");
        else
            System.out.println("Not Balanced");*/

        // s.NextGreaterElement(price);
        // s.mergeOverLappingIntervals();
        // System.out.println(s.largestRectangleUnderHistogram(hist));

        /*String str = "((()()";
        System.out.println(s.longestValidParentheses(str));

        str = "()(()))))";
        System.out.println(s.longestValidParentheses(str));*/
    }
}
