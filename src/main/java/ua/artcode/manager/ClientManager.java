package ua.artcode.manager;

import ua.artcode.exception.InvalidPasswordException;
import ua.artcode.exception.NoUserFoundException;
import ua.artcode.model.Client;

/**
 * Created by serhii on 24.02.15.
 */
public interface ClientManager {

    public void register(String login, String pass,
                         String phone, String email);


    public Client signIn(String login, String pass) throws NoUserFoundException, InvalidPasswordException;

    public void logout(String login);

    public Client getClient(String login) throws NoUserFoundException;



}
