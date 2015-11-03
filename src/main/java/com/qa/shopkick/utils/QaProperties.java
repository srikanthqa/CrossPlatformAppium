package com.qa.shopkick.utils;

import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Properties;

/**
 * Created by mmadhusoodan on 10/26/15.
 */
public class QaProperties { // singleton
    private static Logger log = Logger.getLogger(QaProperties.class);
    public static Properties props = getProperty();
    private static QaProperties instance;
    private static String language = "en";
    private static int numDevice = 1;
    private static OutputStream output = null;

    public QaProperties() {
    }

    public static QaProperties getInstance() {
        if (instance == null) {
            instance = new QaProperties();
        }
        return instance;
    }

    public static Properties getProperty() {
        Properties props = new Properties();
        try {
            FileInputStream in;
            String propFile = "src/main/resources/local.properties";
            File fileProps = new File(propFile);
            if (fileProps.exists()) {
                in = new FileInputStream(fileProps);
            } else {
                in = new FileInputStream(new File("local.properties"));
            }

            props.load(in);
            in.close();
            return props;
        } catch (Exception e) {
            log.error(e);
            System.exit(1);
        }
        return props;
    }

    public static void setProperty(String key, String value) {
        Properties props = new Properties();
        try {
            String propFile = "python/mesh.properties";
            output = new FileOutputStream(propFile);
            props.setProperty(key, value);

            log.info("property of key = " + key + " , value = " + props.getProperty(key));
            props.store(output, null);
            output.close();
        } catch (Exception e) {
            log.info(e);
            System.exit(1);
        }
    }

    public static void setProperty(String propFile, String key, String value) {
        Properties props = new Properties();
        try {
            output = new FileOutputStream(propFile);
            props.setProperty(key, value);
            props.store(output, null);
            output.close();
        } catch (Exception e) {
            log.info(e);
            System.exit(1);
        }
    }

    public static String getReporterEmail() throws NullPointerException {
        if (props.getProperty("Reporter.Email") == null) {
            return "firefox";
        } else {
            return props.getProperty("Reporter.Email").trim();
        }
    }

    public static String getReporterPassword() throws NullPointerException {
        if (props.getProperty("Reporter.Password") == null) {
            return "firefox";
        } else {
            return props.getProperty("Reporter.Password").trim();
        }
    }

    public static String getAPKVersion() throws NullPointerException {
        String apkVersion = "";
        try {
            String version = (props.getProperty("version").trim());
            String buildNo = (props.getProperty("build_no").trim());
            apkVersion = version + "." + buildNo;
        } catch (Exception e) {
            log.error(e);
        }
        return apkVersion;
    }

    public static String getVersion() throws NullPointerException {
        String version = "";
        try {
            version = (props.getProperty("version").trim());
        } catch (Exception e) {
            log.error(e);
        }
        return version;
    }

    public static String getNumDevice() throws NullPointerException {
        String numberdevice = "";
        try {
            numberdevice = (props.getProperty("numberdevice").trim());
            numDevice = Integer.parseInt(numberdevice);
        } catch (Exception e) {
            log.error(e);
        }
        return numberdevice;
    }

    public static String[] getDeviceID() throws NullPointerException {

        String[] deviceid = new String[numDevice];
        try {
            String ids = (props.getProperty("deviceid").trim()).replace('[', ' ');
            ids = ids.replace(']', ' ');

            ids = ids.replaceAll("'", "\"");
            log.info("ids = " + ids);
            if (ids.contains(",")) {
                deviceid = ids.split(",");
            } else {
                deviceid[0] = ids;
            }
        } catch (Exception e) {
            log.error(e);
        }
        return deviceid;
    }

    public static String getLogFile() throws NullPointerException {

        String logFile = "";
        try {
            logFile = (props.getProperty("logfile").trim());
        } catch (Exception e) {
            log.error(e);
        }
        return logFile;
    }


    public static String getStack() throws NullPointerException {
        String stack = props.getProperty("stack").trim();
        return stack;
    }

    public static void setBuildNo(String propFile, String buildNo) throws NullPointerException {
        log.info("setting buildNo: " + buildNo);
        setProperty(propFile, "buildNo", buildNo);
    }

    // Get the suite type based on what has been set in Jenkins via gradle "-Ptype=Smoke"
    public static String getSuiteType() throws NullPointerException {
        String type = "";
        try {
            type = props.getProperty("internalTestType").trim();
        } catch (Exception e) {
            log.error(e);
        }
        return type;
    }

}