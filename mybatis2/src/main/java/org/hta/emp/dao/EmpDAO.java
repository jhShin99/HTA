package org.hta.emp.dao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.hta.emp.domain.Emp;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Map;

public class EmpDAO {

    private SqlSession getSession() {
        SqlSession session = null;
        Reader reader = null;

        try {
            reader = Resources.getResourceAsReader("mybatis/config/sqlMapConfig.xml");
            SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(reader);
            session = sf.openSession(true);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return session;
    }

    public List<Emp> getTermList(Map<String, String> m) {
        List<Emp> list = null;
        try (SqlSession session = getSession()) {
            list = session.selectList("org.hta.emp.termlist", m);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return list;
    }

    public List<Emp> getTermList2(Map<String, String> m) {
        List<Emp> list = null;
        try (SqlSession session = getSession()) {
            list = session.selectList("org.hta.emp.termlist2", m);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return list;
    }
}
