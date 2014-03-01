create table forlag (
    forlagid integer not null,
    forlagnavn varchar(30) not null,
    adresse varchar(30),
    telefon integer,
    constraint forlag_pk primary key (forlagid)
);

create table bok (
    bokid integer not null,
    tittel varchar(30) not null,
    utgittår char(4) not null,
    forlagid integer not null,
    constraint bok_pk primary key (bokid),
    constraint bok_fk foreign key (forlagid) references forlag(forlagid)
        on update cascade
        on delete cascade
);

create table forfatter (
    forfatterid integer not null, 
    fornavn varchar(30) not null,
    etternavn varchar(30) not null,
    fødeår char(4),
    dødår char(4),
    nasjonalitet varchar(30) not null,  
    constraint forfatter_pk primary key (forfatterid)
);

create table bokforfatter (
    bokid integer,
    forfatterid integer,
    constraint bokforfatter_pk primary key (bokid, forfatterid),
    constraint bokforfatter_fk1 foreign key (bokid) references bok(bokid)
        on update cascade
        on delete cascade,
    constraint bokforfatter_fk2 foreign key (forfatterid) references forfatter(forfatterid)
        on update cascade
        on delete cascade
);

-- forlag
insert into forlag values (1, 'Tapir', 'Trondheim', 73590000);
insert into forlag values (2, 'Gyldendal', 'Oslo', 22220000);
insert into forlag values (3, 'Cappelen', 'Oslo', 22220001);
insert into forlag values (4, 'Universitetsforlaget', 'Oslo', 22220003);
insert into forlag values (5, 'Aschehoug', 'Oslo', 222200234);
insert into forlag values (6, 'Oktober', 'Oslo', 222200323);
insert into forlag values (7, 'Tiden', 'Oslo', 234423332);
insert into forlag values (8, 'HarperCollins', 'USA', null);

-- bok
insert into bok values (1, 'Tåpnens sammensvergelse', 1995, 7);
insert into bok values (2, 'Rebecca-koden', 1981, 3);
insert into bok values (3, 'Gutter er gutter', 1998, 5);
insert into bok values (4, 'Microserfs', 1995, 8);
insert into bok values (5, 'Generation X', 1991, 8);
insert into bok values (6, 'Klosterkrønike', 1982, 3);
insert into bok values (7, 'Univers uten grenser', 1988, 3);
insert into bok values (8, 'Nålen', 1978, 3);
insert into bok values (9, 'Markens grøde', 1917, 2);
insert into bok values (10, 'Victoria', 1898, 2);
insert into bok values (11, 'Sult', 1890, 2);
insert into bok values (12, 'Benoni', 1908, 2);
insert into bok values (13, 'Rosa', 1908, 2);
insert into bok values (14, 'Ett skritt etter', 1997, 2);
insert into bok values (15, 'Den femte kvinnen', 1996, 2);
insert into bok values (16, 'Villspor', 1995, 2);
insert into bok values (17, 'Silkeridderen', 1994, 2);
insert into bok values (18, 'Den hvite løvinnen', 1993, 2);
insert into bok values (19, 'Hundene i Riga', 1992, 2);
insert into bok values (20, 'Bridget Jones dagbok', 1996, 5);
insert into bok values (21, 'Sa terapeuten min', 1998, 3);
insert into bok values (22, 'Sa mor', 1996, 3);
insert into bok values (23, 'Jubel', 1995, 3);
insert into bok values (24, 'Tatt av kvinnen', 1993, 3);
insert into bok values (25, 'NAIV.SUPER.', 1996, 3);

-- forfatter
insert into forfatter values (1, 'John Kennedy', 'Toole', 1937, 1969, 'USA');
insert into forfatter values (2, 'Ken', 'Follett', null, null, 'Britisk');
insert into forfatter values (3, 'Stephen W.', 'Hawking', null, null, 'Britisk');
insert into forfatter values (4, 'Jose', 'Saramago', 1942, null, 'Portugisisk');
insert into forfatter values (5, 'Douglas', 'Coupland', 1961, null, 'Canadisk');
insert into forfatter values (6, 'Nick', 'Hornby', 1957, null, 'Britisk');
insert into forfatter values (7, 'Knut', 'Hamsun', 1859, 1952, 'Norsk');
insert into forfatter values (8, 'Henning', 'Mankell', 1948, null, 'Svensk');
insert into forfatter values (9, 'Helen', 'Fielding', null, null, 'Britisk');
insert into forfatter values (10, 'Hal', 'Sirowitz', null, null, 'USA');
insert into forfatter values (11, 'Lars Saabye', 'Christensen', null, null, 'Norsk');
insert into forfatter values (12, 'Erlend', 'Loe', null, null, 'Norsk');

-- bokforfatter
insert into bokforfatter values (1, 1);
insert into bokforfatter values (2, 2);
insert into bokforfatter values (3, 6);
insert into bokforfatter values (4, 5);
insert into bokforfatter values (5, 5);
insert into bokforfatter values (6, 4);
insert into bokforfatter values (7, 3);
insert into bokforfatter values (8, 2);
insert into bokforfatter values (9, 7);
insert into bokforfatter values (10, 7);
insert into bokforfatter values (11, 7);
insert into bokforfatter values (12, 7);
insert into bokforfatter values (13, 7);
insert into bokforfatter values (14, 8);
insert into bokforfatter values (15, 8);
insert into bokforfatter values (16, 8);
insert into bokforfatter values (17, 8);
insert into bokforfatter values (18, 8);
insert into bokforfatter values (19, 8);
insert into bokforfatter values (20, 9);
insert into bokforfatter values (21, 10);
insert into bokforfatter values (22, 10);
insert into bokforfatter values (23, 11);
insert into bokforfatter values (24, 12);
insert into bokforfatter values (25, 12);
