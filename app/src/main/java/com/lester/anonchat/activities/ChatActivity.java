package com.lester.anonchat.activities;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.lester.anonchat.R;
import com.lester.anonchat.adapters.ChatScreenAdapter;
import com.lester.anonchat.pojos.ChatMessage;

import java.util.ArrayList;
import java.util.Calendar;


public class ChatActivity extends Activity {
    private static final String TAG = ChatActivity.class.getSimpleName();
    private EditText messageEditText;
    private ListView messagesContainer;
    private ChatScreenAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        initViews();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.chat, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    private void initViews(){
        messagesContainer = (ListView) findViewById(R.id.messagesContainer);
        messageEditText = (EditText) findViewById(R.id.messageEdit);
        Button sendButton = (Button) findViewById(R.id.chatSendButton);
        adapter = new ChatScreenAdapter(this, new ArrayList<ChatMessage>());
        messagesContainer.setAdapter(adapter);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String lastMsg = messageEditText.getText().toString();
                if (TextUtils.isEmpty(lastMsg)) {
                    return;
                }
                messageEditText.setText("");
                //TODO send message with XMPP
                showMessage(new ChatMessage(lastMsg, Calendar.getInstance().getTime(), false));
            }
        });
    }
    private void showMessage(ChatMessage message) {
        adapter.add(message);
        adapter.notifyDataSetChanged();
        scrollDown();
    }
    private void scrollDown() {
        messagesContainer.setSelection(messagesContainer.getCount() - 1);
    }
}
