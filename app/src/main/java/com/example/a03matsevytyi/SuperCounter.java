package com.example.a03matsevytyi;

public class SuperCounter {
    int countWords(String inpt){
        int count = 1;
        for(int i = 2; i < inpt.length(); i++){
            if(inpt.charAt(i-1) == ' ' && inpt.charAt(i-2) != ' ' && inpt.charAt(i) != ' ')
                count++;
        }
        return count;
    }

    int countChar(String inpt){
        return inpt.length();
    }
}
