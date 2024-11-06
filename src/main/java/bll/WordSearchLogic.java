package bll;

import be.WordObj;
import dal.HistoryDataAccess;
import dal.WordListAccess;

import java.util.List;

public class WordSearchLogic {

    static HistoryDataAccess searchResult = new HistoryDataAccess();
    //wordObj wordObj = new WordObj(word);
    static boolean isFound = true;

    public List<WordObj> loadData(){
        List<WordObj> result = searchResult.loadData();
        return result;
    }
    public boolean writeToFile(WordObj obj, boolean isFound){
        return searchResult.writeToFile(obj, isFound);

    }

    public boolean deleteFile(WordObj obj){
        return searchResult.deleteFile(obj);
    }






}
