package jd.captcha.pixelgrid;

public class BinLetter {
    int width, hight, bytes;
    byte[] bytesArray;
    char value;

    public static BinLetter LevenshteinLetter2BinLetter(LevenshteinLetter b) {
        BinLetter bin = new BinLetter();
        bin.width = b.getWidth();
        bin.hight = b.getHight();
        bin.value=b.value;
        int area = bin.width * bin.hight;
        boolean[] bc = new boolean[area];
        int cd = 0;
        for (int y = 0; y < bin.hight; y++) {
            for (int x = 0; x < bin.width; x++) {
                bc[cd] = b.horizontal[x][y];
                cd++;
            }
        }
        bin.bytes = area / 8;
        if (area % 8 > 0) {
            bin.bytes++;
        }
        bin.bytesArray = new byte[bin.bytes];
        int j = 0;
        // System.out.println(c);
        for (int i = 0; i < area; i += 8) {
            for (int g = i, a = 0; g < Math.min(i + 8, area); g++, a++) {
                if (bc[g]) bin.bytesArray[j] |= 1 << a;
            }
            j++;
        }
        return bin;
    }
}
