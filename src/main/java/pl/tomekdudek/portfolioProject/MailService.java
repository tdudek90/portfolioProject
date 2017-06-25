package pl.tomekdudek.portfolioProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import pl.tomekdudek.portfolioProject.models.form.EmailForm;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * Created by Tomek on 2017-06-15.
 */

@Service
public class MailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendEmail(String toWho, EmailForm emailForm) {
        MimeMessage mail = javaMailSender.createMimeMessage();
        emailForm = new EmailForm(emailForm.getName(), emailForm.getEmail(), emailForm.getPhoneNumber(), emailForm.getMessage());
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mail, true);
            helper.setTo(toWho);
            String message = "Imię: " + emailForm.getName() + "Mail: " + emailForm.getEmail() + "Numer telefonu: " + emailForm.getPhoneNumber() + "WIadomość: " + emailForm.getMessage();
            helper.setText(message, true);

        } catch (MessagingException e) {
            e.printStackTrace();
        }

        javaMailSender.send(mail);
    }


}
