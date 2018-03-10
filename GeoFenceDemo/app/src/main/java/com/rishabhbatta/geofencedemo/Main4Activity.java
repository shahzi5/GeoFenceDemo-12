package com.rishabhbatta.geofencedemo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class Main4Activity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    Button button1;
    Button button2;
    Button button3;
    Constant constant;
    SharedPreferences.Editor editor;
    SharedPreferences app_preferences;
    int appTheme;
    int themeColor;
    int appColor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        app_preferences = PreferenceManager.getDefaultSharedPreferences(this);
        appColor = app_preferences.getInt("color", 0);
        appTheme = app_preferences.getInt("theme", 0);
        themeColor = appColor;
        constant.color = appColor;

        if (themeColor == 0){
            setTheme(Constant.theme);
        }else if (appTheme == 0){
            setTheme(Constant.theme);
        }else{
            setTheme(appTheme);
        }
        setContentView(R.layout.activity_main4);

        if(!SharedPrefManager.getInstance(this).isLoggedIn()){
            finish();
            startActivity(new Intent(this, LoginActivity.class));
        }

        button1=(Button) findViewById(R.id.loc);
        button2=(Button) findViewById(R.id.loc1);
        button3=(Button) findViewById(R.id.time1);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setBackgroundColor(Constant.color);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }



    @Override
    public void onBackPressed(){
      //  final AlertDialog.Builder builder = new AlertDialog.Builder(Main4Activity.this);
      //  builder.setMessage("Are you sure you want to exit");
        //builder.setCancelable(true);
        //builder.setNegativeButton("NO", new DialogInterface.OnClickListener(){

          //  @Override
           // public void onClick(DialogInterface dialogInterface, int i) {
             //   dialogInterface.cancel();
            //}
        //});
       // builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
           // @Override
         //   public void onClick(DialogInterface dialogInterface, int i) {
       //         finish();
       //     }
       // });

       // builder.setPositiveButton("Yes", new Di)
       // builder.setNegativeButton("Yes", new DialogIn)
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }
      //  AlertDialog alertDialog=builder.create();
       // alertDialog.show();

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.nav_drawer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if(id == R.id.action_settings){
            Intent searchIntent = new Intent(Main4Activity.this, SettingsActivity.class);
            startActivity(searchIntent);
            overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
            return true;
        }
        else if(id== R.id.menuLogout){
            SharedPrefManager.getInstance(this).logout();
            finish();
            startActivity(new Intent(this, LoginActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public boolean onNavigationItemSelected(MenuItem item){
        int id = item.getItemId();

        if(id == R.id.settings){
            Intent searchIntent = new Intent(Main4Activity.this, SettingsActivity.class);
            startActivity(searchIntent);
            overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
        }
        //else if(id == R.id.fileimport){
          //  Intent searchIntent = new Intent(Main4Activity.this, FileImport.class);
            //startActivity(searchIntent);
            //overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
        //}else if(id == R.id.slideshow){
          //  Intent searchIntent = new Intent(Main4Activity.this, SlideShow.class);
            //startActivity(searchIntent);
            //overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
        //}else if(id == R.id.gallery) {
          //  Intent searchIntent = new Intent(Main4Activity.this, Gallery.class);
           // startActivity(searchIntent);
            //overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
       // }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public void location(View view){
        Intent intent=new Intent(getApplicationContext(),ListDataActivity.class);
        startActivity(intent);
    }
    public void location1(View view){
        Intent intent=new Intent(getApplicationContext(),ListDataActivity.class);
        startActivity(intent);
    }
    public void time(View view){
        Intent intent=new Intent(getApplicationContext(),Main3Activity.class);
        startActivity(intent);
    }


}
