package SlidingWindow;

import org.junit.jupiter.api.Test;


import java.util.*;

public class FindAllAnagrams {

    @Test
    public void test1(){
        String s = "cbaebabacd", p = "abc";
        List<Integer> op = findAnagrams(s,p);
        System.out.println(op);

    }
    /*
    -- initialise an empty list called result
-- initialise pLen as length of p

-- convert p into a character array called pArr
-- sort pArr                              (sorted form = canonical signature of p's letters)

-- traverse i from 0 to (s.length - pLen)      (every possible window start)

--   extract substring window = s[i .. i+pLen-1]
--   convert window into a character array called ch
--   sort ch                              (sorted form = canonical signature of this window)

--   if ch equals pArr                    (same letters, same counts, just compared as sorted arrays)
--     add i to result                    (this window is an anagram of p)

-- return result
     */
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
       int pLen= p.length();
        char[] pArr = p.toCharArray();
        Arrays.sort(pArr);
        for (int i = 0; i <=s.length()-pLen; i++) {
           String window= s.substring(i,i+pLen);
          char[] ch= window.toCharArray();
          Arrays.sort(ch);

          if(Arrays.equals(pArr,ch)){
              result.add(i);
          }
        }
        return result;
    }
}
