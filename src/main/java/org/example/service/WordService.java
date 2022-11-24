package org.example.service;

import org.example.dto.Word;
import org.example.repository.WordRepository;
import org.example.util.ScanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class WordService {
    @Autowired
    private WordRepository wordRepository;

    public void addWordService(Word word) {
        if (word.getName().length() == 0 || word.getTranslate().length() == 0 || word.getDescription().length() == 0) {
            System.out.println("Mazgi word is empty something!!!!");
            return;
        }
        if (wordRepository.getWord(word) != null) {
            System.out.println("Is exist word !!");
            return;
        }
        int n = wordRepository.addWordRepository(word);
        if (n == 0) {
            System.out.println("Not add!!");
            return;
        }
        System.out.println("Word add list");
    }

    public void allList() {
        List<Word> words = wordRepository.getAllWord();
        for (Word word : words) {
            System.out.println(word);
        }
    }

    public void multipleList() {
        Map<Character, String> variant = new HashMap<>();
        char[] c = {'a', 'b', 'c', 'd'};
        List<Word> words = wordRepository.getAllWord();
        int random = random();
        int rand = getIntRandAns();
        for (int i = 0; i < words.size(); i++) {
            if (random == i) {
                System.out.println(words.get(i).getName());
            }

        }

        for (int i = 0; i < c.length; i++) {
            System.out.println(c[i] + ")" + variant.get(c[i]));
        }
        System.out.print("Enter variant: ");
        char car = ScanUtil.scanChar.next().charAt(0);
        String name = variant.get(car);
        for (int i = 0; i < words.size(); i++) {
            if (words.get(random).getTranslate().equals(name)) {
                System.out.println("tug'ri javob!!");
                return;
            }
        }
        System.out.println("xato javob!");
    }

    public void searchWord(String part) {
        List<Word> words = wordRepository.getSearchWord(part);
        for (Word w : words) {
            System.out.println(w);
        }
    }

    public int getIntRandAns() {
        Random random = new Random();
        return random.nextInt(0, 4);
    }

    public int random() {
        List<Word> words = wordRepository.getAllWord();
        Random random = new Random();
        return random.nextInt(0, words.size());
    }

    public void deleteWord(int id) {
        int n = wordRepository.deleteWord(id);
        if (n == 0) {
            System.out.println("No delete word!!");
            return;
        }
        System.out.println("Delete word");

    }

    public Word spelling() {
        List<Word> words = wordRepository.getAllWord();
        return words.get(random());
    }

    public void spellingAll(String str, Word word) {
        if (word.getName().equals(str)) {
            System.out.println("To'g'ri javob!!");
            return;
        }
        System.out.println("Xato  javob!!");
    }
}
