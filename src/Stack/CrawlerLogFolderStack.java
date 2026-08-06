package Stack;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Stack;

public class CrawlerLogFolderStack {

    @Test
    public void test1() {
        List<String> logs = List.of("d1/", "d2/", "../", "d21/", "./");
        System.out.println(minOperations(logs)); // expect 2
    }

    @Test
    public void test2() {
        List<String> logs = List.of("d1/", "d2/", "./", "d3/", "../", "d31/");
        System.out.println(minOperations(logs)); // expect 3
    }

    @Test
    public void test3() {
        List<String> logs = List.of("d1/", "../", "../", "../");
        System.out.println(minOperations(logs)); // expect 0
    }

    public int minOperations(List<String> logs) {
        /*
        * GOAL: find the minimum number of "../" operations needed to return
        *        to the main folder, using a stack to simulate the folder path

        * initialize an empty stack

        * traverse each log in logs
            * if log equals "../":
                - if stack is NOT empty:
                    - pop the stack (go up one directory level)
                - (if stack is empty, do nothing — already at main folder)

            * else if log equals "./":
                - do nothing (stay in place)

            * else:
                - push log onto the stack (moved into a child folder)

        * after processing all logs, the stack's SIZE represents how many
          levels deep we are — that's exactly the number of "../" operations
          needed to climb back to the main folder

        * return stack.size()
        */

        Stack<String> stack = new Stack<>();

        for (String log : logs) {
            if (log.equals("../")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (log.equals("./")) {
                // stay in place, do nothing
            } else {
                stack.push(log);
            }
        }

        return stack.size();
    }
}