package test2.zad1.models;

public class TallestBoyAndGirlResult {
    private Child tallestBoy;
    private Child tallestGirl;

    public TallestBoyAndGirlResult(Child tallestBoy, Child tallestGirl) {
        this.tallestBoy = tallestBoy;
        this.tallestGirl = tallestGirl;
    }

    public Child getTallestBoy() {
        return tallestBoy;
    }

    public Child getTallestGirl() {
        return tallestGirl;
    }
}
