SET SERVEROUTPUT ON
DECLARE
--%TYPE �Ӽ����� �÷� ���� ���۷��� ���� ����
    VEMPNO EMP.EMPNO%TYPE;
    VENAME EMP.ENAME%TYPE;
BEGIN
    DBMS_OUTPUT.PUT_LINE('���/�̸�');
    DBMS_OUTPUT.PUT_LINE('----------');

    SELECT EMPNO, ENAME
    INTO   VEMPNO, VENAME
    FROM EMP;
    --WHERE ENAME='SCOT';

    -- ���۷��� ������ ����� ���� ���
    DBMS_OUTPUT.PUT_LINE(VEMPNO || '/' || VENAME);

    EXCEPTION
     WHEN NO_DATA_FOUND THEN
         DBMS_OUTPUT.PUT_LINE('��ȸ�� ����� �����ϴ�.');
     WHEN TOO_MANY_ROWS THEN
         DBMS_OUTPUT.PUT_LINE('�ڷᰡ 2�� �̻��Դϴ�.');
     WHEN OTHERS THEN
         DBMS_OUTPUT.PUT_LINE('��Ÿ �����Դϴ�.');
END;
/