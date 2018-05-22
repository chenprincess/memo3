package com.dzy.android.memo;

import android.database.Cursor;
import android.database.CursorWrapper;

import java.util.Date;
import java.util.UUID;

import static com.dzy.android.memo.MemoDbSchema.*;

public class MemoCursorWrapper extends CursorWrapper{
    public MemoCursorWrapper(Cursor cursor) {
        super(cursor);
    }
    public Memo getCrime()
    {
        String uuidString=getString(getColumnIndex(CrimeTable.Cols.UUID));
        String title=getString(getColumnIndex(CrimeTable.Cols.TITLE));
        long date=getLong(getColumnIndex(CrimeTable.Cols.DATE));
        String suspect=getString(getColumnIndex(CrimeTable.Cols.SUSPECT));
        Memo memo =new Memo(UUID.fromString(uuidString));
        memo.setTitle(title);
        memo.setDate(new Date(date));
        memo.setSuspect(suspect);
        return memo;
    }
}
