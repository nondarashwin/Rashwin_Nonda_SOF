public class ConsoleLog implements Logger {
    @Override
    public void log(String userName, String password) {
        System.out.println("ConsoleLog " + userName + " " + password);
    }
}
