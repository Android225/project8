package com.example.project8.data.DataSources.Room.Entity.Database;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.project8.data.DataSources.Room.Dao.ClientDao;
import com.example.project8.data.DataSources.Room.Entity.Client;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Client.class}, version = 1)
public abstract class ClientDatabase extends RoomDatabase {
    public abstract ClientDao clientDao();

    private static volatile ClientDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    private static final RoomDatabase.Callback sRoomDatabaseCallback
            = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            Log.d("ClientDatabase", "onCreate");
            databaseWriteExecutor.execute(() -> {
                ClientDao dao = INSTANCE.clientDao();
                dao.deleteAll();
            });
        }
    };

    public  static ClientDatabase getDatabase(final Context context) {
        Log.d("ClientDatabase", "getDatabase");
        if (INSTANCE == null) {
            synchronized (ClientDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    ClientDatabase.class, "clients_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}