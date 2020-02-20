--Fecha: 19/02/2020
--Nombre: BASE DE DATOS SISTEMA DE MATRICULA

PROMPT Creacion de Tablas

create table TB_Carrera(
Carr_id_PK	number(3) not null,
Carr_codi	varchar2(5) not null,
Carr_nomb	varchar2(8) null,
Carr_titu	varchar2(20) null,
);

create table TB_Ciclo(
Cicl_id_PK	number(3) not null,
Cicl_anno	number(4) not null,
Cicl_nume	number(2) null,
Cicl_fech_inic	date null,
Cicl_fech_fina	date null
);

create table TB_Curso(
Curs_id_PK	number(3) not null,
Curs_codi	varchar2(5) not null,
Curs_nomb	varchar2(20) null,
Curs_cred	number(2) null,
Curs_hora_sema	number(2) null,
Curs_anno	number(2) null,
Cicl_id_FK	number(3) null,
Carr_id_FK	number(3) null
);


PROMPT PKs
alter table TB_Carrera add constraint
TB_Carrera_id_PK primary key (Carr_id_PK);

alter table TB_Ciclo add constraint
TB_Ciclo_id_PK primary key (Cicl_id_PK);

alter table TB_Curso add constraint
TB_Curso_id_PK primary key (Curs_id_PK);


PROMPT FKs
alter table TB_Curso add constraint
TB_Curso_id_FK_TB_Carrera foreign key (Carr_id_FK) references TB_Carrera(Carr_id_PK);

alter table TB_Curso add constraint
TB_Curso_id_FK_TB_Ciclo foreign key (Cicl_id_FK) references TB_Ciclo(Cicl_id_PK);

create sequence Carr_sec_id  start with 1 increment by 1 maxvalue 1000;
create sequence Cicl_sec_id  start with 1 increment by 1 maxvalue 10000;
create sequence Curs_sec_id  start with 1 increment by 1 maxvalue 10000;

PROMPT #1 inserts Carreras
insert into TB_Carrera(Carr_id_PK, Carr_codi, Carr_nomb, Carr_titu) values (Carr_sec_id,'A101', 'Informatica', 'Diplomado');
insert into TB_Carrera(Carr_id_PK, Carr_codi, Carr_nomb, Carr_titu) values (Carr_sec_id,'A102', 'Matematica', 'Diplomado');
insert into TB_Carrera(Carr_id_PK, Carr_codi, Carr_nomb, Carr_titu) values (Carr_sec_id,'A103', 'Agronomia', 'Bachillerato');
insert into TB_Carrera(Carr_id_PK, Carr_codi, Carr_nomb, Carr_titu) values (Carr_sec_id,'A104', 'Topografia', 'Bachillerato');
select * from TB_Carrera;

PROMPT #1 inserts Ciclos
insert into TB_Ciclo(Cicl_id_PK, Cicl_anno, Cicl_nume, Cicl_fech_inic, Cicl_fech_fina) values (Cicl_sec_id, 2020, 1, to_date('12-02-2020','DD-MM-YYYY'), to_date('12-07-2020','DD-MM-YYYY'));
insert into TB_Ciclo(Carr_id_PK, Carr_codi, Carr_nomb, Carr_titu) values (Cicl_sec_id, 2020, 2, to_date('12-07-2020','DD-MM-YYYY'), to_date('12-11-2020','DD-MM-YYYY'));
insert into TB_Ciclo(Carr_id_PK, Carr_codi, Carr_nomb, Carr_titu) values (Cicl_sec_id, 2020, 3, to_date('12-11-2020','DD-MM-YYYY'), to_date('12-02-2021','DD-MM-YYYY'));
select * from TB_Ciclo;

PROMPT #1 inserts Cursos
insert into TB_Curso(Curs_id_PK, Curs_codi, Curs_nomb, Curs_cred, Curs_hora_sema, Curs_anno, Cicl_id_FK, Carr_id_FK)
	values (Curs_sec_id,'B101', 'Programacion I', 4, 8, 1, 1, 1);
insert into TB_Curso(Curs_id_PK, Curs_codi, Curs_nomb, Curs_cred, Curs_hora_sema, Curs_anno, Cicl_id_FK, Carr_id_FK)
	values (Curs_sec_id,'B102', 'Programacion II', 4, 8, 1, 2, 1);
insert into TB_Curso(Curs_id_PK, Curs_codi, Curs_nomb, Curs_cred, Curs_hora_sema, Curs_anno, Cicl_id_FK, Carr_id_FK)
	values (Curs_sec_id,'B103', 'Programacion III', 4, 8, 2, 1, 1);
select * from TB_Curso;

commit;












