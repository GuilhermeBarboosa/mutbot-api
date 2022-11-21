CREATE TABLE public.tb_questions (
	id serial4 NOT NULL,
	title varchar(255) NOT NULL,
	text varchar(255) NOT NULL,
	author integer NOT NULL,
	active bool NOT NULL,
	created_date timestamp NOT NULL,
	last_updated_date timestamp NOT NULL,
	CONSTRAINT tb_questions_pk PRIMARY KEY (id)
	CONSTRAINT tb_questions_fk FOREIGN KEY (author)
);