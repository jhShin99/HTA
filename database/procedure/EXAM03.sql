DECLARE
    DEPT_RECORD DEPT%ROWTYPE;
BEGIN
    SELECT DEPTNO, DNAME, LOC
    INTO DEPT_RECORD
    FROM DEPT
    WHERE DEPTNO = 10;
 
    -- ���ڵ� ������ ����� ��� ������ ���
    DBMS_OUTPUT.PUT_LINE('  �μ���ȣ : ' ||
          TO_CHAR(DEPT_RECORD.DEPTNO));
    DBMS_OUTPUT.PUT_LINE('   �μ��̸�: ' ||
          DEPT_RECORD.DNAME);
    DBMS_OUTPUT.PUT_LINE('   ����     : ' ||
          DEPT_RECORD.LOC);
END;
/