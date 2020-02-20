--PAsos seguidos con el Excel: Clase#06-Ejemplo-Datos-Emp_Depto-Version2.xlsx
--Nombre: 
--Tema: Modelo Relacional


conn system/root

drop user nomina cascade;

create user nomina identified by n123;

grant dba to nomina;

conn nomina/n123
PROMPT Creacion de Tablas
--tipo date
--telefono en null
create table empleados(
id           number(3) not null,
nombre       varchar2(10) not null,
telefono     number(8) null,
fec_ingreso  date not null,
fec_salida   date null,
id_depto     number(3) not null,
id_jefe      number(3)
) tablespace users;

create table departamentos(
id           number(3) not null,
nombre       varchar2(10) not null,
ubicacion    varchar2(10) null,
id_emp_jefe  number(3) null
) tablespace users;

PROMPT Creamos las PK
alter table empleados add constraint
empleados_pk primary key (id) using index tablespace users;

alter table departamentos add constraint
departamentos_pk primary key (id) using index tablespace users;

PROMPT Creamos las FK nombre relacionado // 30 letras
alter table empleados add constraint
emp_fk_emp_jefe foreign key (id_jefe) references empleados(id);

alter table empleados add constraint
emp_fk_emp_depto foreign key (id_depto) references departamentos;

alter table departamentos add constraint
dep_fk_emp_jefe foreign key (id_emp_jefe) references empleados;

PROMPT #1 Insertamos Depto Ventas
insert into departamentos(id, nombre) values (7,'Ventas');
select * from departamentos;


PROMPT #2 Insertamos Emp Juan
insert into empleados(id, nombre, telefono, fec_ingreso, id_depto, id_jefe) values (1,'Juan' ,88888,sysdate, 7, null);
select * from empleados;

--alter table empleados add constraint empleados_ck_jefe_igual check(id<>id_jefe);

PROMPT #3 Update de Depto Ventas, asignando juan como jefe
update departamentos
set    id_emp_jefe = 1
where  id = 7;
select * from departamentos;

PROMPT #4 Insertamos Emp Ana
insert into empleados(id, nombre, telefono, fec_ingreso, id_depto, id_jefe) values (2,'Ana' ,88888,sysdate, 7, 1);
select * from empleados;


PROMPT #5 Insertamos Depto Bodega (explicitamente indicando: id_emp_jefe = null)
insert into departamentos(id, nombre, id_emp_jefe) values (8,'Bodega',null);
select * from departamentos;


PROMPT #6 Insertamos Emp Pedro
insert into empleados(id, nombre, telefono, fec_ingreso, id_depto, id_jefe) values (3,'Pedro' ,88888,sysdate, 8, null);
select * from empleados;


PROMPT #7 Update de Depto Bodega, asignando Pedro como jefe de Bodega
update departamentos
set    id_emp_jefe = 3
where  id = 8;
select * from departamentos;

PROMPT #8 Insertamos Depto Compras, indicando que Juan es el Jefe
insert into departamentos(id, nombre, id_emp_jefe) values (9,'Compras',1);
select * from departamentos;

update empleados
set fec_ingreso = to_date('11-1974','MM-YYYY')
where id = 1;

select id, nombre, to_char(fec_ingreso,'DD-MM-YYYY HH24:MI:SS')fec_det
from empleados 
order by nombre;
--PROMPT #6 Insertamos Emp Pedro

commit;












