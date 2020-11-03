package com.example.androidassignments;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ChatWindow extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_window);

        final ArrayList<String> chatMessages = new ArrayList<String>();
        ListView pastMessages = findViewById(R.id.past_messages);
        final EditText currentMessages = findViewById(R.id.message_box);
        Button sendButton = findViewById(R.id.send_button);

        class ChatAdapter extends ArrayAdapter<String> {
            public ChatAdapter(@NonNull Context context) {
                super(context,0);
            }

            public int getCount() {
                return chatMessages.size();
            }

            public String getItem(int position) {
                return chatMessages.get(position);
            }

            public View getView(int position, View convertView, ViewGroup parent) {
                LayoutInflater inflater = ChatWindow.this.getLayoutInflater();
                View result = null;
                if (position%2 ==0) {
                    result = inflater.inflate(R.layout.chat_row_ingoing,null);
                } else if (position%2 == 1){
                    result = inflater.inflate(R.layout.chat_row_outgoing,null);
                }
                TextView message = result.findViewById(R.id.message_text);
                message.setText(getItem(position)); // get the string at position

                return result;
            }

        }

        final ChatAdapter messageAdapter = new ChatAdapter(this);
        pastMessages.setAdapter(messageAdapter);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String currentMessage = currentMessages.getText().toString();
                chatMessages.add(currentMessage);
                messageAdapter.notifyDataSetChanged(); //this restarts the process of getCount()/
                currentMessages.setText("");

            }
        });
    }


}