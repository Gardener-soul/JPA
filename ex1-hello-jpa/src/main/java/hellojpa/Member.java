package hellojpa;

import javax.persistence.*;
import java.util.Date;

@Entity // 엔티티가 꼭 필요
public class Member {

    @Id // 무엇이 기본키인지 알려주는 Annotation
    private Long id;
    @Column(name = "name", nullable = false) // 객체는 username인데 DB에는 name이라고 작성할 때
    private String username;
    private Integer age;
    @Enumerated(EnumType.STRING) // enum Type 도 사용가능
    private RoleType roleType;
    @Temporal(TemporalType.TIMESTAMP) // 날짜 타입 (DATE, Time, TimeStamp 3가지 Typw 존재)
    private Date createdDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;
    @Lob // 큰 컨텐츠
    private String description;

    // JPA의 사용을 위해서는 기본 생성자가 꼭 필요.
    public Member() {

    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

}
