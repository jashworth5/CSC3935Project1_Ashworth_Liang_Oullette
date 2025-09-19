package pop3server;

public class Pop3Server {

    // Private variables needed for the POP3 server
    private String configFile = "test-data/pop3d.json";
    private int port;
    private String serverName;
    private String spool;
    private String logFile;
    private String accountFile;

    /**
     * Prints the usage message for the program
     */
    public static void usage() {
        System.out.println("Uage:");
        System.out.println("   pop3server");
        System.out.println("   pop3server --config <configfile>");
        System.out.println("   pop3server --help\n");
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

        //OptionParser parser;

    }

    public static void main(String[] args) {
        System.out.println("POP3 Server is running...");
        usage();
    }
}
