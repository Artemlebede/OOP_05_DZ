package presenter;

import Model.FamilyTree;
import Model.Person;
import service.FileOperations;
import service.FileOperationsImpl;
import view.*;

import java.io.IOException;

public class TreePresenter {
    private FamilyTree<Person> familyTree;
    private final MessageView messageView;
    private final PersonView personView;
    private final InputView inputView;
    private final FileOperations<FamilyTree<Person>> fileOperations;

    public TreePresenter(FamilyTree<Person> familyTree,
                         MessageView messageView,
                         PersonView personView,
                         InputView inputView,
                         FileOperations<FamilyTree<Person>> fileOperations) {
        this.familyTree = familyTree;
        this.messageView = messageView;
        this.personView = personView;
        this.inputView = inputView;
        this.fileOperations = fileOperations;

        if (messageView instanceof PresenterView) {
            ((PresenterView) messageView).setPresenter(this);
        }
    }


    public void addPerson() {
        messageView.displayMessage("Enter name:");
        String name = inputView.getUserInput(); // Запрашиваем имя

        messageView.displayMessage("Enter birth year:");
        try {
            int birthYear = Integer.parseInt(inputView.getUserInput()); // Запрашиваем год рождения
            Person person = new Person(name, birthYear); // Создаем объект Person
            familyTree.addMember(person); // Добавляем персону в семейное дерево
            messageView.displayMessage("Person added: " + name); // Сообщение об успешном добавлении
        } catch (NumberFormatException e) {
            messageView.displayMessage("Invalid birth year. Please enter a valid number.");
        } catch (IllegalArgumentException e) {
            messageView.displayMessage("Error adding person: " + e.getMessage());
        }
    }

    public void showAllPersons() {
        personView.displayPersons(familyTree.getMembers());
    }

    public void sortPersonsByName() {
        familyTree.sortByName();
        messageView.displayMessage("Persons sorted by name:");
        showAllPersons();
    }

    public void sortPersonsByBirthYear() {
        familyTree.sortByBirthYear();
        messageView.displayMessage("Persons sorted by birth year:");
        showAllPersons();
    }

    public void saveTree(String fileName) {
        messageView.displayMessage("Enter file name:");
        fileName = inputView.getUserInput();
        try {
            fileOperations.saveToFile(familyTree, fileName);
            messageView.displayMessage("Family tree saved to " + fileName);
        } catch (IOException e) {
            messageView.displayMessage("Error saving family tree: " + e.getMessage());
        }
    }

    public void loadTree(String fileName) {
        messageView.displayMessage("Enter file name:");
        fileName = inputView.getUserInput();
        try {
            familyTree = fileOperations.loadFromFile(fileName);
            messageView.displayMessage("Family tree loaded from " + fileName);
        } catch (IOException | ClassNotFoundException e) {
            messageView.displayMessage("Error loading family tree: " + e.getMessage());
        }
    }

}