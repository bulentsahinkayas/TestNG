package TestNG;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.Assert;

public class _01_TestNGTests {
    @Test
    public void test1() {
        // each test case should have at least one Assertion
        Assert.assertEquals("test", "test");
    }

    @Test
    public void test2() {
        Assert.assertEquals("not test", "test");
    }

    @Test
    public void test3() throws Exception {
        // automatic exception handling
        // any exception here will fail the test

        // something wrong in the code
        throw new Exception();
    }

    @Test
    public void test4() throws Exception {
        // something wrong in the business logic (software under test)
        boolean someCondition = true;
        if (someCondition) {
            Assert.fail("Test failed because of some condition");
        }
    }

}
