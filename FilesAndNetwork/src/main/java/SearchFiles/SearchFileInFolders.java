package SearchFiles;

import java.io.File;
import java.util.Objects;

public class SearchFileInFolders {

    public SearchFileInFolders(String path){
        searchFile(path);
    }

    private void searchFile(String path){

        File file = new File(path);

        if (file.isDirectory()){
            scanFolder(file);
        } else {
            System.out.println("Ошибка! Данный путь не является директорией!");
        }

    }

    private void scanFolder(File file){
        if (file.isFile()){
            System.out.println(file.getName() + " -> " + file.getPath());
        }

        if (file.isDirectory()){
            File[] folder = file.listFiles();
            for (File files : Objects.requireNonNull(folder)){
                scanFolder(files);
            }
        }
    }
}