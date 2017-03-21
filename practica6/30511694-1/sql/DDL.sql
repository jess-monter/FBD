USE OrgTaxis;
CREATE TABLE Choferes (
	RFC varchar(16), --Llave primaria
	Nombre varchar(255), 
	Antiguedad date, 
	Domicilio varchar(255)
	);
CREATE TABLE Licencias (
	IdLicencia varchar(30), --Llave primaria
    FechaExpedicion date, 
    Activa binary(1)
    );
CREATE TABLE Vehiculos (
	Placas varchar(15), --Llave primaria
	NumPuertas int, 
	Modelo varchar(100), 
	Marca varchar(100)
	);
CREATE TABLE Viajes (
	NumeroViaje int, --Llave primaria
	Tiempo int, 
	Distancia int, 
	NumPasajeros int
	);
CREATE TABLE Seguros (
	Folio varchar(50), --Llave primaria
	Aseguradora varchar(100), 
	TipoSeguro varchar(100)
	);
CREATE TABLE Infracciones (
	Folio varchar(50), --Llave primaria
	AgenteTransito varchar(255), 
	tipoMulta varchar(100), 
	Direccion varchar(255)
	);
CREATE TABLE Propietarios (
	CURP varchar(18), --Llave primaria
	Nombre varchar(255), 
	ApellidoP varchar(255), 
	ApellidoM varchar(255)
	);
CREATE TABLE Pagos (
	Folio varchar(50), --Llave primaria
	Fecha date, 
	Cantidad smallmoney
	);
CREATE TABLE Clientes (
	CURP varchar(18), --Llave primaria
	Facultad varchar(100),
	Email varchar(100), 
	TelefonoCel int, 
	Domicilio varchar(255), 
	Contacto varchar(255)
	);
CREATE TABLE Contadores (
	RFC varchar(15), --Llave primaria
	Nombre varchar(100), 
	ApellidoP varchar(100), 
	ApellidoM varchar(100)
	);

SELECT TABLE_NAME FROM OrgTaxis.INFORMATION_SCHEMA.[TABLES];