package org.example.controller;

import jdk.jshell.execution.JdiDefaultExecutionControl;
import org.example.dto.Word;
import org.example.service.WordService;
import org.example.util.ScanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.sql.SQLOutput;
import java.util.concurrent.ForkJoinWorkerThread;

@Controller
public class WordController {
    @Autowired
    private WordService wordService;

    public void start() {
        int act = 1;
        while (act != 0) {
            menu();
            act = ScanUtil.getAction();
            switch (act) {
                case 1 -> {
                    addWord();
                }
                case 2 -> {
                    wordList();
                }
                case 3 -> {
                    multipleChoice();
                }
                case 4 -> {
                    spelling();
                }
                case 5 -> {
                    searching();
                }
                case 6 -> {
                    deleteById();
                }
                case 0 -> {
                    //back
                }
                default -> {
                    System.out.println("Wrong input!!");
                }
            }
        }
    }

    private void deleteById() {
        System.out.print("Enter word id:");
        int id=ScanUtil.scanInt.nextInt();
        wordService.deleteWord(id);
    }

    private void searching() {
        System.out.print("Enter word (including both): ");
        String part=ScanUtil.scanStr.nextLine();
        wordService.searchWord(part);
    }

    private void spelling() {
        Word word=wordService.spelling();
        System.out.println(word.getTranslate());
        System.out.print("Enter spelling: ");
        String str=ScanUtil.scanStr.nextLine();
        wordService.spellingAll(str,word); 
    }

    private void multipleChoice() {
        wordService.multipleList();
    }

    private void wordList() {
        wordService.allList();
    }

    private void addWord() {
        System.out.print("Enter word: ");
        String name = ScanUtil.scanStr.nextLine();

        System.out.print("Enter translate: ");
        String translate = ScanUtil.scanStr.nextLine();
        System.out.print("Enter description: ");
        String description = ScanUtil.scanStr.nextLine();
        Word word = new Word(name.trim(), translate.trim(), description.trim());
        wordService.addWordService(word);
    }

    private void menu() {
        System.out.println("""
                 ********* Menu ********   
                      1. Add Word
                      2. WordList List
                      3. Multiple Choice
                      4. Spelling
                      5. Searching
                      6. Delete by id
                """);
    }
}
