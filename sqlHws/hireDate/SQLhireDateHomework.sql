create table employees(   
  empid    number(4,0),   
  ename    varchar2(20),
  elastname varchar(20),
  jobid      number(2,0),     
  startdate date,
  quitdate date,
  salary    number(7,2),      
  departmentid   number(2,0) 
);

INSERT INTO employees(empid, ename, elastname, jobid, startdate, quitdate, salary, departmentid) VALUES
(1, 'Ahmet', 'Yýlmaz', 1, TO_DATE('2023-01-01', 'YYYY-MM-DD'), NULL, 5000.00, 10);
INSERT INTO employees(empid, ename, elastname, jobid, startdate, quitdate, salary, departmentid) VALUES
(2, 'Mehmet', 'Demir', 2, TO_DATE('2023-02-05', 'YYYY-MM-DD'), TO_DATE('2023-12-31', 'YYYY-MM-DD'), 4500.00, 20);
INSERT INTO employees(empid, ename, elastname, jobid, startdate, quitdate, salary, departmentid) VALUES
(3, 'Ayþe', 'Kara', 3, TO_DATE('2023-03-15', 'YYYY-MM-DD'), NULL, 6000.00, 10);
INSERT INTO employees(empid, ename, elastname, jobid, startdate, quitdate, salary, departmentid) VALUES
(4, 'Fatma', 'Yýlmaz', 1, TO_DATE('2023-04-22', 'YYYY-MM-DD'), NULL, 5200.00, 30);
INSERT INTO employees(empid, ename, elastname, jobid, startdate, quitdate, salary, departmentid) VALUES
(5, 'Ali', 'Demir', 2, TO_DATE('2023-05-18', 'YYYY-MM-DD'), TO_DATE('2023-11-30', 'YYYY-MM-DD'), 4800.00, 20);
INSERT INTO employees(empid, ename, elastname, jobid, startdate, quitdate, salary, departmentid) VALUES
(6, 'Veli', 'Kara', 3, TO_DATE('2023-06-10', 'YYYY-MM-DD'), NULL, 5800.00, 10);
INSERT INTO employees(empid, ename, elastname, jobid, startdate, quitdate, salary, departmentid) VALUES
(7, 'Hüseyin', 'Yýlmaz', 1, TO_DATE('2023-07-22', 'YYYY-MM-DD'), NULL, 5500.00, 30);
INSERT INTO employees(empid, ename, elastname, jobid, startdate, quitdate, salary, departmentid) VALUES
(8, 'Murat', 'Demir', 2, TO_DATE('2023-08-13', 'YYYY-MM-DD'), TO_DATE('2023-10-30', 'YYYY-MM-DD'), 4900.00, 20);
INSERT INTO employees(empid, ename, elastname, jobid, startdate, quitdate, salary, departmentid) VALUES
(9, 'Zeynep', 'Kara', 3, TO_DATE('2023-09-09', 'YYYY-MM-DD'), NULL, 5700.00, 10);
INSERT INTO employees(empid, ename, elastname, jobid, startdate, quitdate, salary, departmentid) VALUES
(10, 'Elif', 'Yýlmaz', 1, TO_DATE('2023-10-14', 'YYYY-MM-DD'), NULL, 5100.00, 30);
INSERT INTO employees(empid, ename, elastname, jobid, startdate, quitdate, salary, departmentid) VALUES
(11, 'Ahmet2', 'Yýlmaz2', 1, TO_DATE('2023-01-01', 'YYYY-MM-DD'), NULL, 5000.00, 10);
INSERT INTO employees(empid, ename, elastname, jobid, startdate, quitdate, salary, departmentid) VALUES
(12, 'Mehmet2', 'Demir2', 2, TO_DATE('2023-02-05', 'YYYY-MM-DD'), TO_DATE('2023-12-31', 'YYYY-MM-DD'), 4500.00, 20);
INSERT INTO employees(empid, ename, elastname, jobid, startdate, quitdate, salary, departmentid) VALUES
(13, 'Ayþe2', 'Kara2', 3, TO_DATE('2023-03-15', 'YYYY-MM-DD'), NULL, 6000.00, 10);
INSERT INTO employees(empid, ename, elastname, jobid, startdate, quitdate, salary, departmentid) VALUES
(14, 'Fatma2', 'Yýlmaz2', 1, TO_DATE('2023-04-22', 'YYYY-MM-DD'), NULL, 5200.00, 30);
INSERT INTO employees(empid, ename, elastname, jobid, startdate, quitdate, salary, departmentid) VALUES
(15, 'Ali2', 'Demir2', 2, TO_DATE('2023-05-18', 'YYYY-MM-DD'), TO_DATE('2023-11-30', 'YYYY-MM-DD'), 4800.00, 20);
INSERT INTO employees(empid, ename, elastname, jobid, startdate, quitdate, salary, departmentid) VALUES
(16, 'Veli2', 'Kara2', 3, TO_DATE('2023-06-10', 'YYYY-MM-DD'), NULL, 5800.00, 10);
INSERT INTO employees(empid, ename, elastname, jobid, startdate, quitdate, salary, departmentid) VALUES
(17, 'Hüseyin2', 'Yýlmaz2', 1, TO_DATE('2023-07-22', 'YYYY-MM-DD'), NULL, 5500.00, 30);
INSERT INTO employees(empid, ename, elastname, jobid, startdate, quitdate, salary, departmentid) VALUES
(18, 'Murat2', 'Demir2', 2, TO_DATE('2023-08-13', 'YYYY-MM-DD'), TO_DATE('2023-10-30', 'YYYY-MM-DD'), 4900.00, 20);
INSERT INTO employees(empid, ename, elastname, jobid, startdate, quitdate, salary, departmentid) VALUES
(19, 'Zeynep2', 'Kara2', 3, TO_DATE('2023-09-09', 'YYYY-MM-DD'), NULL, 5700.00, 10);
INSERT INTO employees(empid, ename, elastname, jobid, startdate, quitdate, salary, departmentid) VALUES
(20, 'Elif2', 'Yýlmaz2', 1, TO_DATE('2023-10-14', 'YYYY-MM-DD'), NULL, 5100.00, 30);


select empid,ename,elastname,MONTHS_BETWEEN(quitdate,startdate) as "hire date" from employees;

