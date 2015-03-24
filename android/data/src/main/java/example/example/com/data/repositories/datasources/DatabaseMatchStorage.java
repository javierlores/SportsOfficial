package example.example.com.data.repositories.datasources;


import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;

import example.example.com.data.entities.MatchEntity;

public class DatabaseMatchStorage {
    private DatabaseHelper mDatabaseHelper;

    public DatabaseMatchStorage(Context context) {
        mDatabaseHelper = new DatabaseHelper(context);
    }

    public MatchEntity getMatch(int id) {
        SQLiteDatabase database = mDatabaseHelper.getReadableDatabase();

        //Cursor cursor = database.query(DatabaseHelper.TABLE_MATCHES, )

        database.close();
        return  null;
    }

    public List<MatchEntity> getMatchList() {
        SQLiteDatabase database = mDatabaseHelper.getReadableDatabase();

        //Cursor cursor = database.query(DatabaseHelper.TABLE_MATCHES, )

        database.close();
        return  null;
    }

    public void addMatch(MatchEntity match) {
        SQLiteDatabase database = mDatabaseHelper.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(DatabaseHelper.MATCHES_KEY_HOME_TEAM_NAME, match.getHomeTeamName());
        values.put(DatabaseHelper.MATCHES_KEY_AWAY_TEAM_NAME, match.getAwayTeamName());
        values.put(DatabaseHelper.MATCHES_KEY_HOME_TEAM_SCORE, match.getHomeTeamScore());
        values.put(DatabaseHelper.MATCHES_KEY_AWAY_TEAM_SCORE, match.getAwayTeamScore());

        // Date and time

        database.insert(DatabaseHelper.TABLE_MATCHES, null, values);
        database.close();
    }

    public void removeMatch(int id) {
        SQLiteDatabase database = mDatabaseHelper.getWritableDatabase();


        database.close();
    }

    public void updateMatch(MatchEntity match) {
        SQLiteDatabase database = mDatabaseHelper.getWritableDatabase();


        database.close();
    }
}
