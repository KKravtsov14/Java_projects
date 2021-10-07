import java.io.*;

public class FileService {

    private static FileService instance;

    public static synchronized FileService getInstance() {
        if (instance == null) {
            instance = new FileService();
        }
        return instance;
    }

    private FileService(){}

    public boolean finder(String findVariable) throws IOException {

        FileReader fileIn = new FileReader(new File("D:\\IdeaProjects\\AdminAkk\\src\\DataBase.csv"));
        BufferedReader reader = new BufferedReader(fileIn);
        String textLine;
        while ((textLine = reader.readLine()) != null){
            if (textLine.contains("," + findVariable)){
                return true;
            }
        }

        return false;

    }

    public void writer(Account account) throws IOException {
        FileWriter fileOut = new FileWriter(new File("D:\\IdeaProjects\\AdminAkk\\src\\DataBase.csv"), true);
        fileOut.write("," + account.getFullName() + ",");
        fileOut.write(account.getBirth() + ",");
        fileOut.write(account.getEmail() + ",");
        fileOut.write(account.getPassword() + ",");
        fileOut.write(account.getBlocked() + "\n");
        fileOut.close();
    }

    public void trueWriter(String fullName, String birth, String email, String password) throws IOException {
        FileWriter fileOut = new FileWriter(new File("D:\\IdeaProjects\\AdminAkk\\src\\DataBase.csv"), true);

        fileOut.write("," + fullName + ",");
        fileOut.write(birth + ",");
        fileOut.write(email + ",");
        fileOut.write(password + ",");
        fileOut.write("true" + "\n");

        fileOut.close();
    }

    public void cleaner() throws IOException {
        FileWriter fileOut = new FileWriter(new File("D:\\IdeaProjects\\AdminAkk\\src\\DataBase.csv"));
        fileOut.write("");

    }
    public void newDataCleaner() throws IOException {
        FileWriter fileOut = new FileWriter(new File("D:\\IdeaProjects\\AdminAkk\\src\\NewData.csv"));
        fileOut.write("");

    }

    public void copyrater(String fullName, String birth, String email, String password) throws IOException {
        File newData = new File("D:\\IdeaProjects\\AdminAkk\\src\\NewData.csv");
        FileWriter fileOut = new FileWriter(newData, true);

        FileReader fileIn = new FileReader(new File("D:\\IdeaProjects\\AdminAkk\\src\\DataBase.csv"));
        BufferedReader reader = new BufferedReader(fileIn);
        String textLine;


        while ((textLine = reader.readLine()) != null){
            if (!(textLine.contains("," + email))){
                fileOut.write(textLine+ "\n");

            }

        }
        fileOut.close();
    }

    public void newDataWriter() throws IOException {
        try (FileWriter fileOut = new FileWriter(new File("D:\\IdeaProjects\\AdminAkk\\src\\DataBase.csv"), true)) {
            File newData = new File("D:\\IdeaProjects\\AdminAkk\\src\\NewData.csv");

            FileReader fileIn = new FileReader(newData);
            BufferedReader reader = new BufferedReader(fileIn);
            String textLine;

            while ((textLine = reader.readLine()) != null) {
                fileOut.write(textLine + "\n");

            }
        }
    }

    public String allInformationFinder(String findVariable) throws IOException {
        FileReader fileIn = new FileReader(new File("D:\\IdeaProjects\\AdminAkk\\src\\DataBase.csv"));
        BufferedReader reader = new BufferedReader(fileIn);
        String textLine;
        while ((textLine = reader.readLine()) != null){
            if (textLine.contains("," + findVariable)){
                return textLine.substring(1);
            }
        }

        return null;

    }

}
