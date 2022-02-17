package org.zerock;

public class Movie {

    String movie_genre;
    double movie_x;
    double movie_y;

    public Movie(String movie_genre, double movie_x, double movie_y) {
        this.movie_genre = movie_genre;
        this.movie_x = movie_x;
        this.movie_y = movie_y;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movie_genre='" + movie_genre + '\'' +
                ", movie_x=" + movie_x +
                ", movie_y=" + movie_y +
                '}';
    }
}
