package smtpserver;

import merrimackutil.cli.LongOption;
import merrimackutil.cli.OptionParser;
import merrimackutil.json.InvalidJSONException;
import merrimackutil.json.JsonIO;
import merrimackutil.json.types.JSONObject;
import merrimackutil.json.types.JSONType;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InvalidObjectException;

public class SmtpServer {

    // Private variables needed for the SMTP server
    private static String configFile = "test-data/smtpd.json";
    private static int port;
    private static String serverName;
    private static String logFile;
    private static String spool;

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
        OptionParser parser;

        boolean doHelp = false;

        LongOption[] opts = new LongOption[2];
        opts[0] = new LongOption("config", true, 'c');
        opts[1] = new LongOption("help", false, 'h');

        parser = new OptionParser(args);

        parser.setLongOpts(opts);
        parser.setOptString("c:h");

        while (parser.getOptIdx() != args.length) {
            var currOpt = parser.getLongOpt(false);

            switch (currOpt.getFirst()) {
                case 'c':
                    configFile = currOpt.getSecond();
                    break;
                case 'h':
                    doHelp = true;
                    break;
                default:
                    System.out.println("Invalid option" + currOpt.getFirst());
                    usage();
                    System.exit(1);
            }
        }
        if (doHelp) {
            usage();
            System.exit(0);
        }

        System.out.println("Using config file: " + configFile);

        // Check if the config file exists
        File file = new File(configFile);
        if (!file.exists()) {
            System.out.println("Config file does not exist: " + configFile);
            System.exit(1);
        }

        // Deserialize the config file
        try {
            deserialize(JsonIO.readObject(file));
        } catch (InvalidJSONException | FileNotFoundException | InvalidObjectException e) {
            System.err.println("Error reading config file!!!");
            System.exit(1);
        }
    }

    public static void main(String[] args) {
        if (args.length > 3) {
            usage();
            System.exit(1);
        }
        processArgs(args);
    }

    // --------- Private methods --------- //

    /**
     * Deserialize the configuration file
     *
     * @param jsonType - The JSON object to deserialize
     * @throws InvalidObjectException - If the JSON object is not a JSONObject
     */
    private static void deserialize(JSONType jsonType) throws InvalidObjectException {
        // Check if the JSON object is a JSONObject
        if (!(jsonType instanceof JSONObject)) {
            throw new InvalidObjectException("JSONObject expected.");
        }

        JSONObject obj = (JSONObject) jsonType;

        // Check if the required fields are present
        obj.checkValidity(new String[]{"port", "server-name", "log", "spool"});

        // Get the values from the JSON object
        port = obj.getInt("port");
        serverName = obj.getString("server-name");
        logFile = obj.getString("log");
        spool = obj.getString("spool");
    }
}
