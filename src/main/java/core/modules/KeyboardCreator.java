package core.modules;

import com.vk.api.sdk.objects.messages.*;

import java.util.LinkedList;
import java.util.List;

public class KeyboardCreator {

    public Keyboard createStartKeyboard() {
        Keyboard keyboard = new Keyboard();
        keyboard.setOneTime(false);
        keyboard.setInline(false);
        KeyboardButton keyboardButton1 = new KeyboardButton().setColor(KeyboardButtonColor.PRIMARY);
        KeyboardButton keyboardButton2 = new KeyboardButton().setColor(KeyboardButtonColor.PRIMARY);
        KeyboardButtonAction keyboardButtonAction1 = new KeyboardButtonAction()
                .setType(KeyboardButtonActionType.TEXT)
                .setPayload("{\"button\":\"countryStatistics\"}")
                .setLabel("Загальна статистика по країні");
        KeyboardButtonAction keyboardButtonAction2 = new KeyboardButtonAction()
                .setType(KeyboardButtonActionType.TEXT)
                .setPayload("{\"button\":\"regionStatistics\"}")
                .setLabel("Перевірити конкретну область");


        return keyboard.setButtons(createButtonList(keyboardButton1, keyboardButton2, keyboardButtonAction1, keyboardButtonAction2));
    }

    public List<List<KeyboardButton>> createButtonList(KeyboardButton keyboardButton1, KeyboardButton keyboardButton2, KeyboardButtonAction keyboardButtonAction1, KeyboardButtonAction keyboardButtonAction2) {
        keyboardButton1.setAction(keyboardButtonAction1);
        keyboardButton2.setAction(keyboardButtonAction2);
        List<KeyboardButton> firstRow = new LinkedList<>();
        firstRow.add(keyboardButton1);
        firstRow.add(keyboardButton2);
        List<List<KeyboardButton>> buttons = new LinkedList<>();
        buttons.add(firstRow);
        return buttons;
    }
}
