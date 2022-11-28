CREATE TABLE public.tb_response_questions (
	id serial4 NOT NULL,
	response varchar(2500) NOT NULL,
	active bool NOT NULL,
	created_date timestamp NOT NULL,
	last_updated_date timestamp NOT NULL,
	author_id int4 NOT NULL,
	question_id int4 NOT NULL,
	CONSTRAINT tb_response_questions_pk PRIMARY KEY (id),
	CONSTRAINT tb_response_questions_fk FOREIGN KEY (author_id) REFERENCES public.tb_users(id),
	CONSTRAINT tb_response_questions_question_fk FOREIGN KEY (question_id) REFERENCES public.tb_questions(id)
);