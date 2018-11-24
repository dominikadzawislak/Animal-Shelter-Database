INSERT INTO "Schronisko" VALUES (1,'124999555',null,'Piêkna', 'Warszawa', 'Polska', 'Wesole', 1);

INSERT INTO "Zwierzeta" VALUES (1, 'Azor', '10', '2017-05-13',1,1);
INSERT INTO "Zwierzeta" VALUES  (2, 'Puszek', '2', '2017-05-13',1,1);
INSERT INTO "Zwierzeta" VALUES (3,'Ciapek','5','01/04/15',1,3);
INSERT INTO "Zwierzeta" VALUES  (4,'Burek','5','01/04/15',1,2);
INSERT INTO "Zwierzeta" VALUES  (5,'Kasia','5','01/02/15',1,2);

INSERT INTO "Koty" VALUES (1,1,'Dachowiec');
INSERT INTO "Koty" VALUES (2,2,'Pers');

INSERT INTO "Psy" VALUES (3,1,'Mops');
INSERT INTO "Psy" VALUES (4,2,'Owczarek');

INSERT INTO "Inne" VALUES (5,1,'Papuga');

INSERT INTO "Stany_zdrowia" VALUES (1, '11/05/10', null, null, 1);
INSERT INTO "Stany_zdrowia" VALUES (2, null, '01/02/17', null, 2);
INSERT INTO "Stany_zdrowia" VALUES (3, null, '01/06/16', null, 3);
INSERT INTO "Stany_zdrowia" VALUES (4, '01/04/15', null, null, 4);
INSERT INTO "Stany_zdrowia" VALUES (5, null, null, null, 5);

INSERT INTO "Pracownicy" VALUES (1,'Jan','Kowalski','96102208922', '01/04/16', null, 'Prezes', '125467102', 'j.kowalski@wp.pl', 'Ulica1', 'Warszawa', '1', '3', 'Polska', 1, 1);
INSERT INTO "Pracownicy" VALUES (2,'Piotr','Nowak','94106208452', '01/03/17', null, 'Ksiêgowy', '125456702', 'p.nowak@wp.pl', 'Ulica2', 'Warszawa', '10', '34', 'Polska', 1, 2);
INSERT INTO "Pracownicy" VALUES (3,'Anna','Mazur','92122208545', '10/03/18', null, 'Dy¿urny', '505467107', 'a.mazur@wp.pl', 'Ulica3', 'Warszawa', '31', '3', 'Polska', 1, 3);
INSERT INTO "Pracownicy" VALUES (4,'Kamil','Wojcik','91122208664', '10/03/17', null, 'Kierowca', '616467167', 'k.wojcik@waw.pl', 'Ulica4', 'Warszawa', '1', '3', 'Polska', 1, 2);

INSERT INTO "Wynagrodzenia" VALUES (1, 8000, '01/04/16', null, 1);
INSERT INTO "Wynagrodzenia" VALUES (2, 13000, '01/03/17', null, 2);
INSERT INTO "Wynagrodzenia" VALUES (3, 12000, '10/03/18', null, 3);

INSERT INTO "Wolontariusze" VALUES (1,'Anna','Nowak',null,null,'96092310447','123543876',null,null,'Warszawa','23',null,'Polska',1,1);
INSERT INTO "Wolontariusze" VALUES (2,'Monika','Nowakowska','Pomagamy',null,'96092330447','343543876',null,'Pu³awska','Warszawa','33',null,'Polska',1,2);

INSERT INTO "Klienci" VALUES (1,'96092410446','Katarzyna','Kowal','576934265',null,null,'Warszawa','45','3','Polska',1,3);
INSERT INTO "Klienci" VALUES (2,'94492410446','Monika','Kowalska','446934265','111@wp.pl',null,'Warszawa','46','66','Polska',1,1);
INSERT INTO "Klienci" VALUES (3,'97892410446','Aleksandra','Baran','666934265',null,'Wilcza','Warszawa','34','22','Polska',1,2);

INSERT INTO "Adopcje" VALUES (1,'02/05/16',1,1,1);
INSERT INTO "Adopcje" VALUES (2,'03/06/17',3,2,1);

INSERT INTO "Pomieszczenia" VALUES (1,'Klatka',null,3,3,3,1);
INSERT INTO "Pomieszczenia" VALUES (2,'Kojec',null,2,3,4,1);
INSERT INTO "Pomieszczenia"  VALUES (3,'Wybieg',null,5,5,5,1);

INSERT INTO "Pojazdy" VALUES (1,'04/02/12','WWR3453',1,'Fiat','Osobowy','1HGCM82633A004352','R4','Zielony');
INSERT INTO "Pojazdy" VALUES (2,'04/02/12','WWA3553',1,'Skoda','Dostawczy','2HGCM84433A664352','R6','Czerwony');

INSERT INTO "Poczty" VALUES ('03-300', 1);
INSERT INTO "Poczty" VALUES ('04-300', 2);
INSERT INTO "Poczty" VALUES ('05-200', 3);

INSERT INTO "Darowizny" VALUES (2, 100, '01/04/18', 2);

INSERT INTO "Pojazdy-Pracownicy" VALUES (1, 4);

INSERT INTO "Pracownicy-Zwierzeta" VALUES (3, 1, '01/05/18');

INSERT INTO "Wolontariusze-Zwierzeta" VALUES (2, 1, '01/05/18');
INSERT INTO "Wolontariusze-Zwierzeta" VALUES (3, 2, '01/05/18');

INSERT INTO "Przewoz" VALUES (1, 2);
INSERT INTO "Przewoz" VALUES (2, 4);

INSERT INTO "Obsluga_pomieszczenia" VALUES (1, 2, '04/04/18');
INSERT INTO "Obsluga_pomieszczenia" VALUES (2, 1, '02/05/18');
