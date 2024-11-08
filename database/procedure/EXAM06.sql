SET SERVEROUTPUT ON
DECLARE
  VEMP EMP%ROWTYPE;
  ANNSAL NUMBER(7,2);
BEGIN
--SCOTT 사원의 전체 정보를 로우 단위로 얻어와 VEMP에 저장한다.
  SELECT *
  INTO VEMP
  FROM EMP
  WHERE ENAME='SCOTT';
  
  IF (VEMP.COMM IS NULL) THEN
    ANNSAL := VEMP.SAL*12;
  ELSE
    ANNSAL := VEMP.SAL*12 + VEMP.COMM;
  END IF;

  DBMS_OUTPUT.PUT_LINE('사번/이름/연봉');
  DBMS_OUTPUT.PUT_LINE('---------------');
  DBMS_OUTPUT.PUT_LINE(VEMP.EMPNO || '/' || VEMP.ENAME || '/' ||ANNSAL);
END;
/