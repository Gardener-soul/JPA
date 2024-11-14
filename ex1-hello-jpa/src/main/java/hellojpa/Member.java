package hellojpa;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity // 엔티티가 꼭 필요
public class Member {

    @Id // 무엇이 기본키인지 알려주는 Annotation
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
