package pl.kuczu.abstractDataType.linked;

public class link {
    int value;
    link next;
    link prev;

    public link(int value) {
        this.value = value;
        this.next = null;
        this.prev = null;
    }
}
