package TestNGAsserts;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.util.Random;

public class _01_TestNGAsserts {
    @Test
    public void assertEquals(){
        String[] actual = {"Hello","2"};
        String[] expected = {"Hello","2"};
        Assert.assertEquals(actual,expected,"Actual should be equal to expected");
    }
    @Test
    public void assertEqualNoOrder(){
        String[] actual = {"Hello","2"};
        String[] expected = {"2","Hello"};
        Assert.assertEqualsNoOrder(actual,expected,"Actual should be equal to expected");
    }
    @Test
    public void assertNotEquals(){
        String[] actual = {"Hello","2"};
        String[] expected = {"2","Hello"};
        Assert.assertNotEquals(actual,expected,"Actual should be equal to expected");
    }
    @Test
    public void assertNotEquals2() {
        int actual = 1;
        int expected = 2;
        Assert.assertNotEquals(actual, expected, "Actual should be not equal to Expected");
    }

    @Test
    public void assertNotEquals3() {
        double actual = 1.1;
        double expected = 1.09;
        double delta = 0.04;
        Assert.assertNotEquals(actual, expected, delta, "Actual should be not equal to Expected");
    }
    @Test
    public void assertNotNull() {
        Object o = someFunctionThatMightProduceNull();
        Assert.assertNotNull(o, "O should not be null");
        o.toString();
    }

    private Object someFunctionThatMightProduceNull() {
        boolean returnNullOrNot = new Random().nextBoolean();
        return returnNullOrNot ? null : new Object();
    }

    @Test
    public void assertSame() {
        String actual = "Hello";
        String expected = "Hello";
        Assert.assertSame(actual, expected, "Actual should point to same object");
    }

    @Test
    public void assertSame2() {
        String actual = "Hello";
        String expected = new String("Hello");
        Assert.assertSame(actual, expected, "Actual should point to same object");
    }
    @Test
    public void assertNotSame1() {
        String actual = "Hello";
        String expected = "Hello";
        Assert.assertNotSame(actual, expected, "Actual should point to same object");
    }
    @Test
    public void assertNotSame2() {
        String actual = new String("Hello");
        String expected = new String("Hello");
        Assert.assertNotSame(actual, expected, "Actual should point to same object");
    }
    @Test
    public void assertTrue() {
        boolean actual = isDataAvailable();
        Assert.assertTrue(actual);
    }

    @Test
    public void assertFalse() {
        boolean actual = isDataAvailable();
        Assert.assertFalse(actual);
    }

    private boolean isDataAvailable() {
        return new Random().nextBoolean();
    }

    @Test
    public void assertTrueHowNOTtoUSE() {
        String actual = "Hi";
        String expected = "Hello";
        Assert.assertTrue(actual == expected);
    }

    @Test
    public void assertTrueHowNOTtoUSE2() {
        String actual = "Hi";
        String expected = "Hello";
        Assert.assertTrue(actual.equals(expected), "Actual should be equal to expected!");
    }

    @Test
    public void assertEqualsHowToUSE() {
        String actual = "Hi";
        String expected = "Hello";
        Assert.assertEquals(actual, expected);
    }
    @Test
    public void assertFail() {
        if (!isDataAvailable()) {
            Assert.fail("The data should be available before continuing the test");
        }
    }

    @Test
    public void assertFailWrapper() {
        try {
            throw new Exception("Custom Exception Message");
        } catch (Exception e) {
            Assert.fail("The test failed because we caught an exception", e);
        }
    }

    @Test
    public void failureTest() throws Exception {
        throw new Exception("Custom Exception Message");
    }

    @Test
    public void softAssert() {
        String actual = "Hello";

        org.testng.asserts.SoftAssert sf = new org.testng.asserts.SoftAssert(); // use soft assert if you want to continue testing even though some of the assertions are failing already
        sf.assertEquals(actual, "hello"); // equal to hello
        sf.assertEquals(actual.length(),  0); // length equal to 0
        sf.assertEquals(actual.charAt(0), 'C'); // that it start with capital C

        sf.assertAll(); // will check every assertion and throw an exception if any assertion fails
    }

    @Test
    public void hardAssert() {
        String actual = "Hello";
        Assert.assertEquals(actual, "hello"); // equal to hello
        Assert.assertEquals(actual.length(),  0); // length equal to 0
        Assert.assertEquals(actual.charAt(0), 'C'); // that it start with capital C
    }
}
