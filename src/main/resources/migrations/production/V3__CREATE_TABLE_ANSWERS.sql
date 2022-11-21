CREATE TABLE public.tb_answers (
	id serial4 NOT NULL,
	text varchar(255) NOT NULL,
	author integer NOT NULL,
	active bool NOT NULL,
	created_date timestamp NOT NULL,
	last_updated_date timestamp NOT NULL,
	CONSTRAINT tb_answers_pk PRIMARY KEY (id)
	CONSTRAINT tb_answers_fk FOREIGN KEY (author)
);