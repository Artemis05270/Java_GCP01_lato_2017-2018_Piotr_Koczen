package com.ddsoft.crawler;
import com.ddsoft.exceptions.CrawlerException;
import com.ddsoft.exceptions.MonitorException;
import com.ddsoft.crawler.Crawler.OrderMode;
import java.io.IOException;
import java.util.List;
class Monitor {

    private List<String> fileList;
    private int threadCount;
    private MyThread[] threadTab = null;
    private boolean runFlag = false;

    Monitor(List<String> listOfFiles, int n) throws MonitorException {
        fileList = listOfFiles;
        if (n < fileList.size())
            throw (new MonitorException());
        else
            threadCount = listOfFiles.size();
    }

    void run() throws InterruptedException, IOException, CrawlerException {
        if (threadTab == null) {
            runFlag = true;
            threadTab = new MyThread[threadCount];
            for (int i = 0; i < threadCount; i++) {
                threadTab[i] = new MyThread(fileList.get(i), OrderMode.MARK);
                threadTab[i].setName("Crawler number #" + i);
                threadTab[i].crawler.getName(threadTab[i].getName());
                threadTab[i].start();
            }
        }
    }

    synchronized void cancel() throws InterruptedException {
        if (threadTab != null) {

            runFlag = false;
            for (int i = 0; i < threadCount; i++) {
                threadTab[i].crawler.postCancel();
                threadTab[i].join();
            }
        }
    }

    class MyThread extends Thread {
        private Crawler crawler;

        MyThread(String address, OrderMode md) {
            crawler = new Crawler();
            crawler.enableLogIsModifed();
            crawler.enableLogIteration();
            crawler.enableLogAdd();
            crawler.enableLogRemove();
            crawler.setAddress(address);
    }
        @Override
        public void run() {
            while (runFlag) {
                try {
                    crawler.run();
                } catch (CrawlerException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}