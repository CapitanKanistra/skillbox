import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "subscriptions")
public class Subscriptions implements Serializable {

    @EmbeddedId
    private SubscriptionsKey id;

    @Column(name = "student_id", insertable = false, updatable = false)
    private Integer studentId;

    @Column(name = "course_id", insertable = false, updatable = false)
    private Integer courseId;

    @Column(name = "subscription_date", insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date subscriptionDate;

    @Override
    public String toString() {
        return "Subscriptions{" +
                "id=" + id +
                ", studentId=" + studentId +
                ", courseId=" + courseId +
                ", subscriptionDate=" + subscriptionDate +
                '}';

    }
}


