package pl.kuczu.abstractDataType.linked;

public class Link {
    int value; // package-private
    Link next;
    Link prev;

    public Link(int value) {
        this.value = value;
        this.next = null;
        this.prev = null;
    }
}
