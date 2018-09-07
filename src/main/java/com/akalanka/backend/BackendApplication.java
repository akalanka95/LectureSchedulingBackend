package com.akalanka.backend;


import com.akalanka.backend.config.SecurityUtility;
import com.akalanka.backend.model.*;
import com.akalanka.backend.model.security.Role;
import com.akalanka.backend.model.security.UserRole;
import com.akalanka.backend.repository.AttendanceRepository;
import com.akalanka.backend.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class BackendApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;
	@Autowired
	private DepartmentService departmentService;
	@Autowired
	private SemesterService semesterService;
	@Autowired
	private LectureService lectureService;
	@Autowired
	private StudentService studentService;
	@Autowired
	private  CourseService courseService;
	@Autowired
	private DayService dayService;
	@Autowired
	private TimeService timeService;
	@Autowired
	private  LectureHallService lectureHallService;
	@Autowired
	private TimeTableService timeTableService;
	@Autowired
	private AttendanceRepository attendanceRepository;

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		User user1 = new User();
		user1.setFirstName("John");
		user1.setLastName("Adams");
		user1.setUsername("j");
		user1.setPassword(SecurityUtility.passwordEncoder().encode("p"));
		user1.setEmail("JAdams@gmail.com");
		Set<UserRole> userRoles = new HashSet<>();
		Role role1 = new Role();
		role1.setRoleId(1);
		role1.setName("ROLE_USER");
		userRoles.add(new UserRole(user1, role1));

		userService.createUser(user1, userRoles);

		userRoles.clear();

		User user2 = new User();
		user2.setFirstName("Admin");
		user2.setLastName("Admin");
		user2.setUsername("admin");
		user2.setPassword(SecurityUtility.passwordEncoder().encode("p"));
		user2.setEmail("Admin@gmail.com");
		Role role2 = new Role();
		role2.setRoleId(0);
		role2.setName("ROLE_ADMIN");
		userRoles.add(new UserRole(user2, role2));

		userService.createUser(user2, userRoles);

		//department
		Department department1 = new Department();
		department1.setDepartmentName("cis");
		department1.setActive(true);
		department1.setDescription("adads");
		departmentService.save(department1);

		Department department2 = new Department();
		department2.setActive(true);
		department2.setDepartmentName("Computing and Information System(CIS)");
		department2.setDescription(" The degree program has been designed so that the graduates could cater to the growing demand in government and private sector. ");
		departmentService.save(department2);
		//Semester
		Semester semester1 = new Semester("Semester one");
		semesterService.save(semester1);
		Semester semester2 = new Semester("Semester two");
		semesterService.save(semester2);

		//day
		Day d1 = new Day();
		d1.setDay("Monday");
		d1.setActive(true);
		dayService.save(d1);

		Day d2 = new Day();
		d2.setDay("Tuesday");
		d2.setActive(false);
		dayService.save(d2);

		//Time
		Time time18 = new Time();
		time18.setTime("8:00");
		timeService.save(time18);

		Time time19 = new Time();
		time19.setTime("8:30");
		timeService.save(time19);

		Time time20 = new Time();
		time20.setTime("9:00");
		timeService.save(time20);
        Time time21 = new Time();
        time21.setTime("9:30");
        timeService.save(time21);
        Time time22 = new Time();
        time22.setTime("10:00");
        timeService.save(time22);
        Time time23 = new Time();
        time23.setTime("10:30");
        timeService.save(time23);
        Time time24 = new Time();
        time24.setTime("11:00");
        timeService.save(time24);
        Time time25 = new Time();
        time25.setTime("11:30");
        timeService.save(time25);
        Time time26 = new Time();
        time26.setTime("12:00");
        timeService.save(time26);
        Time time27 = new Time();
        time27.setTime("12:30");
        timeService.save(time27);
        Time time28 = new Time();
        time28.setTime("13:00");
        timeService.save(time28);
        Time time29 = new Time();
        time29.setTime("13:30");
        timeService.save(time29);
        Time time30 = new Time();
        time30.setTime("14:00");
        timeService.save(time30);

		//attendance
		Attendance attendance = new Attendance();
		attendance.setMonday(true);
		attendance.setTuesday(true);
		attendance.setWednesday(true);
		attendance.setThursday(true);
		attendance.setFriday(true);

		Attendance attendance1 = new Attendance();
		attendance1.setMonday(true);
		attendance1.setTuesday(true);
		attendance1.setWednesday(true);
		attendance1.setThursday(true);
		attendance1.setFriday(true);

		Attendance attendance2 = new Attendance();
		attendance2.setMonday(true);
		attendance2.setTuesday(true);
		attendance2.setWednesday(true);
		attendance2.setThursday(true);
		attendance2.setFriday(true);

		//LectureHall
		LectureHall lectureHall = new LectureHall();
		lectureHall.setCode("LT-104");
		lectureHall.setDescription("A specific lecture hall in the faculty");
		lectureHall.setName("LT-104");
		lectureHall.setCapacity(150);
		lectureHallService.save(lectureHall);

		LectureHall lectureHall1 = new LectureHall();
		lectureHall1.setCode("LT-105");
		lectureHall1.setDescription("A specific lecture hall in the faculty");
		lectureHall1.setName("LT-105");
		lectureHall1.setCapacity(150);
		lectureHallService.save(lectureHall1);

		//lecturer
		Lecture lecture = new Lecture();
		lecture.setAddress("colombo");
		lecture.setContact("+94453454527");
		lecture.setEmail("nirmaliw@appsc.sab.ac.lk");
		lecture.setFullName("Dr.M.Nirmali Wicramaratne");
		lecture.setRole("Senior Lecturer");
		lecture.setActive(true);
		lecture.setDepartment(department1);
		lecture.setAttendance(attendance);
		lectureService.save(lecture);

		Lecture lecture2 = new Lecture();
		lecture2.setAddress("Kurunegala");
		lecture2.setContact("+94714433425");
		lecture2.setEmail("malavisarath@appsc.sab.ac.lk");
		lecture2.setFullName("Mr.S.Malavipathirana");
		lecture2.setRole("Lecturer");
		lecture2.setActive(true);
		lecture2.setDepartment(department2);
		lecture2.setAttendance(attendance1);
		lectureService.save(lecture2);

		Lecture lecture3 = new Lecture();
		lecture3.setAddress("Kurunegala");
		lecture3.setContact("+94714433425");
		lecture3.setEmail("malavisarath@appsc.sab.ac.lk");
		lecture3.setFullName("Mr.S.Jayaweera");
		lecture3.setRole("Lecturer");
		lecture3.setActive(true);
		lecture3.setDepartment(department2);
		lecture3.setAttendance(attendance2);
		lectureService.save(lecture3);


		//Student
		Student student1 = new Student();
		student1.setActive(true);
		student1.setAddress("23");
		student1.setContact("12");
		student1.setEmail("as");
		student1.setFullName("ak");
		student1.setRole("ad");
		student1.setDepartment(department1);
		student1.setSemester(semester1);
		studentService.save(student1);

		//Course
		Course course = new Course();
		course.setCourseCode("IS22221");
		course.setCourseName("Operating Systems");
		course.setDescription("This is regarding Operating System");
		course.setDepartment(department1);
		course.setLecture(lecture);
		course.setLectureHall(lectureHall);
		course.setSemester(semester1);

		Course course1 = new Course();
		course1.setCourseCode("IS3000");
		course1.setCourseName("Agile Systems");
		course1.setDescription("This is regarding Operating System");
		course1.setDepartment(department1);
		course1.setLecture(lecture);
		course1.setLectureHall(lectureHall);
		course1.setSemester(semester1);
		/*courseService.save(course);*/

		//TimeTable
		TimeTable timeTable = new TimeTable();
		timeTable.setActive(true);
		timeTable.setState("old");
		timeTable.setCourse(course);
		timeTable.setSemester(semester1);
		timeTable.setDate(d1);
		timeTable.setStartTime(time18);
		timeTable.setEndTime(time20);
		timeTable.setLecture(lecture);
		timeTable.settWeek(false);
		timeTable.setnWeek(true);
		timeTableService.save(timeTable);

		TimeTable timeTable1 = new TimeTable();
		timeTable1.setActive(true);
		timeTable1.setState("new");
		timeTable1.setCourse(course1);
		timeTable1.setSemester(semester1);
		timeTable1.setDate(d1);
		timeTable1.setStartTime(time21);
		timeTable1.setEndTime(time23);
		timeTable1.setLecture(lecture);
		timeTable1.settWeek(true);
		timeTable1.setnWeek(false);
		timeTableService.save(timeTable1);

		/*TimeTable timeTable3 = new TimeTable();
		timeTable3.setActive(true);
		timeTable3.setState("new");
		timeTable3.setCourse(course);
		timeTable3.setSemester(semester1);
		timeTable3.setDate(d1);
		timeTable3.setStartTime(time26);
		timeTable3.setEndTime(time28);
		timeTable3.setLecture(lecture);
		timeTable3.settWeek(false);
		timeTable3.setnWeek(true);
		timeTableService.save(timeTable3);*/

	}

}
