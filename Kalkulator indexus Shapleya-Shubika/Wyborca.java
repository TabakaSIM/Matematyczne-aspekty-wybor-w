package MAW;

public class Wyborca {
    public int nr;
    public int value;
    public int indexB = 0;
    public int indexSS = 0;

    public Wyborca(int value, int nr) {
        this.value = value;
        this.nr = nr;
    }

    public void addIndexSS(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n must be non-negative");
        }
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }

        this.indexSS+=result;
    }

}
