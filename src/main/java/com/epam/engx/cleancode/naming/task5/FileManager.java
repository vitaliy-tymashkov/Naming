package com.epam.engx.cleancode.naming.task5;

import com.epam.engx.cleancode.naming.task5.predicates.FileExtensionPredicate;
import com.epam.engx.cleancode.naming.task5.thirdpartyjar.InvalidDirectoryException;
import com.epam.engx.cleancode.naming.task5.thirdpartyjar.InvalidFileTypeException;
import com.epam.engx.cleancode.naming.task5.thirdpartyjar.PropertyUtil;

import java.io.File;
import java.io.FilenameFilter;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public final class FileManager {

    private static final String[] IMAGES_TYPES = {"jpg", "png"};
    private static final String[] DOCUMENTS_TYPES = {"pdf", "doc"};

    private String basePath = PropertyUtil.loadProperty("basePath");

    public File retrieveFile(String fileName) {
        validateFileType(fileName);
        final String dirPath = basePath + File.separator;
        return Paths.get(dirPath, fileName).toFile();
    }

    public List<String> listAllImages() {
        return files(basePath, IMAGES_TYPES);
    }

    public List<String> listAllDocumentFiles() {
        return files(basePath, DOCUMENTS_TYPES);
    }

    private void validateFileType(String fileName) {
        if (isInvalidFileType(fileName)) {
            throw new InvalidFileTypeException("File type not Supported: " + fileName);
        }
    }

    private boolean isInvalidFileType(String fileName) {
        return isInvalidImage(fileName) && isInvalidDocument(fileName);
    }

    private boolean isInvalidImage(String fileName) {
        FileExtensionPredicate imageExtensionsPredicate = new FileExtensionPredicate(IMAGES_TYPES);
        return !imageExtensionsPredicate.test(fileName);
    }

    private boolean isInvalidDocument(String fileName) {
        FileExtensionPredicate documentExtensionsPredicate = new FileExtensionPredicate(DOCUMENTS_TYPES);
        return !documentExtensionsPredicate.test(fileName);
    }

    private List<String> files(String directoryPath, String[] allowedExtensions) {
        final FileExtensionPredicate predicate = new FileExtensionPredicate(allowedExtensions);
        return Arrays.asList(Objects.requireNonNull(directory(directoryPath).list(getFilenameFilterByPredicate(predicate))));
    }

    private FilenameFilter getFilenameFilterByPredicate(final FileExtensionPredicate predicate) {
        return new FilenameFilter() {
            @Override
            public boolean accept(File dirName, String fileName) {
                return predicate.test(fileName);
            }
        };
    }

    private File directory(String directoryPath) {
        File directory = new File(directoryPath);
        validateDirectory(directory);
        return directory;
    }

    private void validateDirectory(File directoryInstance) {
        if (isNotDirectory(directoryInstance)) {
            throw new InvalidDirectoryException("Invalid directory found: " + directoryInstance.getAbsolutePath());
        }
    }

    private boolean isNotDirectory(File dir) {
        return !dir.isDirectory();
    }
}
