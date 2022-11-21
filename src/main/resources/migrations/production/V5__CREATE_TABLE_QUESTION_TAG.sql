CREATE TABLE public.tb_question_tag (
	id_questions INTEGER NOT NULL,
	id_tags INTEGER NOT NULL,
	CONSTRAINT tb_question_tag_pk PRIMARY KEY (id_questions, id_tags)
);