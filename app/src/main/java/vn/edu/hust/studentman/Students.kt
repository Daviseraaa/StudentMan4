package vn.edu.hust.studentman

import android.database.sqlite.SQLiteDatabase

object Students {
    lateinit var db: SQLiteDatabase

    val ref_list = listOf(
        StudentModel("Nguyễn Văn An", "SV001"),
        StudentModel("Trần Thị Bích", "SV002"),
        StudentModel("Lê Văn Cường", "SV003"),
        StudentModel("Phạm Thị Dung", "SV004"),
        StudentModel("Vũ Văn Hiếu", "SV005")
    )

    val list: MutableList<StudentModel> = mutableListOf()

    val adapter = StudentAdapter(list)

    fun deleteStudent(id: String) {
        db.delete("students", "student_id = ?", arrayOf(id))
    }

    fun insertStudent(name: String, id: String) {
        db.execSQL("INSERT INTO students (name, student_id) VALUES ('$name', '$id')")
    }

    fun updateStudent(student: StudentModel, oldID: String) {
        db.update("students", student.toContentValues(), "student_id = ?", arrayOf(oldID))
    }
}