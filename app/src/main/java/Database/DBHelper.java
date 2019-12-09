package Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "User.db";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String SQL_CREATE_ENTRIES =
                "CREATE TABLE " + UserProfile.Users.TABLE_NAME + " (" +
                        UserProfile.Users._ID + " INTEGER PRIMARY KEY," +
                        UserProfile.Users.COLUMN_NAME_USERNAME + " TEXT," +
                        UserProfile.Users.COLUMN_NAME_PASSWORD + " TEXT," +
                        UserProfile.Users.COLUMN_NAME_DATEOFBIRTH + " TEXT," +
                        UserProfile.Users.COLUMN_NAME_GENDER + " TEXT)";

        sqLiteDatabase.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //
    }

    public long addInfo(String username, String password, String dob) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(UserProfile.Users.COLUMN_NAME_USERNAME, username);
        values.put(UserProfile.Users.COLUMN_NAME_PASSWORD, password);
        values.put(UserProfile.Users.COLUMN_NAME_DATEOFBIRTH, dob);
        //values.put(UserProfile.Users.COLUMN_NAME_GENDER, gender);

        long newRowId = db.insert(UserProfile.Users.TABLE_NAME, null, values);

        return newRowId;
    }

    public boolean updateInfo(int id, String username, String password, String dob, String gender) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(UserProfile.Users.COLUMN_NAME_PASSWORD, password);
        values.put(UserProfile.Users.COLUMN_NAME_PASSWORD, dob);
        values.put(UserProfile.Users.COLUMN_NAME_PASSWORD, gender);

        String selection = UserProfile.Users.COLUMN_NAME_USERNAME + " LIKE ?";
        String[] selectionArgs = { username };

        int count = db.update(
                UserProfile.Users.TABLE_NAME,
                values,
                selection,
                selectionArgs);

        if (count == 1)
            return true;
        else
            return false;
    }

    public Cursor readAllInfo() {
        SQLiteDatabase db = getReadableDatabase();

        String[] projection = {
                BaseColumns._ID,
                UserProfile.Users.COLUMN_NAME_USERNAME,
                UserProfile.Users.COLUMN_NAME_PASSWORD,
                UserProfile.Users.COLUMN_NAME_DATEOFBIRTH,
                UserProfile.Users.COLUMN_NAME_GENDER
        };

        Cursor cursor = db.query(
                UserProfile.Users.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null
        );

        return cursor;
    }

    public void readAllInfo(int id) {
        SQLiteDatabase db = getReadableDatabase();

        String[] projection = {
                BaseColumns._ID,
                UserProfile.Users.COLUMN_NAME_USERNAME,
                UserProfile.Users.COLUMN_NAME_PASSWORD,
                UserProfile.Users.COLUMN_NAME_DATEOFBIRTH,
                UserProfile.Users.COLUMN_NAME_GENDER
        };

        String selection = BaseColumns._ID + " = ?";
        String[] selectionArgs = { "" + id };

        Cursor cursor = db.query(
                UserProfile.Users.TABLE_NAME,
                projection,
                selection,
                selectionArgs,
                null,
                null,
                null
        );
    }

    public boolean deleteInfo() {
        SQLiteDatabase db = getReadableDatabase();

        String selection = UserProfile.Users.COLUMN_NAME_USERNAME + " LIKE ?";
        String[] selectionArgs = { "MyTitle" };

        int deletedRows = db.delete(UserProfile.Users.TABLE_NAME, selection, selectionArgs);

        if (deletedRows == 1)
            return true;
        else
            return false;
    }

    public boolean login(String username, String password) {
        Cursor cursor;
        cursor = readAllInfo();

        return false;
    }
}
