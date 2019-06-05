package tests.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import tests.tests.TextAnalytics;

public class TextAnalyticsTest{

    @Test
    public void testIfWrongFilepathIsHandled(){
        TextAnalytics analytics = new TextAnalytics("/");
        String text = analytics.readFile();
        assertTrue(true);

    }

    @Test
    public void testIfFileContentIsEmpty(){
        TextAnalytics analytics = new TextAnalytics("/");
        String text = analytics.readFile();
        assertNull(text);
    }

    @Test
    public void testIfFunctionReturnsSimilarContent(){
        String path = "C:\\Users\\Rando\\Desktop\\java\\kodutoo java\\artiklikogumik.txt";
        TextAnalytics analytics = new TextAnalytics(path);
        String content = analytics.readFile();
        assertEquals(content, analytics.readFile());

    }

    @Test
    public void TestIfItHasWords(){
        TextAnalytics analytics = new TextAnalytics("tere isa");
        String[] words = analytics.cutTextIntoWords();
        assertNotNull(words);
        assertTrue(words.length > 1);
    }

    @Test
    public void TestIfEmptyTextIsHandled(){
        TextAnalytics analytics = new TextAnalytics("");
        String[] words = analytics.cutTextIntoWords();
        assertTrue(true);
    }

    @Test
    public void testIfOutputIsTheSame(){
        String text = "tere tere vana kere";
        TextAnalytics analytics = new TextAnalytics(text);
        String[] words = analytics.cutTextIntoWords();
        assertEquals(words, analytics.cutTextIntoWords());

    }


    @Test
    public void testIfEmptyStringIsHandledCorrectly(){
        String text = "";
        TextAnalytics analytics = new TextAnalytics(text);
        assertTrue(analytics.countWordsWithHash() == "");
    }

    @Test
    public void testIfResultsAreSimilar(){
        String text = "ye ya da";
        TextAnalytics analyticsCaseOne = new TextAnalytics(text);
        TextAnalytics analyticsCaseTwo = new TextAnalytics(text);
        assertEquals(analyticsCaseOne.countWordsWithHash(), analyticsCaseTwo.countWordsWithHash());
    }

    @Test
    public void testIfEmptyTextIsNotGivingErrorsWhenTurningIntoLowercase(){
        String text = "SAABAS";
        TextAnalytics analytics = new TextAnalytics(text);
        analytics.returnInLowercase();
        assertTrue(true);
    }

    @Test
    public void testIfLowercasingWorks(){
        String textInUppercase = "SAABAS LIND";
        String textInLowercase = "saabas lind";
        TextAnalytics analyticsUpper = new TextAnalytics(textInUppercase);
        TextAnalytics analyticsLower = new TextAnalytics(textInLowercase);
        assertEquals(analyticsLower.returnInLowercase(), analyticsUpper.returnInLowercase());
    }

    @Test
    public void testIfLowercasingSymbolsWorks(){
        String text = "☛ ♞";
        TextAnalytics analytics = new TextAnalytics(text);
        analytics.returnInLowercase();
        assertTrue(true);
    }

}