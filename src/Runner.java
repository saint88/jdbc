import data.Student;
import db.IDBExecutor;
import db.MySqlExecutor;
import tables.AbsTable;
import tables.StudentTable;

import java.util.ArrayList;
import java.util.List;

public class Runner {

  public static void main(String... args) {
    IDBExecutor dbExecutor = new MySqlExecutor();
    try {
      AbsTable studentTable = new StudentTable(dbExecutor);

      List<String> columnsStudentTable = new ArrayList<>();
      columnsStudentTable.add("id int primary key");
      columnsStudentTable.add("name varchar(50)");
      columnsStudentTable.add("age int");

      studentTable.create(columnsStudentTable);
    } finally {
      dbExecutor.close();
    }
  }

}
