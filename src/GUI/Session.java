package GUI;

public class Session {
    private static int loggedInEmployeeId;
    private static String loggedInEmployeeName;

    public static void setLoggedInEmployee(int id, String name) {
        loggedInEmployeeId = id;
        loggedInEmployeeName = name;
    }

    public static int getLoggedInEmployeeId() {
        return loggedInEmployeeId;
    }

    public static String getLoggedInEmployeeName() {
        return loggedInEmployeeName;
    }

    public static void clearSession() {
        loggedInEmployeeId = 0;
        loggedInEmployeeName = null;
    }
}