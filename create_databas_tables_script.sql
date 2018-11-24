/*
Created: 15.04.2018
Modified: 07.05.2018
Model: Oracle 11g Release 1
Database: Oracle 11g Release 1
*/


-- Create user data types section -------------------------------------------------

CREATE TYPE "SCOTT"."Cust_Address_Type"
AS OBJECT
    ( street_address     VARCHAR2(40)
    , postal_code        VARCHAR2(10)
    , city               VARCHAR2(30)
    , state_province     VARCHAR2(10)
    , country_id         CHAR(2)
    , phone              Phone_List_Type
    )
/

-- Create tables section -------------------------------------------------

-- Table Zwierzeta

CREATE TABLE "Zwierzeta"(
  "ID_Zwierzęcia" Number(10,0) NOT NULL,
  "Imię" Varchar2(20 ) NOT NULL,
  "Wiek" Number(2,0),
  "Data_przyjęcia" Date NOT NULL,
  "ID_Schroniska" Number(3,0) NOT NULL,
  "ID_Pomieszczenia" Number(5,0) NOT NULL
)
/

-- Create indexes for table Zwierzetaa

CREATE INDEX "IX_Relationship30" ON "Zwierzeta" ("ID_Schroniska")
/

CREATE INDEX "IX_Relationship35" ON "Zwierzeta" ("ID_Pomieszczenia")
/

-- Add keys for table Zwierzeta

ALTER TABLE "Zwierzeta" ADD CONSTRAINT "Key1" PRIMARY KEY ("ID_Zwierzęcia")
/

ALTER TABLE "Zwierzeta" ADD CONSTRAINT "ID Zwierzęcia" UNIQUE ("ID_Zwierzęcia")
/

-- Table Pracownicy

CREATE TABLE "Pracownicy"(
  "ID_Pracownika" Number(4,0) NOT NULL,
  "Imię" Varchar2(20 ) NOT NULL,
  "Nazwisko" Varchar2(30 ) NOT NULL,
  "PESEL" Char(11 ) NOT NULL,
  "Data_zadrudnienia" Date NOT NULL,
  "Data_zwolnienia" Date,
  "Stanowisko" Varchar2(20 ) NOT NULL,
  "Numer_telefonu" Varchar2(14 ) NOT NULL,
  "Adres_e-mail" Varchar2(30 ),
  "Ulica" Varchar2(30 ),
  "Miasto" Varchar2(30 ) NOT NULL,
  "Numer_domu" Varchar2(4 ) NOT NULL,
  "Numer_mieszkania" Varchar2(4 ),
  "Kraj" Varchar2(15 ),
  "ID_Schroniska" Number(3,0) NOT NULL,
  "ID_Poczty" Number(10,0) NOT NULL
)
/

-- Create indexes for table Pracownicy

CREATE INDEX "IX_Relationship15" ON "Pracownicy" ("ID_Schroniska")
/

CREATE INDEX "IX_Relationship16" ON "Pracownicy" ("ID_Poczty")
/

-- Add keys for table Pracownicy

ALTER TABLE "Pracownicy" ADD CONSTRAINT "Key2" PRIMARY KEY ("ID_Pracownika")
/

ALTER TABLE "Pracownicy" ADD CONSTRAINT "ID Pracownika" UNIQUE ("ID_Pracownika")
/

-- Table Wynagrodzenia

CREATE TABLE "Wynagrodzenia"(
  "ID_wynagrodzenia" Number(4,0) NOT NULL,
  "Płaca_brutto" Number(10,2) NOT NULL,
  "Data_wynagrodzenia" Date NOT NULL,
  "Premia" Number(6,2),
  "ID_Pracownika" Number(4,0) NOT NULL
)
/

-- Create indexes for table Wynagrodzenia

CREATE INDEX "IX_Relationship20" ON "Wynagrodzenia" ("ID_Pracownika")
/

-- Add keys for table Wynagrodzenia

ALTER TABLE "Wynagrodzenia" ADD CONSTRAINT "Key3" PRIMARY KEY ("ID_wynagrodzenia")
/

ALTER TABLE "Wynagrodzenia" ADD CONSTRAINT "ID Wynagrodzenia" UNIQUE ("ID_wynagrodzenia")
/

-- Table Wolontariusze

CREATE TABLE "Wolontariusze"(
  "ID_Wolontariusza" Number(4,0) NOT NULL,
  "Imię" Varchar2(20 ) NOT NULL,
  "Nazwisko" Varchar2(30 ) NOT NULL,
  "Zrzeszenie" Varchar2(30 ),
  "Wymar_godzin" Varchar2(6 ),
  "PESEL" Char(11 ) NOT NULL,
  "Numer_telefonu" Varchar2(14 ) NOT NULL,
  "Adres_e-mail" Varchar2(30 ),
  "Ulica" Varchar2(30 ),
  "Miasto" Varchar2(30 ) NOT NULL,
  "Numer_domu" Varchar2(4 ) NOT NULL,
  "Numer_mieszkania" Varchar2(4 ),
  "Kraj" Varchar2(15 ),
  "ID_Schroniska" Number(3,0) NOT NULL,
  "ID_Poczty" Number(10,0) NOT NULL
)
/

-- Create indexes for table Wolontariusze

CREATE INDEX "IX_Relationship22" ON "Wolontariusze" ("ID_Schroniska")
/

CREATE INDEX "IX_Relationship15" ON "Wolontariusze" ("ID_Poczty")
/

-- Add keys for table Wolontariusze

ALTER TABLE "Wolontariusze" ADD CONSTRAINT "Key2" PRIMARY KEY ("ID_Wolontariusza")
/

ALTER TABLE "Wolontariusze" ADD CONSTRAINT "ID Wolontariusza" UNIQUE ("ID_Wolontariusza")
/

-- Table Stany_zdrowia

CREATE TABLE "Stany_zdrowia"(
  "ID_Stanu_zdrowia" Number(10,0) NOT NULL,
  "Data_bilansu" Date,
  "Data_ostatniego_szczepienia" Date,
  "Pełnosprawność" Varchar2(30 ),
  "ID_Zwierzęcia" Number(10,0) NOT NULL
)
/

-- Create indexes for table Stany_zdrowia

CREATE INDEX "IX_Relationship2" ON "Stany_zdrowia" ("ID_Zwierzęcia")
/

-- Add keys for table Stany_zdrowia

ALTER TABLE "Stany_zdrowia" ADD CONSTRAINT "Key4" PRIMARY KEY ("ID_Stanu_zdrowia")
/

ALTER TABLE "Stany_zdrowia" ADD CONSTRAINT "ID Stanu zdrowia" UNIQUE ("ID_Stanu_zdrowia")
/

-- Table Klienci

CREATE TABLE "Klienci"(
  "ID_Klienta" Number(6,0) NOT NULL,
  "Pesel" Char(11 ) NOT NULL,
  "Imię" Varchar2(20 ) NOT NULL,
  "Nazwisko" Varchar2(30 ) NOT NULL,
  "Numer_telefonu" Varchar2(14 ) NOT NULL,
  "Adres_e-mail" Varchar2(30 ),
  "Ulica" Varchar2(30 ),
  "Miasto" Varchar2(30 ) NOT NULL,
  "Numer_domu" Varchar2(4 ) NOT NULL,
  "Numer_mieszkania" Varchar2(4 ),
  "Kraj" Varchar2(15 ) NOT NULL,
  "ID_Schroniska" Number(3,0) NOT NULL,
  "ID_Poczty" Number(10,0) NOT NULL
)
/

-- Create indexes for table Klienci

CREATE INDEX "IX_Relationship9" ON "Klienci" ("ID_Schroniska")
/

CREATE INDEX "IX_Relationship17" ON "Klienci" ("ID_Poczty")
/

-- Add keys for table Klienci

ALTER TABLE "Klienci" ADD CONSTRAINT "Key1" PRIMARY KEY ("ID_Klienta")
/

ALTER TABLE "Klienci" ADD CONSTRAINT "ID Klienta" UNIQUE ("ID_Klienta")
/

-- Table Schronisko

CREATE TABLE "Schronisko"(
  "ID_Schroniska" Number(3,0) NOT NULL,
  "Numer_telefonu" Varchar2(14 ) NOT NULL,
  "Adres_e-mail" Varchar2(30 ),
  "Ulica" Varchar2(30 ),
  "Miasto" Varchar2(30 ) NOT NULL,
  "Kraj" Varchar2(15 ) NOT NULL,
  "Nazwa" Varchar2(30 ) NOT NULL,
  "ID_Poczty" Number(10,0) NOT NULL
)
/

-- Create indexes for table Schronisko

CREATE INDEX "IX_Relationship18" ON "Schronisko" ("ID_Poczty")
/

-- Add keys for table Schronisko

ALTER TABLE "Schronisko" ADD CONSTRAINT "Key1" PRIMARY KEY ("ID_Schroniska")
/

ALTER TABLE "Schronisko" ADD CONSTRAINT "ID Schroniska" UNIQUE ("ID_Schroniska")
/

-- Table Darowizny

CREATE TABLE "Darowizny"(
  "ID_Darowizny" Number(5,0) NOT NULL,
  "Kwota" Number(10,2) NOT NULL,
  "Data_darowizny" Date NOT NULL,
  "ID_Klienta" Number(6,0) NOT NULL
)
/

-- Create indexes for table Darowizny

CREATE INDEX "IX_Relationship20" ON "Darowizny" ("ID_Klienta")
/

-- Add keys for table Darowizny

ALTER TABLE "Darowizny" ADD CONSTRAINT "Key3" PRIMARY KEY ("ID_Darowizny")
/

ALTER TABLE "Darowizny" ADD CONSTRAINT "ID Darowizny" UNIQUE ("ID_Darowizny")
/

-- Table Pojazdy

CREATE TABLE "Pojazdy"(
  "ID_Pojazdu" Number(3,0) NOT NULL,
  "Data_przeglądu" Date NOT NULL,
  "Numer_rejestracyjny" Char(8 ) NOT NULL,
  "ID_Schroniska" Number(3,0) NOT NULL,
  "Marka" Varchar2(20 ) NOT NULL,
  "Typ" Varchar2(30 ) NOT NULL,
  "VIN" Char(17 ) NOT NULL,
  "Silnik" Varchar2(30 ) NOT NULL,
  "Kolor" Varchar2(30 ) NOT NULL
)
/

-- Create indexes for table Pojazdy

CREATE INDEX "IX_Relationship14" ON "Pojazdy" ("ID_Schroniska")
/

-- Add keys for table Pojazdy

ALTER TABLE "Pojazdy" ADD CONSTRAINT "Key5" PRIMARY KEY ("ID_Pojazdu")
/

ALTER TABLE "Pojazdy" ADD CONSTRAINT "ID Pojazdu" UNIQUE ("ID_Pojazdu")
/

-- Table Adopcje

CREATE TABLE "Adopcje"(
  "ID Adopcji" Number(7,0) NOT NULL,
  "Data_adopcji" Date NOT NULL,
  "ID_Zwierzęcia" Number(10,0) NOT NULL,
  "ID_Klienta" Number(6,0) NOT NULL,
  "ID_Schroniska" Number(3,0) NOT NULL
)
/

-- Create indexes for table Adopcje

CREATE INDEX "IX_Relationship6" ON "Adopcje" ("ID_Zwierzęcia")
/

CREATE INDEX "IX_Relationship7" ON "Adopcje" ("ID_Klienta")
/

CREATE INDEX "IX_Relationship8" ON "Adopcje" ("ID_Schroniska")
/

-- Add keys for table Adopcje

ALTER TABLE "Adopcje" ADD CONSTRAINT "Key4" PRIMARY KEY ("ID Adopcji")
/

ALTER TABLE "Adopcje" ADD CONSTRAINT "ID_Adopcji" UNIQUE ("ID Adopcji")
/

-- Table Pojazdy-Pracownicy

CREATE TABLE "Pojazdy-Pracownicy"(
  "ID_Pojazdu" Number(3,0) NOT NULL,
  "ID_Pracownika" Number(4,0) NOT NULL
)
/

-- Add keys for table Pojazdy-Pracownicy

ALTER TABLE "Pojazdy-Pracownicy" ADD CONSTRAINT "Key8" PRIMARY KEY ("ID_Pojazdu","ID_Pracownika")
/

-- Table Pracownicy-Zwierzęta

CREATE TABLE "Pracownicy-Zwierzeta"(
  "ID_Pracownika" Number(4,0) NOT NULL,
  "ID_Zwierzęcia" Number(10,0) NOT NULL,
  "Data_mycia" Date
)
/

-- Add keys for table Pracownicy-Zwierzeta

ALTER TABLE "Pracownicy-Zwierzeta" ADD CONSTRAINT "Key9" PRIMARY KEY ("ID_Pracownika","ID_Zwierzęcia")
/

-- Table Wolontariusze-Zwierzeta

CREATE TABLE "Wolontariusze-Zwierzeta"(
  "ID_Zwierzęcia" Number(10,0) NOT NULL,
  "ID_Wolontariusza" Number(4,0) NOT NULL,
  "Data_wyprowadzenia" Date
)
/

-- Add keys for table Wolontariusze-Zwierzeta

ALTER TABLE "Wolontariusze-Zwierzeta" ADD CONSTRAINT "Key10" PRIMARY KEY ("ID_Zwierzęcia","ID_Wolontariusza")
/

-- Table Pomieszczenia

CREATE TABLE "Pomieszczenia"(
  "ID_Pomieszczenia" Number(5,0) NOT NULL,
  "Rodzaj" Varchar2(20 ) NOT NULL,
  "Miejsce" Varchar2(20 ),
  "Wysokość" Number(2,0) NOT NULL,
  "Szerokość" Number(3,0) NOT NULL,
  "Długość" Number(3,0) NOT NULL,
  "ID_Schroniska" Number(3,0) NOT NULL
)
/

-- Create indexes for table Pomieszczenia

CREATE INDEX "IX_Relationship3" ON "Pomieszczenia" ("ID_Schroniska")
/

-- Add keys for table Pomieszczenia

ALTER TABLE "Pomieszczenia" ADD CONSTRAINT "Key11" PRIMARY KEY ("ID_Pomieszczenia")
/

ALTER TABLE "Pomieszczenia" ADD CONSTRAINT "ID Pomieszczenia" UNIQUE ("ID_Pomieszczenia")
/

-- Table Obsluga pomieszczenia

CREATE TABLE "Obsluga_pomieszczenia"(
  "ID_Wolontariusza" Number(4,0) NOT NULL,
  "ID_Pomieszczenia" Number(5,0) NOT NULL,
  "Data_sprzątania" Date
)
/

-- Create indexes for table Obsluga pomieszczenia

CREATE INDEX "IX_Jest przypisana do" ON "Obsluga_pomieszczenia" ("ID_Pomieszczenia")
/

CREATE INDEX "IX_Ma przypisane" ON "Obsluga_pomieszczenia" ("ID_Wolontariusza")
/

-- Table Przewoz

CREATE TABLE "Przewoz"(
  "ID_Pojazdu" Number(3,0) NOT NULL,
  "ID_Zwierzęcia" Number(10,0) NOT NULL
)
/

-- Add keys for table Przewoz

ALTER TABLE "Przewoz" ADD CONSTRAINT "Key14" PRIMARY KEY ("ID_Pojazdu","ID_Zwierzęcia")
/

-- Table Koty

CREATE TABLE "Koty"(
  "ID_Zwierzęcia" Number(10,0) NOT NULL,
  "ID_Kota" Number(10,0) NOT NULL,
  "Rasa_kota" Varchar2(30 )
)
/

-- Create indexes for table Koty

CREATE INDEX "IX_Gatunki" ON "Koty" ("ID_Kota")
/

-- Table Psy

CREATE TABLE "Psy"(
  "ID_Zwierzęcia" Number(10,0) NOT NULL,
  "ID_Psa" Number(10,0) DEFAULT 10 NOT NULL,
  "Rasa_psa" Varchar2(30 )
)
/

-- Add keys for table Psy

ALTER TABLE "Psy" ADD CONSTRAINT "Key15" PRIMARY KEY ("ID_Zwierzęcia","ID_Psa")
/

-- Table Inne

CREATE TABLE "Inne"(
  "ID_Zwierzęcia" Number(10,0) NOT NULL,
  "ID_innego _gatunku" Number(10,0) NOT NULL,
  "Nazwa_gatunku" Varchar2(30 ) NOT NULL
)
/

-- Add keys for table Inne

ALTER TABLE "Inne" ADD CONSTRAINT "Key15" PRIMARY KEY ("ID_Zwierzęcia","ID_innego _gatunku")
/

-- Table Poczty

CREATE TABLE "Poczty"(
  "Kod_pocztowy" Varchar2(6 ) NOT NULL,
  "ID_Poczty" Number(10,0) NOT NULL
)
/

-- Add keys for table Poczty

ALTER TABLE "Poczty" ADD CONSTRAINT "Key16" PRIMARY KEY ("ID_Poczty")
/

ALTER TABLE "Poczty" ADD CONSTRAINT "ID_Poczty" UNIQUE ("ID_Poczty")
/


-- Create foreign keys (relationships) section ------------------------------------------------- 

ALTER TABLE "Adopcje" ADD CONSTRAINT "Są pod" FOREIGN KEY ("ID_Zwierzęcia") REFERENCES "Zwierzeta" ("ID_Zwierzęcia")
/


ALTER TABLE "Adopcje" ADD CONSTRAINT "Są oferowane" FOREIGN KEY ("ID_Klienta") REFERENCES "Klienci" ("ID_Klienta")
/


ALTER TABLE "Adopcje" ADD CONSTRAINT "Oferuje" FOREIGN KEY ("ID_Schroniska") REFERENCES "Schronisko" ("ID_Schroniska")
/


ALTER TABLE "Klienci" ADD CONSTRAINT "Ma" FOREIGN KEY ("ID_Schroniska") REFERENCES "Schronisko" ("ID_Schroniska")
/


ALTER TABLE "Pojazdy" ADD CONSTRAINT "Umożliwia" FOREIGN KEY ("ID_Schroniska") REFERENCES "Schronisko" ("ID_Schroniska")
/


ALTER TABLE "Pracownicy" ADD CONSTRAINT "Zatrudnia" FOREIGN KEY ("ID_Schroniska") REFERENCES "Schronisko" ("ID_Schroniska")
/


ALTER TABLE "Wynagrodzenia" ADD CONSTRAINT "Otrzymują" FOREIGN KEY ("ID_Pracownika") REFERENCES "Pracownicy" ("ID_Pracownika")
/


ALTER TABLE "Wolontariusze" ADD CONSTRAINT "Pracują" FOREIGN KEY ("ID_Schroniska") REFERENCES "Schronisko" ("ID_Schroniska")
/


ALTER TABLE "Pojazdy-Pracownicy" ADD CONSTRAINT "Są obsługiwane" FOREIGN KEY ("ID_Pojazdu") REFERENCES "Pojazdy" ("ID_Pojazdu")
/


ALTER TABLE "Pojazdy-Pracownicy" ADD CONSTRAINT "Obsługuje" FOREIGN KEY ("ID_Pracownika") REFERENCES "Pracownicy" ("ID_Pracownika")
/


ALTER TABLE "Pracownicy-Zwierzeta" ADD CONSTRAINT "Zajmują się" FOREIGN KEY ("ID_Pracownika") REFERENCES "Pracownicy" ("ID_Pracownika")
/


ALTER TABLE "Pracownicy-Zwierzeta" ADD CONSTRAINT "Znajdują się pod opieką" FOREIGN KEY ("ID_Zwierzęcia") REFERENCES "Zwierzeta" ("ID_Zwierzęcia")
/


ALTER TABLE "Zwierzeta" ADD CONSTRAINT "Przechowuje" FOREIGN KEY ("ID_Schroniska") REFERENCES "Schronisko" ("ID_Schroniska")
/


ALTER TABLE "Wolontariusze-Zwierzeta" ADD CONSTRAINT "Są pod opieką" FOREIGN KEY ("ID_Zwierzęcia") REFERENCES "Zwierzeta" ("ID_Zwierzęcia")
/


ALTER TABLE "Wolontariusze-Zwierzeta" ADD CONSTRAINT "Opiekują się" FOREIGN KEY ("ID_Wolontariusza") REFERENCES "Wolontariusze" ("ID_Wolontariusza")
/


ALTER TABLE "Obsluga_pomieszczenia" ADD CONSTRAINT "Mają przypisane" FOREIGN KEY ("ID_Wolontariusza") REFERENCES "Wolontariusze" ("ID_Wolontariusza")
/


ALTER TABLE "Obsluga_pomieszczenia" ADD CONSTRAINT "Są przypisane do" FOREIGN KEY ("ID_Pomieszczenia") REFERENCES "Pomieszczenia" ("ID_Pomieszczenia")
/


ALTER TABLE "Zwierzeta" ADD CONSTRAINT "Przebywają" FOREIGN KEY ("ID_Pomieszczenia") REFERENCES "Pomieszczenia" ("ID_Pomieszczenia")
/


ALTER TABLE "Stany_zdrowia" ADD CONSTRAINT "Posiadają" FOREIGN KEY ("ID_Zwierzęcia") REFERENCES "Zwierzeta" ("ID_Zwierzęcia")
/


ALTER TABLE "Pomieszczenia" ADD CONSTRAINT "Zawiera" FOREIGN KEY ("ID_Schroniska") REFERENCES "Schronisko" ("ID_Schroniska")
/


ALTER TABLE "Przewoz" ADD CONSTRAINT "Przewożą" FOREIGN KEY ("ID_Pojazdu") REFERENCES "Pojazdy" ("ID_Pojazdu")
/


ALTER TABLE "Przewoz" ADD CONSTRAINT "Są przewożone" FOREIGN KEY ("ID_Zwierzęcia") REFERENCES "Zwierzeta" ("ID_Zwierzęcia")
/


ALTER TABLE "Psy" ADD CONSTRAINT "Gatunki" FOREIGN KEY ("ID_Zwierzęcia") REFERENCES "Zwierzeta" ("ID_Zwierzęcia")
/


ALTER TABLE "Inne" ADD CONSTRAINT "Gatunki" FOREIGN KEY ("ID_Zwierzęcia") REFERENCES "Zwierzeta" ("ID_Zwierzęcia")
/


ALTER TABLE "Koty" ADD CONSTRAINT "Gatunki" FOREIGN KEY ("ID_Kota") REFERENCES "Zwierzeta" ("ID_Zwierzęcia")
/


ALTER TABLE "Wolontariusze" ADD CONSTRAINT "Przynależy do wolontariuszy" FOREIGN KEY ("ID_Poczty") REFERENCES "Poczty" ("ID_Poczty")
/


ALTER TABLE "Pracownicy" ADD CONSTRAINT "Przynależy do pracowników" FOREIGN KEY ("ID_Poczty") REFERENCES "Poczty" ("ID_Poczty")
/


ALTER TABLE "Klienci" ADD CONSTRAINT "Przynależą do klientów" FOREIGN KEY ("ID_Poczty") REFERENCES "Poczty" ("ID_Poczty")
/


ALTER TABLE "Schronisko" ADD CONSTRAINT "Przynależy do schroniska" FOREIGN KEY ("ID_Poczty") REFERENCES "Poczty" ("ID_Poczty")
/


ALTER TABLE "Darowizny" ADD CONSTRAINT "Wpłacają" FOREIGN KEY ("ID_Klienta") REFERENCES "Klienci" ("ID_Klienta")
/




-- Grant permissions section -------------------------------------------------
