package hellojpa;

import javax.persistence.*;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf =  Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        //JPA는 Transaction의 단위가 매우 중요.
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        // 이 구간에 code 작성
        try{
            // 삽입 및 비영속 상태
//            Member member = new Member();
//            member.setId(1L);
//            member.setName("Gardener");

            // em.persist를 한 순간 영속 상태
//            em.persist(member);

            // 찾기
//            Member findMember = em.find(Member.class, 1L);
            // 찾은 정보를 바탕으로 수정
//            findMember.setName("EunSoo");

            // 삭제
//            em.remove(findMember);

            // 트랜잭션 단위의 커밋
            tx.commit();
        } catch (Exception e) {
            // 혹시 오류가 생기면 롤백
            tx.rollback();
        } finally {
            // 앤티티 메니저 닫아주기
            em.close();
        }

        emf.close();
    }
}
