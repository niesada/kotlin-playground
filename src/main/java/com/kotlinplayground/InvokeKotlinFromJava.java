package com.kotlinplayground;

import com.kotlinplayground.classes.Authenticate;
import com.kotlinplayground.classes.Course;
import com.kotlinplayground.classes.CourseCategory;
//import com.kotlinplayground.classes.CourseKt;
import com.kotlinplayground.classes.CourseUtils;

public class InvokeKotlinFromJava {

  public static void main(String[] args) {
    var course =
        new Course(
            1,
            "Reactive Programming in Modern Java using Project Reactor",
            "Dilip"
//          ,
//            CourseCategory.DEVELOPMENT
        );

    course.noOfCourse = 11;

    System.out.println("Course : " + course);
    System.out.println("noOfCourse : " + course.noOfCourse);

    CourseUtils.printName1();
    CourseUtils.printName1("abc");

    Course.Companion.printName2("abc");
    Course.printName2("abc1");

    Authenticate.INSTANCE.authenticate("Dilip", "abc");
    Authenticate.authenticate("Dilip", "abc");
  }
}
