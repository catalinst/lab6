package isp.lab6.exercise2;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class DictionaryTest {

    Dictionary dictionary = Dictionary.getDictionary();
    Word word = new Word("good");
    List<Word> synonyms = new ArrayList<>();
    WordDescription wordDescription = new WordDescription("benefit or advantage to someone or something", synonyms);

    @Before
    public void init() {
        synonyms.add(new Word("fine"));
        synonyms.add(new Word("ethical"));
        synonyms.add(new Word("superior"));
        dictionary.addWord(word, wordDescription);
    }


    @Test
    public void testAddWord() {
        Word word = new Word("test");
        WordDescription wordDescription = new WordDescription("to test something", null);
        boolean result = dictionary.addWord(word, wordDescription);
        assertTrue("Adding should be fine", result);
    }

    @Test
    public void testDeleteWord() {
        boolean result = dictionary.deleteWord(word);
        assertTrue("The world should be removed", result);
    }

    @Test
    public void testSearchWord() {
        assertEquals("Should be the same word", dictionary.getDescriptionByWords().get(word), dictionary.searchWord(word));
    }

    @Test
    public void testFindSynonyms() {
        assertEquals("Should be all synonyms", dictionary.getDescriptionByWords().get(word).getSynonyms(), dictionary.findSynonyms(word));
    }
}