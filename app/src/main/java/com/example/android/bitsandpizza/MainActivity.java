package com.example.android.bitsandpizza;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ShareActionProvider;
import android.widget.Toast;

public class MainActivity extends Activity {

    private ShareActionProvider provider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
// Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem menuItem = menu.findItem(R.id.action_share);
        provider = (ShareActionProvider) menuItem.getActionProvider();
        setIntent("Simple text");
        return super.onCreateOptionsMenu(menu);
    }

    private void setIntent(String text){
//        Intent intent = new Intent(Intent.createChooser(Intent.ACTION_SEND));
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, text);
        provider.setShareIntent(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_create_order:
                Toast.makeText(this, "no, you're already fat",Toast.LENGTH_SHORT ).show();
                Intent intent = new Intent(this, OrderActivity.class);
                startActivity(intent);
//Code to run when the Create Order item is clicked
                return true;
            case R.id.action_settings:
//Code to run when the settings item is clicked
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}