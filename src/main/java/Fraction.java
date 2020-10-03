public class Fraction implements IFraction {

    private final Integer numerator;
    private final Integer denominator;

    public Fraction(Integer numerator, Integer denominator) {
        this.numerator = numerator; //čitatel
        this.denominator = denominator; //jmenovatel

        if (denominator == 0) throw new ArithmeticException("Cannot Divide by 0");
    }

    @Override
    public Integer getNumerator() {
        return numerator;
    }

    @Override
    public Integer getDenominator() {
        return denominator;
    }

    @Override
    public IFraction plus(IFraction other) {
        int spolJmen = getDenominator() * other.getDenominator();
        int newCitatel = (getNumerator() * other.getDenominator()) + (other.getNumerator() * getDenominator());
        return createNormalised(newCitatel, spolJmen);
    }

    @Override
    public IFraction minus(IFraction other) {
        int spolJmen = getDenominator() * other.getDenominator();
        int newCitatel = (getNumerator() * other.getDenominator()) - (other.getNumerator() * getDenominator());
        return createNormalised(newCitatel, spolJmen);
    }

    @Override
    public IFraction times(IFraction other) {
        int newCitatel = getNumerator() * other.getNumerator();
        int newJmen = getDenominator() * other.getDenominator();
        return createNormalised(newCitatel, newJmen);
    }

    @Override
    public IFraction dividedBy(IFraction other) {
        int newCit = getNumerator() * other.getDenominator();
        int newJmen = getDenominator() * other.getNumerator();
        return createNormalised(newCit, newJmen);
    }

    /***
     * 18/12 /:6
     * 3/2
     *
     * @param numerator
     * @param denominator
     * @return
     */
    public static Fraction createNormalised(Integer numerator, Integer denominator) {
        var gcd = gcdByEuclidsAlgorithm(numerator, denominator);
        return new Fraction(numerator / gcd, denominator / gcd);
    }

    private static int gcdByEuclidsAlgorithm(int n1, int n2) {
        if (n2 == 0) {
            return n1;
        }
        return gcdByEuclidsAlgorithm(n2, n1 % n2);
    }


    @Override
    public String toString() {
        return "Fraction " + numerator + "|" + denominator;
    }
}
