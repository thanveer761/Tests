package DuplicateAndUniqueStrings;

import org.junit.jupiter.api.Test;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Arrays;

public class RemoveDuplicateCharacter {
    @Test
    public void test1(){
        String s ="Thanveer Ahmed";
        String op= removeDups(s);
        System.out.println(op);
        String op1= removeDups1(s);
        System.out.println(op1);
        String op2= removeDupsUsingTwoPointer(s);
        System.out.println(op2);
    }

    private String removeDups(String s) {

       String m =s.replace(" ", "");
        Set<Character>  sm = new LinkedHashSet<>();
        for (char c: m.toCharArray()){
            sm.add(c);
        }
        return sm.toString();
    }
    private String removeDups1(String s) {

        String m =s.replace(" ", "");
       String op="";
        for (int i = 0; i <m.length() ; i++) {
            boolean bMatch=false;
            for (int j = 0; j <i; j++) {
                if(m.charAt(i)==m.charAt(j)){
                    bMatch=true;
                    break;
                }

            }
            if (!bMatch) op+=m.charAt(i);
        }
        return op;
    }
    private String removeDupsUsingTwoPointer(String s) {
        String m =s.replace(" ", "");
        char[] ch = m.toCharArray();
        boolean[] seen = new boolean[256];

        int left = 0, right = ch.length - 1;
        while (left <= right) {
            if (!seen[ch[left]]) {
                seen[ch[left]] = true;
                left++;
            } else {
                // duplicate found at left -- pull in a char from the right boundary
                char temp = ch[left];
                ch[left] = ch[right];
                ch[right] = temp;
                right--;
                // don't move left -- recheck the newly swapped-in character
            }
        }

        return new String(Arrays.copyOf(ch, left));
    }
}
