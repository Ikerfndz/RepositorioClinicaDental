create table citas(
idcita				number(6) not null, 
tratamiento			number(6) not null, /* idTratamiento: del 1 al 21 */
secretariado		number(6) not null, /* idEmpleado: el 6 y 7 */
cirujano1			number(6) not null, /* idEmpleado: el 4 y 5 */
cirujano2			number(6),			/* idEmpleado: el 4 y 5 */
enfermeria1			number(6),			/* idEmpleado: el 1 el 2 y 3 */
enfermeria2			number(6),			/* idEmpleado: el 1 el 2 y 3 */
medicamento			number(6),			/* idMedicamento: del 1 al 8 */
rango				char(1) not null,
fechahora			date not null,
tipo				number(1) not null, /* Tipo: 0 es Revisión y Tipo: 1 es Intervención*/
anotacion			varchar(50),
duracion			number(3),
constraint pk_citas primary key(idcita),
constraint fk_citas_trat foreign key (tratamiento) references tratamientos(idtratamiento) on DELETE CASCADE,
constraint fk_citas_empl foreign key (secretariado) references empleados(idempleado) on DELETE CASCADE,
constraint fk_citas_empl foreign key (cirujano1) references empleados(idempleado) on DELETE CASCADE,
constraint fk_citas_empl foreign key (cirujano2) references empleados(idempleado) on DELETE CASCADE,
constraint fk_citas_empl foreign key (enfermeria1) references empleados(idempleado) on DELETE CASCADE,
constraint fk_citas_empl foreign key (enfermeria2) references empleados(idempleado) on DELETE CASCADE,
constraint fk_citas_med foreign key (medicamento) references medicamentos(idmedicamento) on DELETE CASCADE);


INSERT INTO citas (idcita, tratamiento, secretariado, cirujano1, cirujano2, enfermeria1, enfermeria2, medicamento, rango, fechahora, tipo, anotacion, duracion) 
VALUES (000001, 1, 6, 4, null, null, null, 5, 'M', '12/02/2021 10:30:00', 0, 'Cantidad de piezas permanentes y deciduas presentes en boca.', null);

INSERT INTO citas (idcita, tratamiento, secretariado, cirujano1, cirujano2, enfermeria1, enfermeria2, medicamento, rango, fechahora, tipo, anotacion, duracion) 
VALUES (000002, 2, 6, 5, null, null, null, 3, 'M', '22/03/2021 10:30:00', 0, 'Alteraciones de la estructura (mancha blanca, hipoplasia del esmalte y erosión).', null);

INSERT INTO citas (idcita, tratamiento, secretariado, cirujano1, cirujano2, enfermeria1, enfermeria2, medicamento, rango, fechahora, tipo, anotacion, duracion) 
VALUES (000003, 3, 7, 4, null, null, null, 2, 'M', '15/04/2021 10:30:00', 0, 'Alteraciones en el número (supernumerarios, anodoncias).', null);

INSERT INTO citas (idcita, tratamiento, secretariado, cirujano1, cirujano2, enfermeria1, enfermeria2, medicamento, rango, fechahora, tipo, anotacion, duracion) 
VALUES (000004, 4, 7, 5, null, null, null, 1, 'M', '10/05/2021 10:30:00', 0, 'Lesiones cariosas con exposición pulpar y amplia destrucción coronaria.', null);

INSERT INTO citas (idcita, tratamiento, secretariado, cirujano1, cirujano2, enfermeria1, enfermeria2, medicamento, rango, fechahora, tipo, anotacion, duracion) 
VALUES (000005, 5, 6, 4, null, null, null, 6, 'T', '11/06/2021 10:30:00', 0, 'Dolor a la percusión (vertical).', null);

INSERT INTO citas (idcita, tratamiento, secretariado, cirujano1, cirujano2, enfermeria1, enfermeria2, medicamento, rango, fechahora, tipo, anotacion, duracion) 
VALUES (000006, 6, 7, 5, null, null, null, 1, 'T', '18/07/2021 10:30:00', 0, 'Alteraciones en el color (pigmentación intrínseca).', null);

INSERT INTO citas (idcita, tratamiento, secretariado, cirujano1, cirujano2, enfermeria1, enfermeria2, medicamento, rango, fechahora, tipo, anotacion, duracion) 
VALUES (000007, 7, 6, 4, null, null, null, 3, 'T', '22/08/2021 10:30:00', 0, 'Pieza 18 (Tercer molar superior derecho permanente).', null);

INSERT INTO citas (idcita, tratamiento, secretariado, cirujano1, cirujano2, enfermeria1, enfermeria2, medicamento, rango, fechahora, tipo, anotacion, duracion) 
VALUES (123550, 8, 6, 4, 5, 1, 3, null, 'M', '12/04/2022 10:30:00', 1, null, 11);

INSERT INTO citas (idcita, tratamiento, secretariado, cirujano1, cirujano2, enfermeria1, enfermeria2, medicamento, rango, fechahora, tipo, anotacion, duracion) 
VALUES (123551, 9, 7, 4, null, 2, 3, 2, 'M', '12/04/2022 11:00:00', 1, null, 20);

INSERT INTO citas (idcita, tratamiento, secretariado, cirujano1, cirujano2, enfermeria1, enfermeria2, medicamento, rango, fechahora, tipo, anotacion, duracion) 
VALUES (123552, 10, 7, 5, null, 1, 2, null, 'M', '14/04/2022 10:30:00', 1, null, 60);

INSERT INTO citas (idcita, tratamiento, secretariado, cirujano1, cirujano2, enfermeria1, enfermeria2, medicamento, rango, fechahora, tipo, anotacion, duracion) 
VALUES (123553, 11, 6, 4, null, 2, 3, 5, 'M', '15/07/2022 11:00:00', 1, null, 12);

INSERT INTO citas (idcita, tratamiento, secretariado, cirujano1, cirujano2, enfermeria1, enfermeria2, medicamento, rango, fechahora, tipo, anotacion, duracion) 
VALUES (123554, 12, 7, 4, null, 1, 3, null, 'M', '06/07/2022 10:30:00', 1, null, 8);
 
INSERT INTO citas (idcita, tratamiento, secretariado, cirujano1, cirujano2, enfermeria1, enfermeria2, medicamento, rango, fechahora, tipo, anotacion, duracion) 
VALUES (123555, 13, 7, 5, null, 1, 2, null, 'M', '09/07/2022 12:00:00', 1, null, 28);			
		
INSERT INTO citas (idcita, tratamiento, secretariado, cirujano1, cirujano2, enfermeria1, enfermeria2, medicamento, rango, fechahora, tipo, anotacion, duracion) 
VALUES (123556, 14, 6, 4, 5, 1, 3, 6, 'M', '22/10/2022 12:30:00', 1, null, 43);			
		
INSERT INTO citas (idcita, tratamiento, secretariado, cirujano1, cirujano2, enfermeria1, enfermeria2, medicamento, rango, fechahora, tipo, anotacion, duracion) 
VALUES (123557, 15, 6, 4, 5, 2, 3, 1, 'T', '12/06/2022 16:00:00', 1, null, 51);			

INSERT INTO citas (idcita, tratamiento, secretariado, cirujano1, cirujano2, enfermeria1, enfermeria2, medicamento, rango, fechahora, tipo, anotacion, duracion) 
VALUES (123558, 16, 7, 4, 5, 1, 2, 6, 'T', '12/06/2022 16:30:00', 1, null, 71);	
			
INSERT INTO citas (idcita, tratamiento, secretariado, cirujano1, cirujano2, enfermeria1, enfermeria2, medicamento, rango, fechahora, tipo, anotacion, duracion) 
VALUES (123510, 17, 6, 5, null, 2, 3, null, 'T', '20/06/2022 16:00:00', 1, null, 48);	

INSERT INTO citas (idcita, tratamiento, secretariado, cirujano1, cirujano2, enfermeria1, enfermeria2, medicamento, rango, fechahora, tipo, anotacion, duracion) 
VALUES (123511, 18, 7, 4, 5, 1, 3, 7, 'T', '20/06/2022 17:30:00', 1, null, 82);	

INSERT INTO citas (idcita, tratamiento, secretariado, cirujano1, cirujano2, enfermeria1, enfermeria2, medicamento, rango, fechahora, tipo, anotacion, duracion) 
VALUES (123512, 19, 7, 5, null, 1, 2, null,'T', '29/06/2022 17:00:00', 1, null, 22);		
		
INSERT INTO citas (idcita, tratamiento, secretariado, cirujano1, cirujano2, enfermeria1, enfermeria2, medicamento, rango, fechahora, tipo, anotacion, duracion) 
VALUES (123513, 20, 6, 5, null, 2, 3, 1, 'T', '11/10/2022 18:30:00', 1, null, 29);				
			
INSERT INTO citas (idcita, tratamiento, secretariado, cirujano1, cirujano2, enfermeria1, enfermeria2, medicamento, rango, fechahora, tipo, anotacion, duracion) 
VALUES (123514, 21, 7, 4, 5, 1, 3, 6, 'T', '02/12/2022 18:00:00', 1, null, 59);			
			