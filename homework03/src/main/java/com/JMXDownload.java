package com;


import javax.management.*;
import java.lang.management.ManagementFactory;

public class JMXDownload {

    public static void main(String[] args) throws MalformedObjectNameException, NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanRegistrationException, InterruptedException {

        MBeanServer platformMBeanServer = ManagementFactory.getPlatformMBeanServer();
        GetFileManagerMBean getFileManagerMBean = new GetFileManager();
        platformMBeanServer.registerMBean(getFileManagerMBean, new ObjectName("file:name=get_manager"));
        Thread.sleep(Integer.MAX_VALUE);
    }

}
