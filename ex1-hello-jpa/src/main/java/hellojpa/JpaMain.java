package hellojpa;

import javax.persistence.*;
import java.sql.SQLOutput;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf =  Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        //JPA는 Transaction의 단위가 매우 중요.
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        // 이 구간에 code 작성
        try{
            Team team = new Team();
            team.setName("TeamA");
            em.persist(team);

            Member member = new Member();
            member.setName("gardener");
            member.changeTeam(team);
            em.persist(member); // 영속성 컨텍스트에 저장

            Member findMember = em.find(Member.class, member.getId());
            List<Member> members = findMember.getTeam().getMembers();
            for(Member m : members) {
                System.out.println(m.getName());
            }

            Team findTeam = findMember.getTeam();

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
