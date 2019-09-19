import java.io.File;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class Communication {

    private Scanner scanner;
    private FindPatternInDir findPatternInDir;
    private MoveToDirectory moveToDirectory;
    private List<Path> pathList;

    public Communication(Scanner scanner ,String searchInDirectory) {
        this.scanner = scanner;
        this.findPatternInDir = new FindPatternInDir(searchInDirectory);
        this.handlePatternFinder();
    }

    private void handlePatternFinder(){
        String fileName;

        System.out.println("Enter a file name: (for exit, enter stop)");
        fileName = scanner.nextLine();
        if (fileName.equals("stop")){
            scanner.close();
        }
        findPatternInDir.setPattern(fileName);

        pathList = findPatternInDir.getFiles();

        if (pathList.isEmpty()){
            handlePatternFinder();
        }else{
            handleMoveToDirectory();
        }

    }


    private void handleMoveToDirectory(){
        String dirPath;

        System.out.println("Enter path directory: (for exit, enter stop)");
        dirPath = scanner.nextLine();
        if (dirPath.equals("stop")){
            scanner.close();
        }

        moveToDirectory = new MoveToDirectory(dirPath);
        // check if this directory exist
       if (!moveToDirectory.pathExists()){
           System.out.println("The path is wrong.");
           handleMoveToDirectory();
       }

        String commandFile;
       do {

           System.out.println("For copying enter (copy).");
           System.out.println("For transferring and removing from the old directory enter (move)");
           commandFile = scanner.nextLine();
       }while (!commandFile.equals("copy") && !commandFile.equals("move"));


        if (commandFile.equals("copy")) {
            for (Path path: pathList) {
                moveToDirectory.copyToAnotherDirectory(path);
            }
        }else{
            for (Path path: pathList) {
                moveToDirectory.movToAnotherDirectory(path);
            }
        }



    }

}
