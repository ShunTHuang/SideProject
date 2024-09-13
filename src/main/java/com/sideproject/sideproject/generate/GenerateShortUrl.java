package com.sideproject.sideproject.generate;

public class GenerateShortUrl {
    private static char[] charList= new char[]{
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'
    };

    private static int charSize = charList.length;

    public static String generateShortUrl(String url){
        StringBuilder sb = new StringBuilder();
        int hash =  url.hashCode();
        long number = hash < 0 ? Integer.MAX_VALUE - (long)hash: hash;
        while (number > 0) {
            int index = (int) (number % charSize);
            sb.append(charList[index]);
            number /= charSize;
        }
        return sb.toString();
    }
}