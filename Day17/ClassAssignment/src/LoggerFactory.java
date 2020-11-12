public class LoggerFactory {
    public static Logger createLog(String type) {

        if (type.equals("File")) return new FileLog();
        if (type.equals("Database")) return new DatabaseLog();
        if (type.equals("Console")) return new ConsoleLog();
        return null;

    }
}
