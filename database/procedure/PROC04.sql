CREATE OR REPLACE FUNCTION CAL_BONUS
(VEMPNO IN EMP.EMPNO%TYPE)
RETURN NUMBER--함수 CAL_BONUS에 의해서 되돌려지는 값은 수치데이터
IS
  VSAL NUMBER(7,2);
BEGIN
  SELECT SAL
  INTO   VSAL
  FROM  EMP
  WHERE EMPNO = VEMPNO; -- VEMPNO로 사원번호를 조회하여
                                      -- 급여 컬럼값을 VSAL에 저장
  RETURN (VSAL * 2); -- 함수의 결과값을 되돌린다.
END;
/