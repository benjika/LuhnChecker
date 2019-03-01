package org.hit.fintech2018.katz;

public class MyLuhnChecker implements LuhnChecker {
    @Override
    public byte getLuhnDigit(byte[] data) throws Exception {
        if (data == null || data.length <= 0) throw new Exception();
        for (byte aData : data)
            if (aData < 0 || aData > 9)
                throw new Exception();

        /*
        I assumed that data is an array of numbers without the check digit
        and I need to find the check digit
        */

        byte sum = 0;

        for (int i = 0; i < data.length; i++) {
            if (i % 2 == 0) sum += (data[data.length - 1 - i] * 2) % 9;
            else sum += data[data.length - 1 - i];
        }

        return (byte) ((10 - (sum % 10)) % 10);
    }

    @Override
    public boolean isLuhnValid(byte[] data) throws Exception {
        if (data == null || data.length <= 0) throw new Exception();
        for (byte aData : data)
            if (aData < 0 || aData > 9)
                throw new Exception();

        int sum = 0;

        for (int i = 1; i <= data.length; i++) {
            if (i % 2 != 0) sum += data[data.length - i];
            else sum += (data[data.length - 1 - i] * 2) % 9;
        }

        return sum % 10 == 0;
    }
}
