public class VaksinNode {
    int noAntrian;
    String nama;
    VaksinNode prev, next;

    public VaksinNode(int noAntrian, String nama) {
        this.noAntrian = noAntrian;
        this.nama = nama;
        this.prev = null;
        this.next = null;
    }
}