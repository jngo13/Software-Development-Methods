//Lab 4
//RandomWords.java

import java.util.Random;

public class RandomWords {
    static int collisions; 
    public static void main(String[] args) {
     
        
        String[] words1 = generateRandomWords(300);
        String[] words2 = generateRandomWords(500);
        String[] words3 = generateRandomWords(700);
        String[] hash1 = getHashTable(words1);
        //System.out.println(hash1);
        System.out.println("Hash1: " + collisions);
        String[] hash2 = getHashTable(words2);
        //System.out.println(hash2);
        System.out.println("Hash2: " + collisions);
        String[] hash3 = getHashTable(words3);
        //System.out.println(hash3);
        System.out.println("Hash3: " + collisions);
        /*for(String s : randomStrings) {
            hashFunction(s);
        }*/
    }

    //A static method that takes in the number or words you would like in your array of 
    //random words.  Each word is between 3 and 10 characters in length and contain only
    //lower case letters.  
    public static String[] generateRandomWords(int numberOfWords)
    {
        String[] randomStrings = new String[numberOfWords];
        Random random = new Random();
        for(int i = 0; i < numberOfWords; i++)
        {
            char[] word = new char[random.nextInt(8)+3]; // Words of length 3 through 10. (Because 1 and 2 letter words are boring.)
            for(int j = 0; j < word.length; j++)
            {
                word[j] = (char)('a' + random.nextInt(26));
            }
            randomStrings[i] = new String(word);
        }
        return randomStrings;
    }
    
    private static int hashFunction (String s) {
        char[] letters = s.toCharArray();
        int ascii = 0;
        for(char letter : letters) {
            ascii += (int) letter;
        }
        return ascii%500;
    }
    
    public static String[] getHashTable(String[] words) {
        String[] hash = new String[500];
        collisions = 0;
        for(int i = 0; i < words.length; i++) {
            int hashnum = hashFunction(words[i]);
            //System.out.println(hashnum);
            if(hashnum > 500) {System.out.println("position" + i + "failed");}
            while(!(hash[hashnum] == null)) {
                hashnum++;
                collisions++;
                if(hashnum > 499) {
                    hashnum = 0;
                }
            }
            hash[hashnum] = words[i];
        }
        return hash;
    }
}
