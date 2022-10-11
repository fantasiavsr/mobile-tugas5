package polinema.ac.id.dtsapp.data;

import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityDeletionOrUpdateAdapter;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.arch.persistence.room.util.StringUtil;
import android.database.Cursor;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public class UserDao_Impl implements UserDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfUser;

  private final EntityDeletionOrUpdateAdapter __deletionAdapterOfUser;

  private final EntityDeletionOrUpdateAdapter __updateAdapterOfUser;

  public UserDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfUser = new EntityInsertionAdapter<User>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `User`(`username`,`password`,`email`,`phone_number`) VALUES (?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, User value) {
        if (value.username == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.username);
        }
        if (value.password == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.password);
        }
        if (value.email == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.email);
        }
        if (value.phoneNumber == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.phoneNumber);
        }
      }
    };
    this.__deletionAdapterOfUser = new EntityDeletionOrUpdateAdapter<User>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `User` WHERE `username` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, User value) {
        if (value.username == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.username);
        }
      }
    };
    this.__updateAdapterOfUser = new EntityDeletionOrUpdateAdapter<User>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `User` SET `username` = ?,`password` = ?,`email` = ?,`phone_number` = ? WHERE `username` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, User value) {
        if (value.username == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.username);
        }
        if (value.password == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.password);
        }
        if (value.email == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.email);
        }
        if (value.phoneNumber == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.phoneNumber);
        }
        if (value.username == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.username);
        }
      }
    };
  }

  @Override
  public void insertAll(User... users) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfUser.insert(users);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(User user) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfUser.handle(user);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(User user) {
    __db.beginTransaction();
    try {
      __updateAdapterOfUser.handle(user);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<User> getAll() {
    final String _sql = "SELECT * FROM user";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfUsername = _cursor.getColumnIndexOrThrow("username");
      final int _cursorIndexOfPassword = _cursor.getColumnIndexOrThrow("password");
      final int _cursorIndexOfEmail = _cursor.getColumnIndexOrThrow("email");
      final int _cursorIndexOfPhoneNumber = _cursor.getColumnIndexOrThrow("phone_number");
      final List<User> _result = new ArrayList<User>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final User _item;
        _item = new User();
        _item.username = _cursor.getString(_cursorIndexOfUsername);
        _item.password = _cursor.getString(_cursorIndexOfPassword);
        _item.email = _cursor.getString(_cursorIndexOfEmail);
        _item.phoneNumber = _cursor.getString(_cursorIndexOfPhoneNumber);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<User> loadAllByIds(String[] usernameList) {
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT * FROM user WHERE username IN (");
    final int _inputSize = usernameList.length;
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(")");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 0 + _inputSize;
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    for (String _item : usernameList) {
      if (_item == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindString(_argIndex, _item);
      }
      _argIndex ++;
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfUsername = _cursor.getColumnIndexOrThrow("username");
      final int _cursorIndexOfPassword = _cursor.getColumnIndexOrThrow("password");
      final int _cursorIndexOfEmail = _cursor.getColumnIndexOrThrow("email");
      final int _cursorIndexOfPhoneNumber = _cursor.getColumnIndexOrThrow("phone_number");
      final List<User> _result = new ArrayList<User>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final User _item_1;
        _item_1 = new User();
        _item_1.username = _cursor.getString(_cursorIndexOfUsername);
        _item_1.password = _cursor.getString(_cursorIndexOfPassword);
        _item_1.email = _cursor.getString(_cursorIndexOfEmail);
        _item_1.phoneNumber = _cursor.getString(_cursorIndexOfPhoneNumber);
        _result.add(_item_1);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public User selectOne() {
    final String _sql = "SELECT * FROM user LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfUsername = _cursor.getColumnIndexOrThrow("username");
      final int _cursorIndexOfPassword = _cursor.getColumnIndexOrThrow("password");
      final int _cursorIndexOfEmail = _cursor.getColumnIndexOrThrow("email");
      final int _cursorIndexOfPhoneNumber = _cursor.getColumnIndexOrThrow("phone_number");
      final User _result;
      if(_cursor.moveToFirst()) {
        _result = new User();
        _result.username = _cursor.getString(_cursorIndexOfUsername);
        _result.password = _cursor.getString(_cursorIndexOfPassword);
        _result.email = _cursor.getString(_cursorIndexOfEmail);
        _result.phoneNumber = _cursor.getString(_cursorIndexOfPhoneNumber);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public User findByUsernameAndPassword(String username, String password) {
    final String _sql = "SELECT * FROM user WHERE username = ? AND password = ? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (username == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, username);
    }
    _argIndex = 2;
    if (password == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, password);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfUsername = _cursor.getColumnIndexOrThrow("username");
      final int _cursorIndexOfPassword = _cursor.getColumnIndexOrThrow("password");
      final int _cursorIndexOfEmail = _cursor.getColumnIndexOrThrow("email");
      final int _cursorIndexOfPhoneNumber = _cursor.getColumnIndexOrThrow("phone_number");
      final User _result;
      if(_cursor.moveToFirst()) {
        _result = new User();
        _result.username = _cursor.getString(_cursorIndexOfUsername);
        _result.password = _cursor.getString(_cursorIndexOfPassword);
        _result.email = _cursor.getString(_cursorIndexOfEmail);
        _result.phoneNumber = _cursor.getString(_cursorIndexOfPhoneNumber);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
