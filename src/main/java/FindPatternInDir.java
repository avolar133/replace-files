import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FindPatternInDir {

    private String pattern;
    //private String directory;
    private File[] files;

    public FindPatternInDir(String pattern, String directory) {
        this.pattern = pattern;
        files = new File(directory).listFiles();
        findAllFiles(files, pattern);
    }

    private void showFiles(File[] files){
        for (File file : files){
            if (file.isDirectory()){
                System.out.println("Directory : " + file.getName());
                showFiles(file.listFiles());
            }else{
                System.out.println("File : " + file.getName());
            }
        }
    }

    private List<Path> findAllFiles(File[] files , String fileName){

        List<Path> pathList = new ArrayList<>();

        for (File file : files){
            if (file.isDirectory()){
                findAllFiles(file.listFiles() , fileName);
            }else if (file.getName().equals(fileName)){
                pathList.add(file.toPath());
            }
        }
        return pathList;
    }
}
