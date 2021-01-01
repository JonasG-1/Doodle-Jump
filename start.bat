@Echo off
:choice
set /P c=Moechtest du das Programm im Entwicklermodus starten? (J/N)
if /I "%c%" EQU "J" goto :Yes
if /I "%c%" EQU "N" goto :No

:Yes 
Echo Starte im Entwicklermodus...
@Echo on
cd files
java -jar DdlJmp.jar
pause
exit

:No
Echo Starte...
cd files
java -jar DdlJmp.jar
exit