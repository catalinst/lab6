package isp.lab6.exercise2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dictionary {
    private static Dictionary dictionary = new Dictionary();
    private Map<Word, WordDescription> descriptionByWords = new HashMap<>();

    private Dictionary() {
    }

    public static Dictionary getDictionary() {
        return dictionary;
    }

    public Map<Word, WordDescription> getDescriptionByWords() {
        return descriptionByWords;
    }

    public void setDescriptionByWords(Map<Word, WordDescription> descriptionByWords) {
        this.descriptionByWords = descriptionByWords;
    }

    public boolean addWord(Word word, WordDescription wordDescription) {
        if (descriptionByWords.containsKey(word)) { // case that word exists in dictionary

            if (wordDescription.getSynonyms().containsAll(descriptionByWords.get(word).getSynonyms())) {
                descriptionByWords.put(word, wordDescription);
                return true;
            } else {
                return false;
            }

        } else { // case that word not exists in dictionary
            descriptionByWords.put(word, wordDescription);
            return true;
        }
    }

    public boolean deleteWord(Word word) {
        WordDescription description = descriptionByWords.get(word);
        return descriptionByWords.remove(word, description);
    }

    public WordDescription searchWord(Word word) {
        return descriptionByWords.get(word);
    }

    public List<Word> findSynonyms(Word word) {
        return descriptionByWords.get(word).getSynonyms();
    }

    @Override
    public String toString() {
        return "Dictionary{" +
                "descriptionByWords=" + descriptionByWords +
                '}';
    }
}
