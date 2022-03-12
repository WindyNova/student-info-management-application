create database stuinfo CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
use stuinfo;
#建表

#院系表
create table department(
Dno decimal,
Dname varchar(12),
constraint primary key PK_department (Dno)
);
#班级表

create table class(
Clno decimal,
Clname varchar(24),
Dno decimal,
constraint primary key PK_class (Clno),
constraint foreign key FK_class_department (Dno) references department(Dno)
);
#学生表
create table student(
Sno decimal,
Sname varchar(24),
Ssex char(2) check(Ssex in ('男','女')),
Sage tinyint check(Sage > 0),
Clno decimal,
constraint primary key PK_student (Sno),
constraint foreign key FK_student_class (Clno) references class(Clno)
);
#课程表
create table course(
Cno decimal,
Cname varchar(24),
Cteacher varchar(24),
Ccredit tinyint check(Ccredit > 0),
constraint primary key PK_course (Cno)
);
#选课表
create table sc(
Sno decimal,
Cno decimal,
Grade tinyint check(Grade < 100 and Grade > 0),
constraint foreign key FK_sc_student (Sno) references student(Sno),
constraint foreign key FK_sc_course (Cno) references course(Cno),
constraint primary key PK_sc (Sno,Cno)
);
#用户表
create table user(
username varchar(12) not null,
password char(32) not null,
level char(6) check(level in ('用户','管理员')),
constraint primary key PK_user (username)
);


#插入测试数据
insert into department
values('201501','软件学院');
insert into department
values('201502','经管学院');
insert into department
values('201503','人文学院');
insert into department
values('201504','国际学院');
insert into department
values('201505','理学院');

insert into class
values('20150103','2015-3班','201501');#软件学院
insert into class
values('20150104','2015-4班','201501');#软件学院
insert into class
values('20150201','2015-1班','201502');#经管学院
insert into class
values('20150202','2015-2班','201502');#经管学院
insert into class
values('20150301','2015-1班','201503');#人文学院
insert into class
values('20150302','2015-2班','201503');#人文学院

insert into student
values('2015010312','张明','男',20,'20150103');
insert into student
values('2015010313','秦羽','女',19,'20150103');
insert into student
values('2015010314','刘翔','男',19,'20150103');

insert into course
values('1','高等数学','张三',4);
insert into course
values('2','数据库原理设计','李四',3);
insert into course
values('3','Java程序设计','王五',4);

insert into sc
values('2015010312','1',50);
insert into sc
values('2015010312','2',80);
insert into sc
values('2015010312','3',70);
insert into sc
values('2015010313','1',90);
insert into sc
values('2015010313','2',89);
insert into sc
values('2015010313','3',59);
insert into sc
values('2015010314','1',85);
insert into sc
values('2015010314','2',75);
insert into sc
values('2015010314','3',95);

insert into user
values('admin','e0b27c451c728867a567e8c1bb4e53','管理员');

insert into user
values('user','2cb962ac59075b964b07152d234b70','用户'); 
##123

#查询示例

##查询所有课程平均分
#select sc.cno cno,cname,avg(grade) avg
#from course,sc 
#where course.cno = sc.cno 
#group by cno 
#order by cno;
#
##查询全部课程不及格率
#select cno,(select cname from course where cno = x.cno) cname,
#cast(100.0*(select count(sno) from sc where grade < 60 and cno = x.cno)/(select count(sno) from sc where cno = x.cno) as decimal(18,2)) rate 
#from sc x 
#group by cno;
#
##查选修某一门课程的总人数
#select cno,count(Sno) 总人数
#from sc
#group by Cno
#having Cno = '1';
#
##查询某一门课程的全部成绩排名
#select cno,student.Sno,Dname,Clname,Sname,Ssex,Sage,grade
#from department,class,student,sc
#where student.sno = sc.sno
#and class.Clno = student.Clno
#and department.Dno = class.Dno
#and cno = '1'
#order by grade desc;
