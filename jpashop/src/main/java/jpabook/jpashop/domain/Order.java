package jpabook.jpashop.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ORDERS")
public class Order {

    @Id @GeneratedValue
    @Column(name = "ORDER_ID")
    private Long id;

    // 누가 주문했는지 알아야함
    @Column(name = "MEMBER_ID")
    private Long memberId;

    private Member member;

    public Member getMember() {
        return member;
    }

    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING) // enum은 꼭 enumerated Annotation을 붙여주고 String으로 설정!
    private OrderStatus OrderStatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }
}
