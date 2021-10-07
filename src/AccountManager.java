import java.io.IOException;
import java.util.ArrayList;

public interface AccountManager {

    FailedLoginCounter failedLoginCounter = new FailedLoginCounter();
    FileService fileService = new FileService();

    static void register(Account account) throws IOException, AccountAlreadyExistsException {
        String email = account.getEmail();
        if (!fileService.finder(email)){
            fileService.writer(account);
            failedLoginCounter.creator(email);

        }
        else {
            throw new AccountAlreadyExistsException("Аккаунт уже существует");
        }

    }

    static Account login(String email, String password) throws IOException,
            WrongCredentialsException,
            AccountBlockedException {

        String allInformation = fileService.allInformationFinder(email);
        if (allInformation != null) {
            if (!allInformation.isEmpty() &
                    allInformation.contains("," + password)) {

                if (allInformation.contains("false")) {

                    String guess = ",";
                    ArrayList<Integer> indexes = new ArrayList<>();
                    int index = allInformation.indexOf(guess);
                    while (index >= 0) {
                        indexes.add(index);
                        index = allInformation.indexOf(guess, index + 1);
                    }

                    int firstcomma = indexes.get(0);
                    int secondcomma = indexes.get(1);
                    int thirdcomma = indexes.get(2);
                    int fourthcomma = indexes.get(3);

                    Account account = new Account(allInformation.substring(0, firstcomma),
                            allInformation.substring(firstcomma + 1, secondcomma),
                            allInformation.substring(secondcomma + 1, thirdcomma),
                            allInformation.substring(thirdcomma + 1, fourthcomma),
                            false);

                    failedLoginCounter.deleter(email);

                    return account;

                } else {
                    throw new AccountBlockedException("Аккаунт заблокирован");
                }
            } else {
                if (failedLoginCounter.updater(email)) {
                    throw new WrongCredentialsException("Неверно введены email или пароль");
                }
                else {

                    String guess = ",";
                    ArrayList<Integer> indexes = new ArrayList<>();
                    int index = allInformation.indexOf(guess);
                    while (index >= 0) {
                        indexes.add(index);
                        index = allInformation.indexOf(guess, index + 1);
                    }

                    int firstcomma = indexes.get(0);
                    int secondcomma = indexes.get(1);
                    int thirdcomma = indexes.get(2);
                    int fourthcomma = indexes.get(3);

                    fileService.copyrater(allInformation.substring(0, firstcomma),
                                 allInformation.substring(firstcomma + 1, secondcomma),
                               allInformation.substring(secondcomma + 1, thirdcomma),
                             allInformation.substring(thirdcomma + 1, fourthcomma));
                    fileService.cleaner();
                    fileService.newDataWriter();
                    fileService.trueWriter(allInformation.substring(0, firstcomma),
                            allInformation.substring(firstcomma + 1, secondcomma),
                            allInformation.substring(secondcomma + 1, thirdcomma),
                            allInformation.substring(thirdcomma + 1, fourthcomma));

                    fileService.newDataCleaner();

                    throw new WrongCredentialsException("Неверно введены email или пароль, аккаунт заблокирован");
                }

            }
        }
        return null;
    }

    static void removeAccount(String email, String password) throws IOException, WrongCredentialsException {
        if (fileService.finder(email)) {
            if (fileService.allInformationFinder(email).contains("," + password)){
                String allInformation = fileService.allInformationFinder(email);
                String guess = ",";
                ArrayList<Integer> indexes = new ArrayList<>();
                int index = allInformation.indexOf(guess);
                while (index >= 0) {
                    indexes.add(index);
                    index = allInformation.indexOf(guess, index + 1);
                }

                int firstcomma = indexes.get(0);
                int secondcomma = indexes.get(1);
                int thirdcomma = indexes.get(2);
                int fourthcomma = indexes.get(3);

                fileService.copyrater(allInformation.substring(0, firstcomma),
                        allInformation.substring(firstcomma + 1, secondcomma),
                        allInformation.substring(secondcomma + 1, thirdcomma),
                        allInformation.substring(thirdcomma + 1, fourthcomma));
                fileService.cleaner();
                fileService.newDataWriter();
                fileService.newDataCleaner();
            }

            else{
                throw new WrongCredentialsException("Неверный пароль");
            }
        }
        else {
            throw new WrongCredentialsException("Неверный логин");
        }
    }
}
