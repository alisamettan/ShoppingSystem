package org.example.util;

import java.util.Random;

public class RandomCodeGenerator {

    public static String generateRandomCode(){
        String characters="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789*_?!^+%&/.:,;";
        Random random=new Random();

        StringBuilder code=new StringBuilder(10);

        int i=0;

        while(i<10){
            int index=random.nextInt(characters.length());
            code.append(characters.charAt(index));
            i++;
        }

        return code.toString();
    }

}