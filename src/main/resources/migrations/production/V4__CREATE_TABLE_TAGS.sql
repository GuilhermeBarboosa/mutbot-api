CREATE TABLE public.tb_tags (
	id serial4 NOT NULL,
	tag_name varchar(255) NOT NULL,
	active bool NOT NULL,
	created_date timestamp NOT NULL,
	last_updated_date timestamp NOT NULL,
	CONSTRAINT tb_tags_pk PRIMARY KEY (id)
);