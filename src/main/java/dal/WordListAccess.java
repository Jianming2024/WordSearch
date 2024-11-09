package dal;

import be.WordObj;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WordListAccess {
    private final List<String> wordsList = new ArrayList<>(79685);
    private final File ListFile = new File("C:\\Users\\fanja\\Desktop\\SDE\\Exercises\\week45\\brit-a-z.txt");

    public WordListAccess() {
        try
        {
            Scanner fileReader = new Scanner(ListFile,"ISO-8859-1");
            while (fileReader.hasNextLine())
            {
                String line = fileReader.nextLine();
                wordsList.add(line);
            }
            fileReader.close();
            System.out.println(wordsList.size());
        }
        catch (FileNotFoundException e)
        {
            throw new RuntimeException(e);
        }
    }

    public List<String> getDataSource() {
        return wordsList;
    }


}

