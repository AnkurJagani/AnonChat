package com.lester.anonchat;

import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.lester.anonchat.activities.ChatActivity;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

@RunWith(RobolectricTestRunner.class)
@Config(emulateSdk=18, manifest="app/src/main/AndroidManifest.xml")
public class ChatActivityTest {
    private ChatActivity chatActivity;
    @Before
    public void setup()  {
        chatActivity = Robolectric.buildActivity(ChatActivity.class)
                .create().get();
    }
    @Test
    public void buutonClickShouldSendMessage(){
        Button button = (Button) chatActivity.findViewById(R.id.chatSendButton);
        EditText messageEdit = (EditText) chatActivity.findViewById(R.id.messageEdit);
        String messageToSend = "Some message";
        messageEdit.setText(messageToSend);
        button.performClick();
        ListView messageContainer  = (ListView) chatActivity.findViewById(R.id.messagesContainer);
        String receivedMessage = messageContainer.getItemAtPosition(0).toString();//maybe not right
        Assert.assertEquals("Messages equals",messageToSend,receivedMessage);
    }
}
