jOrdner 
-------
jOrdner ist ein Projekt zur Verwaltung der Resourcen eines Dateisystems.
Speziell soll die Anwendung helfen große Sammlungen von Bildern, Musikdateien
und ähnlichem zu verwalten. Dabei sollen folgende Aufgaben im Fokus stehen:
* Duplikate finden: Identische Dateien die ausversehen an mehreren Orten im 
Filesystem abgelegt wurden z.B. weil die Hierarchie der Ordnung nicht 
eineindeutig war
* Verwalten von Metadaten zu einzelnen Elementen im Dateisystem: Label, Tags
Kategorien, Zusatzinfos, Bewertungen etc.
* Vergleich von Dateisystemen zum Beispiel mehrerer Backups um Deltas zu finden
* Backup von Ordnern und Unterordnern über ein externes System 

Architektur und Implementierung
-------------------------------
Das Programm soll als RCP Anwendung mit eclipse 4 realisiert werden und alle
Daten per JPA persistieren. Als JPA Provider wird Gemini JPA verwendet, da es 
OSGI Bundle Support bietet.
