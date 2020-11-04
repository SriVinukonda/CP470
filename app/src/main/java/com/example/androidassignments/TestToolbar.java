package com.example.androidassignments;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.DialogFragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class TestToolbar extends AppCompatActivity {
    static String message = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_toolbar);
        Toolbar toolbar = findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "You have ordered from Aperture Laboratories", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu m) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar_menu,m);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem mi) {
//        final EditText message = findViewById(android.R.id.content).findViewById(R.id.message);
        int itemId = mi.getItemId();
        switch(itemId) {
            case R.id.action_one:
                Log.d("Toolbar","Option 1 selected");
                if (message == "")
                Snackbar.make(findViewById(android.R.id.content), "You selected item 1", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                else
                Snackbar.make(findViewById(android.R.id.content), message, Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                break;
            case R.id.action_two:
                Log.d("Toolbar","Option 2 selected");
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle(R.string.pick_color)
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                    }
                });
                builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                    }
                });
                // Create the AlertDialog
                AlertDialog dialog = builder.create();
                dialog.show();
                break;
            case R.id.action_three:
                Log.d("Toolbar","Option 3 selected");
                AlertDialog.Builder builderThree = new AlertDialog.Builder(this);
                LayoutInflater inflater = getLayoutInflater();
                final View hackView = inflater.inflate(R.layout.hack_world,null);
                builderThree.setView(hackView)
                .setTitle(R.string.msg_to_world)
                        .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                                EditText messageBox = (EditText) hackView.findViewById(R.id.new_message);
                                message = messageBox.getText().toString();
//                                }
                            }
                        });
                builderThree.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                    }
                });
                // Create the AlertDialog
                AlertDialog dialogThree = builderThree.create();
                dialogThree.show();
                break;
            case R.id.action_four:
                Toast versionToast = Toast.makeText(this,"Version 1.0 by Haricharan Vinukonda",Toast.LENGTH_LONG);
                break;
            default:
                Log.d("Error","MenuItem ID messed up");
                break;
        }

        return true;

    }


}