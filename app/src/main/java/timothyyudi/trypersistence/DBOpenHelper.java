package timothyyudi.trypersistence;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by root on 4/6/2016.
 */
public class DBOpenHelper extends SQLiteOpenHelper {

    final static  String DBNAME="TESDB";
    final static int DBVERSION=1;

    public DBOpenHelper(Context ctx){
        super(ctx, DBNAME, null, DBVERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCreate="CREATE TABLE `MsUser` (\n" +
                "\t`NIM`\tTEXT,\n" +
                "\t`Nama`\tTEXT,\n" +
                "\t`Email`\tTEXT,\n" +
                "\tPRIMARY KEY(NIM)\n" +
                ");";
        String nim="nim123";
        String queryInsert="INSERT INTO `MsUser`" +
                "(`NIM`,`Nama`,`Email`) VALUES (\""+nim+"\",\"nama123\",\"email123\");";
        db.execSQL(queryCreate);
        db.execSQL(queryInsert);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {}
}
