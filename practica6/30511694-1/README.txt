Integrantes del equipo:
305116941 Jessica Monter Gallardo
309223674 Nestor Jesus Real Estrada
308071087 Gibran Aguilar Zuñiga
310226682 Daniel Ramírez Delgado

1.En terminal, nos ubicamos en el directorio que contiene el script DDL.sql
2.Una vez ahí tecleamos lo siguiente
/> sqlcmd -q "CREATE DATABASE OrgTaxis;"
3.Abrimos una terminal nueva y nos volvemos a ubicar en el directorio que contiene del script DDL.sql
4.Una vez ahí tecleamos lo siguiente
/> sqlcmd -S <nombre-servidor>\<nombre-instancia> -i "DDL.sql"
5.- Apareceran las tablas creadas por el script.
