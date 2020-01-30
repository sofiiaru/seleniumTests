package utilities;

public class EnvironmentManager {
    public static String url;

    public static void setUp(){
        switch(ConfigReader.getProperty("environment").toLowerCase()){
            case "dev":
                dev();
                break;
            case "qa":
                qa();
                break;
            case "qa2":
                qa2();
                break;
            case "prod":
                prod();
                break;
            default:
                qa();
                break;

        }
    }

    public static void dev(){
        url = "dev.expedia.com/";
    }

    public static void qa(){
        url = "qa.expedia.com/";
    }

    public static void qa2(){
        url = "qa2.expedia.com/";
    }


    public static void prod(){
        url = "https://www.expedia.com/";
    }
}
