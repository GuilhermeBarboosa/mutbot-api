CREATE TABLE public.tb_users (
	id serial4 NOT NULL,
	name varchar(255) NOT NULL,
	email varchar(255) NOT NULL,
	username varchar(255) NOT NULL,
	"password" varchar(255) NOT NULL,
	active bool NOT NULL,
	created_date timestamp NOT NULL,
	last_updated_date timestamp NOT NULL,
	CONSTRAINT tb_users_pk PRIMARY KEY (id)
);