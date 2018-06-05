package bo.com.cognos.quakeradar.persistence;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import bo.com.cognos.quakeradar.domain.Quake;

@Database(entities = {Quake.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract QuakeDAO getQuakeDAO();

}
