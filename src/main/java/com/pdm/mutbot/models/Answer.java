package com.pdm.mutbot.models;

import com.pdm.mutbot.models.abstracts.DefaultEntity;
import lombok.*;

import org.hibernate.annotations.Where;

import javax.persistence.*;

@Data
@Builder
@Entity
@Where(clause = "active = true")
@Table(name = "tb_answers")
@AllArgsConstructor
@NoArgsConstructor
public class Answer extends DefaultEntity {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column()
    private Long id;

    @Column()
    private String text;

    @Column()
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tb_users_id")
	private User author;

    @Column()
    @OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "tb_questions_id")
	private Question question;
}
