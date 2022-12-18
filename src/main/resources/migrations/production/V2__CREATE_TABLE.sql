CREATE TABLE public.tb_tags (
	id serial4 NOT NULL,
	name varchar(2500) NOT NULL,
	active bool NOT NULL,
	created_date timestamp NOT NULL,
	last_updated_date timestamp NOT NULL,
	CONSTRAINT tb_tags_pk PRIMARY KEY (id)
);

insert into tb_tags (name, created_date, last_updated_date, active) values ('Tecnologia', current_timestamp, current_timestamp, true);

insert into tb_tags (name, created_date, last_updated_date, active) values ('Moda', current_timestamp, current_timestamp, true);

insert into tb_tags (name, created_date, last_updated_date, active) values ('Esporte', current_timestamp, current_timestamp, true);

insert into tb_tags (name, created_date, last_updated_date, active) values ('Culinária', current_timestamp, current_timestamp, true);

insert into tb_tags (name, created_date, last_updated_date, active) values ('Ciência', current_timestamp, current_timestamp, true);
