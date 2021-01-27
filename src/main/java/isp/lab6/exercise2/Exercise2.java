package isp.lab6.exercise2;

import java.util.ArrayList;
import java.util.List;

public class Exercise2 {
    public static void main(String[] args) {
        Dictionary dictionary = Dictionary.getDictionary();

        Word word1 = new Word("potato");
        List<Word> synonyms1 = new ArrayList<>();
        synonyms1.add(new Word("white"));
        synonyms1.add(new Word("red"));
        WordDescription wordDescription1 = new WordDescription("veg", synonyms1);

        dictionary.addWord(word1, wordDescription1);

        Word word2 = new Word("car");
        List<Word> synonyms2 = new ArrayList<>();
        synonyms2.add(new Word("engine"));
        synonyms2.add(new Word("doors"));
        synonyms2.add(new Word("wheels"));
        WordDescription wordDescription2 = new WordDescription("electric", synonyms2);

        dictionary.addWord(word2, wordDescription2);

        System.out.println(dictionary.findSynonyms(new Word("potato")));
        System.out.println(dictionary.searchWord(new Word("potato")));
        System.out.println(dictionary);
        System.out.println("------");
        System.out.println(dictionary.deleteWord(new Word("potato")));
        System.out.println(dictionary);

        System.out.println("----------------------------------");

        List<Word> synonyms3 = new ArrayList<>();
        synonyms3.add(new Word("engine"));
        synonyms3.add(new Word("doors"));
        synonyms3.add(new Word("wheels"));
        synonyms3.add(new Word("turbo"));
        WordDescription wordDescription3 = new WordDescription("electric", synonyms3);
        System.out.println(dictionary.addWord(word2, wordDescription3));
        System.out.println(dictionary);
    }
}
