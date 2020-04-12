package core.commands;

import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.objects.messages.Message;
import vk.VKManager;

public class BottomCommandsHandler {
    CommandExecutor commandExecutor = new CommandExecutor();

    public BottomCommandsHandler(Message message) {
        executeCommand(getCommand(message.getPayload()), message.getPeerId());
    }

    private void executeCommand(String command, int peerId){
        switch (command){
            case "start":
                commandExecutor.sendStartMsg(peerId);
                break;
            case "countryStatistics":
                break;
            case "regionStatistics":

                break;

        }
    }

    public String getCommand(String text){
        return delNonLetter(text.split(":")[1]);
    }

    private String delNonLetter(String text){
        StringBuffer stringBuffer = new StringBuffer();
        for (char ch : text.toCharArray()){
            if(Character.isLetter(ch)){
                stringBuffer.append(ch);
            }
        }
        return stringBuffer.toString();
    }
}
