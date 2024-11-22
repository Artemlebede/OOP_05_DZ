package service;

import java.io.IOException;

public interface FileOperations<T> {
    void saveToFile(T object, String fileName) throws IOException;
    T loadFromFile(String fileName) throws IOException, ClassNotFoundException;
}