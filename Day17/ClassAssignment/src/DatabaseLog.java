public class DatabaseLog implements Logger {
    @Override
    public void log(String userName, String password) {
        System.out.println("DatabaseLog " + userName + " " + password);
    }
}
