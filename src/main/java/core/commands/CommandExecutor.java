package core.commands;

import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.queries.messages.MessagesSendQuery;
import core.modules.KeyboardCreator;
import vk.VKManager;

import java.util.Random;

public class CommandExecutor {
    private static final String START_MSG = "Що потрібно дізнатись?";

    private VKManager vkManager = new VKManager();
    private KeyboardCreator keyboardCreator = new KeyboardCreator();
    private MessagesSendQuery messagesSendQuery = vkManager.getSendQuery().randomId(getRandomInt());

    public void sendStartMsg(int peerId) {
        messagesSendQuery.peerId(peerId);
        messagesSendQuery.message(START_MSG);
        messagesSendQuery.keyboard(keyboardCreator.createStartKeyboard());
        try {
            messagesSendQuery.execute();
        } catch (ApiException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }

    private int getRandomInt() {
        return new Random().nextInt(1000000) + 1000000;
    }
}
