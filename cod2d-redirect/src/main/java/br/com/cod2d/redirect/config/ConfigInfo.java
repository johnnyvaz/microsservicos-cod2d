package br.com.cod2d.redirect.config;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Locale;

public class ConfigInfo {
    private String env;
    private String version;
    private String ownerBd;
    private String appName;
    private String baseUrl;
    private String port;
    private String database;
    private List<String> serviceAdress;
    private Locale locale;
    private InetAddress localMachine;

    private static ConfigInfo instance;

    public static ConfigInfo config()
    {
        if (instance == null)
        {
            instance = new ConfigInfo();
        }
        return instance;
    }

    public ConfigInfo()
    {

        try {
            localMachine = InetAddress.getLocalHost();
        } catch (final UnknownHostException e) {
            localMachine = null;
        }

    }

    public String getHostName()
    {
        if (localMachine == null) {
            return null;
        } else {
            return localMachine.getHostName();
        }
    }

    public String getEnv() {
        return env;
    }

    public void setEnv(final String env) {
        this.env = env;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(final String version) {
        this.version = version;
    }

    public String getOwnerBd() {
        return ownerBd;
    }

    public void setOwnerBd(final String ownerBd) {
        this.ownerBd = ownerBd;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(final String appName) {
        this.appName = appName;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(final String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getPort() {
        return port;
    }

    public void setPort(final String port) {
        this.port = port;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(final String database) {
        this.database = database;
    }

    public List<String> getServiceAdress() {
        return serviceAdress;
    }

    public void setServiceAdress(final List<String> serviceAdress) {
        this.serviceAdress = serviceAdress;
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(final Locale locale) {
        this.locale = locale;
    }

    public InetAddress getLocalMachine() {
        return localMachine;
    }

    public void setLocalMachine(final InetAddress localMachine) {
        this.localMachine = localMachine;
    }
}
