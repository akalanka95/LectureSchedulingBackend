package com.akalanka.backend;


import com.akalanka.backend.config.GmailInbox;
import com.akalanka.backend.config.SecurityUtility;
import com.akalanka.backend.model.*;
import com.akalanka.backend.model.security.Role;
import com.akalanka.backend.model.security.UserRole;
import com.akalanka.backend.repository.*;
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
	@Autowired
	private WeekRepository weekRepository;
	@Autowired
	private MessageRepository messageRepository;
	@Autowired
	private RegisterRepository indexRepository;
	@Autowired
	private ResultRepository resultRepository;

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		GmailInbox gmail = new GmailInbox();
		gmail.read();

		User user1 = new User();
		user1.setFirstName("John");
		user1.setLastName("Adams");
		user1.setUsername("a");
		user1.setPassword(SecurityUtility.passwordEncoder().encode("m"));
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
		/*Department department1 = new Department();
		department1.setDepartmentName("cis");
		department1.setActive(true);
		department1.setDescription("adads");
		departmentService.save(department1);*/

		Department department2 = new Department();
		department2.setActive(true);
		department2.setDepartmentName("Computing and Information System(CIS)");
		department2.setDescription(" The degree program has been designed so that the graduates could cater to the growing demand in government and private sector. ");
		departmentService.save(department2);
		//Semester
		Semester semester1 = new Semester("Year 1");
		semesterService.save(semester1);
		Semester semester2 = new Semester("Year 2");
		semesterService.save(semester2);
		Semester semester3 = new Semester("Year 3");
		semesterService.save(semester3);
		Semester semester4 = new Semester("Year 4");
		semesterService.save(semester4);

		// Week
		Week w1 = new Week();
		w1.setActive(true);
		w1.setWeek("Week 1");
		weekRepository.save(w1);

		Week w2 = new Week();
		w2.setActive(false);
		w2.setWeek("Week 2");
		weekRepository.save(w2);

		Week w3 = new Week();
		w3.setActive(false);
		w3.setWeek("Week 3");
		weekRepository.save(w3);

		Week w4 = new Week();
		w4.setActive(false);
		w4.setWeek("Week 4");
		weekRepository.save(w4);

		Week w5 = new Week();
		w5.setActive(false);
		w5.setWeek("Week 5");
		weekRepository.save(w5);

		Week w6 = new Week();
		w6.setActive(false);
		w6.setWeek("Week 6");
		weekRepository.save(w6);

		Week w7 = new Week();
		w7.setActive(false);
		w7.setWeek("Week 7");
		weekRepository.save(w7);

		Week w8 = new Week();
		w8.setActive(false);
		w8.setWeek("Week 8");
		weekRepository.save(w8);

		Week w9 = new Week();
		w9.setActive(false);
		w9.setWeek("Week 9");
		weekRepository.save(w9);

		Week w10 = new Week();
		w10.setActive(false);
		w10.setWeek("All Weeks");
		weekRepository.save(w10);

		//day
		Day d1 = new Day();
		d1.setDay("Monday");
		d1.setActive(true);
		dayService.save(d1);

		Day d2 = new Day();
		d2.setDay("Tuesday");
		d2.setActive(true);
		dayService.save(d2);

		Day d3 = new Day();
		d3.setDay("Wednesday");
		d3.setActive(true);
		dayService.save(d3);

		Day d4 = new Day();
		d4.setDay("Thursday");
		d4.setActive(true);
		dayService.save(d4);

		Day d5 = new Day();
		d5.setDay("Friday");
		d5.setActive(true);
		dayService.save(d5);

		//Time
		Time time8 = new Time();
		time8.setTime("8:00");
		timeService.save(time8);

		Time time81 = new Time();
		time81.setTime("8:30");
		timeService.save(time81);

		Time time9 = new Time();
		time9.setTime("9:00");
		timeService.save(time9);
        Time time91 = new Time();
        time91.setTime("9:30");
        timeService.save(time91);
        Time time10 = new Time();
        time10.setTime("10:00");
        timeService.save(time10);
        Time time101 = new Time();
        time101.setTime("10:30");
        timeService.save(time101);
        Time time11 = new Time();
        time11.setTime("11:00");
        timeService.save(time11);
        Time time111 = new Time();
        time111.setTime("11:30");
        timeService.save(time111);
        Time time12 = new Time();
        time12.setTime("12:00");
        timeService.save(time12);
        Time time121 = new Time();
        time121.setTime("12:30");
        timeService.save(time121);
        Time time13 = new Time();
        time13.setTime("13:00");
        timeService.save(time13);
        Time time131 = new Time();
        time131.setTime("13:30");
        timeService.save(time131);
        Time time14 = new Time();
        time14.setTime("14:00");
        timeService.save(time14);
		Time time141 = new Time();
		time141.setTime("14:30");
		timeService.save(time141);
		Time time15 = new Time();
		time15.setTime("15:00");
		timeService.save(time15);
		Time time151 = new Time();
		time151.setTime("15:30");
		timeService.save(time151);
		Time time16 = new Time();
		time16.setTime("16:00");
		timeService.save(time16);
		Time time161 = new Time();
		time161.setTime("16:30");
		timeService.save(time161);
		Time time17 = new Time();
		time17.setTime("17:00");
		timeService.save(time17);

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

		Attendance attendance3 = new Attendance();
		attendance3.setMonday(true);
		attendance3.setTuesday(true);
		attendance3.setWednesday(true);
		attendance3.setThursday(true);
		attendance3.setFriday(true);

		Attendance attendance4 = new Attendance();
		attendance4.setMonday(true);
		attendance4.setTuesday(true);
		attendance4.setWednesday(true);
		attendance4.setThursday(true);
		attendance4.setFriday(true);

        Attendance attendance5 = new Attendance();
        attendance5.setMonday(true);
        attendance5.setTuesday(true);
        attendance5.setWednesday(true);
        attendance5.setThursday(true);
        attendance5.setFriday(true);

        Attendance attendance6 = new Attendance();
        attendance6.setMonday(true);
        attendance6.setTuesday(true);
        attendance6.setWednesday(true);
        attendance6.setThursday(true);
        attendance6.setFriday(true);

        Attendance attendance7 = new Attendance();
        attendance7.setMonday(true);
        attendance7.setTuesday(true);
        attendance7.setWednesday(true);
        attendance7.setThursday(true);
        attendance7.setFriday(true);

        Attendance attendance8 = new Attendance();
        attendance8.setMonday(true);
        attendance8.setTuesday(true);
        attendance8.setWednesday(true);
        attendance8.setThursday(true);
        attendance8.setFriday(true);

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

		LectureHall lectureHall2 = new LectureHall();
		lectureHall2.setCode("LT-202");
		lectureHall2.setDescription("A lecture hall inside the faculty");
		lectureHall2.setName("LT-202");
		lectureHall2.setCapacity(50);
		lectureHallService.save(lectureHall2);

		LectureHall lectureHall3 = new LectureHall();
		lectureHall3.setCode("Z-9");
		lectureHall3.setDescription("Old lecture hall");
		lectureHall3.setName("Z-9");
		lectureHall3.setCapacity(75);
		lectureHallService.save(lectureHall3);

		LectureHall lectureHall4 = new LectureHall();
		lectureHall4.setCode("NLH");
		lectureHall4.setDescription("New lecture hall");
		lectureHall4.setName("NLH");
		lectureHall4.setCapacity(100);
		lectureHallService.save(lectureHall4);

		LectureHall lectureHall5 = new LectureHall();
		lectureHall5.setCode("CIS Lab 01");
		lectureHall5.setDescription("CIS Computer Laboratory");
		lectureHall5.setName("CIS Lab 01");
		lectureHall5.setCapacity(40);
		lectureHallService.save(lectureHall5);

        LectureHall lectureHall6 = new LectureHall();
        lectureHall6.setCode("CIS Lab 02");
        lectureHall6.setDescription("CIS Computer Laboratory");
        lectureHall6.setName("CIS Lab 02");
        lectureHall6.setCapacity(80);
        lectureHallService.save(lectureHall6);

		//lecturer
		Lecture lecture = new Lecture();
		lecture.setAddress("colombo");
		lecture.setContact("+94767068361");
		lecture.setEmail("akalankamaduka95@gmail.com");
		lecture.setFullName("Dr. BTGS Kumara");
		lecture.setRole("Head of the Department");
		lecture.setActive(true);
		lecture.setDepartment(department2);
		lecture.setAttendance(attendance);
		lecture.setImageUrl("Lec01.jpg");
		lecture.setCode("Lec1001");
		lectureService.save(lecture);

		Lecture lecture2 = new Lecture();
		lecture2.setAddress("Kurunegala");
		lecture2.setContact("+94714433425");
		lecture2.setEmail("priyan@appsc.sab.ac.lk");
		lecture2.setFullName("Dr. S Vasanthapriyan");
		lecture2.setRole("Senior Lecturer");
		lecture2.setActive(true);
		lecture2.setDepartment(department2);
		lecture2.setAttendance(attendance1);
        lecture2.setImageUrl("Lec02.jpg");
        lecture2.setCode("Lec1002");
		lectureService.save(lecture2);

		Lecture lecture3 = new Lecture();
		lecture3.setAddress("Galle");
		lecture3.setContact("+94714433425");
		lecture3.setEmail("ravindra.dangalla@appsc.sab.ac.lk");
		lecture3.setFullName("Mr. RL Dangalla");
		lecture3.setRole("Lecturer");
		lecture3.setActive(true);
		lecture3.setDepartment(department2);
		lecture3.setAttendance(attendance2);
        lecture3.setImageUrl("Lec03.jpg");
        lecture3.setCode("Lec1003");
		lectureService.save(lecture3);

		Lecture lecture4 = new Lecture();
		lecture4.setAddress("Ratnapura");
		lecture4.setContact("+94453454527");
		lecture4.setEmail("slekamge@appsc.sab.ac.lk");
		lecture4.setFullName("Dr. LS Lekamge");
		lecture4.setRole("Lecture");
		lecture4.setActive(true);
		lecture4.setDepartment(department2);
		lecture4.setAttendance(attendance3);
        lecture4.setImageUrl("Lec04.jpg");
        lecture4.setCode("Lec1004");
		lectureService.save(lecture4);

		Lecture lecture5 = new Lecture();
		lecture5.setAddress("Colombo");
		lecture5.setContact("+94717851500");
		lecture5.setEmail("wimalasooriya@appsc.sab.ac.lk");
		lecture5.setFullName("Mrs. CU Wimalasooriya");
		lecture5.setRole("Lecturer");
		lecture5.setActive(true);
		lecture5.setDepartment(department2);
		lecture5.setAttendance(attendance4);
        lecture5.setImageUrl("Lec05.jpg");
        lecture5.setCode("Lec1005");
		lectureService.save(lecture5);

        Lecture lecture6 = new Lecture();
        lecture6.setAddress("Colombo");
        lecture6.setContact("+94717851500");
        lecture6.setEmail("hansi@appsc.sab.ac.lk");
        lecture6.setFullName("Mrs. HN Gunasinghe");
        lecture6.setRole("Lecturer");
        lecture6.setActive(true);
        lecture6.setDepartment(department2);
        lecture6.setAttendance(attendance5);
        lecture6.setImageUrl("Lec06.jpg");
        lecture6.setCode("Lec1006");
        lectureService.save(lecture6);

        Lecture lecture7 = new Lecture();
        lecture7.setAddress("Colombo");
        lecture7.setContact("+94717851500");
        lecture7.setEmail("kalinga@appsc.sab.ac.lk");
        lecture7.setFullName("Mr. HMKT Gunawardhana");
        lecture7.setRole("Lecturer");
        lecture7.setActive(true);
        lecture7.setDepartment(department2);
        lecture7.setAttendance(attendance6);
        lecture7.setImageUrl("Lec07.jpg");
        lecture7.setCode("Lec1007");
        lectureService.save(lecture7);

        Lecture lecture8 = new Lecture();
        lecture8.setAddress("Colombo");
        lecture8.setContact("+94717851500");
        lecture8.setEmail("anuradha.herath@appsc.sab.ac.lk");
        lecture8.setFullName("Mr. GACA Herath");
        lecture8.setRole("Lecturer");
        lecture8.setActive(true);
        lecture8.setDepartment(department2);
        lecture8.setAttendance(attendance7);
        lecture8.setImageUrl("Lec08.jpg");
        lecture8.setCode("Lec1008");
        lectureService.save(lecture8);

        Lecture lecture9 = new Lecture();
        lecture9.setAddress("Colombo");
        lecture9.setContact("+94717851500");
        lecture9.setEmail("smadhara@appsc.sab.ac.lk");
        lecture9.setFullName("Mrs HN Samadhara");
        lecture9.setRole("Lecturer");
        lecture9.setActive(true);
        lecture9.setDepartment(department2);
        lecture9.setAttendance(attendance8);
        lecture9.setImageUrl("Lec09.jpg");
        lecture9.setCode("Lec1009");
        lectureService.save(lecture9);


		//Student
		Student student1 = new Student();
		student1.setActive(true);
		student1.setAddress("No 34 , Kandy ");
		student1.setContact("+94767068361");
		student1.setEmail("hashan@gmail.com");
		student1.setFullName("Hashan Malwenna");
		student1.setRole("Representative");
		student1.setDepartment(department2);
		student1.setSemester(semester3);
		student1.setImageUrl("St01.jpg");
		studentService.save(student1);

		//message
		Message m1 = new Message();
		m1.setDate("2018/10/03");
		m1.setTime("8.30am");
		m1.setType("send");
		m1.setMessage("I want to add a lecture on Advance DBMS for year 3 in this week");
		m1.setLecture(lecture);
		messageRepository.save(m1);


		Message m2 = new Message();
		m2.setDate("2018/10/04");
		m2.setTime("9.30am");
		m2.setType("send");
		m2.setMessage("Can I get to know whether NLH lecture hall is available on Monday from 8 to 10");
		m2.setLecture(lecture);
		messageRepository.save(m2);

		Message m3 = new Message();
		m3.setDate("2018/10/5");
		m3.setTime("10.30am");
		m3.setType("received");
		m3.setMessage("Lecture will be added on Monday 10 to 12 on Advance DBMS in NLH lecture Hall");
		m3.setLecture(lecture);
		messageRepository.save(m3);

		Message m4 = new Message();
		m4.setDate("2018/10/23");
		m4.setTime("10.30am");
		m4.setType("received");
		m4.setMessage("All Lecture was cancelled on Monday");
		m4.setLecture(lecture2);
		messageRepository.save(m4);

		//Course
        Course course00 = new Course();
        course00.setCourseCode("IS11201");
        course00.setCourseName("Fundamentals of Information Systems");
        course00.setDescription("Fundamentals of Information Systems");
        course00.setDepartment(department2);
        course00.setLecture(lecture5);
        course00.setSemester(semester1);
        course00.setCourseCredit(2);
        courseService.save(course00);

        Course course01 = new Course();
        course01.setCourseCode("IS11202");
        course01.setCourseName("Structured Programming Techniques");
        course01.setDescription("Structured Programming Techniques");
        course01.setDepartment(department2);
        course01.setLecture(lecture3);
        course01.setSemester(semester1);
        course01.setCourseCredit(2);
        courseService.save(course01);

        Course course02 = new Course();
        course02.setCourseCode("IS11203");
        course02.setCourseName("Information Systems Theory and Practice");
        course02.setDescription("Information Systems Theory and Practice");
        course02.setDepartment(department2);
        course02.setLecture(lecture9);
        course02.setSemester(semester1);
        course02.setCourseCredit(2);
        courseService.save(course02);

        Course course03 = new Course();
        course03.setCourseCode("IS11204");
        course03.setCourseName("Information System Infrastructure");
        course03.setDescription("Information System Infrastructure");
        course03.setDepartment(department2);
        course03.setLecture(lecture6);
        course03.setSemester(semester1);
        course03.setCourseCredit(2);
        courseService.save(course03);

        Course course04 = new Course();
        course04.setCourseCode("IS11205");
        course04.setCourseName("Fundamentals of Mathematics");
        course04.setDescription("Fundamentals of Mathematics");
        course04.setDepartment(department2);
        course04.setLecture(lecture);
        course04.setSemester(semester1);
        course04.setCourseCredit(2);
        courseService.save(course04);

        Course course05 = new Course();
        course05.setCourseCode("IS11206");
        course05.setCourseName("Statistics & Probability Theory");
        course05.setDescription("Statistics & Probability Theory");
        course05.setDepartment(department2);
        course05.setLecture(lecture9);
        course05.setSemester(semester1);
        course05.setCourseCredit(2);
        courseService.save(course05);


		Course course = new Course();
		course.setCourseCode("IS21213");
		course.setCourseName("Personal Productivity with IS technology");
		course.setDescription("Personal Productivity with IS technology");
		course.setDepartment(department2);
		course.setLecture(lecture9);
		course.setSemester(semester2);
		course.setCourseCredit(2);
		courseService.save(course);

		Course course1 = new Course();
		course1.setCourseCode("IS21214");
		course1.setCourseName("Software Project Management");
		course1.setDescription("Software Project Management");
		course1.setDepartment(department2);
		course1.setLecture(lecture5);
		course1.setSemester(semester2);
		course1.setCourseCredit(2);
		courseService.save(course1);

		Course course2 = new Course();
		course2.setCourseCode("IS21215");
		course2.setCourseName("Object Oriented Analysis and Design");
		course2.setDescription("Object Oriented Analysis and Design");
		course2.setDepartment(department2);
		course2.setLecture(lecture4);
		course2.setSemester(semester2);
		course2.setCourseCredit(2);
		courseService.save(course2);

		Course course3 = new Course();
		course3.setCourseCode("IS21216");
		course3.setCourseName("Platform Technologies");
		course3.setDescription("Platform Technologies");
		course3.setDepartment(department2);
		course3.setLecture(lecture8);
		course3.setSemester(semester2);
		course3.setCourseCredit(2);
		courseService.save(course3);

        Course course4 = new Course();
        course4.setCourseCode("IS21217");
        course4.setCourseName("System Analysis and Design");
        course4.setDescription("System Analysis and Design");
        course4.setDepartment(department2);
        course4.setLecture(lecture7);
        course4.setSemester(semester2);
        course4.setCourseCredit(2);
        courseService.save(course4);

        Course course5 = new Course();
        course5.setCourseCode("IS21218");
        course5.setCourseName("Information Assurance and Security");
        course5.setDescription("Information Assurance and Security");
        course5.setDepartment(department2);
        course5.setLecture(lecture3);
        course5.setSemester(semester2);
        course5.setCourseCredit(2);
        courseService.save(course5);

        Course course6 = new Course();
        course6.setCourseCode("IS21219");
        course6.setCourseName("Social and Professional Issues");
        course6.setDescription("Social and Professional Issues");
        course6.setDepartment(department2);
        course6.setLecture(lecture);
        course6.setSemester(semester2);
        course6.setCourseCredit(2);
        courseService.save(course6);

        Course course7 = new Course();
        course7.setCourseCode("IS31227");
        course7.setCourseName("Rapid Application Development");
        course7.setDescription("Rapid Application Development");
        course7.setDepartment(department2);
        course7.setLecture(lecture8);
        course7.setSemester(semester3);
        course7.setCourseCredit(2);
        courseService.save(course7);

        Course course8 = new Course();
        course8.setCourseCode("IS31228");
        course8.setCourseName("Electronic Business Strategy, Architecture and Design");
        course8.setDescription("Electronic Business Strategy, Architecture and Design");
        course8.setDepartment(department2);
        course8.setLecture(lecture4);
        course8.setSemester(semester3);
        course8.setCourseCredit(2);
        courseService.save(course8);

        Course course9 = new Course();
        course9.setCourseCode("IS31129");
        course9.setCourseName("Enterprise Architecture");
        course9.setDescription("Enterprise Architecture");
        course9.setDepartment(department2);
        course9.setLecture(lecture7);
        course9.setSemester(semester3);
        course9.setCourseCredit(1);
        courseService.save(course9);

        Course course10 = new Course();
        course10.setCourseCode("IS31231");
        course10.setCourseName("Management Information Systems");
        course10.setDescription("Management Information Systems");
        course10.setDepartment(department2);
        course10.setLecture(lecture9);
        course10.setSemester(semester3);
        course10.setCourseCredit(2);
        courseService.save(course10);

        Course course11 = new Course();
        course11.setCourseCode("IS31231");
        course11.setCourseName("IT Auditing");
        course11.setDescription("IT Auditing");
        course11.setDepartment(department2);
        course11.setLecture(lecture6);
        course11.setSemester(semester3);
        course11.setCourseCredit(2);
        courseService.save(course11);

        Course course12 = new Course();
        course12.setCourseCode("IS31232");
        course12.setCourseName("Entrepreneurship and Innovation");
        course12.setDescription("Entrepreneurship and Innovation");
        course12.setDepartment(department2);
        course12.setLecture(lecture7);
        course12.setSemester(semester3);
        course12.setCourseCredit(2);
        courseService.save(course12);

        Course course13 = new Course();
        course13.setCourseCode("IS31233");
        course13.setCourseName("Software Engineering");
        course13.setDescription("Software Engineering");
        course13.setDepartment(department2);
        course13.setLecture(lecture2);
        course13.setSemester(semester3);
        course13.setCourseCredit(2);
        courseService.save(course13);

        Course course14 = new Course();
        course14.setCourseCode("IS31237");
        course14.setCourseName("Advanced Database Systems");
        course14.setDescription("Advanced Database Systems");
        course14.setDepartment(department2);
        course14.setLecture(lecture);
        course14.setSemester(semester3);
        course14.setCourseCredit(2);
        courseService.save(course14);

        Course course15 = new Course();
        course15.setCourseCode("IS31239");
        course15.setCourseName("Agile Software Development");
        course15.setDescription("Agile Software Development");
        course15.setDepartment(department2);
        course15.setLecture(lecture2);
        course15.setSemester(semester3);
        course15.setCourseCredit(2);
        courseService.save(course15);

        Course course16 = new Course();
        course16.setCourseCode("IS31240");
        course16.setCourseName("Software Quality Assurance");
        course16.setDescription("Software Quality Assurance");
        course16.setDepartment(department2);
        course16.setLecture(lecture8);
        course16.setSemester(semester3);
        course16.setCourseCredit(2);
        courseService.save(course16);

        Course course17 = new Course();
        course17.setCourseCode("IS31241");
        course17.setCourseName("Design Patterns and Applications");
        course17.setDescription("Design Patterns and Applications");
        course17.setDepartment(department2);
        course17.setLecture(lecture4);
        course17.setSemester(semester3);
        course17.setCourseCredit(2);
        courseService.save(course17);



		//TimeTable
        // Semester 01
        TimeTable timeTable11 = new TimeTable();
        timeTable11.setActive(true);
        timeTable11.setState("old");
        timeTable11.setCourse(course00);
        timeTable11.setSemester(semester1);
        timeTable11.setDate(d1);
        timeTable11.setStartTime(time8);
        timeTable11.setEndTime(time10);
        timeTable11.setLecture(lecture5);
        timeTable11.settWeek(true);
        timeTable11.setnWeek(true);
        timeTable11.setLectureHall(lectureHall3);
        timeTableService.save(timeTable11);

        TimeTable timeTable12 = new TimeTable();
        timeTable12.setActive(true);
        timeTable12.setState("old");
        timeTable12.setCourse(course01);
        timeTable12.setSemester(semester1);
        timeTable12.setDate(d2);
        timeTable12.setStartTime(time8);
        timeTable12.setEndTime(time10);
        timeTable12.setLecture(lecture3);
        timeTable12.settWeek(true);
        timeTable12.setnWeek(true);
        timeTable12.setLectureHall(lectureHall2);
        timeTableService.save(timeTable12);

        TimeTable timeTable13 = new TimeTable();
        timeTable13.setActive(true);
        timeTable13.setState("old");
        timeTable13.setCourse(course02);
        timeTable13.setSemester(semester1);
        timeTable13.setDate(d2);
        timeTable13.setStartTime(time10);
        timeTable13.setEndTime(time12);
        timeTable13.setLecture(lecture9);
        timeTable13.settWeek(true);
        timeTable13.setnWeek(true);
        timeTable13.setLectureHall(lectureHall3);
        timeTableService.save(timeTable13);

        TimeTable timeTable14 = new TimeTable();
        timeTable14.setActive(true);
        timeTable14.setState("old");
        timeTable14.setCourse(course03);
        timeTable14.setSemester(semester1);
        timeTable14.setDate(d2);
        timeTable14.setStartTime(time13);
        timeTable14.setEndTime(time15);
        timeTable14.setLecture(lecture6);
        timeTable14.settWeek(true);
        timeTable14.setnWeek(true);
        timeTable14.setLectureHall(lectureHall5);
        timeTableService.save(timeTable14);

        TimeTable timeTable15 = new TimeTable();
        timeTable15.setActive(true);
        timeTable15.setState("old");
        timeTable15.setCourse(course04);
        timeTable15.setSemester(semester1);
        timeTable15.setDate(d3);
        timeTable15.setStartTime(time10);
        timeTable15.setEndTime(time12);
        timeTable15.setLecture(lecture);
        timeTable15.settWeek(true);
        timeTable15.setnWeek(true);
        timeTable15.setLectureHall(lectureHall4);
        timeTableService.save(timeTable15);

        TimeTable timeTable16 = new TimeTable();
        timeTable16.setActive(true);
        timeTable16.setState("old");
        timeTable16.setCourse(course05);
        timeTable16.setSemester(semester1);
        timeTable16.setDate(d4);
        timeTable16.setStartTime(time8);
        timeTable16.setEndTime(time10);
        timeTable16.setLecture(lecture9);
        timeTable16.settWeek(true);
        timeTable16.setnWeek(true);
        timeTable16.setLectureHall(lectureHall4);
        timeTableService.save(timeTable16);

        TimeTable timeTable17 = new TimeTable();
        timeTable17.setActive(true);
        timeTable17.setState("old");
        timeTable17.setCourse(course03);
        timeTable17.setSemester(semester1);
        timeTable17.setDate(d5);
        timeTable17.setStartTime(time10);
        timeTable17.setEndTime(time12);
        timeTable17.setLecture(lecture6);
        timeTable17.settWeek(true);
        timeTable17.setnWeek(true);
        timeTable17.setLectureHall(lectureHall1);
        timeTableService.save(timeTable17);



        // Semester 02
        TimeTable timeTable21 = new TimeTable();
        timeTable21.setActive(true);
        timeTable21.setState("old");
        timeTable21.setCourse(course6);
        timeTable21.setSemester(semester2);
        timeTable21.setDate(d1);
        timeTable21.setStartTime(time13);
        timeTable21.setEndTime(time15);
        timeTable21.setLecture(lecture);
        timeTable21.settWeek(true);
        timeTable21.setnWeek(true);
        timeTable21.setLectureHall(lectureHall5);
        timeTableService.save(timeTable21);

        TimeTable timeTable22 = new TimeTable();
        timeTable22.setActive(true);
        timeTable22.setState("old");
        timeTable22.setCourse(course4);
        timeTable22.setSemester(semester2);
        timeTable22.setDate(d2);
        timeTable22.setStartTime(time8);
        timeTable22.setEndTime(time10);
        timeTable22.setLecture(lecture7);
        timeTable22.settWeek(true);
        timeTable22.setnWeek(true);
        timeTable22.setLectureHall(lectureHall);
        timeTableService.save(timeTable22);

        TimeTable timeTable23 = new TimeTable();
        timeTable23.setActive(true);
        timeTable23.setState("old");
        timeTable23.setCourse(course2);
        timeTable23.setSemester(semester2);
        timeTable23.setDate(d2);
        timeTable23.setStartTime(time15);
        timeTable23.setEndTime(time17);
        timeTable23.setLecture(lecture4);
        timeTable23.settWeek(true);
        timeTable23.setnWeek(true);
        timeTable23.setLectureHall(lectureHall3);
        timeTableService.save(timeTable23);

        TimeTable timeTable24 = new TimeTable();
        timeTable24.setActive(true);
        timeTable24.setState("old");
        timeTable24.setCourse(course);
        timeTable24.setSemester(semester2);
        timeTable24.setDate(d3);
        timeTable24.setStartTime(time8);
        timeTable24.setEndTime(time10);
        timeTable24.setLecture(lecture9);
        timeTable24.settWeek(true);
        timeTable24.setnWeek(true);
        timeTable24.setLectureHall(lectureHall2);
        timeTableService.save(timeTable24);

        TimeTable timeTable25 = new TimeTable();
        timeTable25.setActive(true);
        timeTable25.setState("old");
        timeTable25.setCourse(course5);
        timeTable25.setSemester(semester2);
        timeTable25.setDate(d3);
        timeTable25.setStartTime(time10);
        timeTable25.setEndTime(time12);
        timeTable25.setLecture(lecture3);
        timeTable25.settWeek(true);
        timeTable25.setnWeek(true);
        timeTable25.setLectureHall(lectureHall5);
        timeTableService.save(timeTable25);

        TimeTable timeTable26= new TimeTable();
        timeTable26.setActive(true);
        timeTable26.setState("old");
        timeTable26.setCourse(course6);
        timeTable26.setSemester(semester2);
        timeTable26.setDate(d3);
        timeTable26.setStartTime(time13);
        timeTable26.setEndTime(time15);
        timeTable26.setLecture(lecture);
        timeTable26.settWeek(true);
        timeTable26.setnWeek(true);
        timeTable26.setLectureHall(lectureHall3);
        timeTableService.save(timeTable26);

        TimeTable timeTable27 = new TimeTable();
        timeTable27.setActive(true);
        timeTable27.setState("old");
        timeTable27.setCourse(course3);
        timeTable27.setSemester(semester2);
        timeTable27.setDate(d3);
        timeTable27.setStartTime(time15);
        timeTable27.setEndTime(time17);
        timeTable27.setLecture(lecture8);
        timeTable27.settWeek(true);
        timeTable27.setnWeek(true);
        timeTable27.setLectureHall(lectureHall1);
        timeTableService.save(timeTable27);

        TimeTable timeTable28 = new TimeTable();
        timeTable28.setActive(true);
        timeTable28.setState("old");
        timeTable28.setCourse(course);
        timeTable28.setSemester(semester2);
        timeTable28.setDate(d4);
        timeTable28.setStartTime(time13);
        timeTable28.setEndTime(time15);
        timeTable28.setLecture(lecture9);
        timeTable28.settWeek(true);
        timeTable28.setnWeek(true);
        timeTable28.setLectureHall(lectureHall5);
        timeTableService.save(timeTable28);

        TimeTable timeTable29 = new TimeTable();
        timeTable29.setActive(true);
        timeTable29.setState("old");
        timeTable29.setCourse(course1);
        timeTable29.setSemester(semester2);
        timeTable29.setDate(d5);
        timeTable29.setStartTime(time13);
        timeTable29.setEndTime(time17);
        timeTable29.setLecture(lecture5);
        timeTable29.settWeek(true);
        timeTable29.setnWeek(true);
        timeTable29.setLectureHall(lectureHall1);
        timeTableService.save(timeTable29);




        // Semester 03
		TimeTable timeTable31 = new TimeTable();
		timeTable31.setActive(true);
		timeTable31.setState("old");
		timeTable31.setCourse(course7);
		timeTable31.setSemester(semester3);
		timeTable31.setDate(d1);
		timeTable31.setStartTime(time10);
		timeTable31.setEndTime(time13);
		timeTable31.setLecture(lecture8);
		timeTable31.settWeek(true);
		timeTable31.setnWeek(true);
		timeTable31.setLectureHall(lectureHall);
		timeTableService.save(timeTable31);

		TimeTable timeTable32 = new TimeTable();
		timeTable32.setActive(true);
		timeTable32.setState("old");
		timeTable32.setCourse(course9);
		timeTable32.setSemester(semester3);
		timeTable32.setDate(d1);
		timeTable32.setStartTime(time13);
		timeTable32.setEndTime(time15);
		timeTable32.setLecture(lecture7);
		timeTable32.settWeek(true);
		timeTable32.setnWeek(true);
		timeTable32.setLectureHall(lectureHall4);
		timeTableService.save(timeTable32);

		TimeTable timeTable33 = new TimeTable();
		timeTable33.setActive(true);
		timeTable33.setState("old");
		timeTable33.setCourse(course10);
		timeTable33.setSemester(semester3);
		timeTable33.setDate(d2);
		timeTable33.setStartTime(time8);
		timeTable33.setEndTime(time10);
		timeTable33.setLecture(lecture9);
		timeTable33.settWeek(true);
		timeTable33.setnWeek(true);
		timeTable33.setLectureHall(lectureHall4);
		timeTableService.save(timeTable33);

		TimeTable timeTable34 = new TimeTable();
		timeTable34.setActive(true);
		timeTable34.setState("old");
		timeTable34.setCourse(course12);
		timeTable34.setSemester(semester3);
		timeTable34.setDate(d2);
		timeTable34.setStartTime(time13);
		timeTable34.setEndTime(time15);
		timeTable34.setLecture(lecture7);
		timeTable34.settWeek(true);
		timeTable34.setnWeek(true);
		timeTable34.setLectureHall(lectureHall4);
		timeTableService.save(timeTable34);

		TimeTable timeTable35 = new TimeTable();
		timeTable35.setActive(true);
		timeTable35.setState("old");
		timeTable35.setCourse(course13);
		timeTable35.setSemester(semester3);
		timeTable35.setDate(d3);
		timeTable35.setStartTime(time8);
		timeTable35.setEndTime(time10);
		timeTable35.setLecture(lecture2);
		timeTable35.settWeek(true);
		timeTable35.setnWeek(true);
		timeTable35.setLectureHall(lectureHall3);
		timeTableService.save(timeTable35);

        TimeTable timeTable36 = new TimeTable();
        timeTable36.setActive(true);
        timeTable36.setState("old");
        timeTable36.setCourse(course14);
        timeTable36.setSemester(semester3);
        timeTable36.setDate(d3);
        timeTable36.setStartTime(time10);
        timeTable36.setEndTime(time12);
        timeTable36.setLecture(lecture);
        timeTable36.settWeek(true);
        timeTable36.setnWeek(true);
        timeTable36.setLectureHall(lectureHall5);
        timeTableService.save(timeTable36);

        TimeTable timeTable37 = new TimeTable();
        timeTable37.setActive(true);
        timeTable37.setState("old");
        timeTable37.setCourse(course11);
        timeTable37.setSemester(semester3);
        timeTable37.setDate(d3);
        timeTable37.setStartTime(time13);
        timeTable37.setEndTime(time15);
        timeTable37.setLecture(lecture6);
        timeTable37.settWeek(true);
        timeTable37.setnWeek(true);
        timeTable37.setLectureHall(lectureHall3);
        timeTableService.save(timeTable37);


        TimeTable timeTable38 = new TimeTable();
        timeTable38.setActive(true);
        timeTable38.setState("old");
        timeTable38.setCourse(course15);
        timeTable38.setSemester(semester3);
        timeTable38.setDate(d3);
        timeTable38.setStartTime(time15);
        timeTable38.setEndTime(time17);
        timeTable38.setLecture(lecture2);
        timeTable38.settWeek(true);
        timeTable38.setnWeek(true);
        timeTable38.setLectureHall(lectureHall2);
        timeTableService.save(timeTable38);

        TimeTable timeTable39 = new TimeTable();
        timeTable39.setActive(true);
        timeTable39.setState("old");
        timeTable39.setCourse(course17);
        timeTable39.setSemester(semester3);
        timeTable39.setDate(d4);
        timeTable39.setStartTime(time8);
        timeTable39.setEndTime(time10);
        timeTable39.setLecture(lecture4);
        timeTable39.settWeek(true);
        timeTable39.setnWeek(true);
        timeTable39.setLectureHall(lectureHall2);
        timeTableService.save(timeTable39);

        TimeTable timeTable310 = new TimeTable();
        timeTable310.setActive(true);
        timeTable310.setState("old");
        timeTable310.setCourse(course16);
        timeTable310.setSemester(semester3);
        timeTable310.setDate(d4);
        timeTable310.setStartTime(time13);
        timeTable310.setEndTime(time15);
        timeTable310.setLecture(lecture8);
        timeTable310.settWeek(true);
        timeTable310.setnWeek(true);
        timeTable310.setLectureHall(lectureHall1);
        timeTableService.save(timeTable310);

        TimeTable timeTable311 = new TimeTable();
        timeTable311.setActive(true);
        timeTable311.setState("old");
        timeTable311.setCourse(course8);
        timeTable311.setSemester(semester3);
        timeTable311.setDate(d5);
        timeTable311.setStartTime(time8);
        timeTable311.setEndTime(time10);
        timeTable311.setLecture(lecture4);
        timeTable311.settWeek(true);
        timeTable311.setnWeek(true);
        timeTable311.setLectureHall(lectureHall5);
        timeTableService.save(timeTable311);

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

		Register n1 = new Register();
		n1.setNumber("2039");
		n1.setSemester(semester1);
		indexRepository.save(n1);

		Register n2 = new Register();
		n2.setNumber("EP2030");
		n2.setSemester(semester1);
		indexRepository.save(n2);

		Register n3 = new Register();
		n3.setNumber("EP2031");
		n3.setSemester(semester1);
		indexRepository.save(n3);

		Register n4 = new Register();
		n4.setNumber("EP2030");
		n4.setSemester(semester1);
		indexRepository.save(n4);

		Register n5 = new Register();
		n5.setNumber("EP2030");
		n5.setSemester(semester1);
		indexRepository.save(n5);

		Result r1 = new Result();
		r1.setIndexNo("EP2039");
		r1.setCourse(course);
		r1.setSemester(semester1);
		r1.setYear("2015");
		resultRepository.save(r1);

	}

}
