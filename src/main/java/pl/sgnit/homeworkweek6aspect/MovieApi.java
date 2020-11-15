package pl.sgnit.homeworkweek6aspect;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieApi {

    private List<Movie> movieList;

    public MovieApi() {
        movieList = new ArrayList<>();
        movieList.add(new Movie("Film 1", 2019, "Studio 1"));
        movieList.add(new Movie("Film 2", 1989, "Studio 2"));
        movieList.add(new Movie("Film 3", 2000, "Studio 3"));
    }

    @GetMapping
    public List<Movie> getMovieList() {
        return movieList;
    }

    @PostMapping
    @SendEmail
    public void addMovie(@RequestBody Movie newMovie) {
        movieList.add(newMovie);
    }
}
