import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

public class SingletonPattern {
    public void run() {
        ConfigSingleton configSingleton = ConfigSingleton.getInstance();
    }
}

@XmlRootElement(name = "config")
class ConfigSingleton {

    @XmlElement
    private String ip;
    @XmlElement
    private String port;
    @XmlElement
    private String username;
    @XmlElement
    private String password;

    private static ConfigSingleton config;

    private ConfigSingleton() {}

    public static ConfigSingleton getInstance() {
        if (config == null)
            config = new ConfigSingleton();

        System.out.println("Get Singleton instance");
        /* Do something with  XML config file */

        return config;
    }
 }