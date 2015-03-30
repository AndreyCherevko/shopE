package ua.artcode.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.artcode.exception.InvalidPasswordException;
import ua.artcode.exception.NoSuchFoundOrderException;
import ua.artcode.exception.NoSuchFoundProductException;
import ua.artcode.exception.NoUserFoundException;
import ua.artcode.manager.ClientManager;
import ua.artcode.manager.ClientManagerImpl;
import ua.artcode.manager.OrderManager;
import ua.artcode.manager.ProductManager;
import ua.artcode.model.Client;
import ua.artcode.model.Product;
import ua.artcode.model.ProductType;

import java.util.List;
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
    @Autowired
    private OrderManager orderManager;

    private Scanner scanner = new Scanner(System.in);

    public void showMenu(){
        System.out.println("1.Create client");
        System.out.println("2.Show client");
        System.out.println("3.Add product");
        System.out.println("4.Find product");
        System.out.println("5.Create order");
        System.out.println("6.find order");
        System.out.println("7.Exit");
    }

    public void choose(int choose)  {
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
                Client accessKey = null;
                try {
                    accessKey = clientManager.signIn(login,pass);
                } catch (NoUserFoundException e) {
                    System.err.println("No user found with login " + login);
                } catch (InvalidPasswordException e) {
                    e.printStackTrace();
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
                //System.out.println("Input id");
                try {
                    System.out.println( productManager.getProducts(1,2,ProductType.BOOK));
                } catch (NoSuchFoundProductException e) {
                    e.printStackTrace();
                }

                break;
            }
            case 5: {
                try {
                    List<Product> products = productManager.getProducts(1,2, ProductType.BOOK);
                    System.out.println("Input login");
                    String login = scanner.nextLine();
                    System.out.println("Input pass");
                    String pass = scanner.nextLine();
                    Client client = clientManager.signIn(login,pass);
                    orderManager.newOrder(client,products);
                } catch (NoSuchFoundProductException e) {
                    e.printStackTrace();
                } catch (NoUserFoundException e) {
                    e.printStackTrace();
                } catch (InvalidPasswordException e) {
                    e.printStackTrace();
                }
                break;
            }
            case 6: {
                try {
                    System.out.println("Input login");
                    String login = scanner.nextLine();
                    Client client = clientManager.getClient(login);
                    System.out.println(orderManager.getOrderByClient(client));
                } catch (NoUserFoundException e) {
                    e.printStackTrace();
                } catch (NoSuchFoundOrderException e) {
                    e.printStackTrace();
                }
                break;
            }
            case 7 : {
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

    public void setProductManager(ProductManager productManager) {
        this.productManager = productManager;
    }
}
