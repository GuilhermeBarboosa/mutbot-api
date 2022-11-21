package com.pdm.mutbot.models;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import com.pdm.mutbot.models.abstracts.DefaultEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@Where(clause = "active = true")
@Table(name = "tb_tags")
@AllArgsConstructor
@NoArgsConstructor
public class TagQuestion extends DefaultEntity {

	@EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column()
    private Long id;

    @Column(name = "tag_name")
    private String tagName;
    
    @Column()
    @ManyToMany(mappedBy = "tb_tags")
    private Set<Question> questions = new LinkedHashSet<>();
}
