package persistence.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Rating {

    @Id
    private Long id;

    @Column
    private String bookId;

    @Column
    private int stars;

}
