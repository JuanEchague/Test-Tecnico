package com.juandelsol.testtecnico;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PhoneWordEncoderTests {
     ////////////////////////Atributes///////////////////////////////////////
          private String[] replacements = {"2 ", "22 ", "222 ", "3 ", "33 ", "333 ", "4 ", "44 ", "444 ", "5 ", "55 ", "555 ", "6 ", "66 ", "666 ", "7 ", "77 ", "777 ", "7777 ", "8 ", "88 ", "888 ", "9 ", "99 ", "999 ", "9999 ","0 "};
     
     ///////////////////////////////Methods/////////////////////////////////////
    
    public String encodeText(char[] chars, String original, String[] replacements) {
        StringBuilder sb = new StringBuilder(chars.length);
        for (char c : chars) {
            int index = original.indexOf(c);
            if (index >= 0) {
                sb.append(replacements[index]);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
    
    @Test
    void testEncodeText() {
assertEquals("44 444 ", encodeText("hi".toLowerCase().toCharArray(), "abcdefghijklmnopqrstuvwxyz ", replacements));
assertEquals("999 33 7777 ", encodeText("yes".toLowerCase().toCharArray(), "abcdefghijklmnopqrstuvwxyz ", replacements));
assertEquals("333 666 666 22 2 777 ", encodeText("foobar".toLowerCase().toCharArray(), "abcdefghijklmnopqrstuvwxyz ", replacements));
assertEquals("44 33 555 555 666 9 666 777 555 3 ", encodeText("helloworld".toLowerCase().toCharArray(), "abcdefghijklmnopqrstuvwxyz ", replacements));
assertEquals("333 666 666 3 0 22 2 777 ", encodeText("food bar".toLowerCase().toCharArray(), "abcdefghijklmnopqrstuvwxyz ", replacements));
    }
}
