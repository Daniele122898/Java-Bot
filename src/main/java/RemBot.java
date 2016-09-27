import sx.blah.discord.api.ClientBuilder;
import sx.blah.discord.api.IDiscordClient;
import sx.blah.discord.util.DiscordException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * Created by Daniele on 27.09.2016.
 */


public class RemBot {

    public static void main(String[] args){ // throws DiscordException
        try{
        IDiscordClient Rem = getClient( getToken(), true);
            Rem.getDispatcher().registerListener(new RemListener());
    } catch (DiscordException e) {

    }
    }

    public static IDiscordClient getClient(String token, boolean login) throws DiscordException { // Returns an instance of the Discord client
        ClientBuilder clientBuilder = new ClientBuilder(); // Creates the ClientBuilder instance
        clientBuilder.withToken(token); // Adds the login info to the builder
        if (login) {
            return clientBuilder.login(); // Creates the client instance and logs the client in
        } else {
            return clientBuilder.build(); // Creates the client instance but it doesn't log the client in yet, you would have to call client.login() yourself
        }
    }

    private static String getToken(){
        File tokenFile = new File("config/token");

        if(!tokenFile.exists())
            System.exit(-1);

        String token = "";

        try {
            token = new String(Files.readAllBytes(tokenFile.toPath()));
        } catch (IOException ignored){}

        if(token.length() != 59)
            System.exit(-1);

        return token;
    }

}

