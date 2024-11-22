package view;

import Model.Person;
import presenter.TreePresenter;

import java.util.List;
import java.util.Scanner;

public class ConsoleTreeView implements TreeView {
    private TreePresenter presenter;
    private Scanner scanner;

    public ConsoleTreeView() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void displayMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void displayPersons(List<Person> persons) {
        if (persons.isEmpty()) {
            System.out.println("No persons in the family tree.");
        } else {
            for (Person person : persons) {
                System.out.println(person);
            }
        }
    }

    @Override
    public String getUserInput() {
        return scanner.nextLine();
    }

    @Override
    public void setPresenter(TreePresenter presenter) {
        this.presenter = presenter;
    }
}