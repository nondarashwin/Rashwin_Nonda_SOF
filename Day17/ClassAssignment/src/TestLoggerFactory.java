public class TestLoggerFactory {
    public static void main(String[] args) {
        Logger fileLog = LoggerFactory.createLog("File");
        fileLog.log("rashwin", "rashwin");
        Logger databaseLog = LoggerFactory.createLog("Database");
        databaseLog.log("rashwin", "rashwin");
        Logger consoleLog = LoggerFactory.createLog("Console");
        consoleLog.log("rashwin", "rashwin");
    }
}
