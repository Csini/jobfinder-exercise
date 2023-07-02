# jobfinder-exercise

*howto run:*


*production-ready:*
- nem GDPR berát, h email címet ésmevet tárolunk örökké, pláne, h olvasható is
- semmi nem véd a floodolástól
- így kell indítani mvn spring-boot:run -Dspring-boot.run.arguments=
- --spring.jpa.defer-datasource-initialization=false, -al kell indtíani, h ne írjon bele az adatbázisba default adatokat
- --logging.level.root=INFO,
- --spring.datasource.url=jdbc:h2:xxxx, ---> itt kell megadni a tényleges PROD adatbázis elérhetőségét, ha az H2 (ha nem akkor további paraméterek megadására van szükség)
- --spring.datasource.username=xx, és --spring.datasource.password=xxx, az db usernév és passwordjei
- portot a --server.port=9010, -al lehet megadni, ha nincs megadva, akkor a 9010-es porton fut
  


*továbbfejlesztési lehetőségek/javaslatok:*
- position-nak legyen egy lejárati ideje, mert jeleneg "örökké" ott marad --> akkor automatikusan inaktivvá válna
- vagy másik lehetőség, h az API bővítése szerkesztési és törlési lehetőséggel, de akkor azt is menteni kéne, h ki szerkesztheti (komplexebb cleint management)
- további mezők position-ban, mint pl. summary, details, salary, company, created, ...
- client apikey-ek jelenleg örökre szólnak -> jó lenne ha lenne lejárati idő --> analizálni kéne, h mekkora "session"-t érdemes hagyni (1 óra, 1 nap, 1 hét, ... stb.)
