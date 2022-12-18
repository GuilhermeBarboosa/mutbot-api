package com.pdm.mutbot.repositories;

import com.pdm.mutbot.models.Tag;
import com.pdm.mutbot.repositories.Tag.TagQueries;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long>, TagQueries {
}
