public class FilmNode {
    int id;
    String judul;
    double rating;
    FilmNode prev, next;

    public FilmNode(int id, String judul, double rating) {
        this.id = id;
        this.judul = judul;
        this.rating = rating;
    }
}