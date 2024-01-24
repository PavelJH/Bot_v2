package com.mybot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class MyPlayBot extends TelegramLongPollingBot {

    @Override
    public String getBotUsername() {
        return "PlaySilversBot"; // Имя вашего бота
    }

    @Override
    public String getBotToken() {
        return "6880313931:AAFdA9GrvUt-bOmSQbcZuIoTXgNLU7Iv-2E"; // Токен вашего бота
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String messageText = update.getMessage().getText();
            long chatId = update.getMessage().getChatId();

            if (messageText.equals("@play")) {
                SendMessage message = new SendMessage();
                message.setChatId(String.valueOf(chatId));
                message.setText("@ubundows @geliopat @artpechka Максим @Starkillerxxx @PavelJHo8o let's go play");

                try {
                    execute(message); // Отправка сообщения
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
