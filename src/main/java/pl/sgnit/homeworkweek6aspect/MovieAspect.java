package pl.sgnit.homeworkweek6aspect;

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
    private void sendEmail() {
        emailApi.sendEmail("adres@domena.pl", "Dodano film", "Film został dodany");
    }
}
