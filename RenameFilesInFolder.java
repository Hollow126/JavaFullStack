import java.io.File;

public class RenameFilesInFolder {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Utilizzo: java RenameFilesInFolder <folder_path>");
            return;
        }

        String folderPath = args[0];
        File folder = new File(folderPath);

        if (!folder.exists() || !folder.isDirectory()) {
            System.out.println("Path non valido. PFornisci un path valido.");
            return;
        }

        processFolder(folder);
    }

    private static void processFolder(File folder) {
        File[] files = folder.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    String parentName = folder.getName();
                    String newName = file.getName();

                    if (parentName.length() >= 2) {
                        String lastTwoLetters = parentName.substring(parentName.length() - 2);
                        newName = lastTwoLetters + "_" + newName.substring(0, newName.lastIndexOf('.'))
                                + newName.substring(newName.lastIndexOf('.'));
                    }

                    File newFile = new File(file.getParentFile(), newName);
                    boolean success = file.renameTo(newFile);
                    if (success) {
                        System.out.println("Renamed " + file.getName() + " to " + newName);
                    } else {
                        System.out.println("Failed to rename " + file.getName());
                    }
                } else if (file.isDirectory()) {
                    processFolder(file);
                }
            }
        }
    }
}

/*
 * 
 * 
 * javac RenameFilesInFolder.java
 * java RenameFilesInFolder folderchecontienelefolders
 * 
 * 
 */