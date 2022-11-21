package com.pdm.mutbot.models;

import com.pdm.mutbot.models.abstracts.DefaultEntity;
import lombok.*;

import org.hibernate.annotations.Where;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.*;

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
    private String title;

    @Column()
    private String text;

    @Column()
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tb_users_id")
	private User author;

    @Column()
    @ManyToMany
	@JoinTable(name="tb_question_tag",
			joinColumns=@JoinColumn(name= "id_questions"),	
	   inverseJoinColumns=@JoinColumn(name="id_tags"))
	private Set<TagQuestion> tags = new LinkedHashSet<>();
}
