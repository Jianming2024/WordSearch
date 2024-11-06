package easv.dk.wordsearch;

import be.WordObj;
import bll.FileDataLogic;
import bll.WordSearchLogic;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.awt.Color.*;

public class HelloController {
    @FXML
    private Button btnClear;
    @FXML
    private ListView lstHistory;
    @FXML
    private Button btnSearch;
    @FXML
    private TextField txtWord;
    @FXML
    private Label lblResult;
    @FXML
    private Label lblWordsCount;
    @FXML
    private ListView lstWords;
    @FXML
    private ListView lstWordsWithA;
    @FXML
    private ListView lstWordsWithN;

    @FXML
    private final WordSearchLogic wordSearchLogic = new WordSearchLogic();
    private final FileDataLogic fileDataLogic = new FileDataLogic();

    public void initialize() {
        List<String> wordsList = fileDataLogic.getAllWords();
        List<String> wordsListStartWithA = fileDataLogic.getWordsStartWithA();
        List<String> wordsListStartWithN = fileDataLogic.getWordsStartWithN();

        lstWords.getItems().addAll(wordsList);
        //lstWords.setFixedCellSize(20);

        lstWordsWithA.getItems().addAll(wordsListStartWithA);
        lstWordsWithA.setFixedCellSize(20);

        lstWordsWithN.getItems().addAll(wordsListStartWithN);
        lstWordsWithA.setFixedCellSize(20);

        //Show the words count at bottom line.
        lblWordsCount.setText("Total word count: " + wordsList.size());

        displayHistory();
    }

    //show search result.
    public void onClickBtnSearch(ActionEvent actionEvent) {
        if (txtWord.getText().isEmpty()) {
            lblResult.setText("Please enter a word!");
        } else {
            if (wordIsFound()) {
                lblResult.setText("Search result: " + txtWord.getText() + " is found!");
                lstWords.scrollTo(txtWord.getText());
                lstWords.getSelectionModel().select(txtWord.getText());
                boolean isFound = true;
                wordSearchLogic.writeToFile(new WordObj(txtWord.getText().trim()), isFound);

            } else if (!wordIsFound()) {
                lblResult.setText("Search result: " + txtWord.getText() + " is Not found!");
                boolean isFound = false;
                wordSearchLogic.writeToFile(new WordObj(txtWord.getText().trim()), isFound);

            }
            // Save to history and update the display
            displayHistory();

            // Clear the search input
            txtWord.setText("");
        }
    }

    public boolean wordIsFound() {
        List<String> wordsList = fileDataLogic.getData();
        return wordsList.contains(txtWord.getText().trim());
            /*for (String word : wordsList) {
                if (word.equals(txtWord.getText())) {
                    return true;
                }
            }
            return false;*/
    }

    public void displayHistory() {
        lstHistory.getItems().clear(); // Clear current items to prevent duplication
        List<WordObj> historyList = wordSearchLogic.loadData();
        for (WordObj wordObj : historyList) {
            lstHistory.getItems().add(wordObj.getWord());
        }
    }

    public void onClickBtnClear(ActionEvent actionEvent) {
        lstHistory.getItems().clear();
        wordSearchLogic.deleteFile(new WordObj(txtWord.getText().trim()));
    }
}


