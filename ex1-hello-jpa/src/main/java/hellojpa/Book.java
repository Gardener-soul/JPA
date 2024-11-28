package hellojpa;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorValue("B")
public class Book extends Item{

    private String author;
    private String isbn;

}
