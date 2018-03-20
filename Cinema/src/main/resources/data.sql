INSERT INTO korisnici
(grad, email, prezime, ime, lozinka, telefon, role) VALUES 
('Zrenjanin' , 'email@gmail.com', 'Prezime', 'Ime', 'password', '8321093012', 'REGULAR');

INSERT INTO korisnici
(grad, email, prezime, ime, lozinka, telefon, role) VALUES 
('Beograd' , 'admin@gmail.com', 'Prezime', 'Ime', 'password', '453454', 'SYSTEM');

INSERT INTO obican_korisnik (id, test) VALUES ('1', 'nebitno');

INSERT INTO administrator (id, first_login) VALUES ('2', true);