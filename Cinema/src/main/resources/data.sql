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
('Novi sad' , 'pera@gmail.com', 'Peric', 'Pera', 'password', '06000000', 'REGULAR', true);

INSERT INTO korisnici
(grad, email, prezime, ime, lozinka, telefon, role, enabled) VALUES 
('Kumanovo' , 'mika@gmail.com', 'Mikic', 'Mika', 'password', '07300000', 'REGULAR', true);

INSERT INTO obican_korisnik (id) VALUES ('1');

INSERT INTO administrator (id, first_login) VALUES ('2', true);

INSERT INTO administrator (id, first_login) VALUES ('3', true);

INSERT INTO obican_korisnik (id) VALUES ('4');

INSERT INTO obican_korisnik (id) VALUES ('5');

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



