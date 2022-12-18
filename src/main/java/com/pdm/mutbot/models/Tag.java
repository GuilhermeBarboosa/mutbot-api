package com.pdm.mutbot.models;

import com.pdm.mutbot.models.abstracts.DefaultEntity;
import lombok.*;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Data
@Builder
@Entity
@Where(clause = "active = true")
@Table(name = "tb_tags")
@AllArgsConstructor
@NoArgsConstructor
public class Tag extends DefaultEntity {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column()
    private Long id;

    @Column()
    private String name;
}
