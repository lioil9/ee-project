package club.banyuan.utils;

import club.banyuan.dao.IUserDao;
import java.io.IOException;
import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class TransactionManager {
    static InputStream ins;
    SqlSession session;
    static SqlSessionFactory sqlSessionFactory;

    static {
        // 加载配置文件
        try {
            ins = Resources.getResourceAsStream("SqlMapConfig.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 获取用于创建SqlSessionFactory对象的类的对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        // 创建SqlSessionFactory对象
        sqlSessionFactory = builder.build(ins);
    }

    public SqlSession beginTransaction() throws IOException {
        // 创建SqlSession对象
        session = sqlSessionFactory.openSession();
        return session;
    }

    public void commit(){
        session.commit();
    }

    public void rollback(){
        session.rollback();
    }

    public void release(){
        session.close();
    }

    public static void destroy(){
        try {
            ins.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
