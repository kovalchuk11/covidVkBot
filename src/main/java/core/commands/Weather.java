package core.commands;

import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.objects.messages.Message;
import core.Command;
import core.modules.WeatherParser;
import vk.VKManager;

import java.io.IOException;

public class Weather extends Command implements ServiceCommand {
    public Weather(String name) {
        super(name);
    }

    @Override
    public void exec(Message message) {

        try {
            new VKManager().sendMessage(getWeather(), message.getPeerId());
        } catch (ClientException e) {
            e.printStackTrace();
        } catch (ApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void service() {

    }

    private String getWeather(){
        String weather;
        try {
            weather = new WeatherParser().getWeatherTodayDescription();
        } catch (IOException e) {
            weather = "не удалось получить погоду";
        }

        return weather;
    }
}
