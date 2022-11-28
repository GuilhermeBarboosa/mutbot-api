CREATE TABLE public.tb_questions (
	id serial4 NOT NULL,
	question varchar(2500) NOT NULL,
	active bool NOT NULL,
	created_date timestamp NOT NULL,
	last_updated_date timestamp NOT NULL,
	author_id int4 NOT NULL,
	CONSTRAINT tb_questions_pk PRIMARY KEY (id),
	CONSTRAINT tb_questions_fk FOREIGN KEY (author_id) REFERENCES public.tb_users(id)
);