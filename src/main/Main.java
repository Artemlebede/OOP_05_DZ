package main;

import Model.FamilyTree;
import Model.Person;
import presenter.CommandHandler;
import presenter.TreePresenter;
import service.FileOperationsImpl;
import view.ConsoleTreeView;

public class Main {
    public static void main(String[] args) {
        // Создаем модель семейного дерева
        FamilyTree<Person> familyTree = new FamilyTree<>();

        // Создаем представление консоли
        ConsoleTreeView view = new ConsoleTreeView();

        // Создаем объект для работы с файлами
        FileOperationsImpl<FamilyTree<Person>> fileOperations = new FileOperationsImpl<>();

        // Создаем презентер, передавая модель, представление и файловые операции
        TreePresenter presenter = new TreePresenter(
                familyTree,
                view, // MessageView
                view, // PersonView
                view, // InputView
                fileOperations
        );

        // Создаем обработчик команд, который управляет взаимодействием между пользователем и презентером
        CommandHandler commandHandler = new CommandHandler(
                presenter,
                view, // InputView
                view  // MessageView
        );

        // Запускаем обработчик команд
        commandHandler.start();
    }
}