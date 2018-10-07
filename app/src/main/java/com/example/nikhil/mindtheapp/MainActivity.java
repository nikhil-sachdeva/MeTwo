package com.example.nikhil.mindtheapp;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

<<<<<<< HEAD
import com.example.nikhil.mindtheapp.Adapters.PageAdapter;
=======
import com.example.nikhil.mindtheapp.Navigation_Activities.Movements;
import com.example.nikhil.mindtheapp.Navigation_Activities.NGOs;
import com.example.nikhil.mindtheapp.Navigation_Activities.PoliceInfo;
import com.example.nikhil.mindtheapp.Navigation_Activities.Products;
import com.example.nikhil.mindtheapp.Navigation_Activities.SelfDefence;
>>>>>>> origin/master
import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.IdpResponse;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final int PICK_IMAGE = 2;
    TextView name;
    FirebaseUser user;
    ImageView profilepic;
    Bitmap bitmap;
    private static final int RC_SIGN_IN = 1;
    TabLayout tabLayout;
    ViewPager pager=null;
    DrawerLayout mDrawerLayout;
    List<AuthUI.IdpConfig> providers = Arrays.asList(
            new AuthUI.IdpConfig.EmailBuilder().build(),
            new AuthUI.IdpConfig.PhoneBuilder().build(),
            new AuthUI.IdpConfig.GoogleBuilder().build());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
<<<<<<< HEAD
        getSupportActionBar().setTitle("#MeTwo");
=======
        getSupportActionBar().setTitle("Me2");
>>>>>>> origin/master
        user = FirebaseAuth.getInstance().getCurrentUser();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(user!=null){
                    startActivity(new Intent(MainActivity.this,CreatePost.class));

                }
                else{
                    Toast.makeText(MainActivity.this, "Please login to add a confession", Toast.LENGTH_SHORT).show();
                }

            }
        });

        mDrawerLayout=(DrawerLayout)findViewById(R.id.drawer_layout);
        setSupportActionBar(toolbar);

        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu);
        tabLayout = (TabLayout)findViewById(R.id.tab_layout);
        pager=(ViewPager)findViewById(R.id.pager);
        NavigationView navigationView= (NavigationView)findViewById(R.id.nav_view);
        tabLayout.setupWithViewPager(pager);
        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        PageAdapter myAdapter=new PageAdapter(fragmentManager);
        pager.setAdapter(myAdapter);

        name=findViewById(R.id.name);

        if(user!=null){
            name.setText("Hi "+user.getDisplayName()+" !");
        }
        View headerview = navigationView.getHeaderView(0);
        profilepic = headerview.findViewById(R.id.profilepic);
        profilepic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE);
            }
        });
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId()==R.id.self_defence){
<<<<<<< HEAD
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse("https://www.youtube.com/results?search_query=self+defence"));
                    startActivity(i);
                }
                if(item.getItemId()==R.id.products){
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse("https://www.amazon.in/s/ref=nb_sb_noss?url=search-alias%3Daps&field-keywords=women+safety"));
                    startActivity(i);
                }
                if(item.getItemId()==R.id.pol_stations){
//                    Intent i = new Intent(Intent.ACTION_VIEW);
//                    i.setData(Uri.parse(url));
//                    startActivity(i);
                }
                if(item.getItemId()==R.id.ngos){
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse("https://yourstory.com/2016/04/women-helpline-india/"));
                    startActivity(i);
                }
                if(item.getItemId()==R.id.fem_mov){
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse("http://www.unwomen.org/en/what-we-do/leadership-and-political-participation/womens-movements"));
                    startActivity(i);
=======
                   startActivity(new Intent(MainActivity.this,SelfDefence.class));
                }
                if(item.getItemId()==R.id.products){
                    startActivity(new Intent(MainActivity.this,Products.class));
                }
                if(item.getItemId()==R.id.pol_stations){
                    startActivity(new Intent(MainActivity.this,PoliceInfo.class));
                }
                if(item.getItemId()==R.id.ngos){
                    startActivity(new Intent(MainActivity.this,NGOs.class));
                }
                if(item.getItemId()==R.id.fem_mov){
                    startActivity(new Intent(MainActivity.this,Movements.class));
>>>>>>> origin/master
                }


                return true;}
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode,data);
        if (requestCode == PICK_IMAGE) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = { MediaStore.Images.Media.DATA };

            Cursor cursor = getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();

            bitmap = BitmapFactory.decodeFile(picturePath);
            profilepic.setImageBitmap(bitmap);

        }
        if (requestCode == RC_SIGN_IN) {
            IdpResponse response = IdpResponse.fromResultIntent(data);

            if (resultCode == RESULT_OK) {
                // Successfully signed in
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                // ...
            } else {
                // Sign in failed. If response is null the user canceled the
                // sign-in flow using the back button. Otherwise check
                // response.getError().getErrorCode() and handle the error.
                // ...
            }
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        if(user!=null) {
            getMenuInflater().inflate(R.menu.menu_after_login, menu);
            return true;
        }
        else
            getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        if (id == R.id.login) {
            startActivityForResult(
                    AuthUI.getInstance()
                            .createSignInIntentBuilder()
                            .setAvailableProviders(providers)
                            .build(),
                    RC_SIGN_IN);
            return true;
        }
        if (id == R.id.logout) {
            AuthUI.getInstance()
                    .signOut(this)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        public void onComplete(@NonNull Task<Void> task) {

                        }
                    });
            return true;
        }
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
