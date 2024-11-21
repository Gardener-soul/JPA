package jpabook.jpashop.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ORDERS")
public class Order {

    @Id @GeneratedValue
    @Column(name = "ORDER_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @OneToOne
    @JoinColumn(name = "DELIVERY_ID")
    private Delivery delivery;

    @OneToMany(mappedBy = "order")
    List<OrderItem> orderItems = new ArrayList<>();

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

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public jpabook.jpashop.domain.OrderStatus getOrderStatus() {
        return OrderStatus;
    }

    public void setOrderStatus(jpabook.jpashop.domain.OrderStatus orderStatus) {
        OrderStatus = orderStatus;
    }

    public void addOrderItem(OrderItem orderItem) {
        orderItems.add(orderItem);
        orderItem.setOrder(this);
    }
}
