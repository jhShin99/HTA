DECLARE
    EMP_RECORD EMP%ROWTYPE;
BEGIN
    SELECT EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO
    INTO EMP_RECORD
    FROM EMP
    WHERE EMPNO = 7788;
 
    -- 레코드 변수에 저장된 사원 정보를 출력
      DBMS_OUTPUT.PUT_LINE('사번   이름   직업   상사   입사일   급여   커미션부서번호');
    DBMS_OUTPUT.PUT_LINE('-------------------------------------------------------------');
    DBMS_OUTPUT.PUT_LINE(EMP_RECORD.EMPNO || '  ' ||
EMP_RECORD.ENAME || '  ' ||
EMP_RECORD.JOB ||'  ' ||
EMP_RECORD.MGR ||'  ' ||
EMP_RECORD.HIREDATE ||'  ' ||
EMP_RECORD.SAL ||'  ' ||
EMP_RECORD.COMM ||'  ' ||
EMP_RECORD.DEPTNO
);
END;
/