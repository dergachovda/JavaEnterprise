package com;

public interface GetFileManagerMBean {
    String getInputURL();

    void setInputURL(String inputURL);

    String getPath();

    void setPath(String path);

    void download();
}
