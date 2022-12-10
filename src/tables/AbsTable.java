package tables;

import db.IDBExecutor;
import db.MySqlExecutor;

import java.util.Collections;
import java.util.List;

public abstract class AbsTable {

  private String tableName;
  private IDBExecutor dbExecutor;

  public AbsTable(String tableName, IDBExecutor dbExecutor) {
    this.tableName = tableName;
    this.dbExecutor = dbExecutor;
  }

  public void create(List<String> colums) {
    dbExecutor.execute(String.format("create table %s (%s)", tableName, String.join(",", colums)));
  }

  public void delete() {
    dbExecutor.execute(String.format("drop table %s", tableName));
  }


}
