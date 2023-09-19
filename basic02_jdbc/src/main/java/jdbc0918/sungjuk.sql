-- sungjuk.sql

※ 참조 D:\java202307\database\section0818\06_성적테이블.sql

--sqlplus 사용자 추천
--오라클 콘솔창 예쁘게 출력
set linesize 1000;
col uname for a10; --col 칼럼명 for 20자
col addr  for a10;

--sungjuk테이블 삭제
drop table sungjuk;

set linesize 1000;
col uname for a10; --col 칼럼명 for 20자
col addr  for a10;

--sungjuk테이블 생성
create table sungjuk (
    sno   int         not null  --일련번호
   ,uname varchar(50) not null
   ,kor   int         not null 
   ,eng   int         not null
   ,mat   int         not null
   ,tot   int         
   ,aver  int   
   ,addr  varchar(20)          --주소
   ,wdate date                 --작성일(년월일시분초)
);
 
-- sungjuk테이블에서 사용할 시퀀스 생성  
create sequence sungjuk_seq;

-- sungjuk_seq 시퀀스 삭제
drop sequence sungjuk_seq; 


--전체 행 갯수
select count(*) from sungjuk;
select count(*) as cnt from sungjuk;

--전체 행에 대해서 총점과 평균 구하기
update sungjuk set tot=kor+eng+mat, aver=(kor+eng+mat)/3;
commit;

//주소가 서울인 행들의 국영수 평균값 구하기
//소수점은 반올림해서 둘째자리 값까지 표현
select avg(kor), avg(eng), avg(mat)
from sungjuk
where addr='Seoul';
      
select round()avg(kor),2), round()avg(eng),2), round()avg(mat),2)
from sungjuk
where addr='Seoul';
      
select   round()avg(kor),2)   as avg_kor
      ,round()avg(eng),2)   as avg_eng
      ,round()avg(mat),2)   as avg_mat
from sungjuk
where addr='Seoul';


// 이름에 '나' 문자가 있는행 조회
select %
from sungjuk
where uname like '%박%';


--sungjuk 테이블에서 이름순으로 정렬후 행번호 4~6만 조회하시오

select sno, uname, aver, addr
from sungjuk
order by uname;

--줄번호 rownum 추가
select sno, uname, aver, addr
from ()
   select sno, uname, aver, addr
   from sungjuk
   order by uname
   )AA;

--rownum 칼럼명 변경
select sno, uname, aver, addr as rnum
from ()
   select sno, uname, aver, addr
   from sungjuk
   order by uname
   )AA;
   
--위의 결과값을 BB테이블로 정의
select *
from ()
   select sno, uname, aver, addr as rnum
      from ()
         select sno, uname, aver, addr
         from sungjuk
         order by uname
         )AA;
   )BB
select *
from (
        select sno, uname, aver, addr as rnum
      from (
         select sno, uname, aver, addr
         from sungjuk
         order by uname
         )AA
        )BB;
        
--AA, BB 이름 생략
select *
from (
        select sno, uname, aver, addr, rownum as rnum
      from (
         select sno, uname, aver, addr
         from sungjuk
         order by uname
         )
        );

--행번호 4~6조회
select *
from (
        select sno, uname, aver, addr, rownum as rnum
      from (
         select sno, uname, aver, addr
         from sungjuk
         order by uname
         )
        )
where rnum >= 4 and rnum <= 6;

//문제) 학번 g1001이 수강신청한 과목을 과목코드별로 조회하시오
   
            g1001      d001     HTML
            g1001      p001     JAVA
            g1001      p002     Oracle
            g1001      p003     JSP
            g1001      p004     Python
            g1001      p005     AJAX      
      
select SU.hakno, SU.gcode, GW.gname
from tb_sugang SU inner join tb_gwamok GW
on SU.gcode = GW.gcode;

select SU.hakno, SU.gcode, GW.gname
from tb_sugang SU inner join tb_gwamok GW
on SU.gcode = GW.gcode
where SU.hakno = 'g1001';

select SU.hakno, SU.gcode, GW.gname
from tb_sugang SU inner join tb_gwamok GW
on SU.gcode = GW.gcode
where SU.hakno = 'g1001'
order by SU.gcode;