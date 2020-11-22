import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class HandleTruthTest {

    // Verify key output is correct
    @Test
    public void test1() {
        String msg = "son we live in a world that has walls and those walls have to be guarded by men with guns whos gonna do it you you lieutenant weinberg i have a greater responsibility than you can possibly fathom you weep for santiago and you curse the marines you have that luxury you have the luxury of not knowing what i know that santiagos death while tragic probably saved lives and my existence while grotesque and incomprehensible to you saves lives you dont want the truth because deep down in places you dont talk about at parties you want me on that wall you need me on that wall we use words like honor code loyalty we use these words as the backbone of a life spent defending something you use them as a punchline i have neither the time nor the inclination to explain myself to a man who rises and sleeps under the blanket of the very freedom that i provide and then questions the manner in which i provide it i would rather you just said thank you and went on your way otherwise i suggest you pick up a weapon and stand a post either way i dont give a damn what you think you are entitled to";

        assertEquals("[18, 9, 8, 6, 5, 3, 2, 1]", HandleTruth.wordCount(msg).keySet().toString());

        assertFalse(HandleTruth.wordCount(msg).containsKey(4));
        assertFalse(HandleTruth.wordCount(msg).containsKey(7));
        for (int i = 10; i < 50; i++) {
            if ( i != 18) {
                assertFalse(HandleTruth.wordCount(msg).containsKey(i));
            }
        }
        assertFalse(HandleTruth.wordCount(msg).containsKey(-3));
    }

    // Verify size is correct
    @Test
    public void test2() {
        String msg = "hi hi mango coconut car hi hi";

        assertTrue(HandleTruth.wordCount(msg).size() == 2);
        assertFalse(HandleTruth.wordCount(msg).size() == -1);
        assertFalse(HandleTruth.wordCount(msg).size() == 2.1);

        String msg2 = "hi hi hi hi hi hi hi hi hi hi hi hi man . .";
        assertTrue(HandleTruth.wordCount(msg2).size() == 3);

        String msg3 = " ";
        assertTrue(HandleTruth.wordCount(msg3).size() == 0);
    }

    // Verify value output is correct
    @Test
    public void test3() {
        String msg = ". hot egg quail man man good band hot , . sauce ( ( ( ( ) ) )";
        assertEquals("[[(], [)], [man, hot, .], [egg, band, sauce, ,, good, quail]]", HandleTruth.wordCount(msg).values().toString());
    }

    // CATCHES BUG - The function counts multiple spaces as values
    @Test
    public void test4() {
        String msg = "1           4              4      ";
        assertEquals("[2, 1]", HandleTruth.wordCount(msg).keySet().toString());
        assertEquals("[[4], [1]]", HandleTruth.wordCount(msg).values().toString());
    }

    // CATCHES BUG - Line 9 in HandleTruth fixes this bug
    @Test
    public void test5() {
        String msg = "";
        assertEquals("[]", HandleTruth.wordCount(msg).keySet().toString());
        assertEquals("[]", HandleTruth.wordCount(msg).values().toString());
    }

    @Test
    public void test6() {
        String msg = "                                            ";
        assertEquals("[]", HandleTruth.wordCount(msg).keySet().toString());
        assertEquals("[]", HandleTruth.wordCount(msg).values().toString());
    }

    @Test
    public void test7() {
        String msg = "a";
        assertEquals("[1]", HandleTruth.wordCount(msg).keySet().toString());
        assertEquals("[[a]]", HandleTruth.wordCount(msg).values().toString());
    }

    @Test
    public void test8() {
        String msg = "aa";
        assertEquals("[1]", HandleTruth.wordCount(msg).keySet().toString());
        assertEquals("[[aa]]", HandleTruth.wordCount(msg).values().toString());
    }

    @Test
    public void test9() {
        String msg = "abc";
        assertEquals("[1]", HandleTruth.wordCount(msg).keySet().toString());
        assertEquals("[[abc]]", HandleTruth.wordCount(msg).values().toString());
    }

    @Test
    public void test10() {
        String msg = "a b c";
        assertEquals("[1]", HandleTruth.wordCount(msg).keySet().toString());
        assertEquals("[[a, b, c]]", HandleTruth.wordCount(msg).values().toString());
    }

    // CATCHES BUG - Line 7 in HandleTruth fixes this bug
    @Test
    public void test11() {
        String msg = " a";
        assertEquals("[1]", HandleTruth.wordCount(msg).keySet().toString());
        assertEquals("[[a]]", HandleTruth.wordCount(msg).values().toString());
    }

    @Test
    public void test12() {
        String msg = "a ";
        assertEquals("[1]", HandleTruth.wordCount(msg).keySet().toString());
        assertEquals("[[a]]", HandleTruth.wordCount(msg).values().toString());
    }

    @Test
    public void test13() {
        String msg = " a ";
        assertEquals("[1]", HandleTruth.wordCount(msg).keySet().toString());
        assertEquals("[[a]]", HandleTruth.wordCount(msg).values().toString());
    }

    @Test
    public void test14() {
        String msg = "                     a                       ";
        assertEquals("[1]", HandleTruth.wordCount(msg).keySet().toString());
        assertEquals("[[a]]", HandleTruth.wordCount(msg).values().toString());
    }

}