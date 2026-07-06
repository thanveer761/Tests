package CommonAndUnCommonWords;

import org.junit.jupiter.api.Test;

import java.util.*;

public class UncommonWords {
    @Test
    public void test1(){
        String s1="this is my book";
        String s2="this is his bag";
        String[] op=uncommonWords(s1,  s2);
        System.out.println(Arrays.toString(op));
    }

    private String[] uncommonWords(String s1, String s2) {
        Map<String, Integer> map = new TreeMap<>();
        for (String word:s1.split(" ")){
            map.put(word, map.getOrDefault(word,0)+1);
        }
        for (String word:s2.split(" ")){
            map.put(word, map.getOrDefault(word,0)+1);
        }
        List<String> ls= new ArrayList<>();
        for (Map.Entry<String,Integer>mn: map.entrySet()){
if(mn.getValue()==1){
    ls.add(mn.getKey());
}
        }
return ls.toArray(new String[0]);
    }
}
