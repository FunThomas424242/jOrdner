Erzählung: 
Um das Filesystem meines PCs besser verwalten zu können 
Als ein PC Nutzer
Ich möchte ein Programm zur Organisation nutzen. 
 
Szenario:  Start des Programmes jOrdner
  
Gegeben Der Nutzer startet das Programm jOrdner
Wenn sich eine Eclipse RCP Anwendung öffnet
Dann wird die Oberfläche von jOrdner wird dargestellt.


Szenario:  Beenden des Programmes über Schliessen Kreuz
  
Gegeben ist eine laufende RCP Anwendung jOrdner 
Wenn der Nutzer den Schließen Button drückt 
Dann wird die Anwendung beendet.

Szenario:  Beenden des Programmes über Menüpunkt
  
Gegeben ist eine laufende RCP Anwendung jOrdner 
Wenn der Nutzer den Menüpunkt Datei auswählt
Und anschließend den Menüpunkt Beenden wählt 
Dann wird die Anwendung beendet.

Szenario:  Darstellen des Öffnen Dialogs zum Hinzufügen eines Ordners
  
Gegeben ist eine laufende RCP Anwendung jOrdner 
Wenn der Nutzer den Menüpunkt Datei auswählt
Und anschließend den Menüpunkt Ordner hinzufügen wählt 
Dann erscheint ein Auswahldialog zur Auswahl des hinzuzufügenden Ordners.

Szenario:  Hinzufügen eines verwalteten Ordners
  
Gegeben es wird ein Öffnen Dialog zum Hinzufügen eines Ordners dargestellt
Und es werden nur Ordner des Filesystems zur Auswahl angeboten
Wenn der Nutzer dann einen Ordner auswählt
Und anschließend den Öffnen Button drückt 
Dann wird der Dialog geschlossen und der ausgewählte Ordner im Explorerfenster dargestellt





