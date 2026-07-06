package DuplicateAndUniqueStrings;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class ReturnUniqueCharacteInString {

    @Test
    public void test1(){
        String s1="this is my test string";
        String op1=uniqueCharacter(s1);
        System.out.println(op1);
        String op2=uniqueCharacter1(s1);
        System.out.println(op2);

    }



    private String uniqueCharacter(String s1) {
        StringBuilder op= new StringBuilder();

        for (int i = 0; i < s1.length(); i++) {
            boolean found =false;
            for (int j = 0; j < s1.length() ; j++) {
                if(i!=j&& s1.charAt(i)==s1.charAt(j)){
                    found=true;
                    break;
                }
            }
            if(!found) {
                op.append(s1.charAt(i));
            }
        }

        return op.toString();
    }

    private String uniqueCharacter1(String s1) {
       char[] c= s1.toCharArray();
        StringBuilder op= new StringBuilder();
        Set<Character> seen= new HashSet<>();
        Set<Character> duplicates= new HashSet<>();
        for (Character n:c){
            if(seen.contains(n)){
                duplicates.add(n);
            }else {
                seen.add(n);
            }
        }
        for (Character n: c){
            if(!duplicates.contains(n)){
                op.append(n);
            }

    }
        return op.toString();

}}
