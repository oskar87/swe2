-- ===============================================================================
-- Jede SQL-Anweisung muss in genau 1 Zeile
-- Kommentare durch -- am Zeilenanfang
-- ===============================================================================


INSERT INTO bestellung (id, version, kunde_fk, status, erzeugt, aktualisiert) VALUES (400,0,101, 'versendet','01.01.2007 01:00:00','01.01.2007 01:00:00');
INSERT INTO bestellung (id, version, kunde_fk, status, erzeugt, aktualisiert) VALUES (401,0,101, 'in Bearbeitung', '01.01.2007 02:00:00','01.01.2007 02:00:00');
INSERT INTO bestellung (id, version, kunde_fk, status, erzeugt, aktualisiert) VALUES (402,0,102, 'Zahlung erhalten','01.01.2007 03:00:00','01.01.2007 03:00:00');
INSERT INTO bestellung (id, version, kunde_fk, status, erzeugt, aktualisiert) VALUES (403,0,102, 'versendet', '01.01.2007 04:00:00','01.01.2007 04:00:00');
INSERT INTO bestellung (id, version, kunde_fk, status, erzeugt, aktualisiert) VALUES (404,0,104, 'auf Zahlung warten', '01.01.2007 05:00:00','01.01.2007 05:00:00');
INSERT INTO bestellung (id, version, kunde_fk, status, erzeugt, aktualisiert) VALUES (410,0,103, 'storniert', '01.01.2007 06:00:00','01.01.2007 06:00:00');
