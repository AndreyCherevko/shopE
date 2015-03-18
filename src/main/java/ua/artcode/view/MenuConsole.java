package ua.artcode.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.artcode.exception.NoUserFoundException;
import ua.artcode.manager.ClientManager;
import ua.artcode.manager.ClientManagerImpl;
import ua.artcode.manager.ProductManager;
import ua.artcode.model.ProductType;

import java.util.Scanner;

/**
 *
 */
@Component
public class MenuConsole {

    @Autowired
    private ClientManager clientManager;
    @Autowired
    private ProductManager productManager;
    // ServerConnection conection

    private Scanner scanner = new Scanner(System.in);

    public void showMenu(){
        System.out.println("1.Create client");
        System.out.println("2.Show client");
        System.out.println("3.Add product");
        System.out.println("4.Find product");
        System.out.println("5.Exit");
    }

    public void choose(int choose){
        switch (choose) {
            case 1 : {
                System.out.println("Input login");
                String login = scanner.nextLine();
                System.out.println("Input pass");
                String pass = scanner.nextLine();
                System.out.println("Input phone");
                String phone = scanner.nextLine();
                System.out.println("Input email");
                String email = scanner.nextLine();
                clientManager.register(login, pass, phone, email);
                break;
            }
            case 2 : {
                System.out.println("Input login");
                String login = scanner.nextLine();
                System.out.println("Input pass");
                String pass = scanner.nextLine();
                String accessKey = null;
                try {
                    accessKey = clientManager.signIn(login,pass);
                } catch (NoUserFoundException e) {
                    System.err.println("No user found with login " + login);
                }
                System.out.println(accessKey);
                break;
            }
            case 3 : {
                System.out.println("Input name");
                String name = scanner.nextLine();
                System.out.println("Input desc");
                String desc = scanner.nextLine();
                System.out.println("Input price");
                int price = scanner.nextInt();
                productManager.addProduct(name,desc,price, ProductType.BOOK);
                break;
            }
            case 4 : {
                System.out.println("Input login");
                String login = scanner.nextLine();
                System.out.println("Input pass");
                String pass = scanner.nextLine();
                String accessKey = null;
                try {
                    accessKey = clientManager.signIn(login,pass);
                } catch (NoUserFoundException e) {
                    System.err.println("No user found with login " + login);
                }
                System.out.println(accessKey);
                break;
            }
            case 5 : {
                System.exit(1);
                break;
            }
        }
    }

    public ClientManager getClientManager() {
        return clientManager;
    }

    public void setClientManager(ClientManager clientManager) {
        this.clientManager = clientManager;
    }
}
