import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FindPatternInDir {

    private String pattern;
    //private String directory;
    private File[] files;
    private List<Path> pathList;

    public FindPatternInDir(String directory) {
        this.pathList = new ArrayList<>();
        files = new File(directory).listFiles();
    }


    private List<Path> findAllFiles(File[] allFiles ){

        for (File file : allFiles){
            if (file.isDirectory()){
                findAllFiles(file.listFiles() );
            }else if (file.getName().equals(pattern)){
                pathList.add(file.toPath());
            }
        }
        return pathList;
    }


    public List<Path> getFiles(){
        return this.findAllFiles(files);
    }

    public void setPattern(String pattern){
        this.pattern = pattern;
    }



}
