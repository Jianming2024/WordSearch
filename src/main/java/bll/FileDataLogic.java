package bll;

import dal.WordListAccess;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.List;

public class FileDataLogic {

    private final WordListAccess wordsList = new WordListAccess();

    public List<String> getData(){
        return wordsList.getDataSource();
    }

    public List<String> getAllWords()
    {
        List<String> allWords = wordsList.getDataSource();
        return allWords;
    }

    public List<String> getWordsStartWithA(){
        List<String> allWords = wordsList.getDataSource();
        List<String> wordsStartWithA = new ArrayList<>();
        for(String word: allWords) {
            if (word.startsWith("a")) {
                wordsStartWithA.add(word);
            }
        }
        return wordsStartWithA;
    }

    public List<String> getWordsStartWithN(){
        List<String> allWords = wordsList.getDataSource();
        List<String> wordsStartWithN = new ArrayList<>();
        for(String word: allWords) {
            if (word.startsWith("n")) {
                wordsStartWithN.add(word);
            }
        }
        return wordsStartWithN;
    }

}
