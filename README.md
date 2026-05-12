# Volleyball Stats Tracker

## Projekti eesmärk

**Volleyball Stats Tracker** on JavaFX rakendus võrkpallimängu statistika jälgimiseks mängu ajal.

Projekti eesmärk on luua lihtne ja arusaadav tööriist, millega kasutaja saab:

- luua uue mängu;
- lisada mängijad ja võistkonnad;
- jälgida mängu jooksul tehtud tegevusi;
- uuendada skoori automaatselt tegevuste tulemuste põhjal;
- muuta skoori ja salvestatud statistikat;
- salvestada mängu andmed JSON-faili;
- avada varem loodud mänge;
- eksportida mängu statistikat.

Rakendus on mõeldud mängude jaoks, kus statistikat kogutakse nelja mängija kohta:

- Player 1
- Player 2
- Player 3
- Player 4

Iga mängija kohta saab jälgida järgmisi tegevusi:

- Attack
- Receive
- Block
- Dig

Projekt aitab analüüsida mängijate sooritust, edukaid tegevusi, vigu, skoorimuutusi, ralli pikkust ja teise puute punkte.

---

## Peamised funktsioonid

### 1. Main Menu

Main Menu on rakenduse avaleht.

Ekraan sisaldab peamisi navigeerimisnuppe:

- New Game
- Open Game
- Exit

Kasutaja saab sellelt ekraanilt:

- alustada uue mängu loomist;
- avada varem loodud mängu;
- sulgeda rakenduse.

Loogika:

```text
Main Menu -> vali tegevus -> ava vastav ekraan
```

---

### 2. New Game

New Game ekraan võimaldab kasutajal luua uue mängu.

Ekraan sisaldab:

- mängu nime välja;
- Team 1 mängijate välju;
- Team 2 mängijate välju;
- mängijate positsioonide valikut;
- autofill võimalust;
- faili nime või faili asukoha välja.

Kasutaja saab sisestada:

- mängu nime;
- Team 1 mängijad;
- Team 2 mängijad;
- mängijate positsioonid;
- faili nime või asukoha, kuhu mänguandmed salvestatakse.

Mängu nimi võib tekkida automaatselt mängijate nimede põhjal.

Näide mängu nimest:

```text
Volõnski/Voltšihhin vs Korotkov/Tiisar
```

Kuna `/` märki ei ole turvaline failinimes kasutada, tuleb failinimi teisendada turvalisele kujule.

Näide failinimest:

```text
1_Volõnski-Voltšihhin_vs_Korotkov-Tiisar.json
```

Failinime alguses olev number on mängu unikaalne ID.

Loogika:

```text
New Game -> sisesta mängijad -> vali positsioonid -> loo mäng -> salvesta JSON-fail
```

---

### 3. Open Game

Open Game ekraan võimaldab kasutajal avada varem loodud mängu.

Ekraan sisaldab:

- Back nuppu;
- Open Game pealkirja;
- All Created Matches nimekirja;
- loodud mängude nimekirja;
- Select nuppu valitud mängu avamiseks.

Kasutaja saab sellel ekraanil:

- vaadata kõiki varem loodud mänge;
- valida ühe mängu nimekirjast;
- avada valitud mängu Game Editor ekraanil;
- minna tagasi Main Menu ekraanile.

Kui loodud mänge on palju, peab mängude nimekiri olema keritav.

Loogika:

```text
Open Game -> vali mäng nimekirjast -> vajuta Select -> ava Game Editor
```

---

### 4. Game Editor

Game Editor on põhiline mängu juhtimise ekraan.

Seda ekraani kasutatakse mängu ajal statistika sisestamiseks ja skoori jälgimiseks.

Ekraan sisaldab:

- mängu nime;
- hetkeseisu;
- Player 1;
- Player 2;
- Player 3;
- Player 4;
- iga mängija tegevusnuppe;
- New Set nuppu;
- Edit Stats nuppu;
- Export nuppu;
- Exit nuppu;
- Rally Counter nuppu;
- Edit Score nuppu;
- Second Ball Points nuppu.

Igal mängijal on järgmised tegevusnupud:

- Attack
- Receive
- Block
- Dig

Kui kasutaja vajutab mängija tegevusnuppu, avaneb hüpikaken, kus saab valida tegevuse täpse tulemuse.

Näide:

```text
Player 1 -> Attack -> Spike kill
```

Pärast valiku tegemist salvestatakse tegevus statistikasse ja vajadusel uuendatakse skoori.

---

## Mängutegevused

Mängutegevused on tegevused, mida kasutaja saab Game Editor ekraanil valida.

Need tegevused jagunevad viieks põhitüübiks:

- Serve
- Receive
- Attack
- Block
- Dig

Iga tegevuse puhul salvestatakse:

- mängija;
- tegevuse tüüp;
- tegevuse tulemus;
- kas skoor muutus;
- millisele võistkonnale punkt lisati.

---

### Serve

Serve tegevus kirjeldab pallingut.

Serve valikud:

- Float serve
- Jump serve
- Ace
- Attempt
- Error

Kui tulemus on `Ace`, saab pallija võistkond punkti.

Kui tulemus on `Error`, saab vastasvõistkond punkti.

Kui tulemus on `Attempt`, salvestatakse tegevus statistikasse, kuid skoor ei muutu.

Loogika:

```text
Serve -> vali tulemus -> salvesta statistikasse -> vajadusel uuenda skoori
```

---

### Receive

Receive tegevus kirjeldab palli vastuvõttu.

Receive valikud:

- For the option
- Good receive
- Hard to set
- Receive error

Kui tulemus on `Receive error`, saab vastasvõistkond punkti.

Kui tulemus on `Good receive`, `Hard to set` või `For the option`, salvestatakse tegevus statistikasse, kuid skoor ei muutu.

Loogika:

```text
Receive -> vali tulemus -> salvesta statistikasse -> vajadusel uuenda skoori
```

---

### Attack

Attack tegevus kirjeldab rünnakut.

Attack valikud:

- Spike kill
- Spike error
- Cut shot kill
- Cut shot error
- Spike attempt
- Cut shot attempt

Kui tulemus on `Spike kill` või `Cut shot kill`, saab ründaja võistkond punkti.

Kui tulemus on `Spike error` või `Cut shot error`, saab vastasvõistkond punkti.

Kui tulemus on `Spike attempt` või `Cut shot attempt`, salvestatakse tegevus statistikasse, kuid skoor ei muutu.

Loogika:

```text
Attack -> vali tulemus -> salvesta statistikasse -> vajadusel uuenda skoori
```

---

### Block

Block tegevus kirjeldab blokki.

Block valikud:

- Monster Block
- Very good Block touch
- Block touch
- Block out

Kui tulemus on `Monster Block`, saab blokki teinud mängija võistkond punkti.

Kui tulemus on `Block out`, saab vastasvõistkond punkti.

Kui tulemus on `Very good Block touch` või `Block touch`, salvestatakse tegevus statistikasse, kuid skoor ei muutu.

Loogika:

```text
Block -> vali tulemus -> salvesta statistikasse -> vajadusel uuenda skoori
```

---

### Dig

Dig tegevus kirjeldab kaitsemängu.

Dig valikud:

- Dig
- Dig error

Kui tulemus on `Dig error`, saab vastasvõistkond punkti.

Kui tulemus on `Dig`, salvestatakse tegevus statistikasse, kuid skoor ei muutu.

Loogika:

```text
Dig -> vali tulemus -> salvesta statistikasse -> vajadusel uuenda skoori
```

---

## Punktide lisamise loogika

Punktide lisamine toimub automaatselt valitud tegevuse tulemuse põhjal.

Rakendus peab kontrollima:

- milline mängija tegi tegevuse;
- millises võistkonnas mängija on;
- milline tegevuse tulemus valiti;
- kas punkt läheb mängija võistkonnale või vastasvõistkonnale.

---

### Punkt lisatakse mängija võistkonnale, kui:

- Serve tulemus on `Ace`;
- Attack tulemus on `Spike kill`;
- Attack tulemus on `Cut shot kill`;
- Block tulemus on `Monster Block`;
- lisatakse `Second Ball Point`.

Näide:

```text
Player 1 -> Attack -> Spike kill
```

Tulemus:

```text
Player 1 võistkond saab +1 punkti
```

---

### Punkt lisatakse vastasvõistkonnale, kui:

- Serve tulemus on `Error`;
- Receive tulemus on `Receive error`;
- Attack tulemus on `Spike error`;
- Attack tulemus on `Cut shot error`;
- Block tulemus on `Block out`;
- Dig tulemus on `Dig error`.

Näide:

```text
Player 2 -> Attack -> Spike error
```

Tulemus:

```text
Vastasvõistkond saab +1 punkti
```

---

### Punkti ei lisata, kui:

- Serve tulemus on `Attempt`;
- Receive tulemus on `Good receive`;
- Receive tulemus on `Hard to set`;
- Receive tulemus on `For the option`;
- Attack tulemus on `Spike attempt`;
- Attack tulemus on `Cut shot attempt`;
- Block tulemus on `Very good Block touch`;
- Block tulemus on `Block touch`;
- Dig tulemus on `Dig`.

Sellisel juhul tegevus ainult salvestatakse statistikasse.

Skoor automaatselt ei muutu.

---

## New Set loogika

New Set nupp alustab uut setti.

Seda kasutatakse siis, kui praegune sett on lõppenud ja mäng peab jätkuma järgmise setiga.

New Set nupp teeb järgmist:

- salvestab praeguse seti tulemuse;
- loob uue seti;
- lähtestab skoori kujule `0 : 0`;
- jätab mängu üldandmed alles;
- jätkab statistika kogumist uues setis.

Loogika:

```text
New Set -> salvesta praegune sett -> loo uus sett -> skoor 0 : 0
```

Iga sett peab säilitama oma statistika eraldi.

---

## Rally Counter loogika

Rally Counter nupp loendab ralli pikkust.

Ralli tähendab olukorda, kus pall liigub mängu ajal üle võrgu mitu korda.

Rally Counter nuppu kasutatakse selleks, et märkida, mitu korda pall ralli jooksul üle võrgu liikus.

Pikk ralli on olukord, kus pall ületab võrku rohkem kui 3 korda.

Loogika:

```text
Rally Counter -> suurenda ralli loendurit -> salvesta ralli pikkus
```

---

## Edit Score loogika

Edit Score nupp võimaldab kasutajal käsitsi skoori muuta.

Seda kasutatakse siis, kui:

- kasutaja valis vale tegevuse;
- skoor muutus valesti;
- punkt lisati valele võistkonnale;
- kasutaja tahab skoori käsitsi parandada.

Edit Score ekraan või hüpikaken sisaldab:

- Team 1 skoori välja;
- Team 2 skoori välja;
- Save nuppu;
- Cancel nuppu.

Loogika:

```text
Edit Score -> ava skoori väljad -> muuda punktid -> salvesta
```

Pärast salvestamist peab Game Editor ekraan uuendama skoori.

---

## Edit Stats loogika

Edit Stats nupp võimaldab kasutajal muuta varem salvestatud tegevusi.

Seda kasutatakse siis, kui mängu ajal sisestati vale tegevus või vale tulemus.

Edit Stats ekraan sisaldab:

- salvestatud tegevuste nimekirja;
- valitud tegevuse andmeid;
- Edit nuppu;
- Delete nuppu;
- Save nuppu;
- Back nuppu.

Kasutaja saab:

- valida tegevuse;
- muuta tegevuse tüüpi;
- muuta tegevuse tulemust;
- muuta mängijat;
- kustutada tegevuse.

Loogika:

```text
Edit Stats -> ava tegevuste ajalugu -> vali tegevus -> muuda või kustuta
```

Kui tegevuse muutmine mõjutab skoori, peab rakendus ka skoori uuesti arvutama või parandama.

---

## Second Ball Points loogika

Second Ball Points nupp lisab punkti, mis saadi teise puutega.

Seda kasutatakse siis, kui mängija ei tee tavalist rünnakut, vaid saab punkti ootamatu teise puutega.

Second Ball Points tegevus peab:

- avama mängija valiku;
- lisama valitud mängija võistkonnale punkti;
- salvestama tegevuse statistikasse.

Loogika:

```text
Second Ball Points -> vali mängija -> lisa punkt mängija võistkonnale -> salvesta statistikasse
```

See aitab eraldi jälgida nutikaid ja ootamatuid punkte.

---

## Export loogika

Export nupp võimaldab kasutajal eksportida mängu statistikat.

Export funktsioon võib olla avatud kahest kohast:

- Main Menu ekraanilt;
- Game Editor ekraanilt.

Export ekraan sisaldab:

- mängu valikut;
- ekspordi formaadi valikut;
- faili nime välja;
- Export nuppu;
- Back nuppu.

Kasutaja saab valida ekspordi formaadi:

- PDF
- JSON
- Excel

Export peab sisaldama:

- mängu nime;
- kuupäeva;
- lõppskoori;
- settide tulemusi;
- mängijate statistikat;
- võistkondade statistikat;
- rünnaku statistikat;
- vastuvõtu statistikat;
- bloki statistikat;
- kaitse statistikat;
- vigade arvu;
- edukuse protsente;
- diagramme või graafikuid.

Loogika:

```text
Export -> vali mäng -> vali formaat -> sisesta faili nimi -> loo ekspordifail
```

Näide PDF-struktuurist:

```text
Mängu nimi

Mängu info:
Kuupäev
Skoor

Player 1 statistika          Player 2 statistika
Attack                       Attack
Receive                      Receive
Block                        Block
Dig                          Dig

Diagram:
[graafiku pilt]
```

Exporti tulemusena luuakse fail valitud formaadis ja salvestatakse projekti ekspordi kausta.

---

## Projekti struktuur

```text
src/main/java/com/volleyballtracker/
│
├── MainApp.java
│
├── view/
│   ├── MainMenuView.java
│   ├── NewGameView.java
│   ├── OpenGameView.java
│   ├── GameEditorView.java
│   ├── EditStatsView.java
│   ├── EditScoreView.java
│   └── ExportStatsView.java
│
├── controller/
│   ├── MainMenuController.java
│   ├── NewGameController.java
│   ├── OpenGameController.java
│   ├── GameEditorController.java
│   ├── EditStatsController.java
│   ├── EditScoreController.java
│   └── ExportStatsController.java
│
├── model/
│   ├── Match.java
│   ├── Set.java
│   ├── Player.java
│   ├── Team.java
│   └── ActionRecord.java
│
├── service/
│   ├── MatchService.java
│   ├── GameLogicService.java
│   ├── ScoreService.java
│   ├── StatsService.java
│   └── ExportService.java
│
├── storage/
│   └── JsonMatchRepository.java
│
└── util/
    └── SceneManager.java
```

---

## Kaustade vastutus

### view

`view` pakett sisaldab JavaFX ekraane.

Need klassid vastutavad nuppude, tekstide, nimekirjade, paigutuste ja visuaalsete elementide loomise eest.

Näide:

```text
GameEditorView.java
```

Loob mängu ekraani koos mängijate nuppude, skoori ja tegevusnuppudega.

---

### controller

`controller` pakett käsitleb kasutaja tegevusi.

Kontrollerid reageerivad nupuvajutustele ning ühendavad view klassid service klassidega.

Näide:

```text
GameEditorController.java
```

Käsitleb Attack, Receive, Block, Dig, New Set, Edit Score ja Export nuppe.

---

### model

`model` pakett sisaldab andmeklasse.

Need klassid hoiavad infot:

- mängude;
- settide;
- mängijate;
- võistkondade;
- salvestatud tegevuste kohta.

Model klassid ei tohi sisaldada JavaFX kasutajaliidese loogikat.

---

### service

`service` pakett sisaldab rakenduse põhilist loogikat.

Service klassid vastutavad:

- punktide lisamise;
- tegevuste töötlemise;
- statistika arvutamise;
- võitja kontrollimise;
- ekspordiandmete ettevalmistamise eest.

---

### storage

`storage` pakett vastutab mänguandmete salvestamise ja laadimise eest.

Peamine salvestusklass on:

```text
JsonMatchRepository.java
```

See salvestab mängud JSON-failidesse ja laadib need rakendusse tagasi.

---

### util

`util` pakett sisaldab abiklasse.

Näide:

```text
SceneManager.java
```

See klass vastutab ekraanide vahel liikumise eest.

---

## Andmete salvestamine

Mänguandmed tuleks salvestada JSON-failidena.

Soovituslik kaust:

```text
data/matches/
```

Näide:

```text
data/matches/1_Volõnski-Voltšihhin_vs_Korotkov-Tiisar.json
```

Eksporditud failid tuleks salvestada eraldi.

Soovituslik kaust:

```text
data/exports/
```

Näide:

```text
data/exports/1_Volõnski-Voltšihhin_vs_Korotkov-Tiisar.pdf
```

---

## Peamised klassid

### Match

Hoiab mängu üldist infot:

- mängu ID;
- mängu nimi;
- kuupäev;
- võistkondade nimed;
- mängijate nimed;
- setid;
- mängu võitja;
- faili nimi;
- faili asukoht.

---

### Set

Hoiab ühe seti infot:

- seti number;
- Team 1 punktid;
- Team 2 punktid;
- võitja;
- rally counter;
- serve statistika;
- receive statistika;
- attack statistika;
- block statistika;
- dig statistika.

---

### Player

Hoiab mängija infot:

- mängija nimi;
- mängija positsioon;
- attack rating;
- receive rating;
- block rating;
- dig rating.

---

### Team

Hoiab võistkonna infot:

- võistkonna nimi;
- mängijad;
- punktid;
- võidetud setid.

---

### ActionRecord

Hoiab ühe salvestatud tegevuse infot.

Näide:

```text
Player 1
Attack
Spike kill
Team 1 +1 punkt
Set 1
```

Seda klassi on vaja Edit Stats funktsiooni ja mängu ajaloo jaoks.

---

## Tehnoloogiad

- Java
- JavaFX
- Maven
- JSON storage
- Gson või Jackson JSON-failide jaoks
- valikuline PDF eksportimise teek

---

## Arendusplaan

Soovituslik arendusjärjekord:

```text
1. Loo Main Menu
2. Loo New Game ekraan
3. Loo Match, Set, Player ja Team model klassid
4. Lisa mängude salvestamine ja laadimine JSON-failidest
5. Loo Open Game ekraan
6. Loo Game Editor ekraan
7. Lisa hüpikaknad tegevuste valimiseks
8. Lisa punktide loogika
9. Lisa Edit Score
10. Lisa Edit Stats
11. Lisa Export
12. Lisa diagrammid
```

---

## Projekti hetkeseis

Projekt on praegu planeerimise ja varajase arenduse faasis.

Praegune fookus:

- JavaFX kasutajaliidese loomine;
- selge projekti struktuuri loomine;
- model klasside määratlemine;
- põhilise mängu loomise loogika;
- punktide loogika;
- mängude salvestamine JSON-failidesse.
