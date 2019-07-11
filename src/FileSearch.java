import java.io.File;

public class FileSearch implements Runnable {

    /**
     * initial path for the search
     */

    private String initPath;
    /**
     * Name of the file we are searching for
     */

    private String fileName;


    /**
     * Constructor of of the class
     *
     * @param initPath
     * @param fileName
     */
    public FileSearch(String initPath, String fileName) {
        this.initPath = initPath;
        this.fileName = fileName;
    }

    @Override
    public void run() {

        File file = new File(initPath);
        if (file.isDirectory()) {

            try {
                directoryProcess(file);
            } catch (InterruptedException e) {
                System.out.printf("%s: the Search has been interrupted", Thread.currentThread().getName());
                cleanResources();
            }
        }
    }

    /**
     * Method for cleaning the resources. In this case is empty
     */
    private void cleanResources() {

    }

    /**
     * Method that process a directory
     *
     * @param file
     * @throws InterruptedException
     */
    private void directoryProcess(File file) throws InterruptedException {
        File[] list = file.listFiles();
        if (list != null) {
            for (int i = 0; i < list.length; i++) {
                if (list[i].isDirectory()) {
                    directoryProcess(list[i]);
                } else {
                    fileProcess(list[i]);
                }
            }
        }
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
    }

    /**
     * Method that process a file
     *
     * @param file
     * @throws InterruptedException
     */
    private void fileProcess(File file) throws InterruptedException {
        if (file.getName().equals(fileName)) {
            System.out.printf("%s : %s\n", Thread.currentThread().getName(), file.getAbsolutePath());
        }
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
    }
}
