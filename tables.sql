
CREATE TABLE public.br_cargo (
	id int4 NOT NULL,
	nombre varchar NULL,
	descripcion varchar NULL,
	CONSTRAINT br_cargo_pkey PRIMARY KEY (id)
);


CREATE TABLE public.br_usuario (
	carnet varchar NOT NULL,
	documento varchar NULL,
	correo varchar NULL,
	nombres varchar NULL,
	apellidos varchar NULL,
	passwd varchar NULL,
	ultimoingreso date NULL,
	bloqueado bool NULL DEFAULT false,
	id_cargo int4 NULL,
	CONSTRAINT br_usuario_pkey PRIMARY KEY (carnet),
	CONSTRAINT fk_usuario_cargo FOREIGN KEY (id_cargo) REFERENCES br_cargo(id)
);


CREATE TABLE public.br_tipo (
	tipo varchar(50) NOT NULL,
	descripcion varchar(100) NOT NULL,
	id int4 NOT NULL,
	CONSTRAINT br_tipo_pkey PRIMARY KEY (id)
);


CREATE TABLE public.br_recurso (
	id bigserial NOT NULL,
	nombre varchar(200) NOT NULL,
	ubicacion varchar(50) NOT NULL,
	capacidad int4 NOT NULL,
	disponible bool NULL DEFAULT true,
	id_tipo int4 NULL,
	tiempo int4 NULL,
	CONSTRAINT recursos_pkey PRIMARY KEY (id),
	CONSTRAINT fk_recurso_tipo FOREIGN KEY (id_tipo) REFERENCES br_tipo(id) ON DELETE CASCADE
);

CREATE TABLE public.br_reserva (
	codigo int4 NOT NULL,
	fecha date NOT NULL,
	usuario varchar NOT NULL,
	hora int4 NOT NULL,
	duracion int4 NOT NULL,
	recurso int8 NOT NULL,
	activa bool NOT NULL DEFAULT true,
	grupo int4 NULL,
	registro date NULL,
	CONSTRAINT br_reserva_pkey PRIMARY KEY (codigo),
	CONSTRAINT ck_limite CHECK (((hora + duracion) < 1901)),
	CONSTRAINT ck_maxima CHECK (((duracion < 201) AND (duracion > 0))),
	CONSTRAINT ck_rangohora CHECK ((hora > 699))
);


INSERT INTO public.br_cargo
(id, nombre, descripcion)
VALUES(0, 'aa', 'aa');

INSERT INTO public.br_usuario
(carnet, documento, correo, nombres, apellidos, passwd, ultimoingreso, bloqueado, id_cargo)
VALUES('000', '000', '000', 'aaa', 'aa', 'aaa', '2019-12-12', false, 0);


/*CREATE UNIQUE INDEX recurso_index ON br_recurso (nombre, id_tipo);*/


