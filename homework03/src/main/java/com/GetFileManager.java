package com;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

public class GetFileManager implements GetFileManagerMBean {
    private String inputURL = "https://pbs.twimg.com/profile_images/426420605945004032/K85ZWV2F_400x400.png";
    private String outputFile;

    public GetFileManager() {
        try {

            outputFile = loadProperties().getProperty("dir")
                    + File.separator
                    + loadProperties().getProperty("file");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Properties loadProperties() throws IOException {
        Properties properties = new Properties();
        InputStream stream = this.getClass().getResourceAsStream("file.properties");
        properties.load(stream);
        return properties;
    }

    @Override
    public String getUrl() {
        return inputURL;
    }

    @Override
    public void setUrl(String url) {
        this.inputURL = url;
    }

    @Override
    public String getOutputFile() {
        return outputFile;
    }

    @Override
    public void setOutputFile(String outputFile) {
        this.outputFile = outputFile;
    }

    @Override
    public void download() {

        URL url = null;
        try {
            url = new URL(inputURL);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        try (BufferedInputStream bufferedInputStream =
                     new BufferedInputStream(url.openStream());
             FileOutputStream fileOutputStream =
                     new FileOutputStream(outputFile)) {

            byte[] buffer = new byte[1024];
            int count=0;
            while((count = bufferedInputStream.read(buffer,0,1024)) != -1)
            {
                fileOutputStream.write(buffer, 0, count);
            }

         } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
