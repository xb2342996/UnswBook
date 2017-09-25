package Services;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class MybaitsUtil {
    private final static SqlSessionFactory sessionFactory;
    static {
        String resource = "conf.xml";
        Reader reader = null;
        try {

            reader = Resources.getResourceAsReader(resource);
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

        sessionFactory = new SqlSessionFactoryBuilder().build(reader);
    }
    public static SqlSessionFactory getSession(){
        return sessionFactory;
    }
}
