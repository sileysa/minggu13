public class Vaksinasi {
    VaksinNode head, tail;
    int size;

    public Vaksinasi() {
        head = tail = null;
        size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void enqueue(int noAntrian, String nama) {
        VaksinNode newNode = new VaksinNode(noAntrian, nama);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Antrian kosong");
        } else {
            System.out.println(head.nama + " telah divaksinasi.");
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
            size--;
        }
    }

    public void print() {
        System.out.println("+++++++++++++++++++++++++++++++");
        System.out.println(" DAFTAR PENERIMA VAKSIN");
        System.out.println("+++++++++++++++++++++++++++++++");

        if (isEmpty()) {
            System.out.println(">> Antrian masih kosong.");
            return;
        }

        VaksinNode current = head;
        while (current != null) {
            System.out.println("Nomor Antrian: " + current.noAntrian);
            System.out.println("Nama Penerima: " + current.nama);
            System.out.println("-------------------------------");
            current = current.next;
        }

        System.out.println("Jumlah antrian tersisa: " + size);
    }
}