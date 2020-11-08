package com.example.speedrecords.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.example.speedrecords.util.DateConverter;

import java.util.Date;

@Entity(tableName = "users")
public class User {
 // public static final int GENDER_MALE = 0;
  //public static final int GENDER_FEMALE = 1;

  @PrimaryKey(autoGenerate = true)
  public final int id;

  @ColumnInfo(name = "first_name")
  public final String firstName;

  @ColumnInfo(name = "last_name")
  public final String lastName;
 // @ColumnInfo(name = "distance")
  //public final String ;
  //@ColumnInfo(name = "birth_date")
  //@TypeConverters(DateConverter.class)
  //public final Date birthDate;

  //public final int gender;
  //public final boolean single;

  //@ColumnInfo(name = "some_time")
  //@TypeConverters(DateConverter.class)
  //public final Date someTime;

  public User(int id, String firstName, String lastName) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    //this.birthDate = birthDate;
    //this.gender = gender;
   // this.single = single;
   // this.someTime = someTime;
  }
}
