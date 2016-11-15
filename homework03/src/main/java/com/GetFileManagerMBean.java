package com;

public interface GetFileManagerMBean {
    String getUrl();

    void setUrl(String url);

    String getOutputFile();

    void setOutputFile(String outputFile);

    void download();
}
