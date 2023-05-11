package celilcavus.JavaAndroid.phoneDirectory;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import celilcavus.JavaAndroid.phoneDirectory.Model.PhoneNumbers;

public class DatabaseContext {
    private final String DatabaseName = "phoneDirectory";
    private final SQLiteDatabase database;

    public DatabaseContext(Context context) {
        database = context.openOrCreateDatabase(DatabaseName, Context.MODE_PRIVATE, null);
        database.execSQL("CREATE TABLE IF NOT EXISTS phoneNumbers (ID INTEGER  PRIMARY KEY AUTOINCREMENT,Name Varchar(100),LastName Varchar(100),PhoneNumber Varchar(30))");
    }

    public ArrayList<PhoneNumbers> GetAll() {
        int idIndex = 0, nameIndex = 0, lastNameIndex = 0, phoneNumberIndex = 0;
        ArrayList<PhoneNumbers> person = new ArrayList<>();
        try {
            Cursor cursor = database.rawQuery("SELECT * FROM phoneNumbers", null);

            idIndex = cursor.getColumnIndex("ID");
            nameIndex = cursor.getColumnIndex("Name");
            lastNameIndex = cursor.getColumnIndex("LastName");
            phoneNumberIndex = cursor.getColumnIndex("PhoneNumber");

            while (cursor.moveToNext() && cursor != null) {
                PhoneNumbers p = new PhoneNumbers();

                p.Id = Integer.parseInt(cursor.getString(idIndex));
                p.Name = cursor.getString(nameIndex);
                p.LastName = cursor.getString(lastNameIndex);
                p.PhoneNumber = cursor.getString(phoneNumberIndex);

                person.add(p);
            }
            System.out.println("Person " + person);
            return person;
        } catch (Exception ex) {
            System.out.println("ex = " + ex);
            return null;
        }
    }

    public void Add(PhoneNumbers phoneNumbers) {
        try {
            /*
            String query = String.format("INSERT INTO phoneNumbers (Name,LastName,PhoneNumber) values ({0},{1},{2})",
                    phoneNumbers.Name,
                    phoneNumbers.LastName,
                    phoneNumbers.PhoneNumber);
             */
            String sql = "INSERT INTO phoneNumbers (Name,LastName,PhoneNumber) values (?,?,?)";
            SQLiteStatement st = database.compileStatement(sql);
            st.bindString(1,phoneNumbers.Name);
            st.bindString(2,phoneNumbers.LastName);
            st.bindString(3,phoneNumbers.PhoneNumber);
            st.execute();

        } catch (Exception ex) {
            System.out.println("ex = " + ex);
        }

    }

    public void Update(PhoneNumbers phoneNumbers) {
        try{
            String UpdateQuery = "UPDATE  phoneNumbers SET Name = ?, LastName = ?,PhoneNumber = ? where ID = ?";
            SQLiteStatement sqLiteStatement = database.compileStatement(UpdateQuery);
            sqLiteStatement.bindString(1,phoneNumbers.Name);
            sqLiteStatement.bindString(2,phoneNumbers.LastName);
            sqLiteStatement.bindString(3,phoneNumbers.PhoneNumber);
            sqLiteStatement.bindLong(4,phoneNumbers.Id);
            sqLiteStatement.execute();
        }
        catch (Exception ex)
        {
            System.out.println("Database Context Update Method Ex = " + ex);
        }

    }

    public void Delete(int id) {
        try{
            database.execSQL("DELETE FROM phoneNumbers where ID = " + id);
        }
        catch (Exception ex)
        {
            System.out.println("Database Context Delete Method Ex " + ex);
        }
    }
}
