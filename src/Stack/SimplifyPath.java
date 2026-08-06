package Stack;

import org.junit.jupiter.api.Test;
import java.util.Stack;

public class SimplifyPath {

    @Test
    public void test1() {
        String path = "/home/";
        System.out.println(simplifyPath(path)); // expect "/home"
    }

    @Test
    public void test2() {
        String path = "/home//foo/";
        System.out.println(simplifyPath(path)); // expect "/home/foo"
    }

    @Test
    public void test3() {
        String path = "/home/user/Documents/../Pictures";
        System.out.println(simplifyPath(path)); // expect "/home/user/Pictures"
    }

    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] pieces = path.split("/");

        for (String piece : pieces) {
            if (piece.isEmpty() || piece.equals(".")) {
                continue;
            } else if (piece.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.addLast(piece);
            }
        }

        StringBuilder result = new StringBuilder("/");
        result.append(String.join("/", stack));

        return result.toString();
    }
}