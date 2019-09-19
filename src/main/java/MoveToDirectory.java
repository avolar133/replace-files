import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import org.apache.commons.io.FilenameUtils;


public class MoveToDirectory {

    private Path pathTarget;

    public MoveToDirectory(String pathTarget) {
        this.pathTarget = Paths.get(pathTarget);
    }

    public void copyToAnotherDirectory(Path originalPath){
        File file = new File(originalPath.toString());
        System.out.println(file.exists());
        System.out.println(file);
        System.out.println(pathTarget);
        try {
            Files.copy(originalPath,
                    Paths.get(pathTarget + "/"+ FilenameUtils.getName(originalPath.toString()) ),
                    StandardCopyOption.REPLACE_EXISTING);
        }catch (IOException e){
            System.out.println(e);
        }


    }

    public void movToAnotherDirectory(Path originalPath){

        try {
            Files.move(originalPath,
                    Paths.get(pathTarget + "/"+ FilenameUtils.getName(originalPath.toString()) ),
                    StandardCopyOption.REPLACE_EXISTING);
        }catch (IOException e){
            System.err.println(e);
        }

    }

    public boolean pathExists(){
        File file = new File(pathTarget.toString());
        if(file.exists() && file.isDirectory()){
            return true;
        }else {
            return false;
        }
    }
}
