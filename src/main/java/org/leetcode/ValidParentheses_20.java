package org.leetcode;

public class ValidParentheses_20 {
    public static void main(String[] args) {

        isValid("[{}]");
    }

    public static boolean isValid(String s) {
        Stack head = null;

        for (char i: s.toCharArray()) {
            if (head == null) {
                head = new Stack(i, null);
            } else  {
                if (i == ']' || i == '}') {
                    if (head.value == i - 2) {
                        head = head.next;
                    }
                    else return false;
                } else if (i == ')') {
                    if (head.value == i - 1) {
                        head = head.next;
                    }
                    else return false;
                } else {
                    Stack old = head;
                    head = new Stack(i, null);
                    head.next = old;
                };
            }
        }
        return head == null;
    }

    public static class Stack{
        public char value;
        public Stack next;

        public Stack(){};

        public Stack(char value, Stack next) {
            this.next = next;
            this.value = value;
        }
    }
}
