public class Main {

    public boolean isValid(String s) {

        Stack<Character> st = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            } else {
                if (st.size() == 0) {
                    return false;
                } 
                else if (ch == ')' && st.peek() != '(') {
                    return false;
                }
                 else if (ch == '}' && st.peek() != '{') {
                    return false;
                }
                 else if (ch == ']' && st.peek() != '[') {
                    return false;
                }
                 else {
                    st.pop();
                }
            }
        }
        if (st.size() == 0) {
            return true;
        }
        return false;
    }
}
