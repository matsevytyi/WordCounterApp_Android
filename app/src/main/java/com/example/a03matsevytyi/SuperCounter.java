package com.example.a03matsevytyi;

public class SuperCounter {
    int countWords(String inpt){
        if(inpt.length() == 0 || !containsLettersOrFigures(inpt))
            return 0;
        inpt = inpt.toLowerCase();
        int count = 1;
        for(int i = 2; i < inpt.length(); i++){
            if((inpt.charAt(i-1) == ' ' && Character.isLetterOrDigit(inpt.charAt(i-2)))
                    || (inpt.charAt(i-2) >= '!' && inpt.charAt(i-2) <= '/')
                    ||(inpt.charAt(i-2) > ':' && inpt.charAt(i-2) <= '@'))
                count++;
        }
        return count;
    }

    int countChar(String inpt){
        inpt = inpt.toLowerCase();
        int result = 0;
        for(char i : inpt.toCharArray()){
            if(Character.isLetterOrDigit(i))
                result++;
        }
        return result;
    }

    private boolean containsLettersOrFigures(String str) {
        for (char c : str.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                return true;
            }
        }
        return false;
    }
}
