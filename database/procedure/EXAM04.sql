DECLARE
    EMP_RECORD EMP%ROWTYPE;
BEGIN
    SELECT EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO
    INTO EMP_RECORD
    FROM EMP
    WHERE EMPNO = 7788;
 
    -- ���ڵ� ������ ����� ��� ������ ���
      DBMS_OUTPUT.PUT_LINE('���   �̸�   ����   ���   �Ի���   �޿�   Ŀ�̼Ǻμ���ȣ');
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