import org.junit.Assert;
import org.junit.Test;


public class TestDivision {

    @Test
    public void testSimpleDx() {
        var fraction = TestUtils.createFraction(15, 5);
        var result = fraction.dividedBy(new NotImplementedFraction(3, 5));

        Assert.assertEquals((Integer) 5, result.getNumerator());
        Assert.assertEquals((Integer) 1, result.getDenominator());
    }

    @Test
    public void testNormalisationxD() {
        var fraction = TestUtils.createFraction(3, 5);
        var result = fraction.dividedBy(new NotImplementedFraction(3, 5));

        Assert.assertEquals((Integer) 1, result.getNumerator());
        Assert.assertEquals((Integer) 1, result.getDenominator());
    }
}
