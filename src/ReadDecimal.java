public class ReadDecimal {
    public static double readDecimal() throws Exception
    {
        double number = 0.0;
        int digitAsciiCode = 0;
        int digit = 0;
        int decimalCounter = 0;
        boolean foundDot = false;

        /* We follow the same exact process that we
         * did in readNumber() to generate an integer
         * number that includes all digits the user typed.
         * But we also keep track of how many digits we
         * read after the decimal dot.
         */

        digitAsciiCode = System.in.read();
        while (digitAsciiCode != '\n')
        {
            //Once we find a dot, we set a boolean flag
            if (digitAsciiCode == '.')
                foundDot = true;
            else
            {
                digit = digitAsciiCode - '0';
                number = number * 10 + digit;
                //If this digit showed up after we found the
                //decimal dot, then increment decimal counter.
                if (foundDot)
                    decimalCounter++;
            }
            digitAsciiCode = System.in.read();
        }

        /* This code generates a power of ten as large as
         * the number of decimal digits we counted */
        int divisor = 1;
        while (decimalCounter > 0)
        {
            divisor *= 10;
            decimalCounter--;
        }

        /* In order to get the actual decimal number the user
         * typed we simply divide by the divisor created above */
        number = number / divisor;
        return number;
    }
}
