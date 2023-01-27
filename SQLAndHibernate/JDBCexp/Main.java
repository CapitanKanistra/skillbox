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

            Course course = session.get(Course.class, 1);
            System.out.println(course.getName() + " - " + course.getStudentsCount() + " человек.");

            System.out.println("\n" + course.getTeacher().getName());//OneToMany

            System.out.println("\n" + course.getStudents().size() + " человек");// ManyToMany Student
            List<Student>studentList=course.getStudents();
            for (Student student:studentList){
                System.out.println("Список учеников:" + "\n" + student.getName());
            }

            System.out.println("\n" + "Всего купленно курсов:" + "\n" + course.getPurchaselist().size());//ManyToMany PurchaselList



            transaction.commit();
            sessionFactory.close();


    }
}
