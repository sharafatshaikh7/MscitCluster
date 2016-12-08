package mscitcluster.com.mscitcluster;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

import layout.about;
import layout.college_event;
import layout.feculties;
import layout.feedback;
import layout.home;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    DrawerLayout drawerlayout;
    ActionBarDrawerToggle toggle;
    NavigationView navigationView;
    // protected LinearLayout linearlaout;
    android.support.v4.app.FragmentTransaction fragmenttransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //linearlaout=(LinearLayout)findViewById(R.id.main_content);

        toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //***********************first Time Display Code******************//

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        if (!prefs.getBoolean("firstTime", false)) {
            Intent intent = new Intent(getBaseContext(), First_Time_display.class);
            startActivity(intent);
            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean("firstTime", true);
            editor.commit();
        }


        drawerlayout=(DrawerLayout)findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(
                this, drawerlayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerlayout.setDrawerListener(toggle);

        fragmenttransaction =getSupportFragmentManager().beginTransaction();
        fragmenttransaction.add(R.id.main_content,new home());
        fragmenttransaction.commit();
        getSupportActionBar().setTitle("Home");

        navigationView=(NavigationView)findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.Home:
                        fragmenttransaction=getSupportFragmentManager().beginTransaction();
                        fragmenttransaction.replace(R.id.main_content,new home());
                        fragmenttransaction.commit();
                        getSupportActionBar().setTitle("Home");
                        item.setChecked(true);
                        drawerlayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.Faculties:
                        fragmenttransaction=getSupportFragmentManager().beginTransaction();
                        fragmenttransaction.replace(R.id.main_content,new feculties());
                        fragmenttransaction.commit();
                        getSupportActionBar().setTitle("Faculties");
                        item.setChecked(true);
                        drawerlayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.college_Events:
                        fragmenttransaction=getSupportFragmentManager().beginTransaction();
                        fragmenttransaction.replace(R.id.main_content,new college_event());
                        fragmenttransaction.commit();
                        getSupportActionBar().setTitle("College Events");
                        item.setChecked(true);
                        drawerlayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.About:
                        fragmenttransaction=getSupportFragmentManager().beginTransaction();
                        fragmenttransaction.replace(R.id.main_content,new about());
                        fragmenttransaction.commit();
                        getSupportActionBar().setTitle("About");
                        item.setChecked(true);
                        drawerlayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.nav_share:
                        // final ComponentName name = new ComponentName("com.whatsapp", "com.whatsapp.ContactPicker");
                        Intent oShareIntent = new Intent();
                        //oShareIntent.setComponent(name);
                        oShareIntent.setAction(oShareIntent.ACTION_SEND);
                        oShareIntent.setType("text/plain");
                        oShareIntent.putExtra(android.content.Intent.EXTRA_TEXT, "https://drive.google.com/file/d/0B60AikEqFFszTGFZUy1uNlVnUEU/view?usp=sharing");
                        startActivity(oShareIntent);
                        item.setChecked(true);
                        drawerlayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.feedback:
                        fragmenttransaction=getSupportFragmentManager().beginTransaction();
                        fragmenttransaction.replace(R.id.main_content,new feedback());
                        fragmenttransaction.commit();
                        getSupportActionBar().setTitle("FeedBack");
                        item.setChecked(true);
                        drawerlayout.closeDrawer(GravityCompat.START);
                        break;
                }


                return true;
            }
        });

    }
    @Override
    public void onPostCreate(Bundle savedInstanceState)
    {
        super.onPostCreate(savedInstanceState);
        toggle.syncState();
    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if(id == R.id.exit)
        {
            exitByBackKey();
        }

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exitByBackKey();

            //moveTaskToBack(false);

            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    protected void exitByBackKey() {

        AlertDialog alertbox = new AlertDialog.Builder(this)
                .setMessage("Do you want to exit application?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {

                    // do something when the button is clicked
                    public void onClick(DialogInterface arg0, int arg1) {

                        finish();
                        //close();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {

                    // do something when the button is clicked
                    public void onClick(DialogInterface arg0, int arg1) {
                    }
                })
                .show();
    }
}
