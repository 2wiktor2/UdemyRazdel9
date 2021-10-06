package com.wiktor.udemyrazdel9all.lessons.lesson64;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;


//Для того, чтобы хранить объект в базе данных его нужно пометить аннотацией и в круглых скобках можно указать название таблицы
// что бы использовать этот класс в базе данных он должен содержать только один конструктор который использует все поля. Остальные конструкторы должны быть помечены аннотацией @Ignore

@Entity(tableName = "notes")
public class Note {

/*    Можно указать как поле будет называться в бд @ColumnInfo@ColumnInfo(name = "car_name")
    Если в скобках не указывать имя, то в таблице будет использоваться имя переменной
    @ColumnInfo(name = "car_name")
    private String name;*/

    //Пометить аннотацией ключ. И указать что он генерируется автоматически
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String title;
    private String description;
    private int dayOfWeek;
    private int priority;


    //Для того чтобы объект мог содержаться в бд, он должен содержать конструктор (обязательно public), геттеры и сеттры
    // что бы использовать этот класс в базе данных он должен содержать только один конструктор который использует все поля
    public Note(int id, String title, String description, int dayOfWeek, int priority) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.dayOfWeek = dayOfWeek;
        this.priority = priority;
    }

    //Указать какой конструктор использовать бд, а какой игнорировать в таблице используется конструктор со всеми параметрами, остальные помечаются аннотацией @Ignore
    @Ignore
    public Note(String title, String description, int dayOfWeek, int priority) {
        this.title = title;
        this.description = description;
        this.dayOfWeek = dayOfWeek;
        this.priority = priority;
    }

    //Для того чтобы объект мог содержаться в бд, он должен содержать конструктор, геттеры и сеттры
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getDayOfWeek() {
        return dayOfWeek;
    }

    public int getPriority() {
        return priority;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDayOfWeek(int dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public static String getDayAsString(int position) {
        switch (position) {
            case 1:
                return "Понедельник";
            case 2:
                return "Вторник";
            case 3:
                return "Среда";
            case 4:
                return "Четверг";
            case 5:
                return "Пятница";
            case 6:
                return "Суббота";
            default:
                return "Воскресенье";
        }
    }
}
