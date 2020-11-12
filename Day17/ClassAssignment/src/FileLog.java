public class FileLog implements Logger {

    @Override
    public void log(String userName, String password) {
        System.out.println("FileLog " + userName + " " + password);
    }
}
