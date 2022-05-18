-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 18-05-2022 a las 16:54:46
-- Versión del servidor: 10.4.21-MariaDB
-- Versión de PHP: 7.3.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `clinicadental`
--
CREATE DATABASE IF NOT EXISTS `clinicadental` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `clinicadental`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alergias`
--

DROP TABLE IF EXISTS `alergias`;
CREATE TABLE IF NOT EXISTS `alergias` (
  `id_alergia` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  PRIMARY KEY (`id_alergia`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `alergias`
--

INSERT INTO `alergias` (`id_alergia`, `nombre`) VALUES
(1, 'Alergia al látex'),
(2, 'Alergia a la penicilina'),
(3, 'Alergia a la amoxicilina'),
(4, 'Alergia al paracetamol'),
(5, 'Alergia al flúor'),
(6, 'Alergia al propofol'),
(7, 'Alergia al fluoruro de estaño'),
(8, 'Alergia al cloruro de estaño'),
(9, 'Alergia a la amoxicilina'),
(10, 'Alergia a la codeína');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cirujanos`
--

DROP TABLE IF EXISTS `cirujanos`;
CREATE TABLE IF NOT EXISTS `cirujanos` (
  `id_cirujano` int(11) NOT NULL AUTO_INCREMENT,
  `especialidad` tinyint(1) NOT NULL,
  PRIMARY KEY (`id_cirujano`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `cirujanos`
--

INSERT INTO `cirujanos` (`id_cirujano`, `especialidad`) VALUES
(1, 1),
(2, 1),
(3, 0),
(4, 1),
(5, 1),
(6, 0),
(7, 1),
(8, 1),
(9, 0),
(10, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `citas`
--

DROP TABLE IF EXISTS `citas`;
CREATE TABLE IF NOT EXISTS `citas` (
  `id_cita` int(11) NOT NULL AUTO_INCREMENT,
  `turno` varchar(30) NOT NULL,
  `fecha` date NOT NULL,
  `hora` time NOT NULL,
  `id_tratamiento` int(11) NOT NULL,
  `id_secretario` int(11) NOT NULL,
  PRIMARY KEY (`id_cita`),
  UNIQUE KEY `id_tratamiento_FK` (`id_tratamiento`),
  UNIQUE KEY `id_secretario_FK` (`id_secretario`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `citas`
--

INSERT INTO `citas` (`id_cita`, `turno`, `fecha`, `hora`, `id_tratamiento`, `id_secretario`) VALUES
(1, 'Mañana', '2022-05-09', '10:30:00', 1, 11),
(2, 'Mañana', '2022-05-09', '12:30:00', 2, 12),
(3, 'Tarde', '2022-01-12', '16:30:00', 3, 13),
(4, 'Tarde', '2022-02-02', '18:00:00', 4, 14),
(5, 'Mañana', '2021-11-11', '09:15:00', 5, 15),
(6, 'Tarde', '2022-02-02', '15:30:00', 6, 16),
(7, 'Mañana', '2022-05-02', '09:30:00', 7, 17),
(8, 'Tarde', '2022-02-23', '17:30:00', 8, 18),
(9, 'Mañana', '2022-02-14', '11:30:00', 9, 19),
(10, 'Mañana', '2022-03-08', '10:00:00', 10, 20);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cobros`
--

DROP TABLE IF EXISTS `cobros`;
CREATE TABLE IF NOT EXISTS `cobros` (
  `id_cobro` int(11) NOT NULL AUTO_INCREMENT,
  `importe` double NOT NULL,
  `fecha` date NOT NULL,
  PRIMARY KEY (`id_cobro`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `cobros`
--

INSERT INTO `cobros` (`id_cobro`, `importe`, `fecha`) VALUES
(1, 500, '2022-03-15'),
(2, 300, '2021-07-14'),
(3, 155, '2021-02-08'),
(4, 260, '2022-02-01'),
(5, 950, '2020-09-08'),
(6, 235, '2022-01-28'),
(7, 550, '2021-10-06'),
(8, 932, '2022-01-16'),
(9, 600, '2022-05-09'),
(10, 1050, '2022-02-07');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleados`
--

DROP TABLE IF EXISTS `empleados`;
CREATE TABLE IF NOT EXISTS `empleados` (
  `id_empleado` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `telefono` varchar(9) NOT NULL,
  `direccion` varchar(30) NOT NULL,
  `NIF` varchar(11) NOT NULL,
  PRIMARY KEY (`id_empleado`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `empleados`
--

INSERT INTO `empleados` (`id_empleado`, `nombre`, `telefono`, `direccion`, `NIF`) VALUES
(1, 'Macarena del Bernal', '624875614', 'macarenab@hotmail.com', '48962415W'),
(2, 'Raquel Aranda Ballester', '623587412', 'raquel@yahoo.es', '14856923K'),
(3, 'Pablo Monreal Quintero', '648957412', 'pablo@educastur.es', '14726589L'),
(4, 'Carmen Gisbert Garmendia', '623598458', 'carmengis@hotmail.es', '15489623E'),
(5, 'Benjamín Azcona Rosell', '698541234', 'benjaminaz@gmail.com', '15236987X'),
(6, 'Martirio de Mínguez', '698754102', 'martimin@educastur.es', '45693247C'),
(7, 'Bernardino Sáez Merino', '698235140', 'bernardinosa@gmail.com', '56984712M'),
(8, 'Héctor René Torre Miralles', '635027489', 'hectorrene@gmail.com', '48592636N'),
(9, 'Jerónimo Tudela Fiol', '623587452', 'jeronimotu@gmail.es', '12365489P'),
(10, 'Teresa Madrid Esteve', '623489125', 'teresama@educastur.es', '45693256P'),
(11, 'Emma de Rios', '635987412', 'emmari@educastur.es', '14789230X'),
(12, 'Maite Almansa', '625256985', 'maitealma@educastur.es', '78956231S'),
(13, 'Carina Múgica', '693254147', 'carinamul@gmail.com', '36958475L'),
(14, 'Félix Baeza Caro', '652326598', 'felixbaez@gmail.com', '14596231X'),
(15, 'Amor Rosado Pellicer', '632598470', 'amor@educastur.es', '78596230Z'),
(16, 'Roldán Pedrosa González', '698352147', 'roldan@educastur.es', '69358714O'),
(17, 'Wálter de Muro', '623547562', 'walterm@gmail.com', '16236584U'),
(18, 'Mauricio Nogueira Pons', '698523023', 'mauricionog@gmail.es', '56982310E'),
(19, 'Carolina Caparrós-Aragonés', '695230621', 'carolinaca@gmail.es', '48752013Z'),
(20, 'Elvira de Lamas', '632001478', 'elviralamas@educastur.es', '75896541C'),
(21, 'Manuel del Arnau Fernández', '695241578', 'manueldarn@hotmail.com', '48265974N'),
(22, 'Febe Piñol Escudero', '625001475', 'febepi@hotmail.es', '47856231Q'),
(23, 'Hilario del Amores', '695874123', 'hilario@hotmail.es', '17965874A'),
(24, 'Amarilis Atienza Bayona', '632548745', 'amarilis@hotmail.es', '19845476L'),
(25, 'Marta Irene Correa Villena', '632598745', 'martairene@gmail.com', '56894210C'),
(26, 'Carmela Tomás-Sánchez', '623589541', 'carmelato@educastur.es', '14569230V'),
(27, 'Fabricio Mayol Espada', '652300147', 'fabriciomay@hotmail.es', '48563214Z'),
(28, 'María José Mendez Noguera', '612357456', 'mjmendez@gmail.com', '46952354N'),
(29, 'Marc Río-Aliaga', '635298745', 'marrio@educastur.es', '69235697Z'),
(30, 'Facundo Quiroga Rodríguez', '698566001', 'facuqui@gmail.com', '98324156B');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `enfermeros`
--

DROP TABLE IF EXISTS `enfermeros`;
CREATE TABLE IF NOT EXISTS `enfermeros` (
  `id_enfermero` int(11) NOT NULL AUTO_INCREMENT,
  `categoria` varchar(50) NOT NULL,
  PRIMARY KEY (`id_enfermero`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `enfermeros`
--

INSERT INTO `enfermeros` (`id_enfermero`, `categoria`) VALUES
(21, 'Enfermero en prácticas'),
(22, 'Enfermero anestesista'),
(23, 'Jefe de enfermería'),
(24, 'Enfermero registrado'),
(25, 'Enfermero en prácticas'),
(26, 'Enfermero anestesista'),
(27, 'Enfermero registrado'),
(28, 'Enfermero registrado'),
(29, 'Enfermero anestesista'),
(30, 'Enfermero registrado');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `escribe`
--

DROP TABLE IF EXISTS `escribe`;
CREATE TABLE IF NOT EXISTS `escribe` (
  `id_secretario` int(11) NOT NULL,
  `id_informe` int(11) NOT NULL,
  UNIQUE KEY `id_secretario_FK` (`id_secretario`,`id_informe`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `escribe`
--

INSERT INTO `escribe` (`id_secretario`, `id_informe`) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(6, 6),
(7, 7),
(8, 8),
(9, 9),
(10, 10);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `especialidades`
--

DROP TABLE IF EXISTS `especialidades`;
CREATE TABLE IF NOT EXISTS `especialidades` (
  `id_especialidad` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  PRIMARY KEY (`id_especialidad`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `especialidades`
--

INSERT INTO `especialidades` (`id_especialidad`, `nombre`) VALUES
(1, 'Cirujía general'),
(2, 'Cirujía craneofacial'),
(3, 'Cirujía oral'),
(4, 'Cirujía maxilofacial');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `historiales`
--

DROP TABLE IF EXISTS `historiales`;
CREATE TABLE IF NOT EXISTS `historiales` (
  `id_historial` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(200) NOT NULL,
  `id_paciente` int(11) NOT NULL,
  PRIMARY KEY (`id_historial`),
  UNIQUE KEY `id_paciente_FK` (`id_paciente`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `historiales`
--

INSERT INTO `historiales` (`id_historial`, `descripcion`, `id_paciente`) VALUES
(1, 'Ha sido operada para retirar las muelas del juicio.', 1),
(2, 'Lleva realizada una endodoncia debido al mal estado de sus dientes.', 2),
(3, 'Ha llevado aparato durante 3 años y lleva colocado un alambre para que los dientes inferiores no se muevan. Necesitará una revisión periódica.', 3),
(4, 'Debido a su bruxismo, deberá pasar por quirófano en los próximos meses, ya que le está provocando demasiado dolor.', 4),
(5, 'Ha llegado a la clínica con una inflamación en las encías que le ha provocado finalmente un problema de Gingivitis.', 5),
(6, 'Necesitará tratamiento para su problema de halitosis, que le provoca un mal olor de aliento permanente', 6),
(7, 'Deberá llevar a cabo la colocación de aparatos dentales tanto en la zona superior como inferior.', 7),
(8, 'Tiene problemas de caries en varios dientes, procederemos a la colocación de prótesis dentales en varios de ellos.', 8),
(9, 'Deberá llevar a cabo una limpieza dental a causa de la acumulación de sarro.', 9),
(10, 'Se deberá someter a una operación para la extracción de sus muelas del juicio.', 10);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `incluye`
--

DROP TABLE IF EXISTS `incluye`;
CREATE TABLE IF NOT EXISTS `incluye` (
  `id_historial` int(11) NOT NULL,
  `id_alergia` int(11) NOT NULL,
  UNIQUE KEY `id_alergia_FK` (`id_historial`,`id_alergia`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `incluye`
--

INSERT INTO `incluye` (`id_historial`, `id_alergia`) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(6, 6),
(7, 7),
(8, 8),
(9, 9),
(10, 10);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `informes`
--

DROP TABLE IF EXISTS `informes`;
CREATE TABLE IF NOT EXISTS `informes` (
  `id_informe` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(200) NOT NULL,
  PRIMARY KEY (`id_informe`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `informes`
--

INSERT INTO `informes` (`id_informe`, `descripcion`) VALUES
(1, 'El paciente evoluciona favorablemente.'),
(2, 'El paciente deberá realizar revisiones periódicas cada 6 meses.'),
(3, 'El paciente deberá someterse a una operación de urgencia.'),
(4, 'El paciente necesitará revisiones periódicas cada mes.'),
(5, 'El paciente necesitará aparato dental.'),
(6, 'El paciente necesitará revisiones periódicas cada año.'),
(7, 'El paciente evoluciona favorablemente.'),
(8, 'El paciente evoluciona favorablemente.'),
(9, 'El paciente necesitará revisiones periódicas cada 2 años.'),
(10, 'El paciente evoluciona favorablemente.');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `intervenciones`
--

DROP TABLE IF EXISTS `intervenciones`;
CREATE TABLE IF NOT EXISTS `intervenciones` (
  `id_intervencion` int(11) NOT NULL AUTO_INCREMENT,
  `duracion` varchar(30) NOT NULL,
  `id_enfermero` int(11) NOT NULL,
  `id_cirujano` int(11) NOT NULL,
  PRIMARY KEY (`id_intervencion`),
  UNIQUE KEY `id_enfermero_FK` (`id_enfermero`),
  UNIQUE KEY `id_cirujano_FK` (`id_cirujano`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `intervenciones`
--

INSERT INTO `intervenciones` (`id_intervencion`, `duracion`, `id_enfermero`, `id_cirujano`) VALUES
(1, '30 minutos', 21, 1),
(2, '2h y media', 22, 2),
(3, '4h ', 23, 3),
(4, '2 horas', 24, 4),
(5, '1 hora y media', 25, 5),
(6, '2 horas', 26, 6),
(7, '3 horas', 27, 7),
(8, '1 hora y media', 28, 8),
(9, '3 horas', 29, 9),
(10, '2 horas y media', 30, 10);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `medicamentos`
--

DROP TABLE IF EXISTS `medicamentos`;
CREATE TABLE IF NOT EXISTS `medicamentos` (
  `id_medicamento` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `principio_activo` varchar(50) NOT NULL,
  `dosis_maxima` varchar(10) NOT NULL,
  `id_alergia` int(11) NOT NULL,
  PRIMARY KEY (`id_medicamento`),
  UNIQUE KEY `id_alergia_FK` (`id_alergia`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `medicamentos`
--

INSERT INTO `medicamentos` (`id_medicamento`, `nombre`, `principio_activo`, `dosis_maxima`, `id_alergia`) VALUES
(1, 'Amoxicilina', 'Amoxicilina', '1 g', 6),
(2, 'Flúor', 'Ión fluoruro', '1 g', 2),
(3, 'Alergia a la amoxicilina', 'Paracetamol', '1 g', 1),
(4, 'Alergia al paracetamol', 'Amoxicilina', '1g', 10),
(5, 'Dentispray', 'Benzocaína', '2 mg', 9),
(6, 'Lincocin', 'Lincomicina', '3 mg', 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pacientes`
--

DROP TABLE IF EXISTS `pacientes`;
CREATE TABLE IF NOT EXISTS `pacientes` (
  `id_paciente` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `telefono` varchar(9) NOT NULL,
  `direccion` varchar(30) NOT NULL,
  `NIF` varchar(11) NOT NULL,
  `edad` int(3) NOT NULL,
  PRIMARY KEY (`id_paciente`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `pacientes`
--

INSERT INTO `pacientes` (`id_paciente`, `nombre`, `telefono`, `direccion`, `NIF`, `edad`) VALUES
(1, 'Ofelia Varinia Pastor', '654785698', 'ofelia@educastur.es', '16547924P', 35),
(2, 'Macario Gutierre Perez', '698754563', 'macario@hotmail.es', '56987165L', 19),
(3, 'Lucía Marrón Díaz', '654789532', 'lucia@hotmail.com', '15486069P', 21),
(4, 'Sergio Tuero González', '654789321', 'sergiot@educastur.es', '69582369P', 22),
(5, 'Mauro Felipe Araya', '625321459', 'mauro@hotmail.es', '36258945U', 65),
(6, 'Isaura Jordana Campos', '645982153', 'isaura@gmail.com', '48592614Ñ', 27),
(7, 'Adrián Zoraida Pardo', '624589423', 'adrianz@gmail.com', '23564875M', 26),
(8, 'Angélica Fidelia Ochoa', '654865123', 'angelica@educastur.es', '26485931H', 44),
(9, 'Alba Manso Mínguez', '678951357', 'alba@hotmail.com', '45963258D', 32),
(10, 'Rodrigo Catalán Noriega', '623587451', 'rodrigo@gmail.com', '12653947I', 57);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pagos`
--

DROP TABLE IF EXISTS `pagos`;
CREATE TABLE IF NOT EXISTS `pagos` (
  `id_pago` int(11) NOT NULL AUTO_INCREMENT,
  `importe` double NOT NULL,
  `fecha` date NOT NULL,
  `metodo_pago` varchar(30) NOT NULL,
  `id_paciente` int(11) NOT NULL,
  `id_cobro` int(11) NOT NULL,
  PRIMARY KEY (`id_pago`),
  UNIQUE KEY `id_paciente_FK` (`id_paciente`),
  UNIQUE KEY `id_cobro_FK` (`id_cobro`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `pagos`
--

INSERT INTO `pagos` (`id_pago`, `importe`, `fecha`, `metodo_pago`, `id_paciente`, `id_cobro`) VALUES
(1, 755, '2022-03-18', 'Tarjeta de crédito', 1, 1),
(2, 600, '2022-05-08', 'Efectivo', 2, 2),
(3, 600, '2022-03-15', 'Efectivo', 3, 3),
(4, 550, '2022-05-09', 'Tarjeta de débito', 4, 4),
(5, 2300, '2022-05-10', 'Tarjeta de crédito', 5, 5),
(6, 390, '2022-03-17', 'Efectivo', 6, 6),
(7, 845, '2022-03-16', 'Tarjeta de crédito', 7, 7),
(8, 2600, '2022-04-04', 'Tarjeta de débito', 8, 8),
(9, 950, '2022-04-18', 'Tarjeta de crédito', 9, 9),
(10, 2400, '2022-02-08', 'Tarjeta de crédito', 10, 10);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `receta`
--

DROP TABLE IF EXISTS `receta`;
CREATE TABLE IF NOT EXISTS `receta` (
  `id_medicamento` int(11) NOT NULL,
  `id_cita` int(11) NOT NULL,
  UNIQUE KEY `id_medicamento_FK` (`id_medicamento`,`id_cita`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `receta`
--

INSERT INTO `receta` (`id_medicamento`, `id_cita`) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(6, 6),
(7, 7),
(8, 8),
(9, 9),
(10, 10);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `recibe`
--

DROP TABLE IF EXISTS `recibe`;
CREATE TABLE IF NOT EXISTS `recibe` (
  `id_tratamiento` int(11) NOT NULL,
  `id_paciente` int(11) NOT NULL,
  UNIQUE KEY `id_tratamiento_FK` (`id_tratamiento`,`id_paciente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `recibe`
--

INSERT INTO `recibe` (`id_tratamiento`, `id_paciente`) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(6, 6),
(7, 7),
(8, 8),
(9, 9),
(10, 10);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `revisiones`
--

DROP TABLE IF EXISTS `revisiones`;
CREATE TABLE IF NOT EXISTS `revisiones` (
  `id_revision` int(11) NOT NULL AUTO_INCREMENT,
  `anotaciones` varchar(200) NOT NULL,
  `id_cirujano` int(11) NOT NULL,
  PRIMARY KEY (`id_revision`),
  UNIQUE KEY `id_cirujano_FK` (`id_cirujano`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `revisiones`
--

INSERT INTO `revisiones` (`id_revision`, `anotaciones`, `id_cirujano`) VALUES
(1, 'El paciente evoluciona favorablemente.', 1),
(2, 'El paciente necesitará una segunda operación', 2),
(3, 'El paciente no necesitará más revisiones. Está completamente recuperado.', 4),
(4, 'El paciente tiene una infección debido a la mala cicatrización de la operación.', 7),
(5, 'El paciente evoluciona favorablemente.', 8),
(6, 'El paciente necesitará más revisiones.', 10);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `secretarios`
--

DROP TABLE IF EXISTS `secretarios`;
CREATE TABLE IF NOT EXISTS `secretarios` (
  `id_secretario` int(11) NOT NULL AUTO_INCREMENT,
  `num_años_exp` int(3) NOT NULL,
  PRIMARY KEY (`id_secretario`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `secretarios`
--

INSERT INTO `secretarios` (`id_secretario`, `num_años_exp`) VALUES
(11, 22),
(12, 14),
(13, 24),
(14, 1),
(15, 12),
(16, 17),
(17, 14),
(18, 3),
(19, 6),
(20, 8);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tiene`
--

DROP TABLE IF EXISTS `tiene`;
CREATE TABLE IF NOT EXISTS `tiene` (
  `id_cirujano` int(11) NOT NULL,
  `id_especialidad` int(11) NOT NULL,
  UNIQUE KEY `id_cirujano_FK` (`id_cirujano`,`id_especialidad`),
  KEY `id_especialidad_FK` (`id_especialidad`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tiene`
--

INSERT INTO `tiene` (`id_cirujano`, `id_especialidad`) VALUES
(1, 1),
(1, 2),
(4, 3),
(5, 3),
(7, 4),
(8, 2),
(10, 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tratamientos`
--

DROP TABLE IF EXISTS `tratamientos`;
CREATE TABLE IF NOT EXISTS `tratamientos` (
  `id_tratamiento` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_descriptivo` varchar(30) NOT NULL,
  `consentimiento` tinyint(1) NOT NULL,
  `id_cobro` int(11) NOT NULL,
  `id_informe` int(11) NOT NULL,
  PRIMARY KEY (`id_tratamiento`),
  UNIQUE KEY `id_cobro_FK` (`id_cobro`),
  UNIQUE KEY `id_informe_FK` (`id_informe`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tratamientos`
--

INSERT INTO `tratamientos` (`id_tratamiento`, `nombre_descriptivo`, `consentimiento`, `id_cobro`, `id_informe`) VALUES
(1, 'Operación ', 1, 1, 3),
(2, 'Inserción de aparato dental', 1, 2, 5),
(3, 'Limpieza bucal', 1, 3, 2),
(4, 'Realizamiento de implantes', 0, 4, 1),
(5, 'Operación', 0, 5, 4),
(6, 'Operación', 1, 6, 6),
(7, 'Limpieza bucal', 1, 7, 7),
(8, 'Operación', 1, 8, 8),
(9, 'Endodoncia', 1, 9, 9),
(10, 'Endodoncia', 1, 10, 10);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `cirujanos`
--
ALTER TABLE `cirujanos`
  ADD CONSTRAINT `cirujanos_ibfk_1` FOREIGN KEY (`id_cirujano`) REFERENCES `empleados` (`id_empleado`);

--
-- Filtros para la tabla `citas`
--
ALTER TABLE `citas`
  ADD CONSTRAINT `id_secretario_FK` FOREIGN KEY (`id_secretario`) REFERENCES `secretarios` (`id_secretario`),
  ADD CONSTRAINT `id_tratamiento_FK` FOREIGN KEY (`id_tratamiento`) REFERENCES `tratamientos` (`id_tratamiento`);

--
-- Filtros para la tabla `enfermeros`
--
ALTER TABLE `enfermeros`
  ADD CONSTRAINT `id_enfermero_FK` FOREIGN KEY (`id_enfermero`) REFERENCES `empleados` (`id_empleado`);

--
-- Filtros para la tabla `historiales`
--
ALTER TABLE `historiales`
  ADD CONSTRAINT `id_paciente_FK` FOREIGN KEY (`id_paciente`) REFERENCES `pacientes` (`id_paciente`);

--
-- Filtros para la tabla `intervenciones`
--
ALTER TABLE `intervenciones`
  ADD CONSTRAINT `intervenciones_ibfk_1` FOREIGN KEY (`id_enfermero`) REFERENCES `enfermeros` (`id_enfermero`),
  ADD CONSTRAINT `intervenciones_ibfk_2` FOREIGN KEY (`id_cirujano`) REFERENCES `cirujanos` (`id_cirujano`);

--
-- Filtros para la tabla `medicamentos`
--
ALTER TABLE `medicamentos`
  ADD CONSTRAINT `id_alergia_FK` FOREIGN KEY (`id_alergia`) REFERENCES `alergias` (`id_alergia`);

--
-- Filtros para la tabla `pagos`
--
ALTER TABLE `pagos`
  ADD CONSTRAINT `id_cobro_FK` FOREIGN KEY (`id_cobro`) REFERENCES `cobros` (`id_cobro`),
  ADD CONSTRAINT `pagos_ibfk_1` FOREIGN KEY (`id_paciente`) REFERENCES `pacientes` (`id_paciente`);

--
-- Filtros para la tabla `revisiones`
--
ALTER TABLE `revisiones`
  ADD CONSTRAINT `revisiones_ibfk_1` FOREIGN KEY (`id_cirujano`) REFERENCES `cirujanos` (`id_cirujano`);

--
-- Filtros para la tabla `secretarios`
--
ALTER TABLE `secretarios`
  ADD CONSTRAINT `id_secretario_PK` FOREIGN KEY (`id_secretario`) REFERENCES `empleados` (`id_empleado`);

--
-- Filtros para la tabla `tiene`
--
ALTER TABLE `tiene`
  ADD CONSTRAINT `id_cirujano_FK` FOREIGN KEY (`id_cirujano`) REFERENCES `cirujanos` (`id_cirujano`),
  ADD CONSTRAINT `id_especialidad_FK` FOREIGN KEY (`id_especialidad`) REFERENCES `especialidades` (`id_especialidad`);

--
-- Filtros para la tabla `tratamientos`
--
ALTER TABLE `tratamientos`
  ADD CONSTRAINT `id_informe` FOREIGN KEY (`id_informe`) REFERENCES `informes` (`id_informe`),
  ADD CONSTRAINT `tratamientos_ibfk_1` FOREIGN KEY (`id_cobro`) REFERENCES `cobros` (`id_cobro`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
