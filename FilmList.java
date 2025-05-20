public class FilmList {
    FilmNode head;
    int size;

    public void addFirst(int id, String judul, double rating) {
        FilmNode newFilm = new FilmNode(id, judul, rating);
        if (head == null) {
            head = newFilm;
        } else {
            newFilm.next = head;
            head.prev = newFilm;
            head = newFilm;
        }
        size++;
    }

    public void addLast(int id, String judul, double rating) {
        FilmNode newFilm = new FilmNode(id, judul, rating);
        if (head == null) {
            head = newFilm;
        } else {
            FilmNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newFilm;
            newFilm.prev = current;
        }
        size++;
    }

    public void addAt(int index, int id, String judul, double rating) {
        if (index <= 0) {
            addFirst(id, judul, rating);
        } else if (index >= size) {
            addLast(id, judul, rating);
        } else {
            FilmNode current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            FilmNode newFilm = new FilmNode(id, judul, rating);
            newFilm.prev = current.prev;
            newFilm.next = current;
            current.prev.next = newFilm;
            current.prev = newFilm;
            size++;
        }
    }

    public void removeFirst() {
        if (head != null) {
            head = head.next;
            if (head != null) head.prev = null;
            size--;
        }
    }

    public void removeLast() {
        if (head == null) return;
        if (head.next == null) {
            head = null;
        } else {
            FilmNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.prev.next = null;
        }
        size--;
    }

    public void removeAt(int index) {
        if (index < 0 || index >= size) return;
        if (index == 0) {
            removeFirst();
        } else {
            FilmNode current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            if (current.next != null) {
                current.next.prev = current.prev;
            }
            if (current.prev != null) {
                current.prev.next = current.next;
            }
            size--;
        }
    }

    public void print() {
        FilmNode current = head;
        System.out.println("Cetak Data");
        while (current != null) {
            System.out.println("ID: " + current.id);
            System.out.println("Judul Film: " + current.judul);
            System.out.println("Rating: " + current.rating);
            System.out.println("----------------------");
            current = current.next;
        }
    }

    public void searchById(int id) {
        FilmNode current = head;
        while (current != null) {
            if (current.id == id) {
                System.out.println("ID: " + current.id);
                System.out.println("Judul Film: " + current.judul);
                System.out.println("Rating: " + current.rating);
                return;
            }
            current = current.next;
        }
        System.out.println("Film dengan ID tersebut tidak ditemukan.");
    }

    public void sortByRatingDescending() {
        if (head == null) return;
        for (FilmNode i = head; i != null; i = i.next) {
            for (FilmNode j = i.next; j != null; j = j.next) {
                if (i.rating < j.rating) {
                    int tempId = i.id;
                    String tempJudul = i.judul;
                    double tempRating = i.rating;

                    i.id = j.id;
                    i.judul = j.judul;
                    i.rating = j.rating;

                    j.id = tempId;
                    j.judul = tempJudul;
                    j.rating = tempRating;
                }
            }
        }
    }
}