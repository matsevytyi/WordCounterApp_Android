package com.example.a03matsevytyi;

public class SuperCounter {
    int countWords(String inpt){
        int count = 1;
        for(int i = 2; i < inpt.length(); i++){
            if((inpt.charAt(i-1) == ' ' && inpt.charAt(i-2) != ' ' && inpt.charAt(i) != ' ')
                    || (inpt.charAt(i-2) >= '!' && inpt.charAt(i-2) <= '/')
                    ||(inpt.charAt(i-2) > ':' && inpt.charAt(i-2) <= '@'))
                count++;
        }
        return count;
    }

    int countChar(String inpt){
        inpt = inpt.toLowerCase();
        int result = 0;
        for(int i = 0; i < inpt.length(); i++){
            if((inpt.charAt(i) >= 'a' && inpt.charAt(i) <= 'z')
                || (inpt.charAt(i) >= '0' && inpt.charAt(i) <= '9'))
                result++;
        }
        return result;
    }
}
