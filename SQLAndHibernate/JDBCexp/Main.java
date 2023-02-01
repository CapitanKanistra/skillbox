import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;


public class Main {
    public static void main(String[] args) {

/*        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("file:D:\\github\\SQLAndHibernate\\JDBCexp\\resources\\hibernate.cfg.xml").build();

        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();*/
/*        Course course = session.get(Course.class, 1);        //lesson1-2
        System.out.println(course.getName() + " - " + course.getStudentsCount() + " человек.");

        System.out.println("\n" + course.getTeacher().getName());//OneToMany

        System.out.println("\n" + course.getStudents().size() + " человек");// ManyToMany Student
        List<Student> studentList = course.getStudents();
        for (Student student : studentList) {
            System.out.println("Список учеников:" + "\n" + student.getName());
        }
        System.out.println("\n" + "Всего купленно курсов:" + "\n" + course.getPurchaselist().size());//ManyToMany PurchaselList*/


        /*List<Course> courses = session.get(Student.class, 1).getCourses();
        for (Course course : courses)
            System.out.println(course.getName());*///конфликт


        /*CriteriaBuilder builder=session.getCriteriaBuilder();
        CriteriaQuery<Course>query=builder.createQuery(Course.class);
        Root<Course>root=query.from(Course.class);
        query.select(root);
        List<Course>courseList=session.createQuery(query).getResultList();

        for (Course course:courseList) {
            System.out.println("Hibernate query builder: " + course.getName());
        }*/


        Session session = HibernateUtil.getSessionFactory().openSession();
        String hqlPurchase = "FROM " + PurchaseList.class.getSimpleName();
        List<PurchaseList> purchaseList = session.createQuery(hqlPurchase).getResultList();

        session.beginTransaction();
        for(PurchaseList purchase : purchaseList) {

            CriteriaBuilder builder = session.getCriteriaBuilder();//то, что строит запросы //урок (16.11)
            CriteriaQuery<Course> courseQuery = builder.createQuery(Course.class);//формирование запроса
            Root<Course> courseRoot = courseQuery.from(Course.class);//выбор таблицы, от которой отталкиваемя
            courseQuery.select(courseRoot).where(builder.equal(courseRoot.get("name"), purchase.getCourseName()));
            Course course = session.createQuery(courseQuery).getSingleResult();

            CriteriaQuery<Student> studentQuery = builder.createQuery(Student.class);
            Root<Student> studentRoot = studentQuery.from(Student.class);
            studentQuery.select(studentRoot).where(builder.equal(studentRoot.get("name"), purchase.getStudentName()));
            Student student = session.createQuery(studentQuery).getSingleResult();

            LinkedPurchaseList linkedPurchaseList = new LinkedPurchaseList();
            linkedPurchaseList.setId(new LinkedPurchListKey(course.getId(), student.getId()));//уникальный ключ
            linkedPurchaseList.setCourseId(course.getId());
            linkedPurchaseList.setStudentId(student.getId());
            session.save(linkedPurchaseList);
        }








        session.getTransaction().commit();
        session.close();
    }
}
