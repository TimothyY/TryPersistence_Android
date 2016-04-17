package timothyyudi.trypersistence;

import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    boolean isAdded;

    DBOpenHelper dbOpenHelper;
    SQLiteDatabase sqlite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        isAdded=false;
        dbOpenHelper= new DBOpenHelper(this);
        sqlite = dbOpenHelper.getReadableDatabase();
        Cursor cursor = sqlite.rawQuery("SELECT * FROM MSUSER",null);
        cursor.moveToFirst();
        Toast.makeText(this, cursor.getString(0), Toast.LENGTH_SHORT).show();

        //region shared pref
        SharedPreferences.Editor editor = getSharedPreferences("MyPref", MODE_PRIVATE).edit();
        editor.putString("name", "Elena");
        editor.putInt("idName", 12);
        editor.commit();
        //end region

        SharedPreferences prefs = getSharedPreferences("MyPref", MODE_PRIVATE);
        String name = prefs.getString("name", "No name defined");//"No name defined" is the default value.

        Toast.makeText(this, "shared pref (name): "+name, Toast.LENGTH_SHORT).show();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Toast.makeText(MainActivity.this, item.getTitle()+" clicked", Toast.LENGTH_SHORT).show();
        if(item.getItemId()==R.id.new_game){
            Toast.makeText(MainActivity.this, "New Player only", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        if(isAdded==false)
        menu.add(0,0,0,"Connect to Internet");
        isAdded=true;
        return true;
    }
}
