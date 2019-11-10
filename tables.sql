
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

CREATE TABLE public.br_reserva (
	codigo serial NOT NULL,
	fecha_prestamo date NULL,
	usuario varchar NULL,
	CONSTRAINT br_reserva_pkey PRIMARY KEY (codigo),
	CONSTRAINT reserva_usuario FOREIGN KEY (usuario) REFERENCES br_usuario(carnet)
);

CREATE TABLE public.br_tipo (
	tipo varchar(50) NOT NULL,
	descripcion varchar(100) NOT NULL,
	id int4 NOT NULL,
	CONSTRAINT br_tipo_pkey PRIMARY KEY (id)
);


CREATE TABLE public.br_recurso (
	id serial NOT NULL,
	nombre varchar(200) NOT NULL,
	ubicacion varchar(50) NOT NULL,
	capacidad int4 NOT NULL,
	disponible bool NULL DEFAULT true,
	id_tipo int4 NULL,
	tiempo int4 NULL,
	CONSTRAINT recursos_pkey PRIMARY KEY (id),
	CONSTRAINT fk_recurso_tipo FOREIGN KEY (id_tipo) REFERENCES br_tipo(id) ON DELETE CASCADE
);


CREATE TABLE public.reserva_recurso (
	reserva int4 NOT NULL,
	recurso int4 NOT NULL,
	fecha_entrega date NULL,
	CONSTRAINT reserva_recurso_pkey PRIMARY KEY (reserva, recurso),
	CONSTRAINT reserva_recurso_recurso FOREIGN KEY (recurso) REFERENCES br_recurso(id),
	CONSTRAINT reserva_recurso_reserva FOREIGN KEY (reserva) REFERENCES br_reserva(codigo)
);


/*CREATE UNIQUE INDEX recurso_index ON br_recurso (nombre, id_tipo);*/


