DECLARE
    DEPT_RECORD DEPT%ROWTYPE;
BEGIN
    SELECT DEPTNO, DNAME, LOC
    INTO DEPT_RECORD
    FROM DEPT
    WHERE DEPTNO = 10;
 
    -- 레코드 변수에 저장된 사원 정보를 출력
    DBMS_OUTPUT.PUT_LINE('  부서번호 : ' ||
          TO_CHAR(DEPT_RECORD.DEPTNO));
    DBMS_OUTPUT.PUT_LINE('   부서이름: ' ||
          DEPT_RECORD.DNAME);
    DBMS_OUTPUT.PUT_LINE('   지역     : ' ||
          DEPT_RECORD.LOC);
END;
/