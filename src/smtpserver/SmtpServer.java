package smtpserver;

public class SmtpServer {

    // Private variables needed for the SMTP server
    private String configFile = "test-data/smtpd.json";
    private int port;
    private String serverName;
    private String logFile;
    private String spool;

    /**
     * Prints the usage message for the program
     */
    public static void usage() {
        System.out.println("Usage:");
        System.out.println("   smtpserver");
        System.out.println("   smtpserver --config <configfile>");
        System.out.println("   smtpserver --help\n");
        System.out.println("Options:");
        System.out.printf("  %-15s %-20s\n", "-c, --config", "Set the config file");
        System.out.printf("  %-15s %-20s\n", "-h, --help", "Display the help message");
    }

    /**
     * Processes the arguments passed to the program
     *
     * @param args - The arguments passed to the program
     */
    public static void processArgs(String[] args) {
        // Argument processing logic would go here
    }

    public static void main(String[] args) {
        System.out.println("SMTP Server is running...");
        usage();
    }
}
