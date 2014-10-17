-- sletter eksisterende tabeller

-- drop table ordrelinje;
-- drop table ordre;
-- drop table pizzatyper;
-- drop table kunde;
-- drop table poststeder;

-- oppretter tabeller

create table poststeder (
	postnr 		char(4),
	poststed 	varchar(30) not null,
	constraint poststeder_pk primary key (postnr) );
	
create table kunde (
	kid 			integer,
	navn 			varchar(30) not null,
	adresse 		varchar(30),
	postnr 			char(4),
	tlfnr 			char(8) not null,
	kreditgrense 	integer,
	constraint kunde_pk primary key (kid),
	constraint kunde_fk1 foreign key (postnr) references poststeder(postnr)
		on update cascade
		on delete set null );

create table pizzatyper (
     pid 	integer,
     navn	varchar(30) not null,
     pris	integer not null,
     constraint pizza_pk primary key (pid) );
     
create table ordre (
	ordrenr integer,
	dato	date,
	status	varchar(10),
	total	integer,
	kunde	integer,
	constraint ordre_pk primary key (ordrenr),
	constraint ordre_fk1 foreign key (kunde) references kunde(kid) 
                on update cascade
		        on delete cascade);
	
create table ordrelinje (
	ordrenr integer,
	linjenr integer,
	pizza	integer not null,
	antall	integer not null,
	delsum	integer not null,
	constraint ordrelinje_pk primary key (ordrenr, linjenr),
	constraint ordrelinje_fk1 foreign key (ordrenr) references ordre(ordrenr) 	
		on update cascade
		on delete cascade,
	constraint ordrelinje_fk2 foreign key (pizza) references pizzatyper(pid)
		on update cascade
		on delete restrict );
		
-- legger inn data

-- poststeder
insert into poststeder values (7000, 'Trondheim');
insert into poststeder values (8000, 'Bod¿');
insert into poststeder values (9000, 'Troms¿');
insert into poststeder values (9090, 'Kirkenes');
insert into poststeder values (7046, 'Trondheim');
-- kunder
insert into kunde values (1, 'Ola', 'Kirkegata 1', 7000, 12341234, 10000);
insert into kunde values (2, 'Kari', 'Elgesetergate 12', 7000, 12344321, 10000);
insert into kunde values (3, 'Per', 'Munkegata 10', 7000, 11223344, 5000);
insert into kunde values (4, 'Ola', 'Kongens gate 12', 8000, 88667755, 5000);
-- pizzaer
insert into pizzatyper values (1, 'Cheese & Tomato', 170);
insert into pizzatyper values (2, 'The Tropical', 228);
insert into pizzatyper values (3, 'Pepper Steak', 228);
insert into pizzatyper values (4, 'Thai Chicken', 254);
insert into pizzatyper values (5, 'Heavy Heaven', 258);
-- ordrer
insert into ordre values (1, '2014-01-10', 'Levert', 170, 1);
insert into ordre values (2, '2014-01-10', 'Levert', 568, 2);
insert into ordre values (3, '2014-01-11', 'Levert', 710, 3);
insert into ordre values (4, '2014-01-11', 'Levert', 254, 3);
insert into ordre values (5, '2014-01-12', 'Levert', 482, 2);
-- ordrelinje
insert into ordrelinje values(1, 1, 1, 1, 170);
insert into ordrelinje values(2, 1, 1, 2, 340);
insert into ordrelinje values(2, 2, 2, 1, 228);
insert into ordrelinje values(3, 1, 2, 1, 228);
insert into ordrelinje values(3, 2, 3, 1, 228);
insert into ordrelinje values(3, 3, 4, 1, 254);
insert into ordrelinje values(4, 1, 4, 1, 254);
insert into ordrelinje values(5, 1, 4, 1, 254);
insert into ordrelinje values(5, 2, 3, 1, 228);
