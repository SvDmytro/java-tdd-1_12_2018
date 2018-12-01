## Cucamber

Hej,

Zobaczcie jak wygląda pisanie testów jeśli specyfikację piszecie razem z biznesem. Należy spisać coś co rozumie ktoś kto nie jest techniczny.
Coś co pogodzi jednocześnie Was i tego pana z pieniędzmi jest cucamber. Osoba ta potrafi powiedzieć co robi aplikacja za pomocą słów. No więc.... test składa się właśnie ze słów klienta.

Spójrzcie na plik: `src/test/resources/features/BankFeature.feature`, tam są zdania które rozumie biznes.
Zauważcie, że w pliku `src/test/java/pl/sages/bank/steps/StepConnectDefinitions.java` jest implementacja tych słów.

Test uruchamiamy plikiem: `BankRunner` lub `AllTestRunner`.

Cucamber - fajna sprawa by móc rozmawiać z ludźmi nietechnicznymi :)
