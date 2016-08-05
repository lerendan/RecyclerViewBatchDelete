package com.example.lerendan.recyclerviewbatchdelete.db;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.example.lerendan.recyclerviewbatchdelete.bean.Crime;
import com.example.lerendan.recyclerviewbatchdelete.db.CrimeDbSchema.CrimeTable;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Administrator on 2016/8/5.
 */

public class CrimeCursorWrapper extends CursorWrapper {
    public CrimeCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public Crime getCrime(){
        String uuidString = getString(getColumnIndex(CrimeTable.Cols.UUID));
        String title =getString(getColumnIndex(CrimeTable.Cols.TITLE));
        long date = getLong(getColumnIndex(CrimeTable.Cols.DATE));
        int isSolved = getInt(getColumnIndex(CrimeTable.Cols.SOLVED));

        Crime crime = new Crime(UUID.fromString(uuidString));
        crime.setTitle(title);
        crime.setData(new Date(date));
        crime.setSolved(isSolved != 0);

        return crime;
    }
}
