package jsource_indonesia.co.id.navigationdrawer;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import jsource_indonesia.co.id.navigationdrawer.replacefragment.Fragment1;
import jsource_indonesia.co.id.navigationdrawer.replacefragment.Fragment2;
import jsource_indonesia.co.id.navigationdrawer.replacefragment.Fragment3;

/**
 * Created by muhammad on 19/10/15.
 */
public class NavigationActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;
    private NavigationView navLayout;
    private Fragment fragment1,fragment2,fragment3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_activity);
        toolbar =(Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);

        drawerLayout =(DrawerLayout)findViewById(R.id.drawerLayout);
        toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.setDrawerListener(toggle);
//        toggle.setHomeAsUpIndicator(android.R.drawable.btn_dropdown);
        toggle.syncState();
        navLayout = (NavigationView)findViewById(R.id.navLayout);
        navLayout.setNavigationItemSelectedListener(this);
        fragment1 = new Fragment1();
        fragment2 = new Fragment2();
        fragment3 = new Fragment3();

    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.profile:
                setFragment(fragment1);
                break;
            case R.id.gallery:
                setFragment(fragment2);
                break;
            case R.id.school:
                setFragment(fragment3);
                break;
        }
        return false;
    }
    public void setFragment(Fragment fr){
        getFragmentManager().beginTransaction().replace(R.id.frameLayout,fr).commit();
        drawerLayout.closeDrawer(GravityCompat.START);
    }
    public void addFile(Fragment ads){

    }
}