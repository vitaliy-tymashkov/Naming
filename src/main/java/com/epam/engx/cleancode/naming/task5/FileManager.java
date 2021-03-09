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

    private final String BASE_PATH = PropertyUtil.loadProperty("basePath");
    private final String DIR_PATH = BASE_PATH + File.separator;

    public File retrieveFile(String fileName) {
        validateFileType(fileName);
        return Paths.get(DIR_PATH, fileName).toFile();
    }

    public List<String> listAllImages() {
        return findFilesByExtensions(BASE_PATH, IMAGES_TYPES);
    }

    public List<String> listAllDocumentFiles() {
        return findFilesByExtensions(BASE_PATH, DOCUMENTS_TYPES);
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
        final FileExtensionPredicate checkImage = new FileExtensionPredicate(IMAGES_TYPES);
        return !checkImage.test(fileName);
    }

    private boolean isInvalidDocument(String fileName) {
        final FileExtensionPredicate checkDocument = new FileExtensionPredicate(DOCUMENTS_TYPES);
        return !checkDocument.test(fileName);
    }

    private List<String> findFilesByExtensions(String directoryPath, String[] extensions) {
        final FileExtensionPredicate checkExtension = new FileExtensionPredicate(extensions);
        return Arrays.asList(Objects.requireNonNull(checkDirectory(directoryPath).list(findDirectoryByPath(checkExtension))));
    }

    private FilenameFilter findDirectoryByPath(final FileExtensionPredicate path) {
        return new FilenameFilter() {
            @Override
            public boolean accept(File directory, String fileName) {
                return path.test(fileName);
            }
        };
    }

    private File checkDirectory(String directoryPath) {
        File directory = new File(directoryPath);
        validateDirectory(directory);
        return directory;
    }

    private void validateDirectory(File directory) {
        if (isNotDirectory(directory)) {
            throw new InvalidDirectoryException("Invalid directory found: " + directory.getAbsolutePath());
        }
    }

    private boolean isNotDirectory(File directory) {
        return !directory.isDirectory();
    }
}
