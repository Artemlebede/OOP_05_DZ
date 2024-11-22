package service;

import Model.FamilyTree;

import java.io.*;

public class FileOperationsImpl<T> implements FileOperations<T> {

    @Override
    public void saveToFile(T object, String fileName) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(object);
        }
    }

    @Override
    public T loadFromFile(String fileName) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            return (T) ois.readObject();
        }
    }
}