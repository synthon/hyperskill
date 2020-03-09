public static BigInteger calcDoubleFactorial(int n) {
    BigInteger num = BigInteger.ONE;

    while (n > 0) {
        num = num.multiply(BigInteger.valueOf(n));
        n -= 2;
    }

    return num;
}
