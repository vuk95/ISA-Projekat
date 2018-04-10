--Korisnici

INSERT INTO korisnici
(grad, email, prezime, ime, lozinka, telefon, role, enabled) VALUES 
('Zrenjanin' , 'email@gmail.com', 'Prezime', 'Ime', 'password', '8321093012', 'REGULAR', true);

INSERT INTO korisnici
(grad, email, prezime, ime, lozinka, telefon, role, enabled) VALUES 
('Beograd' , 'admin@gmail.com', 'Prezime', 'Ime', 'password', '453454', 'SYSTEM', true);

INSERT INTO korisnici
(grad, email, prezime, ime, lozinka, telefon, role, enabled) VALUES 
('Vrbas' , 'stefanmilovic2@gmail.com', 'Milovic', 'Stefan', 'sm22', '1234567890', 'CINEMA_THEATRE', true);

INSERT INTO korisnici
(grad, email, prezime, ime, lozinka, telefon, role, enabled) VALUES 
('Washington' , 'fanzone@gmail.com', 'Admin', 'Admin', 'password', '1234567890', 'FAN_ZONE', true);

INSERT INTO korisnici
(grad, email, prezime, ime, lozinka, telefon, role, enabled) VALUES 
('NS' , 'obican@gmail.com', 'Markovic', 'Marko', 'password', '1234567890', 'REGULAR', true);

INSERT INTO korisnici
(grad, email, prezime, ime, lozinka, telefon, role, enabled) VALUES 
('BG' , 'fz@gmail.com', 'Markovski', 'Marko', 'password', '1234567890', 'FAN_ZONE', true);

INSERT INTO korisnici
(grad, email, prezime, ime, lozinka, telefon, role, enabled) VALUES 
('NS' , 'gmail@gmail.com', 'Jovanovic', 'Jovan', 'password', '1234567890', 'REGULAR', true);

INSERT INTO obican_korisnik (user_id) VALUES ('1');

INSERT INTO administrator (user_id, first_login) VALUES ('2', true);

INSERT INTO administrator (user_id, first_login) VALUES ('3', true);

INSERT INTO administrator (user_id, first_login) VALUES ('4', true);

INSERT INTO obican_korisnik (user_id) VALUES ('5');

INSERT INTO administrator (user_id, first_login) VALUES ('6', true);

INSERT INTO obican_korisnik (user_id) VALUES ('7');

--=====================================================================================================
--Bioskopi

INSERT INTO bioskop_pozoriste
(adresa,opis,naziv,tip) values ('Bulevar Mihajla Pupina 3,Novi Sad','Jedan od najposecenijih bioskopa u zemlji','Arena Cineplex','CINEMA');

INSERT INTO bioskop_pozoriste
(adresa,opis,naziv,tip) values ('Novosadski put bb,Zrenjanin','Bioskop u Zrenjaninu','CineStar','CINEMA');

INSERT INTO bioskop_pozoriste
(adresa,opis,naziv,tip) values ('Bulevar Mihajla Pupina 4,Beograd','Jedan od boljih bioskopa','Cineplexx UŠCE Shopping Center','CINEMA');

INSERT INTO bioskop_pozoriste
(adresa,opis,naziv,tip) values ('Decanska 14,Beograd','Najbolji bioskop','Dvorana Doma sindikata','CINEMA');

INSERT INTO bioskop_pozoriste
(adresa,opis,naziv,tip) values ('Trg Cara Jovana Nenada 15,Subotica','Bioskop u Subotici','Eurocinema','CINEMA');

INSERT INTO bioskop_pozoriste
(adresa,opis,naziv,tip) values ('Bulevar kraljice Marije 56,Kragujevac','Bioskop u Kragujevcu','Cineplexx Kragujevac Plaza','CINEMA');

INSERT INTO bioskop_pozoriste
(adresa,opis,naziv,tip) values ('Maršala Tita 73/a,Vrbas','Bioskop u Vrbasu','Bioskop Jugoslavija','CINEMA');

INSERT INTO bioskop_pozoriste
(adresa,opis,naziv,tip) values ('Bulevar Medijana 21,Niš','Bioskop u Nišu','Cineplexx Niš','CINEMA');

--======================================================================================================================
--Pozorista

INSERT INTO bioskop_pozoriste
(adresa,opis,naziv,tip) values ('Pozorišni trg 1,Novi Sad','Jedno od najposecenijih pozorista u zemlji','Srpsko narodno pozorište','THEATRE');

INSERT INTO bioskop_pozoriste
(adresa,opis,naziv,tip) values ('Trg slobode 7,Zrenjanin','Pozoriste u Zrenjninu','Narodno pozorište „Toša Jovanovic','THEATRE');

INSERT INTO bioskop_pozoriste
(adresa,opis,naziv,tip) values ('Trg republike,Beograd','Jedno od pozorista u Beogradu','Narodno pozorište','THEATRE');

INSERT INTO bioskop_pozoriste
(adresa,opis,naziv,tip) values ('Ulica kralja Milana 50,Beograd','Jedno od najposecenijih pozorista u Beogradu','Jugoslovensko dramsko pozorište','THEATRE');

INSERT INTO bioskop_pozoriste
(adresa,opis,naziv,tip) values ('Mileševska 64a,Beograd','Jedno od mnogobrojnih pozorista u Beogradu','Beogradsko dramsko pozorište','THEATRE');

INSERT INTO bioskop_pozoriste
(adresa,opis,naziv,tip) values ('Svetogorska 21,Beograd','Jedno od najboljih pozorista u zemlji','Atelje 212','THEATRE');

INSERT INTO bioskop_pozoriste
(adresa,opis,naziv,tip) values ('Karadjordjeva 22,Šabac','Jedno od pozorista sa dugom tradicijom dobrih glumaca','Šabacko pozorište','THEATRE');

INSERT INTO bioskop_pozoriste
(adresa,opis,naziv,tip) values ('Narodnog heroja 1,Vranje','Jedno od najstarijih i najboljih pozorista u zemlji','Pozorište Bora Stankovic','THEATRE');

--===============================================================================================================================
-- Poseceni bioskopi 
INSERT INTO poseceni_bioskopi_pozorista(user_id, cinematheatre_id) VALUES (5, 1);
INSERT INTO poseceni_bioskopi_pozorista(user_id, cinematheatre_id) VALUES (5, 2);
INSERT INTO poseceni_bioskopi_pozorista(user_id, cinematheatre_id) VALUES (5, 6);
INSERT INTO poseceni_bioskopi_pozorista(user_id, cinematheatre_id) VALUES (5, 8);

-- Posecena pozorista
INSERT INTO poseceni_bioskopi_pozorista(user_id, cinematheatre_id) VALUES (5, 10);
INSERT INTO poseceni_bioskopi_pozorista(user_id, cinematheatre_id) VALUES (5, 12);
INSERT INTO poseceni_bioskopi_pozorista(user_id, cinematheatre_id) VALUES (5, 15);

--=================================================================================================================================

--Predstava

INSERT INTO film_predstava
(opis,reditelj,trajanje,zanr,naziv,slika,cena,tip,pozoriste_bioskop_id) values ('Jedna od najpopularnijih srpskih pretstava','Andrija Milosevic','96','Komedija','Pevaj brate','vajpeTebra.jpg','350','PERFORMANCE','9');

--===================================================================================================================================

--Film
INSERT INTO film_predstava
(opis,reditelj,trajanje,zanr,naziv,slika,cena,tip,pozoriste_bioskop_id) values ('Jedan od najboljih stranih filmova.','Pierre Morel','93','Akcija,Triler','Taken (96 sati)','taken.jpg','500','MOVIE','3');


--====================================================================================================================================

--Projekcije

INSERT INTO repertoar_bioskop_pozoriste (pozoriste_bioskop_id,film_predstava_id) values (9,1);
INSERT INTO repertoar_bioskop_pozoriste (pozoriste_bioskop_id,film_predstava_id) values (3,2);
