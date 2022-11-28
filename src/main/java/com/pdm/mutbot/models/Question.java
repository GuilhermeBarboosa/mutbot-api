package com.pdm.mutbot.models;

import com.pdm.mutbot.models.abstracts.DefaultEntity;
import lombok.*;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Data
@Builder
@Entity
@Where(clause = "active = true")
@Table(name = "tb_questions")
@AllArgsConstructor
@NoArgsConstructor
public class Question extends DefaultEntity {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column()
    private Long id;

    @Column()
    private String question;

    @ManyToOne()
    private User author;
}
