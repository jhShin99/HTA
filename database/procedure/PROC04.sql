CREATE OR REPLACE FUNCTION CAL_BONUS
(VEMPNO IN EMP.EMPNO%TYPE)
RETURN NUMBER--�Լ� CAL_BONUS�� ���ؼ� �ǵ������� ���� ��ġ������
IS
  VSAL NUMBER(7,2);
BEGIN
  SELECT SAL
  INTO   VSAL
  FROM  EMP
  WHERE EMPNO = VEMPNO; -- VEMPNO�� �����ȣ�� ��ȸ�Ͽ�
                                      -- �޿� �÷����� VSAL�� ����
  RETURN (VSAL * 2); -- �Լ��� ������� �ǵ�����.
END;
/