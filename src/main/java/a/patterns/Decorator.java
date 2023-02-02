package a.patterns;

import java.util.Locale;

/**
 * Структурный паттерн. Удобное расширение функциональности.
 */
public class Decorator {
    public static void main(String[] args) {
        MailService mailServiceOrigin = new MailServiceImpl();
        MailService mailServiceExtend = new AuditMailServiceImpl(mailServiceOrigin);

        Mail mail = new Mail();
        mail.from = "Peter";
        mail.to = "Stephan";
        mail.text = "Hello!";

        mailServiceExtend.send(mail);
    }
}


/**
 * Контент для сервиса
 */
class Mail {
    public String from;
    public String to;
    public String text;
}

/**
 * Базовое поведение сервиса
 */
interface MailService {
    void send(Mail mail);
}


/**
 * Стандартная отправка
 */
class MailServiceImpl implements MailService {
    @Override
    public void send(Mail mail) {
        System.out.printf(Locale.getDefault(), "Письмо%nОт: %s%nКому: %s%nСообщение:%n%s%n%s%n",
                mail.from, mail.to, mail.text, "-".repeat(80));
    }
}


/**
 * Дополнительная функциональность: отчёт
 */
class AuditMailServiceImpl implements MailService {
    private final MailService origin;

    public AuditMailServiceImpl(MailService mailService) {
        origin = mailService;
    }

    @Override
    public void send(Mail mail) {
        origin.send(mail);
        System.out.printf(Locale.getDefault(), "Отчёт о письме от %s к %s сохранён%n%s%n",
                mail.from, mail.to, "-".repeat(80));
    }
}
