package StringOccurences;

import org.junit.jupiter.api.Test;

public class FindIndexOfFirstOccurence {
    @Test
    public void test1(){
        String haystack="sadbudsad";
        String needle="sad";
        int op=findIndexFirstOccu(haystack, needle);
        System.out.println(op);

    }
   public int findIndexFirstOccu(String haystack, String needle){
        int h=haystack.length();
        int n= needle.length();
       for (int i = 0; i <=h-n; i++) {
           if(haystack.substring(i,i+n).equals(needle)){
               return i;
           }
       }
        return -1;
   }
}
