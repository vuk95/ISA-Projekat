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

INSERT INTO korisnici
(grad, email, prezime, ime, lozinka, telefon, role, enabled) VALUES 
('Beograd' , 'a@gmail.com', 'Prezime', 'Ime', 'password', '453454', 'SYSTEM', true);


INSERT INTO obican_korisnik (user_id) VALUES ('1');

INSERT INTO administrator (user_id, first_login, predefinisani) VALUES ('2', true, true);

INSERT INTO administrator (user_id, first_login, predefinisani) VALUES ('3', true, false);

INSERT INTO administrator (user_id, first_login, predefinisani) VALUES ('4', true, false);

INSERT INTO obican_korisnik (user_id) VALUES ('5');

INSERT INTO administrator (user_id, first_login, predefinisani) VALUES ('6', true, false);

INSERT INTO obican_korisnik (user_id) VALUES ('7');

INSERT INTO administrator (user_id, first_login, predefinisani) VALUES ('8', true, false);
--=====================================================================================================
--Bioskopi

INSERT INTO bioskop_pozoriste
(adresa,prosecna_ocena,opis,naziv,tip) values ('Bulevar Mihajla Pupina 3,Novi Sad','5','Jedan od najposecenijih bioskopa u zemlji','Arena Cineplex','CINEMA');

INSERT INTO bioskop_pozoriste
(adresa,prosecna_ocena,opis,naziv,tip) values ('Novosadski put bb,Zrenjanin','1.7','Bioskop u Zrenjaninu','CineStar','CINEMA');

INSERT INTO bioskop_pozoriste
(adresa,prosecna_ocena,opis,naziv,tip) values ('Bulevar Mihajla Pupina 4,Beograd','4.9','Jedan od boljih bioskopa','Cineplexx UŠCE Shopping Center','CINEMA');

INSERT INTO bioskop_pozoriste
(adresa,prosecna_ocena,opis,naziv,tip) values ('Decanska 14,Beograd','5','Najbolji bioskop','Dvorana Doma sindikata','CINEMA');

INSERT INTO bioskop_pozoriste
(adresa,prosecna_ocena,opis,naziv,tip) values ('Trg Cara Jovana Nenada 15,Subotica','2.3','Bioskop u Subotici','Eurocinema','CINEMA');

INSERT INTO bioskop_pozoriste
(adresa,prosecna_ocena,opis,naziv,tip) values ('Bulevar kraljice Marije 56,Kragujevac','3.4','Bioskop u Kragujevcu','Cineplexx Kragujevac Plaza','CINEMA');

INSERT INTO bioskop_pozoriste
(adresa,prosecna_ocena,opis,naziv,tip) values ('Maršala Tita 73/a,Vrbas','2.8','Bioskop u Vrbasu','Bioskop Jugoslavija','CINEMA');

INSERT INTO bioskop_pozoriste
(adresa,prosecna_ocena,opis,naziv,tip) values ('Bulevar Medijana 21,Niš','3.2','Bioskop u Nišu','Cineplexx Niš','CINEMA');

--======================================================================================================================
--Pozorista

INSERT INTO bioskop_pozoriste
(adresa,prosecna_ocena,opis,naziv,tip) values ('Pozorišni trg 1,Novi Sad','5','Jedno od najposecenijih pozorista u zemlji','Srpsko narodno pozorište','THEATRE');

INSERT INTO bioskop_pozoriste
(adresa,prosecna_ocena,opis,naziv,tip) values ('Trg slobode 7,Zrenjanin','2.1','Pozoriste u Zrenjninu','Narodno pozorište „Toša Jovanovic','THEATRE');

INSERT INTO bioskop_pozoriste
(adresa,prosecna_ocena,opis,naziv,tip) values ('Trg republike,Beograd','3.8','Jedno od pozorista u Beogradu','Narodno pozorište','THEATRE');

INSERT INTO bioskop_pozoriste
(adresa,prosecna_ocena,opis,naziv,tip) values ('Ulica kralja Milana 50,Beograd','4.3','Jedno od najposecenijih pozorista u Beogradu','Jugoslovensko dramsko pozorište','THEATRE');

INSERT INTO bioskop_pozoriste
(adresa,prosecna_ocena,opis,naziv,tip) values ('Mileševska 64a,Beograd','3.6','Jedno od mnogobrojnih pozorista u Beogradu','Beogradsko dramsko pozorište','THEATRE');

INSERT INTO bioskop_pozoriste
(adresa,prosecna_ocena,opis,naziv,tip) values ('Svetogorska 21,Beograd','5','Jedno od najboljih pozorista u zemlji','Atelje 212','THEATRE');

INSERT INTO bioskop_pozoriste
(adresa,prosecna_ocena,opis,naziv,tip) values ('Karadjordjeva 22,Šabac','2.9','Jedno od pozorista sa dugom tradicijom dobrih glumaca','Šabacko pozorište','THEATRE');

INSERT INTO bioskop_pozoriste
(adresa,prosecna_ocena,opis,naziv,tip) values ('Narodnog heroja 1,Vranje','4.5','Jedno od najstarijih i najboljih pozorista u zemlji','Pozorište Bora Stankovic','THEATRE');

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

--=============================================================================================================================================================
--Sale

INSERT INTO hall(ime,broj_redova,broj_sedista) values ('Glavna sala',12,12);

INSERT INTO hall(ime,broj_redova,broj_sedista) values ('Velika sala',10,12);

INSERT INTO hall(ime,broj_redova,broj_sedista) values ('Mala sala',9,6);

--==============================================================================================================================
--Projekcije(filmovi/predstave)

INSERT INTO projekcije(glumci,prosecna_ocena,datum,opis,reditelj,trajanje,zanr,naziv,price,vreme,cinema_theatre_id,hall_id) values
('Christian Bale, Tom Hardy, Anne Hathaway','4.8','2018-02-03','Poslednji deo Marvelove trilogije o Betmenu','Kristofer Nolan','164','Akcija,Triler','The Dark Knight Rises','350','17:30','1','1');

INSERT INTO projekcije(glumci,prosecna_ocena,datum,opis,reditelj,trajanje,zanr,naziv,price,vreme,cinema_theatre_id,hall_id) values
('Christian Bale, Heath Ledger, Aaron Eckhart','5','2018-03-05','Drugi deo Marvelove trilogije o Betmenu','Kristofer Nolan','152','Akcija,Avanturisticki','The Dark Knight','350','17:30','1','2');

INSERT INTO projekcije(glumci,prosecna_ocena,datum,opis,reditelj,trajanje,zanr,naziv,price,vreme,cinema_theatre_id,hall_id) values
('Christian Bale, Michael Caine, Ken Watanabe','4.1','2018-01-11','Prvi deo Marvelove trilogije o Betmenu','Kristofer Nolan','140','Akcija,Avanturisticki,Triler','Batman Begins','350','17:30','4','1');

INSERT INTO projekcije(glumci,prosecna_ocena,datum,opis,reditelj,trajanje,zanr,naziv,price,vreme,cinema_theatre_id,hall_id) values
('Zoran Radmilovic,Mira Banjac,Milutin Butkovic','3.7','2018-04-01','Jedna od najboljih srpskih predstava','Dusan Kovacevic','165','Komedija,Drama','Radovan III','350','17:30','9','3');

INSERT INTO projekcije(glumci,prosecna_ocena,datum,opis,reditelj,trajanje,zanr,naziv,price,vreme,cinema_theatre_id,hall_id) values
('Jelena Antonijevic,Strahinja Bojovic,Danica Grubacki','4.3','2018-02-10','Pretstava uradjena po motivima istoimenog dela Iva Andrica','Kokan Mladenovic','155','Drama','Na Drini Cuprija','350','17:30','14','2');

--================================================================================================================================
--Bioskop_Pozoriste_projekcije

INSERT INTO bioskop_pozoriste_projections(bioskop_pozoriste_id,projections_id) values
(1,1);

INSERT INTO bioskop_pozoriste_projections(bioskop_pozoriste_id,projections_id) values
(1,2);

INSERT INTO bioskop_pozoriste_projections(bioskop_pozoriste_id,projections_id) values
(4,3);

INSERT INTO bioskop_pozoriste_projections(bioskop_pozoriste_id,projections_id) values
(9,4);

INSERT INTO bioskop_pozoriste_projections(bioskop_pozoriste_id,projections_id) values
(14,5);


--Karta

INSERT INTO karta(popust,rezervisana,sediste,seat_type,projekcija_id,user_user_id) values
('30',false,'3_12','SEAT','1','1');

INSERT INTO karta(popust,rezervisana,sediste,seat_type,projekcija_id,user_user_id) values
('70',false,'3_5','VIP','2','1');

INSERT INTO karta(popust,rezervisana,sediste,seat_type,projekcija_id,user_user_id) values
('75',false,'1_3','BALCONY','3','1');

INSERT INTO karta(popust,rezervisana,sediste,seat_type,projekcija_id,user_user_id) values
('75',false,'1_2','BALCONY','4','1');

INSERT INTO karta(popust,rezervisana,sediste,seat_type,projekcija_id,user_user_id) values
('75',false,'2_5','VIP','5','1');


INSERT INTO projekcije_tickets(projekcije_id,tickets_id) values (1,1);
INSERT INTO projekcije_tickets(projekcije_id,tickets_id) values (2,2);
INSERT INTO projekcije_tickets(projekcije_id,tickets_id) values (3,3);
INSERT INTO projekcije_tickets(projekcije_id,tickets_id) values (4,4);
INSERT INTO projekcije_tickets(projekcije_id,tickets_id) values (5,5);
