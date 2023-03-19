package com.example.demo.cli;

import com.example.demo.interfaces.AccountType;
import com.example.demo.interfaces.CLIUI;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
@Getter
@Setter
public class MyCLI implements CLIUI {
    private Scanner scanner;
    MyCLI() {
        this.scanner = new Scanner(System.in);
    }
    @Override
    public AccountType requestAccountType() {
        String type = scanner.nextLine();

        return switch (type) {
            case "FIXED" -> AccountType.FIXED;
            case "CHECKING" -> AccountType.CHECKING;
            default -> AccountType.SAVING;
        };
    }

    @Override
    public double requestClientAmount() {
        System.out.println("Type amount of money: ");
        return scanner.nextDouble();
    }

    @Override
    public String requestClientAccountNumber() {
        System.out.println("Type account ID: ");
        return scanner.nextLine();
    }
}
