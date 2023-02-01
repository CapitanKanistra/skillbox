import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "purchaselist")
public class PurchaseList {
    @EmbeddedId
    private PurchListKey id;//new +++ ,@Id
/*    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)*///конфликт
    @Column(name = "subscription_date")
    private Date subscriptionDate;
    @Column(name = "student_name",insertable = false, updatable = false)//new
    private String studentName;
    @Column (name = "course_name", insertable = false, updatable = false)//new
    private String couseName;
    private int price;

    public Date getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(Date subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCouseName() {
        return couseName;
    }

    public void setCouseName(String couseName) {
        this.couseName = couseName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
