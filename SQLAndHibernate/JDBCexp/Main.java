import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import java.util.List;




public class Main {


        public static void main(String[] args) {





            StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("file:D:\\github\\SQLAndHibernate\\JDBCexp\\resources\\hibernate.cfg.xml").build();

            Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
            SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

            Session session = sessionFactory.openSession();
            Transaction transaction=session.beginTransaction();




            List<Course> courses = session.get(Student.class, 1).getCourses();
            for (Course course:courses )
            System.out.println(course.getName());





            transaction.commit();
            sessionFactory.close();


    }
}
