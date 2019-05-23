package com.leavitt.service;

import com.leavitt.model.Directory;
import com.leavitt.model.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by JCaldwell on 5/22/19.
 */
@Service
public class FileSystemService {

    private Directory rootDirectory = new Directory();

    public File getFile(String pathway) {
        String[] directoryPathway = pathway.split("/");
        int directoryLength = directoryPathway.length;
        if (directoryPathway != null && directoryPathway.length > 0) {
            Directory currentDirectory = rootDirectory;
            //loop over directory length to get to directory that the file is in
            for (int i = 1; i < directoryLength - 1; i++) {
                Boolean foundSubDirectory = false;
                //search the current directory for the next directory
                for (int j = 0; j < currentDirectory.getSubDirectories().size(); j++) {
                    if (currentDirectory.getSubDirectories().get(j) != null
                            && currentDirectory.getSubDirectories().get(j).getName() != null
                            && currentDirectory.getSubDirectories().get(j).getName().equals(directoryPathway[i])) {
                        currentDirectory = currentDirectory.getSubDirectories().get(j);
                        foundSubDirectory = true;
                    }
                }
                //if it cant find the next directory, return empty file
                if (!foundSubDirectory) {
                    return new File();
                }
            }
            //search over final directory for the file
            if (currentDirectory.getFiles() != null && currentDirectory.getFiles().size() > 0) {
                for (int i = 0; i < currentDirectory.getFiles().size(); i++) {
                    if (currentDirectory.getFiles().get(i) != null
                            && currentDirectory.getFiles().get(i).getName() != null
                            && currentDirectory.getFiles().get(i).getName().equals(directoryPathway[directoryLength - 1])) {
                        return currentDirectory.getFiles().get(i);
                    }
                }
            }
        }
        //return empty file if it wasnt able to find the file
        return new File();
    }

    public boolean deleteFile(String pathway) {
        String[] directoryPathway = pathway.split("/");
        int directoryLength = directoryPathway.length;
        if (directoryPathway != null && directoryPathway.length > 0) {
            Directory currentDirectory = rootDirectory;
            //loop over directory length to get to directory that the file is in
            for (int i = 1; i < directoryLength - 1; i++) {
                Boolean foundSubDirectory = false;
                //search the current directory for the next directory
                for (int j = 0; j < currentDirectory.getSubDirectories().size(); j++) {
                    if (currentDirectory.getSubDirectories().get(j) != null
                            && currentDirectory.getSubDirectories().get(j).getName() != null
                            && currentDirectory.getSubDirectories().get(j).getName().equals(directoryPathway[i])) {
                        currentDirectory = currentDirectory.getSubDirectories().get(j);
                        foundSubDirectory = true;
                    }
                }
                //if it cant find the next directory, return false that the file was deleted    `
                if (!foundSubDirectory) {
                    return false;
                }
            }
            //search over final directory for the file
            if (currentDirectory.getFiles() != null && currentDirectory.getFiles().size() > 0) {
                for (int i = 0; i < currentDirectory.getFiles().size(); i++) {
                    if (currentDirectory.getFiles().get(i) != null
                            && currentDirectory.getFiles().get(i).getName() != null
                            && currentDirectory.getFiles().get(i).getName().equals(directoryPathway[directoryLength - 1])) {
                        currentDirectory.getFiles().remove(i);
                        return true;
                    }
                }
            }
        }
        //return false if it wasnt able to find the file
        return false;
    }

    public boolean updateFile(String origin, String destination, boolean keepOriginal) {
        String[] originPathway = origin.split("/");
        int originLength = originPathway.length;
        for (int i = 0; i < originPathway.length; i++) {
            System.out.println("Directory: " + originPathway[i]);
        }
        if (originPathway != null && originLength > 0) {
            Directory originDirectory = rootDirectory;
            //loop over directory length to get to directory that the file is in
            for (int i = 1; i < originLength - 1; i++) {
                Boolean foundSubDirectory = false;
                System.out.println("Looking for directory: " + originPathway[i]);
                //search the current directory for the next directory
                for (int j = 0; j < originDirectory.getSubDirectories().size(); j++) {
                    if (originDirectory.getSubDirectories().get(j) != null
                            && originDirectory.getSubDirectories().get(j).getName() != null
                            && originDirectory.getSubDirectories().get(j).getName().equals(originPathway[i])) {
                        originDirectory = originDirectory.getSubDirectories().get(j);
                        foundSubDirectory = true;
                    }
                }
                //if it cant find the next directory, return empty file
                if (!foundSubDirectory) {
                    System.out.println("cant find original");
                    return false;
                }
            }
            //search over final directory for the file
            File originFile = null;
            int fileIndex = -1;
            if (originDirectory.getFiles() != null && originDirectory.getFiles().size() > 0) {
                for (int i = 0; i < originDirectory.getFiles().size(); i++) {
                    if (originDirectory.getFiles().get(i) != null
                            && originDirectory.getFiles().get(i).getName() != null
                            && originDirectory.getFiles().get(i).getName().equals(originPathway[originLength - 1])) {
                        originFile = originDirectory.getFiles().get(i);
                        fileIndex = i;
                    }
                }
                //return false if it cant find the file to move
                if (originFile == null) {
                    System.out.println("Cant find file");
                    return false;
                }
            }

            Directory destinationDirectory = rootDirectory;
            String[] destinationPathway = destination.split("/");
            int destinationLength = destinationPathway.length;
            //loop over directory length to get to directory that the file is in
            for (int i = 1; i < destinationLength - 1; i++) {
                Boolean foundSubDirectory = false;
                //search the current directory for the next directory
                for (int j = 0; j < destinationDirectory.getSubDirectories().size(); j++) {
                    if (destinationDirectory.getSubDirectories().get(j) != null
                            && destinationDirectory.getSubDirectories().get(j).getName() != null
                            && destinationDirectory.getSubDirectories().get(j).getName().equals(destinationPathway[i])) {
                        destinationDirectory = destinationDirectory.getSubDirectories().get(j);
                        foundSubDirectory = true;
                    }
                }
                //if it cant find the next directory, return false;
                if (!foundSubDirectory) {
                    System.out.println("cant find directory");
                    return false;
                }
            }

            //move the file to the new directory
            destinationDirectory.getFiles().add(originFile);

            //remove original if needed
            if (!keepOriginal && fileIndex > -1) {
                originDirectory.getFiles().remove(fileIndex);
            }
            return true;
        }
        //return false if original if statement fails
        System.out.println("cant find it");
        return false;
    }

    public boolean createFile(String pathway, File file) {
        String[] directoryPathway = pathway.split("/");
        int directoryLength = directoryPathway.length;
        if (directoryPathway != null && directoryPathway.length > 0) {
            Directory currentDirectory = rootDirectory;
            //loop over directory length to get to directory that the file is in
            for (int i = 1; i < directoryLength - 1; i++) {
                Boolean foundSubDirectory = false;
                //search the current directory for the next directory
                for (int j = 0; j < currentDirectory.getSubDirectories().size(); j++) {
                    if (currentDirectory.getSubDirectories().get(j) != null
                            && currentDirectory.getSubDirectories().get(j).getName() != null
                            && currentDirectory.getSubDirectories().get(j).getName().equals(directoryPathway[i])) {
                        currentDirectory = currentDirectory.getSubDirectories().get(j);
                        foundSubDirectory = true;
                    }
                }
                //if it cant find the next directory, return empty file
                if (!foundSubDirectory) {
                    return false;
                }
            }
            //add file to the newly found directory
            currentDirectory.getFiles().add(file);
            return true;
        }
        //return false otherwise
        return false;
    }

    public boolean createDirectory(String pathway) {
        String[] directoryPathway = pathway.split("/");
        int directoryLength = directoryPathway.length;
        if (directoryPathway != null && directoryPathway.length > 0) {
            Directory currentDirectory = rootDirectory;
            //loop over directory length to get to directory that the file is in
            for (int i = 1; i < directoryLength - 1; i++) {
                Boolean foundSubDirectory = false;
                //search the current directory for the next directory
                for (int j = 0; j < currentDirectory.getSubDirectories().size(); j++) {
                    if (currentDirectory.getSubDirectories().get(j) != null
                            && currentDirectory.getSubDirectories().get(j).getName() != null
                            && currentDirectory.getSubDirectories().get(j).getName().equals(directoryPathway[i])) {
                        currentDirectory = currentDirectory.getSubDirectories().get(j);
                        foundSubDirectory = true;
                    }
                }
                //if it cant find the next directory, return empty file
                if (!foundSubDirectory) {
                    return false;
                }
            }
            //add file to the newly found directory
            Directory newDirectory = new Directory();
            newDirectory.setPathway(pathway);
            newDirectory.setName(directoryPathway[directoryLength - 1]);
            currentDirectory.getSubDirectories().add(newDirectory);
            return true;
        }
        //return false otherwise
        return false;
    }



}
