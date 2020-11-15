package pl.sgnit.homeworkweek6aspect;

public class Movie {

    private String title;

    private int year;

    private String producer;

    public Movie() {
    }

    public Movie(String title, int year, String producer) {
        this.title = title;
        this.year = year;
        this.producer = producer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }
}
