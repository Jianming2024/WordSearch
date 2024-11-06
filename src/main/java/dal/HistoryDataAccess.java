package dal;

import be.WordObj;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HistoryDataAccess {
    private final File HistoryFile = new File("C:\\Users\\fanja\\Desktop\\SDE\\Exercises\\week45\\history.txt");

    public List<WordObj> loadData() {
        List<WordObj> result = new ArrayList<>();
        try {
            Scanner fileReader = new Scanner(HistoryFile);
            while (fileReader.hasNextLine()) {
                String outputStr = fileReader.nextLine();
                result.add(new WordObj(outputStr));
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public boolean writeToFile(WordObj obj, boolean isFound) {
        try {
            FileWriter fw = new FileWriter(HistoryFile.getPath(), true);
            if(isFound) {
                fw.write("Search for " + obj.getWord() + " and found results");
            } else {
                fw.write("Search for " + obj.getWord() + " and NOT found results");

            }
            fw.write("\n");
            fw.close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public boolean deleteFile(WordObj obj) {
        try{
            Files.deleteIfExists(Paths.get(HistoryFile.getPath()));
            return true;

        } catch (IOException e) {
            return false;
        }
    }

}

