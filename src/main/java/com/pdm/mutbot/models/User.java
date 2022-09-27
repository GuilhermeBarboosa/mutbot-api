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
@Table(name = "tb_users")
@AllArgsConstructor
@NoArgsConstructor
public class User extends DefaultEntity {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column()
    private Long id;

    @Column()
    private String name;

    @Column()
    private String email;

    @Column()
    private String username;

    @Size(max = 255)
    private String password;
}
