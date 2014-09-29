package com.lester.anonchat.pojos;

import java.util.Date;

/**
 * Created by lester on 28.09.14.
 */
public class ChatMessage {
    private boolean isIncoming;
    private String text;
    private Date time;
    private String sender;

    public ChatMessage(String text, Date time, boolean isIncoming) {
        this(text, null, time, isIncoming);
    }

    public ChatMessage(String text, String sender, Date time, boolean isIncoming) {
        this.text = text;
        this.sender = sender;
        this.time = time;
        this.isIncoming = isIncoming;
    }

    public boolean isIncoming() {
        return isIncoming;
    }

    public String getText() {
        return text;
    }

    public Date getTime() {
        return time;
    }

    public String getSender() {
        return sender;
    }
}

