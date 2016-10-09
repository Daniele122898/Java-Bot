package com.serenity.rem.modules;

import com.serenity.rem.main.RemListener;
import sx.blah.discord.handle.impl.events.MessageReceivedEvent;
import sx.blah.discord.util.DiscordException;
import sx.blah.discord.util.MissingPermissionsException;
import sx.blah.discord.util.RateLimitException;
import sx.blah.discord.util.RequestBuffer;

/**
 * Created by Daniele on 29.09.2016.
 */
public class Help {


    public static void help(MessageReceivedEvent event){

        String[] msg = event.getMessage().toString().split("\\s");
        if (msg.length < 2 ) {
            RequestBuffer.request(()->{
            try {
                event.getMessage().getChannel().sendMessage(
                                ":information_source: Commands " + "```" +
                                "ping     rem     morning     afk     flip     purge     rmwh\n\n" +
                                "wh       sys     about       inv     help     git       re\n\n" +
                                "ak\n\n" +
                                "```" +
                         "**h <command>:**  gives further information about the command"
                        );
            } catch (MissingPermissionsException | DiscordException e) {
                e.printStackTrace();
            }
            });

        }else{
            //TODO
            switch(msg[1].toLowerCase()) {
                case"ak":
                    akHelpMsg(event);
                    break;
                case"re":
                    try {
                        event.getMessage().getChannel().sendMessage(
                                ":information_source: Commands > wh ```" +
                                        RemListener.getPre()+"wh <mention>\n\n"+
                                        "ParameterType: None\n\n" +
                                        "Premissions needed: None\n\n" +
                                        "Stars or resumes the story of Re:Zero\n" +
                                        "```"
                        );
                    } catch (MissingPermissionsException |RateLimitException |DiscordException e) {
                        e.printStackTrace();
                    }
                    break;
                case"wh":
                    try {
                        event.getMessage().getChannel().sendMessage(
                                ":information_source: Commands > wh ```" +
                                        RemListener.getPre()+"wh <mention>\n\n"+
                                        "ParameterType: Required\n\n" +
                                        "Parameter: Mention of the user that should get Whitelisted\n\n" +
                                        "Premissions needed: ServerOwner status or on the Whitelist\n\n" +
                                        "The user added on the com.serenity.rem.modules.Whitelist can add or remove other people aswell as use administrative commands; Purge etc\n" +
                                        "```"
                        );
                    } catch (MissingPermissionsException |RateLimitException |DiscordException e) {
                        e.printStackTrace();
                    }
                    break;
                case"ping":
                    try {
                        event.getMessage().getChannel().sendMessage(
                                ":information_source: Commands > ping ```" +
                                        RemListener.getPre()+"ping\n\n"+
                                        "ParameterType: None\n\n" +
                                        "Premissions needed: none\n\n" +
                                        "Checks the RTT ping of the bot\n" +
                                        "```"
                        );
                    } catch (MissingPermissionsException |RateLimitException |DiscordException e) {
                        e.printStackTrace();
                    }
                    break;
                case"rem":
                    try {
                        event.getMessage().getChannel().sendMessage(
                                ":information_source: Commands > rem ```" +
                                        RemListener.getPre()+"rem\n\n"+
                                        "ParameterType: None\n\n" +
                                        "Premissions needed: none\n\n" +
                                        "Will post random pictures of Rem that are stored in the Bot's database.\n\n" +
                                        "Current Databse: " + FileStorage.remPics.length +
                                        "```"
                        );
                    } catch (MissingPermissionsException |RateLimitException |DiscordException e) {
                        e.printStackTrace();
                    }
                    break;
                case"morning":
                    try {
                        event.getMessage().getChannel().sendMessage(
                                ":information_source: Commands > morning ```" +
                                        RemListener.getPre()+"morning \n\n"+
                                        "ParameterType: None\n\n" +
                                        "Premissions needed: none\n\n" +
                                        "The user gets greeted why a kawaii picture of Rem for a good start even in mondays\n" +
                                        "```"
                        );
                    } catch (MissingPermissionsException |RateLimitException |DiscordException e) {
                        e.printStackTrace();
                    }
                    break;
                case"afk":
                    try {
                        event.getMessage().getChannel().sendMessage(
                                ":information_source: Commands > afk ```" +
                                        RemListener.getPre()+"afk \n\n"+
                                        "ParameterType: None\n\n" +
                                        "Premissions needed: none\n\n" +
                                        "If you are not on the list yet you will get added so that every user that @mentions " +
                                        "you will get a Response from Rem stating that you are AFK.\n" +
                                        "If you are already on the list it will delete the entry and reset your AFK state.\n" +
                                        "```"
                        );
                    } catch (MissingPermissionsException |RateLimitException |DiscordException e) {
                        e.printStackTrace();
                    }
                    break;
                case"flip":
                    try {
                        event.getMessage().getChannel().sendMessage(
                                ":information_source: Commands > flip ```" +
                                        RemListener.getPre()+"flip \n\n"+
                                        "ParameterType: None\n\n" +
                                        "Premissions needed: none\n\n" +
                                        "Will flip a coin for you. \nThe 1 is tails, the harp is head\n" +
                                        "```"
                        );
                    } catch (MissingPermissionsException |RateLimitException |DiscordException e) {
                        e.printStackTrace();
                    }
                    break;
                case"purge":
                    try {
                        event.getMessage().getChannel().sendMessage(
                                ":information_source: Commands > Purge ```" +
                                        RemListener.getPre()+"Purge <n>\n\n"+
                                        "ParameterType: Required\n\n" +
                                        "Parameter: Number of Messages to delete\n\n" +
                                        "Premissions needed: ServerOwner status or on the Whitelist\n\n" +
                                        "Will delete n messages in the current Channel.\n" +
                                        "100 is the maximum at once otherwise the Bot would get RateLimited\n" +
                                        "```"
                        );
                    } catch (MissingPermissionsException |RateLimitException |DiscordException e) {
                        e.printStackTrace();
                    }
                    break;
                case"rmwh":
                    try {
                        event.getMessage().getChannel().sendMessage(
                                ":information_source: Commands > rmwh ```" +
                                        RemListener.getPre()+"rmwh <mention>\n\n"+
                                        "ParameterType: Required\n\n" +
                                        "Parameter: Mention of the user that should get removed\n\n" +
                                        "Premissions needed: ServerOwner status or on the Whitelist\n\n" +
                                        "The mentioned user will get deleted from the Whitelist, loosing his RemPermissions\n" +
                                        "```"
                        );
                    } catch (MissingPermissionsException |RateLimitException |DiscordException e) {
                        e.printStackTrace();
                    }
                    break;
                case"system":
                case"sys":
                    try {
                        event.getMessage().getChannel().sendMessage(
                                ":information_source: Commands > System```" +
                                        RemListener.getPre()+"System \n"+
                                        RemListener.getPre()+"sys \n\n"+
                                        "ParameterType: None\n\n" +
                                        "Premissions needed: none\n\n" +
                                        "Total Allocated Ram = Total Heap size\n" +
                                        "Used allocated Ram = actual used Ram\n" +
                                        "Free allocated Ram = Free space on heap\n" +
                                        "Max. usable Ram = Max ram the JVM can use to increae heapsize\n\n" +
                                        "----------------------------------------------------\n\n" +
                                        "Shows established connections with; Servers, Channels and Users\n" +
                                        "```" +
                                        "Love to 0xFADED who explained this :heart:"

                        );
                    } catch (MissingPermissionsException |RateLimitException |DiscordException e) {
                        e.printStackTrace();
                    }
                    break;
                case"about":
                    try {
                        event.getMessage().getChannel().sendMessage(
                                ":information_source: Commands > about ```" +
                                        RemListener.getPre()+"h about \n"+
                                        RemListener.getPre()+"Help about \n\n"+
                                        "A huge thanks to:\n\n" +
                                        "0xFADED\n" +
                                        "Igloo\n" +
                                        "dec\n" +
                                        "Arsen4J\n" +
                                        "chrislo27\n\n" +
                                        "Without these awesome people this bot would not be possible" +
                                        "```" +
                                        "Love you guys :heart:"

                        );
                    } catch (MissingPermissionsException |RateLimitException |DiscordException e) {
                        e.printStackTrace();
                    }
                    break;
                case"git":
                    try {
                        event.getMessage().getChannel().sendMessage(
                                ":information_source: Commands > git ```" +
                                        RemListener.getPre()+"git \n\n"+
                                        "ParameterType: None\n\n" +
                                        "Premissions needed: none\n\n" +
                                        "Will post a Link to Rem's Github page\n" +
                                        "```"
                        );
                    } catch (MissingPermissionsException |RateLimitException |DiscordException e) {
                        e.printStackTrace();
                    }
                    break;
                case"invite":
                case"inv":
                    try {
                        event.getMessage().getChannel().sendMessage(
                                ":information_source: Commands > invite ```" +
                                        RemListener.getPre()+"invite \n"+
                                        RemListener.getPre()+"inv \n\n"+
                                        "ParameterType: None\n\n" +
                                        "Premissions needed: none\n\n" +
                                        "Will post the link needed to invite Rem to your Discord Server\n" +
                                        "```"
                        );
                    } catch (MissingPermissionsException |RateLimitException |DiscordException e) {
                        e.printStackTrace();
                    }
                    break;
                default:
                RequestBuffer.request(() -> {
                    try {
                        event.getMessage().getChannel().sendMessage("Invalid Command");
                    } catch (MissingPermissionsException | DiscordException e) {
                        e.printStackTrace();
                    }

                });
                    break;
            }
        }

    }
    public static void akHelpMsg(MessageReceivedEvent event){
        RequestBuffer.request(()->{
        try {
            event.getMessage().getChannel().sendMessage("Check your PMs!");
            event.getMessage().getAuthor().getOrCreatePMChannel().sendMessage("" + //sends private Message
                    ":information_source: Adventure > Acc Creation ```\n" +
                    RemListener.getPre()+"ak\n\n" +
                    "Creates an account if it doesn't already exist.\n\n" +
                    "```\n"+
                    ":information_source: Adventure > Adventure ```\n" +
                    RemListener.getPre()+"ak adv\n\n" +
                    "Begins a battle againt an enemy with similar stats.\n" +
                    "Follow the instructions to either attack or flee.\n" +
                    "```\n" +
                    ":information_source: Adventure > Shop ```\n" +
                    RemListener.getPre()+"ak shop\n" +
                    "Shows the items in the shop.\n\n" +
                    RemListener.getPre()+"ak shop <item> (amount)\n" +
                    "Purchases an item from the shop. If the amount is not specified, you will automatically buy 1 unit. "+
                    "Use the first word of the item. If the first letter of the item is unique, you may also use that.\n" +
                    "For example: \""+RemListener.getPre()+ "ak shop h\" will buy you one health potion\n" +
                    "```\n" +
                    ":information_source: Adventure > Inventory & Use```\n" +
                    RemListener.getPre()+"ak inv\n" +
                    "Shows the items in your inventory.\n\n" +
                    RemListener.getPre()+"ak use <item> (amount)\n" +
                    "Similar to the shop, if the amount is not specified, you will automatically use 1 unit. " +
                    "Use the first word of the item. If the first letter of the item is unique, you may also use that.\n" +
                    "For example: \""+RemListener.getPre()+ "ak use h\" will use one health potion\n" +
                    "```\n" +
                    ":information_source: Adventure > Skill```\n" +
                    RemListener.getPre()+"ak skill\n" +
                    "Shows your current stats and any available skill points.\n" +
                    "Follow the instructions to upgrade your character. The amount is not necessary, but if it is not specified, it will increase by 1 unit." +
                    "```\n"+
                    ":information_source: Adventure > Work```\n" +
                    RemListener.getPre()+"ak work\n" +
                    "Generates money. Will set the cooldown timer to 5 minutes tough.\n" +
                    "```\n"
            );


        } catch (MissingPermissionsException |DiscordException e) {
            e.printStackTrace();
        }});
    }
}
