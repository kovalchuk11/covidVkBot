package vk;

import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.objects.messages.*;
import com.vk.api.sdk.objects.photos.Photo;
import com.vk.api.sdk.objects.photos.PhotoUpload;
import com.vk.api.sdk.objects.photos.responses.MessageUploadResponse;
import com.vk.api.sdk.objects.users.UserXtrCounters;
import com.vk.api.sdk.queries.messages.MessagesSendQuery;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class VKManager {
    public static VKCore vkCore;
    File file = new File("C:\\Users\\I-1\\IdeaProjects\\covid\\download-image23.png");


    String keyboard = "{\n" +
            "  \"one_time\": false,\n" +
            "  \"inline\": true,\n"+
            "  \"buttons\": [\n" +
            "    [\n" +
            "      {\n" +
            "        \"action\": {\n" +
            "          \"type\": \"text\",\n" +
            "          \"payload\": \"{\\\"buttond\\\": \\\"1\\\"}\",\n" +
            "          \"label\": \"Red\"\n" +
            "        },\n" +
            "        \"color\": \"negative\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"action\": {\n" +
            "          \"type\": \"text\",\n" +
            "          \"payload\": \"{\\\"buttond\\\": \\\"2\\\"}\",\n" +
            "          \"label\": \"Green\"\n" +
            "        },\n" +
            "        \"color\": \"positive\"\n" +
            "      }\n" +
            "    ]\n" +
            "  ]\n" +
            "} ";

    static {
        try {
            vkCore = new VKCore();
        } catch (ApiException | ClientException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(String msg, int peerId) throws ClientException, ApiException {
//        PhotoUpload getMessagesUploadServer = vkCore.getVk().photos().getMessagesUploadServer(vkCore.getActor()).execute();
//        MessageUploadResponse uploadPhotoMessage = vkCore.getVk().upload().photoMessage(getMessagesUploadServer.getUploadUrl(), file).execute();
//        List<Photo> saveMessagesPhoto = vkCore.getVk().photos().saveMessagesPhoto(vkCore.getActor(), uploadPhotoMessage.getPhoto()).server(uploadPhotoMessage.getServer()).hash(uploadPhotoMessage.getHash()).execute();

        if (msg == null){
            System.out.println("null");
            return;
        }
        try {
//            MessagesSendQuery messagesSendQuery = new MessagesSendQuery();
            Keyboard keyboard = new Keyboard();
            keyboard.setInline(true);
            KeyboardButton keyboardButton1 = new KeyboardButton().setColor(KeyboardButtonColor.PRIMARY);
            KeyboardButton keyboardButton2 = new KeyboardButton().setColor(KeyboardButtonColor.NEGATIVE);
            KeyboardButtonAction keyboardButtonAction1 = new KeyboardButtonAction()
                    .setType(KeyboardButtonActionType.TEXT)
                    .setPayload("{\"buttond\":\"wather\"}")
                    .setLabel("redddd");
            KeyboardButtonAction keyboardButtonAction2 = new KeyboardButtonAction()
                    .setType(KeyboardButtonActionType.TEXT)
                    .setPayload("{\"buttond\":\"touch\"}")
                    .setLabel("touchmeeeee");

            keyboardButton1.setAction(keyboardButtonAction1);
            keyboardButton2.setAction(keyboardButtonAction2);
            List<KeyboardButton> firstRow = new LinkedList<>();
            firstRow.add(keyboardButton1);
            firstRow.add(keyboardButton2);
            List<List<KeyboardButton>> buttons = new LinkedList<>();
            buttons.add(firstRow);

            keyboard.setButtons(buttons);




            vkCore.getVk().messages()
                    .send(vkCore.getActor())
                    .peerId(peerId)
                    .message(msg)
                    .keyboard(keyboard)
//                    .unsafeParam("keyboard", keyboard)
//                    .attachment("photo"+saveMessagesPhoto.get(0).getOwnerId()+"_"+saveMessagesPhoto.get(0).getId())
                    .attachment("photo-36105708_457239022")
                    .randomId(new Random().nextInt(1000000 ) + 1000000)
                    .execute();
        } catch (ApiException | ClientException e) {
            e.printStackTrace();
        }
    }

    public MessagesSendQuery getSendQuery(){
        return vkCore.getVk().messages().send(vkCore.getActor());
    }

    /**
     * Обращается к VK API и получает объект, описывающий пользователя.
     * @param id идентификатор пользователя в VK
     * @return {@link UserXtrCounters} информацию о пользователе
     * @see UserXtrCounters
     */
    public static UserXtrCounters getUserInfo(int id){
        try {
            return vkCore.getVk().users()
                    .get(vkCore.getActor())
                    .userIds(String.valueOf(id))
                    .execute()
                    .get(0);
        } catch (ApiException | ClientException e) {
            e.printStackTrace();
        }
        return null;
    }

}
