package bankapp.cli;

import bankapp.account.AccountType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
@Service
@AllArgsConstructor
@Getter
public class MyCLI implements CLIUI {

    private Scanner scanner;
    @Autowired
    public MyCLI() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public double requestClientAmount() {
        System.out.println("Type amount of Money: ");
        return Double.parseDouble(scanner.nextLine());
    }

    @Override
    public Long requestClientAccountNumber() {
        System.out.println("Type account ID: ");
        String accountId = scanner.nextLine();
        return Long.parseLong(accountId.substring(accountId.length()-2));
    }

    @Override
    public AccountType requestAccountType() {
        System.out.println("Choose account type");
        System.out.println("[CHECKING, SAVING, FIXED]");
        String type = scanner.nextLine();
        List<String> types = Arrays.asList("CHECKING", "SAVING", "FIXED");
        if(!types.contains(type)) { // checks whether the right type is selected
            System.out.println("You have entered invalid type");
            return null;
        }
        return new AccountType(type);
    }
}
