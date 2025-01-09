package service;

import model.User;
import util.InputUtil;

import java.util.Scanner;

public class NotificationServiceImpl implements NotificationService {

    private Scanner scanner;

    public NotificationServiceImpl(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void notify(User user) {
        System.out.println("Como gostaria de enviar a notificação: ");
        System.out.println("1. Email: " + user.getEmail());
        System.out.println("2. SMS: " + user.getPhoneNumber());
        int option = InputUtil.getPositiveInteger(scanner);

        switch (option) {
            case 1:
                System.out.println("Email enviado");
                break;
            case 2:
                System.out.println("SMS enviado");
                break;
        }
    }
}
