package com;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.Properties;

public class GetFileManager implements GetFileManagerMBean {
    private String inputURL = "https://pbs.twimg.com/profile_images/426420605945004032/K85ZWV2F_400x400.png";
    private String path;

    public GetFileManager() {
        try {
            path = loadProperties().getProperty("path");
        } catch (IOException e) {
            path = "";
            System.out.println("Error: " + e);
            e.printStackTrace();
        }
    }

    @Override
    public String getInputURL() {
        return inputURL;
    }

    @Override
    public void setInputURL(String inputURL) {
        this.inputURL = inputURL;
    }

    @Override
    public String getPath() {
        return path;
    }

    @Override
    public void setPath(String path) {
        this.path = path;
    }

    private Properties loadProperties() throws IOException {
        Properties properties = new Properties();
        InputStream stream = this.getClass().getResourceAsStream("file.properties");
        properties.load(stream);
        return properties;
    }

    @Override
    public void download() {

        try  {

            URL url = new URL(inputURL);
            String[] str = url.getFile().split("/");
            path += File.separator + str[str.length - 1];

            ReadableByteChannel readableByteChannel = Channels.newChannel(url.openStream());
            FileOutputStream fileOutputStream = new FileOutputStream(path);

            fileOutputStream.getChannel().transferFrom(readableByteChannel, 0, Long.MAX_VALUE);

            fileOutputStream.close();
            readableByteChannel.close();

        } catch (IOException e1) {
            System.out.println("Error: " + e1);
            e1.printStackTrace();
        }

    }

}
