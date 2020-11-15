package pl.sgnit.homeworkweek6aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MovieAspect {

    private final EmailApi emailApi;

    public MovieAspect(EmailApi emailApi) {
        this.emailApi = emailApi;
    }

    @After("@annotation(SendEmail)")
    private void sendEmail(JoinPoint joinPoint) {
        StringBuilder message = new StringBuilder();
        Movie newMovie = (Movie) joinPoint.getArgs()[0];

        message.append("Został dodany nowy film")
                .append('\n')
                .append("Tytuł: ").append(newMovie.getTitle())
                .append('\n')
                .append("Rok produkcji: ").append(newMovie.getYear())
                .append('\n')
                .append("Producent: ").append(newMovie.getProducer());
        emailApi.sendEmail("adres@domena.pl", "Dodanie filmu", message.toString());
    }
}
