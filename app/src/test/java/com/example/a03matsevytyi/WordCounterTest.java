package com.example.a03matsevytyi;

import org.junit.Assert;
import org.junit.Test;

public class WordCounterTest {
    @Test
    public void testCountWords() {
        SuperCounter counter = new SuperCounter();
        Assert.assertEquals(2, counter.countWords("Hello, World!"));
        Assert.assertEquals(5, counter.countWords("Hello, World! How are you?"));
        Assert.assertEquals(0, counter.countWords(""));
        Assert.assertEquals(0, counter.countWords(" "));
        Assert.assertEquals(1, counter.countWords("word1"));
        Assert.assertEquals(0, counter.countWords("?!"));
        Assert.assertEquals(2, counter.countWords("word1/word2"));
    }

    @Test
    public void testCountChar() {
        SuperCounter counter = new SuperCounter();
        Assert.assertEquals(10, counter.countChar("Hello, World!"));
        Assert.assertEquals(19, counter.countChar("Hello, World! How are you?"));
        Assert.assertEquals(0, counter.countChar(""));
        Assert.assertEquals(0, counter.countChar(" "));
        Assert.assertEquals(5, counter.countChar("word1"));
        Assert.assertEquals(0, counter.countChar("?!"));
        Assert.assertEquals(10, counter.countChar("word1/word2"));
    }
}
