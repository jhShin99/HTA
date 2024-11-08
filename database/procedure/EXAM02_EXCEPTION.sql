SET SERVEROUTPUT ON
DECLARE
--%TYPE 속성으로 컬럼 단위 레퍼런스 변수 선언
    VEMPNO EMP.EMPNO%TYPE;
    VENAME EMP.ENAME%TYPE;
BEGIN
    DBMS_OUTPUT.PUT_LINE('사번/이름');
    DBMS_OUTPUT.PUT_LINE('----------');

    SELECT EMPNO, ENAME
    INTO   VEMPNO, VENAME
    FROM EMP;
    --WHERE ENAME='SCOT';

    -- 레퍼런스 변수에 저장된 값을 출력
    DBMS_OUTPUT.PUT_LINE(VEMPNO || '/' || VENAME);

    EXCEPTION
     WHEN NO_DATA_FOUND THEN
         DBMS_OUTPUT.PUT_LINE('조회된 결과가 없습니다.');
     WHEN TOO_MANY_ROWS THEN
         DBMS_OUTPUT.PUT_LINE('자료가 2건 이상입니다.');
     WHEN OTHERS THEN
         DBMS_OUTPUT.PUT_LINE('기타 에러입니다.');
END;
/