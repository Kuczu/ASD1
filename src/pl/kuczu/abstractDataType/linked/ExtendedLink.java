package pl.kuczu.abstractDataType.linked;

public class ExtendedLink {
    int value; // package-private
    ExtendedLink min;
    ExtendedLink max;
    ExtendedLink prev;

    public ExtendedLink(int value) {
        this.value = value;
        this.prev = null;
        this.min = this;
        this.max = this;
    }
}
