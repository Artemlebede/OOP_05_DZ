package presenter;

import view.InputView;
import view.MessageView;

public class CommandHandler {
    private final TreePresenter presenter;
    private final InputView inputView;
    private final MessageView messageView;

    public CommandHandler(TreePresenter presenter, InputView inputView, MessageView messageView) {
        this.presenter = presenter;
        this.inputView = inputView;
        this.messageView = messageView;
    }

    public void start() {
        while (true){
            messageView.displayMessage("Enter command (add, list, sortByName, sortByBirthYear, save, load, exit):");
            String command = inputView.getUserInput();
            handleCommand(command);
        }
    }

    private void handleCommand(String command) {
        switch (command) {
            case "add":
                addPersonCommand();
                break;
            case "list":
                presenter.showAllPersons();
                break;
            case "sortByName":
                presenter.sortPersonsByName();
                break;
            case "sortByBirthYear":
                presenter.sortPersonsByBirthYear();
                break;
            case "save":
                saveTreeCommand();
                break;
            case "load":
                loadTreeCommand();
                break;
            case "exit":
                messageView.displayMessage("Exiting...");
                System.exit(0);
            default:
                messageView.displayMessage("Unknown command");
        }
    }

    private void addPersonCommand(){
        presenter.addPerson();
    }

    private void saveTreeCommand (){
        messageView.displayMessage("Enter file name:");
        String fileName = inputView.getUserInput();
        presenter.saveTree(fileName);
    }

    private void loadTreeCommand(){
        messageView.displayMessage("Enter file name:");
        String fileName = inputView.getUserInput();
        presenter.loadTree(fileName);
    }

}
